package com.iota.iri.conf;

import java.util.Collection;
import java.util.Set;

public class IotaConfiguration implements Configuration2 {

    //API
    private int port;
    private String apiHost;
    private Set<String> remoteLimitApi;
    private int maxFindTransactions;
    private int maxRequestList;
    private int maxGetTrytes;
    private int maxBodyLength;
    private String remoteAuth;


    //Network
    private int udpRecieverPort;
    private int tcpRecieverPort;
    private float pRemoveRequest;
    private int sendLimit;
    private int maxPeers;
    private boolean dnsRefresherEnabled;
    private boolean dnsResolutionEnabled;
    private Collection<String> neighbors;


    //General
    private boolean testnet;
    private boolean debug;

    //IXI
    private String ixiDir;

    //DB
    private String dbPath;
    private String dbLogPath;
    private int dbCacheSize;
    private String mainDb;
    private boolean export;
    private boolean revalidate;
    private boolean rescanDb;

    //Protocol
    private int mwm;
    private int transactionPacketSize;
    private int requestHashSize;
    private float pReplyRandomTip;
    private float pDropTransaction;
    private float pSelectMilestoneChild;
    private float pSendMilestone;
    private float pPropagateRequest;
    private int minimumWeightMagnitude;


    //Snapshot
    private int snapshotTime;
    private String snapshotFile;
    private String snapshotSignatureFile;
    private int milsestoneStartIndex;
    private int numberOfKeysInMilestone;

    //ZMQ
    private boolean zmqEnabled;
    private int zmqPort;
    private String zmqIpc;
    private int qSizeNode;
    private int pDropCacheEntryDescription;
    private int pCacheSizeBytes;

    //coordinator
    String coordinator;
    boolean validateTestnetMilestoneSig;


    //Tip Selection
    private int minRandomWalks;
    private int maxRandomWalks;
    private int maxDepth;


    @Override
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String getApiHost() {
        return apiHost;
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    @Override
    public Set<String> getRemoteLimitApi() {
        return remoteLimitApi;
    }

    public void setRemoteLimitApi(Set<String> remoteLimitApi) {
        this.remoteLimitApi = remoteLimitApi;
    }

    @Override
    public int getMaxFindTransactions() {
        return maxFindTransactions;
    }

    public void setMaxFindTransactions(int maxFindTransactions) {
        this.maxFindTransactions = maxFindTransactions;
    }

    @Override
    public int getMaxRequestList() {
        return maxRequestList;
    }

    public void setMaxRequestList(int maxRequestList) {
        this.maxRequestList = maxRequestList;
    }

    @Override
    public int getMaxGetTrytes() {
        return maxGetTrytes;
    }

    public void setMaxGetTrytes(int maxGetTrytes) {
        this.maxGetTrytes = maxGetTrytes;
    }

    @Override
    public int getMaxBodyLength() {
        return maxBodyLength;
    }

    public void setMaxBodyLength(int maxBodyLength) {
        this.maxBodyLength = maxBodyLength;
    }

    @Override
    public String getRemoteAuth() {
        return remoteAuth;
    }

    public void setRemoteAuth(String remoteAuth) {
        this.remoteAuth = remoteAuth;
    }

    @Override
    public int getUdpRecieverPort() {
        return udpRecieverPort;
    }

    public void setUdpRecieverPort(int udpRecieverPort) {
        this.udpRecieverPort = udpRecieverPort;
    }

    @Override
    public int getTcpRecieverPort() {
        return tcpRecieverPort;
    }

    public void setTcpRecieverPort(int tcpRecieverPort) {
        this.tcpRecieverPort = tcpRecieverPort;
    }

    @Override
    public float getpRemoveRequest() {
        return pRemoveRequest;
    }

    public void setpRemoveRequest(float pRemoveRequest) {
        this.pRemoveRequest = pRemoveRequest;
    }

    @Override
    public int getSendLimit() {
        return sendLimit;
    }

    public void setSendLimit(int sendLimit) {
        this.sendLimit = sendLimit;
    }

    @Override
    public int getMaxPeers() {
        return maxPeers;
    }

    public void setMaxPeers(int maxPeers) {
        this.maxPeers = maxPeers;
    }

    @Override
    public boolean isDnsRefresherEnabled() {
        return dnsRefresherEnabled;
    }

    public void setDnsRefresherEnabled(boolean dnsRefresherEnabled) {
        this.dnsRefresherEnabled = dnsRefresherEnabled;
    }

    @Override
    public boolean isDnsResolutionEnabled() {
        return dnsResolutionEnabled;
    }

    public void setDnsResolutionEnabled(boolean dnsResolutionEnabled) {
        this.dnsResolutionEnabled = dnsResolutionEnabled;
    }

    @Override
    public Collection<String> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Collection<String> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public boolean isTestnet() {
        return testnet;
    }

    public void setTestnet(boolean testnet) {
        this.testnet = testnet;
    }

    @Override
    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    @Override
    public String getIxiDir() {
        return ixiDir;
    }

    public void setIxiDir(String ixiDir) {
        this.ixiDir = ixiDir;
    }

    @Override
    public String getDbPath() {
        return dbPath;
    }

    public void setDbPath(String dbPath) {
        this.dbPath = dbPath;
    }

    @Override
    public String getDbLogPath() {
        return dbLogPath;
    }

    public void setDbLogPath(String dbLogPath) {
        this.dbLogPath = dbLogPath;
    }

    @Override
    public int getDbCacheSize() {
        return dbCacheSize;
    }

    public void setDbCacheSize(int dbCacheSize) {
        this.dbCacheSize = dbCacheSize;
    }

    @Override
    public String getMainDb() {
        return mainDb;
    }

    public void setMainDb(String mainDb) {
        this.mainDb = mainDb;
    }

    @Override
    public boolean isExport() {
        return export;
    }

    public void setExport(boolean export) {
        this.export = export;
    }

    @Override
    public boolean isRevalidate() {
        return revalidate;
    }

    public void setRevalidate(boolean revalidate) {
        this.revalidate = revalidate;
    }

    @Override
    public boolean isRescanDb() {
        return rescanDb;
    }

    public void setRescanDb(boolean rescanDb) {
        this.rescanDb = rescanDb;
    }

    @Override
    public int getMwm() {
        return mwm;
    }

    public void setMwm(int mwm) {
        this.mwm = mwm;
    }

    @Override
    public int getTransactionPacketSize() {
        return transactionPacketSize;
    }

    public void setTransactionPacketSize(int transactionPacketSize) {
        this.transactionPacketSize = transactionPacketSize;
    }

    @Override
    public int getRequestHashSize() {
        return requestHashSize;
    }

    public void setRequestHashSize(int requestHashSize) {
        this.requestHashSize = requestHashSize;
    }

    @Override
    public float getpReplyRandomTip() {
        return pReplyRandomTip;
    }

    public void setpReplyRandomTip(float pReplyRandomTip) {
        this.pReplyRandomTip = pReplyRandomTip;
    }

    @Override
    public float getpDropTransaction() {
        return pDropTransaction;
    }

    public void setpDropTransaction(float pDropTransaction) {
        this.pDropTransaction = pDropTransaction;
    }

    @Override
    public float getpSelectMilestoneChild() {
        return pSelectMilestoneChild;
    }

    public void setpSelectMilestoneChild(float pSelectMilestoneChild) {
        this.pSelectMilestoneChild = pSelectMilestoneChild;
    }

    @Override
    public float getpSendMilestone() {
        return pSendMilestone;
    }

    public void setpSendMilestone(float pSendMilestone) {
        this.pSendMilestone = pSendMilestone;
    }

    @Override
    public float getpPropagateRequest() {
        return pPropagateRequest;
    }

    public void setpPropagateRequest(float pPropagateRequest) {
        this.pPropagateRequest = pPropagateRequest;
    }

    @Override
    public int getMinimumWeightMagnitude() {
        return minimumWeightMagnitude;
    }

    public void setMinimumWeightMagnitude(int minimumWeightMagnitude) {
        this.minimumWeightMagnitude = minimumWeightMagnitude;
    }

    @Override
    public int getSnapshotTime() {
        return snapshotTime;
    }

    public void setSnapshotTime(int snapshotTime) {
        this.snapshotTime = snapshotTime;
    }

    @Override
    public String getSnapshotFile() {
        return snapshotFile;
    }

    public void setSnapshotFile(String snapshotFile) {
        this.snapshotFile = snapshotFile;
    }

    @Override
    public String getSnapshotSignatureFile() {
        return snapshotSignatureFile;
    }

    public void setSnapshotSignatureFile(String snapshotSignatureFile) {
        this.snapshotSignatureFile = snapshotSignatureFile;
    }

    @Override
    public int getMilsestoneStartIndex() {
        return milsestoneStartIndex;
    }

    public void setMilsestoneStartIndex(int milsestoneStartIndex) {
        this.milsestoneStartIndex = milsestoneStartIndex;
    }

    @Override
    public int getNumberOfKeysInMilestone() {
        return numberOfKeysInMilestone;
    }

    public void setNumberOfKeysInMilestone(int numberOfKeysInMilestone) {
        this.numberOfKeysInMilestone = numberOfKeysInMilestone;
    }

    @Override
    public boolean isZmqEnabled() {
        return zmqEnabled;
    }

    public void setZmqEnabled(boolean zmqEnabled) {
        this.zmqEnabled = zmqEnabled;
    }

    @Override
    public int getZmqPort() {
        return zmqPort;
    }

    public void setZmqPort(int zmqPort) {
        this.zmqPort = zmqPort;
    }

    @Override
    public String getZmqIpc() {
        return zmqIpc;
    }

    public void setZmqIpc(String zmqIpc) {
        this.zmqIpc = zmqIpc;
    }

    @Override
    public int getqSizeNode() {
        return qSizeNode;
    }

    public void setqSizeNode(int qSizeNode) {
        this.qSizeNode = qSizeNode;
    }

    @Override
    public int getpDropCacheEntryDescription() {
        return pDropCacheEntryDescription;
    }

    public void setpDropCacheEntryDescription(int pDropCacheEntryDescription) {
        this.pDropCacheEntryDescription = pDropCacheEntryDescription;
    }

    @Override
    public int getpCacheSizeBytes() {
        return pCacheSizeBytes;
    }

    public void setpCacheSizeBytes(int pCacheSizeBytes) {
        this.pCacheSizeBytes = pCacheSizeBytes;
    }

    @Override
    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    @Override
    public boolean isValidateTestnetMilestoneSig() {
        return validateTestnetMilestoneSig;
    }

    public void setValidateTestnetMilestoneSig(boolean validateTestnetMilestoneSig) {
        this.validateTestnetMilestoneSig = validateTestnetMilestoneSig;
    }

    @Override
    public int getMinRandomWalks() {
        return minRandomWalks;
    }

    public void setMinRandomWalks(int minRandomWalks) {
        this.minRandomWalks = minRandomWalks;
    }

    @Override
    public int getMaxRandomWalks() {
        return maxRandomWalks;
    }

    public void setMaxRandomWalks(int maxRandomWalks) {
        this.maxRandomWalks = maxRandomWalks;
    }

    @Override
    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }
}