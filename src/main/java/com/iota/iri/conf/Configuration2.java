package com.iota.iri.conf;

import java.util.Collection;
import java.util.Set;

public interface Configuration2 {

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

    float getpRemoveRequest();

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

    float getpReplyRandomTip();

    float getpDropTransaction();

    float getpSelectMilestoneChild();

    float getpSendMilestone();

    float getpPropagateRequest();

    int getMinimumWeightMagnitude();

    int getSnapshotTime();

    String getSnapshotFile();

    String getSnapshotSignatureFile();

    int getMilsestoneStartIndex();

    int getNumberOfKeysInMilestone();

    boolean isZmqEnabled();

    int getZmqPort();

    String getZmqIpc();

    int getqSizeNode();

    int getpDropCacheEntryDescription();

    int getpCacheSizeBytes();

    String getCoordinator();

    boolean isValidateTestnetMilestoneSig();

    int getMinRandomWalks();

    int getMaxRandomWalks();

    int getMaxDepth();
}
