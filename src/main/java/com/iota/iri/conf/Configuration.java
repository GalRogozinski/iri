package com.iota.iri.conf;

import java.util.Collection;
import java.util.Set;

public interface Configuration {

    String MAINNET_COORDINATOR_ADDRESS =
            "KPWCHICGJZXKE9GSUDXZYUAPLHAKAHYHDXNPHENTERYMMBQOPSQIDENXKLKCEYCPVTZQLEEJVYJZV9BWU";
    String TESTNET_COORDINATOR_ADDRESS =
            "EQQFCZBIHRHWPXKMTOLMYUYPCN9XLMJPYZVFJSAY9FQHCCLWTOLLUGKKMXYFDBOOYFBLBI9WUEILGECYM";
    String MAINNET_SNAPSHOT_FILE = "/snapshotMainnet.txt";
    String TESTNET_SNAPSHOT_FILE = "/snapshotTestnet.txt";
    String MAINNET_SNAPSHOT_SIG_FILE = "/snapshotMainnet.sig";

    String PREVIOUS_EPOCHS_SPENT_ADDRESSES_TXT = "/previousEpochsSpentAddresses.txt";
    String PREVIOUS_EPOCH_SPENT_ADDRESSES_SIG = "/previousEpochsSpentAddresses.sig";
    String MAINNET_MILESTONE_START_INDEX = "338000";
    String TESTNET_MILESTONE_START_INDEX = "434525";
    String MAINNET_NUM_KEYS_IN_MILESTONE = "20";
    String TESTNET_NUM_KEYS_IN_MILESTONE = "22";
    String GLOBAL_SNAPSHOT_TIME = "1517180400";
    String TESTNET_GLOBAL_SNAPSHOT_TIME = "1522306500";


    String MAINNET_MWM = "14";
    String TESTNET_MWM = "9";
    String PACKET_SIZE = "1650";
    String TESTNET_PACKET_SIZE = "1653";
    String REQ_HASH_SIZE = "46";
    String TESTNET_REQ_HASH_SIZE = "49";

    int getPort();

    String getApiHost();

    Set<String> getRemoteLimitApi();

    int getMaxFindTransactions();

    int getMaxRequestList();

    int getMaxGetTrytes();

    int getMaxBodyLength();

    String getRemoteAuth();

    int getUdpRecieverPort();

    int getTcpRecieverPort();

    double getPRemoveRequest();

    int getSendLimit();

    int getMaxPeers();

    boolean isDnsRefresherEnabled();

    boolean isDnsResolutionEnabled();

    Collection<String> getNeighbors();

    boolean isTestnet();

    boolean isDebug();

    String getIxiDir();

    String getDbPath();

    String getDbLogPath();

    int getDbCacheSize();

    String getMainDb();

    boolean isExport();

    boolean isRevalidate();

    boolean isRescanDb();

    int getMwm();

    int getTransactionPacketSize();

    int getRequestHashSize();

    double getpReplyRandomTip();

    double getPDropTransaction();

    double getpSelectMilestoneChild();

    double getPSendMilestone();

    double getPPropagateRequest();

    int getMinimumWeightMagnitude();

    long getSnapshotTime();

    String getSnapshotFile();

    String getSnapshotSignatureFile();

    int getMilestoneStartIndex();

    int getNumberOfKeysInMilestone();

    boolean isZmqEnabled();

    int getZmqPort();

    String getZmqIpc();

    int getQSizeNode();

    int getPDropCacheEntry();

    int getCacheSizeBytes();

    String getCoordinator();

    boolean isValidateTestnetMilestoneSig();

    int getMinRandomWalks();

    int getMaxRandomWalks();

    int getMaxDepth();
}
