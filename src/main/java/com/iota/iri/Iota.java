package com.iota.iri;

import com.iota.iri.conf.Configuration;
import com.iota.iri.conf.ConfigurationOld;
import com.iota.iri.controllers.*;
import com.iota.iri.hash.SpongeFactory;
import com.iota.iri.model.Hash;
import com.iota.iri.network.Node;
import com.iota.iri.network.TransactionRequester;
import com.iota.iri.network.UDPReceiver;
import com.iota.iri.network.replicator.Replicator;
import com.iota.iri.service.TipsManager;
import com.iota.iri.storage.*;
import com.iota.iri.storage.rocksDB.RocksDBPersistenceProvider;
import com.iota.iri.utils.Pair;
import com.iota.iri.zmq.MessageQ;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by paul on 5/19/17.
 */
public class Iota {
    private static final Logger log = LoggerFactory.getLogger(Iota.class);

    public final LedgerValidator ledgerValidator;
    public final Milestone milestone;
    public final Tangle tangle;
    public final TransactionValidator transactionValidator;
    public final TipsManager tipsManager;
    public final TransactionRequester transactionRequester;
    public final Node node;
    public final UDPReceiver udpReceiver;
    public final Replicator replicator;
    public final Configuration configuration;
    public final Hash coordinator;
    public final TipsViewModel tipsViewModel;
    public final MessageQ messageQ;

    public final boolean testnet;
    public final int maxPeers;
    public final int udpPort;
    public final int tcpPort;
    public final int maxTipSearchDepth;

    public Iota(Configuration configuration) throws IOException {
        this.configuration = configuration;
        testnet = configuration.isTestnet();
        maxPeers = configuration.getMaxPeers();
        udpPort = configuration.getUdpRecieverPort();
        tcpPort = configuration.getTcpRecieverPort();

        String snapshotFile = configuration.getSnapshotFile();
        String snapshotSigFile = configuration.getSnapshotSignatureFile();
        Snapshot initialSnapshot = Snapshot.init(snapshotFile, snapshotSigFile, testnet).clone();
        long snapshotTimestamp = configuration.getSnapshotTime();
        int milestoneStartIndex = configuration.getMilestoneStartIndex();
        int numKeysMilestone = configuration.getNumberOfKeysInMilestone();
        //TODO remove negation
        boolean dontValidateMilestoneSig = !configuration.isValidateTestnetMilestoneSig();
        int transactionPacketSize = configuration.getTransactionPacketSize();

        maxTipSearchDepth = configuration.getMaxDepth();
        if(testnet) {
            String coordinatorTrytes = configuration.getCoordinator();
            if(StringUtils.isNotEmpty(coordinatorTrytes)) {
                coordinator = new Hash(coordinatorTrytes);
            } else {
                log.warn("No coordinator address given for testnet. Defaulting to "
                        + ConfigurationOld.TESTNET_COORDINATOR_ADDRESS);
                coordinator = new Hash(ConfigurationOld.TESTNET_COORDINATOR_ADDRESS);
            }
        } else {
            coordinator = new Hash(ConfigurationOld.MAINNET_COORDINATOR_ADDRESS);
        }
        tangle = new Tangle();
        messageQ = new MessageQ(configuration.getZmqPort(),
                configuration.getZmqIpc(),
                1,
                configuration.isZmqEnabled()
                );
        tipsViewModel = new TipsViewModel();
        transactionRequester = new TransactionRequester(tangle, messageQ);
        transactionValidator = new TransactionValidator(tangle, tipsViewModel, transactionRequester, messageQ,
                snapshotTimestamp);
        milestone = new Milestone(tangle, coordinator, initialSnapshot, transactionValidator, testnet, messageQ,
                numKeysMilestone, milestoneStartIndex, dontValidateMilestoneSig);
        node = new Node(configuration, tangle, transactionValidator, transactionRequester, tipsViewModel, milestone, messageQ);
        replicator = new Replicator(node, tcpPort, maxPeers, testnet, transactionPacketSize);
        udpReceiver = new UDPReceiver(udpPort, node, configuration.getTransactionPacketSize());
        ledgerValidator = new LedgerValidator(tangle, milestone, transactionRequester, messageQ);
        tipsManager = new TipsManager(tangle, ledgerValidator, transactionValidator, tipsViewModel, milestone,
                maxTipSearchDepth, messageQ, testnet, milestoneStartIndex);
    }

    public void init() throws Exception {
        initializeTangle();
        tangle.init();

        if (configuration.isRescanDb()){
            rescan_db();
        }
        boolean revalidate = configuration.isRevalidate();

        if (revalidate) {
            tangle.clearColumn(com.iota.iri.model.Milestone.class);
            tangle.clearColumn(com.iota.iri.model.StateDiff.class);
            tangle.clearMetadata(com.iota.iri.model.Transaction.class);
        }
        milestone.init(SpongeFactory.Mode.CURLP27, ledgerValidator, revalidate);
        transactionValidator.init(testnet, configuration.getMwm());
        tipsManager.init();
        transactionRequester.init(configuration.getPRemoveRequest());
        udpReceiver.init();
        replicator.init();
        node.init();
    }

    private void rescan_db() throws Exception {
        int counter = 0;
        //delete all Address , Bundle , Approvee & Tag
        AddressViewModel add = AddressViewModel.first(tangle);
        while (add != null) {
            if (++counter % 10000 == 0) {
                log.info("Clearing cache: {} Addresses", counter);
            }
            AddressViewModel NextAdd = add.next(tangle);
            add.delete(tangle);
            add = NextAdd;
        }
        counter = 0;
        BundleViewModel bn = BundleViewModel.first(tangle);
        while (bn != null) {
            if (++counter % 10000 == 0) {
                log.info("Clearing cache: {} Bundles", counter);
            }
            BundleViewModel NextBn = bn.next(tangle);
            bn.delete(tangle);
            bn = NextBn;
        }
        counter = 0;
        ApproveeViewModel app = ApproveeViewModel.first(tangle);
        while (app != null) {
            if (++counter % 10000 == 0) {
                log.info("Clearing cache: {} Approvees", counter);
            }
            ApproveeViewModel NextApp = app.next(tangle);
            app.delete(tangle);
            app = NextApp;
        }
        counter = 0;
        TagViewModel tag = TagViewModel.first(tangle);
        while (tag != null) {
            if (++counter % 10000 == 0) {
                log.info("Clearing cache: {} Tags", counter);
            }
            TagViewModel NextTag = tag.next(tangle);
            tag.delete(tangle);
            tag = NextTag;
        }

        //rescan all tx & refill the columns
        TransactionViewModel tx = TransactionViewModel.first(tangle);
        counter = 0;
        while (tx != null) {
            if (++counter % 10000 == 0) {
                log.info("Rescanned {} Transactions", counter);
            }
            List<Pair<Indexable, Persistable>> saveBatch = tx.getSaveBatch();
            saveBatch.remove(5);
            tangle.saveBatch(saveBatch);
            tx = tx.next(tangle);
        }
    }

    public void shutdown() throws Exception {
        milestone.shutDown();
        tipsManager.shutdown();
        node.shutdown();
        udpReceiver.shutdown();
        replicator.shutdown();
        transactionValidator.shutdown();
        tangle.shutdown();
        messageQ.shutdown();
    }

    private void initializeTangle() {
        switch (configuration.getMainDb()) {
            case "rocksdb": {
                tangle.addPersistenceProvider(new RocksDBPersistenceProvider(
                        configuration.getDbPath(),
                        configuration.getDbLogPath(),
                        configuration.getDbCacheSize()));
                break;
            }
            default: {
                throw new NotImplementedException("No such database type.");
            }
        }
        if (configuration.isExport()) {
            tangle.addPersistenceProvider(new FileExportProvider());
        }
        if (configuration.isZmqEnabled()) {
            tangle.addPersistenceProvider(new ZmqPublishProvider(messageQ));
        }
    }
}