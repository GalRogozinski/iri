package com.iota.iri.service.tipselection.impl;

import com.iota.iri.LedgerValidator;
import com.iota.iri.TransactionValidator;
import com.iota.iri.controllers.TransactionViewModel;
import com.iota.iri.model.Hash;
import com.iota.iri.Milestone;
import com.iota.iri.service.tipselection.WalkValidator;
import com.iota.iri.storage.Tangle;
import com.iota.iri.utils.collections.impl.BoundedSetWrapper;
import com.iota.iri.utils.collections.interfaces.BoundedSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Implementation of <tt>WalkValidator</tt> that checks consistency of the ledger as part of validity checks.
 *
 *     A transaction is only valid if:
 *      <ol>
 *      <li>it is a tail
 *      <li>all the history of the transaction is present (is solid)
 *      <li>it does not reference an old unconfirmed transaction (not belowMaxDepth)
 *      <li>the ledger is still consistent if the transaction is added
 *          (balances of all addresses are correct and all signatures are valid)
 *      </ol>
 */
public class WalkValidatorImpl implements WalkValidator {

    public static final int MAX_CACHE_SIZE = 2_000_000;
    //As long as tip selection is synchronized we are fine with the collection not being thread safe
    private static final BoundedSet<Hash> FAILED_BELOW_MAX_DEPTH_CACHE = new BoundedSetWrapper<>(
            new LinkedHashSet<>(10_000), MAX_CACHE_SIZE);
    public static final int MAX_ANALYZED_TXS = 10_000;

    private final Tangle tangle;
    private final Logger log = LoggerFactory.getLogger(WalkValidator.class);
    private final LedgerValidator ledgerValidator;
    private final TransactionValidator transactionValidator;
    private final Milestone milestone;

    private final int maxDepth;

    private Set<Hash> maxDepthOkMemoization;
    private Map<Hash, Long> myDiff;
    private Set<Hash> myApprovedHashes;

    public WalkValidatorImpl(Tangle tangle, LedgerValidator ledgerValidator, TransactionValidator transactionValidator,
                             Milestone milestone, int maxDepth) {
        this.tangle = tangle;
        this.ledgerValidator = ledgerValidator;
        this.transactionValidator = transactionValidator;
        this.milestone = milestone;
        this.maxDepth = maxDepth;

        maxDepthOkMemoization = new HashSet<>();
        myDiff = new HashMap<>();
        myApprovedHashes = new HashSet<>();
    }

    @Override
    public boolean isValid(Hash transactionHash) throws Exception {

        TransactionViewModel transactionViewModel = TransactionViewModel.fromHash(tangle, transactionHash);
        if (transactionViewModel.getType() == TransactionViewModel.PREFILLED_SLOT) {
            log.debug("Validation failed: {} is missing in db", transactionHash);
            return false;
        } else if (transactionViewModel.getCurrentIndex() != 0) {
            log.debug("Validation failed: {} not a tail", transactionHash);
            return false;
        } else if (!transactionValidator.checkSolidity(transactionViewModel.getHash(), false)) {
            log.debug("Validation failed: {} is not solid", transactionHash);
            return false;
        } else if (belowMaxDepth(transactionViewModel.getHash(), milestone.latestSolidSubtangleMilestoneIndex - maxDepth)) {
            log.debug("Validation failed: {} is below max depth", transactionHash);
            return false;
        } else if (!ledgerValidator.updateDiff(myApprovedHashes, myDiff, transactionViewModel.getHash())) {
            log.debug("Validation failed: {} is not consistent", transactionHash);
            return false;
        }
        return true;
    }

    private boolean belowMaxDepth(Hash tip, int lowerAllowedSnapshotIndex) throws Exception {
        //if tip is confirmed stop
        if (TransactionViewModel.fromHash(tangle, tip).snapshotIndex() >= lowerAllowedSnapshotIndex) {
            return false;
        }
        //if tip unconfirmed, check if any referenced tx is confirmed below maxDepth
        Queue<Hash> nonAnalyzedTransactions = new LinkedList<>(Collections.singleton(tip));
        Set<Hash> analyzedTransactions = new HashSet<>();
        Hash hash;
        while ((hash = nonAnalyzedTransactions.poll()) != null) {
            if (FAILED_BELOW_MAX_DEPTH_CACHE.contains(hash)) {
                updateCache(analyzedTransactions);
                return true;
            }
            if (analyzedTransactions.size() == MAX_ANALYZED_TXS) {
                updateCache(analyzedTransactions);
                return true;
            }

            if (analyzedTransactions.add(hash)) {
                TransactionViewModel transaction = TransactionViewModel.fromHash(tangle, hash);
                if ((transaction.snapshotIndex() != 0 || Objects.equals(Hash.NULL_HASH, transaction.getHash()))
                        && transaction.snapshotIndex() < lowerAllowedSnapshotIndex) {
                    updateCache(analyzedTransactions);
                    return true;
                }
                if (transaction.snapshotIndex() == 0) {
                    if (!maxDepthOkMemoization.contains(hash)) {
                        nonAnalyzedTransactions.offer(transaction.getTrunkTransactionHash());
                        nonAnalyzedTransactions.offer(transaction.getBranchTransactionHash());
                    }
                }
            }
        }
        maxDepthOkMemoization.add(tip);
        return false;
    }

    private void updateCache(Set<Hash> txsToBeAdded) {
        FAILED_BELOW_MAX_DEPTH_CACHE.addAll(txsToBeAdded);
    }

}
