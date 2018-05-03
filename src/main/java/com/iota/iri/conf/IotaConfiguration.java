package com.iota.iri.conf;

import com.beust.jcommander.Parameter;

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
    private long snapshotTime;
    private String snapshotFile;
    private String snapshotSignatureFile;
    private int milestoneStartIndex;
    private int numberOfKeysInMilestone;

    //ZMQ
    private boolean zmqEnabled;
    private int zmqPort;
    private String zmqIpc;
    private int qSizeNode;
    private int pDropCacheEntry;
    private int pCacheSizeBytes;

    //coordinator
    String coordinator;
    boolean validateTestnetMilestoneSig;


    //Tip Selection
    private int minRandomWalks;
    private int maxRandomWalks;
    private int maxDepth;


    @Override
    @Parameter(names = {"--port", "-p"}, description = ConfigDescriptions.PORT)
    public int getPort() {
        return port;
    }

    @Parameter
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    @Parameter(names = {"--host"}, description = ConfigDescriptions.API_HOST)
    public String getApiHost() {
        return apiHost;
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    @Override
    @Parameter(names = {"--remote-limit-api"}, description = ConfigDescriptions.API_HOST)
    public Set<String> getRemoteLimitApi() {
        return remoteLimitApi;
    }

    public void setRemoteLimitApi(Set<String> remoteLimitApi) {
        this.remoteLimitApi = remoteLimitApi;
    }

    @Override
    @Parameter(names = {"--max-find-transactions"}, description = ConfigDescriptions.MAX_FIND_TRANSACTIONS)
    public int getMaxFindTransactions() {
        return maxFindTransactions;
    }

    public void setMaxFindTransactions(int maxFindTransactions) {
        this.maxFindTransactions = maxFindTransactions;
    }

    @Override
    @Parameter(names = {"--max-request-list"}, description = ConfigDescriptions.MAX_REQUESTS_LIST)
    public int getMaxRequestList() {
        return maxRequestList;
    }

    public void setMaxRequestList(int maxRequestList) {
        this.maxRequestList = maxRequestList;
    }

    @Override
    @Parameter(names = {"--max-get-trytes"}, description = ConfigDescriptions.MAX_GET_TRYTES)
    public int getMaxGetTrytes() {
        return maxGetTrytes;
    }

    public void setMaxGetTrytes(int maxGetTrytes) {
        this.maxGetTrytes = maxGetTrytes;
    }

    @Override
    @Parameter(names = {"--max-body-length"}, description = ConfigDescriptions.MAX_BODY_LENGTH)
    public int getMaxBodyLength() {
        return maxBodyLength;
    }

    public void setMaxBodyLength(int maxBodyLength) {
        this.maxBodyLength = maxBodyLength;
    }

    @Override
    @Parameter(names = {"--remote-auth"}, description = ConfigDescriptions.REMOTE_AUTH)
    public String getRemoteAuth() {
        return remoteAuth;
    }

    public void setRemoteAuth(String remoteAuth) {
        this.remoteAuth = remoteAuth;
    }

    @Override
    @Parameter(names = {"-u", "--udp-reciever-port"})
    public int getUdpRecieverPort() {
        return udpRecieverPort;
    }

    public void setUdpRecieverPort(int udpRecieverPort) {
        this.udpRecieverPort = udpRecieverPort;
    }

    @Override
    @Parameter(names = {"-t", "--tcp-reciever-port"})
    public int getTcpRecieverPort() {
        return tcpRecieverPort;
    }

    public void setTcpRecieverPort(int tcpRecieverPort) {
        this.tcpRecieverPort = tcpRecieverPort;
    }

    @Override
    @Parameter(names = {"-p", "--p-remove-request"}, description = ConfigDescriptions.P_REMOVE_REQUEST)
    public float getPRemoveRequest() {
        return pRemoveRequest;
    }

    public void setpRemoveRequest(float pRemoveRequest) {
        this.pRemoveRequest = pRemoveRequest;
    }

    @Override
    @Parameter(names = {"--send-limit"}, description = ConfigDescriptions.SEND_LIMIT)
    public int getSendLimit() {
        return sendLimit;
    }

    public void setSendLimit(int sendLimit) {
        this.sendLimit = sendLimit;
    }

    @Override
    @Parameter(names = {"--max-peers"}, description = ConfigDescriptions.MAX_PEERS)
    public int getMaxPeers() {
        return maxPeers;
    }

    public void setMaxPeers(int maxPeers) {
        this.maxPeers = maxPeers;
    }

    @Override
    @Parameter(names = {"--dns--refresher"}, description = ConfigDescriptions.DNS_REFRESHER_ENABLED)
    public boolean isDnsRefresherEnabled() {
        return dnsRefresherEnabled;
    }

    public void setDnsRefresherEnabled(boolean dnsRefresherEnabled) {
        this.dnsRefresherEnabled = dnsRefresherEnabled;
    }

    @Override
    @Parameter(names = {"--dns-resolution"}, description = ConfigDescriptions.DNS_RESOLUTION_ENABLED)
    public boolean isDnsResolutionEnabled() {
        return dnsResolutionEnabled;
    }

    public void setDnsResolutionEnabled(boolean dnsResolutionEnabled) {
        this.dnsResolutionEnabled = dnsResolutionEnabled;
    }

    @Override
    @Parameter(names = {"-n", "--neighbors"}, description = ConfigDescriptions.NEIGHBORS)
    public Collection<String> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Collection<String> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    @Parameter(names = {"--testnet"}, description = ConfigDescriptions.TESTNET)
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
    @Parameter(names = {"--ixi-dir"}, description = ConfigDescriptions.IXI_DIR)
    public String getIxiDir() {
        return ixiDir;
    }

    public void setIxiDir(String ixiDir) {
        this.ixiDir = ixiDir;
    }

    @Override
    @Parameter(names = {"--db-path"}, description = ConfigDescriptions.DB_PATH)
    public String getDbPath() {
        return dbPath;
    }

    public void setDbPath(String dbPath) {
        this.dbPath = dbPath;
    }

    @Override
    @Parameter(names = {"--db-log-path"}, description = ConfigDescriptions.DB_LOG_PATH)
    public String getDbLogPath() {
        return dbLogPath;
    }

    public void setDbLogPath(String dbLogPath) {
        this.dbLogPath = dbLogPath;
    }

    @Override
    @Parameter(names = {"--db-cache-size"}, description = ConfigDescriptions.DB_CACHE_SIZE)
    public int getDbCacheSize() {
        return dbCacheSize;
    }

    public void setDbCacheSize(int dbCacheSize) {
        this.dbCacheSize = dbCacheSize;
    }

    @Override
    @Parameter(names = {"--main-db"}, description = ConfigDescriptions.MAIN_DB)
    public String getMainDb() {
        return mainDb;
    }

    public void setMainDb(String mainDb) {
        this.mainDb = mainDb;
    }

    @Override
    @Parameter(names = {"--export"}, description = ConfigDescriptions.EXPORT)
    public boolean isExport() {
        return export;
    }

    public void setExport(boolean export) {
        this.export = export;
    }

    @Override
    @Parameter(names = {"--revalidate"}, description = ConfigDescriptions.EXPORT)
    public boolean isRevalidate() {
        return revalidate;
    }

    public void setRevalidate(boolean revalidate) {
        this.revalidate = revalidate;
    }

    @Override
    @Parameter(names = {"--rescan"}, description = ConfigDescriptions.EXPORT)
    public boolean isRescanDb() {
        return rescanDb;
    }

    public void setRescanDb(boolean rescanDb) {
        this.rescanDb = rescanDb;
    }

    @Override
    @Parameter(names = {"--mwm"}, description = ConfigDescriptions.MWM)
    public int getMwm() {
        return mwm;
    }

    public void setMwm(int mwm) {
        this.mwm = mwm;
    }

    @Override
    @Parameter(names = {"--packet-size"}, description = ConfigDescriptions.TRANSACTION_PACKET_SIZE)
    public int getTransactionPacketSize() {
        return transactionPacketSize;
    }

    public void setTransactionPacketSize(int transactionPacketSize) {
        this.transactionPacketSize = transactionPacketSize;
    }

    @Override
    @Parameter(names = {"--request-hash-size"}, description = ConfigDescriptions.REQUEST_HASH_SIZE)
    public int getRequestHashSize() {
        return requestHashSize;
    }

    public void setRequestHashSize(int requestHashSize) {
        this.requestHashSize = requestHashSize;
    }

    @Override
    @Parameter(names = {"--p-reply-random"}, description = ConfigDescriptions.P_REPLY_RANDOM_TIP)
    public float getpReplyRandomTip() {
        return pReplyRandomTip;
    }

    public void setpReplyRandomTip(float pReplyRandomTip) {
        this.pReplyRandomTip = pReplyRandomTip;
    }

    @Override
    @Parameter(names = {"--p-drop-transaction"}, description = ConfigDescriptions.P_DROP_TRANSACTION)
    public float getpDropTransaction() {
        return pDropTransaction;
    }

    public void setpDropTransaction(float pDropTransaction) {
        this.pDropTransaction = pDropTransaction;
    }

    @Override
    @Parameter(names = {"--p-select-milestone"}, description = ConfigDescriptions.P_SELECT_MILESTONE)
    public float getpSelectMilestoneChild() {
        return pSelectMilestoneChild;
    }

    public void setpSelectMilestoneChild(float pSelectMilestoneChild) {
        this.pSelectMilestoneChild = pSelectMilestoneChild;
    }

    @Override
    @Parameter(names = {"--p-send-milestone"}, description = ConfigDescriptions.P_SEND_MILESTONE)
    public float getpSendMilestone() {
        return pSendMilestone;
    }

    public void setpSendMilestone(float pSendMilestone) {
        this.pSendMilestone = pSendMilestone;
    }

    @Override
    @Parameter(names = {"--p-propagate-request"}, description = ConfigDescriptions.P_PROPAGATE_REQUEST)
    public float getpPropagateRequest() {
        return pPropagateRequest;
    }

    public void setpPropagateRequest(float pPropagateRequest) {
        this.pPropagateRequest = pPropagateRequest;
    }

    @Override
    @Parameter(names = {"--mwm"}, description = ConfigDescriptions.MWM)
    public int getMinimumWeightMagnitude() {
        return minimumWeightMagnitude;
    }

    public void setMinimumWeightMagnitude(int minimumWeightMagnitude) {
        this.minimumWeightMagnitude = minimumWeightMagnitude;
    }

    @Override
    @Parameter(names = "--snapshot-time", description = ConfigDescriptions.SNAPSHOT_TIME)
    public long getSnapshotTime() {
        return snapshotTime;
    }

    public void setSnapshotTime(long snapshotTime) {
        this.snapshotTime = snapshotTime;
    }

    @Override
    @Parameter(names = "--snapshot-file", description = ConfigDescriptions.SNAPSHOT_FILE)
    //TODO maybe change string to file. Experiment with Jackson before
    public String getSnapshotFile() {
        return snapshotFile;
    }

    public void setSnapshotFile(String snapshotFile) {
        this.snapshotFile = snapshotFile;
    }

    @Override
    @Parameter(names = "--snapshot-signature", description = ConfigDescriptions.SNAPSHOT_SIGNATURE_FILE)
    //TODO maybe change string to file. Experiment with Jackson before
    public String getSnapshotSignatureFile() {
        return snapshotSignatureFile;
    }

    public void setSnapshotSignatureFile(String snapshotSignatureFile) {
        this.snapshotSignatureFile = snapshotSignatureFile;
    }

    @Override
    @Parameter(names = "--milestone-start-index", description = ConfigDescriptions.MILESTONE_START_INDEX)
    public int getMilestoneStartIndex() {
        return milestoneStartIndex;
    }

    public void setMilestoneStartIndex(int milestoneStartIndex) {
        this.milestoneStartIndex = milestoneStartIndex;
    }

    @Override
    @Parameter(names = "--milestone-keys", description = ConfigDescriptions.MWM)
    public int getNumberOfKeysInMilestone() {
        return numberOfKeysInMilestone;
    }

    public void setNumberOfKeysInMilestone(int numberOfKeysInMilestone) {
        this.numberOfKeysInMilestone = numberOfKeysInMilestone;
    }

    @Override
    @Parameter(names = "--zmq-enabled", description = ConfigDescriptions.ZMQ_ENABLED)
    public boolean isZmqEnabled() {
        return zmqEnabled;
    }

    public void setZmqEnabled(boolean zmqEnabled) {
        this.zmqEnabled = zmqEnabled;
    }

    @Override
    @Parameter(names = "--zmq-port", description = ConfigDescriptions.ZMQ_PORT)
    public int getZmqPort() {
        return zmqPort;
    }

    public void setZmqPort(int zmqPort) {
        this.zmqPort = zmqPort;
    }

    @Override
    @Parameter(names = "--zmq-ipc", description = ConfigDescriptions.ZMQ_IPC)
    public String getZmqIpc() {
        return zmqIpc;
    }

    public void setZmqIpc(String zmqIpc) {
        this.zmqIpc = zmqIpc;
    }

    @Override
    @Parameter(names = "--queue-size", description = ConfigDescriptions.Q_SIZE_NODE)
    public int getQSizeNode() {
        return qSizeNode;
    }

    public void setQSizeNode(int qSizeNode) {
        this.qSizeNode = qSizeNode;
    }

    @Override
    @Parameter(names = "--p-drop-cache", description = ConfigDescriptions.P_DROP_CACHE_ENTRY)
    public int getPDropCacheEntry() {
        return pDropCacheEntry;
    }

    public void setpDropCacheEntry(int pDropCacheEntry) {
        this.pDropCacheEntry = pDropCacheEntry;
    }

    @Override
    @Parameter(names = "--p-cache-size", description = ConfigDescriptions.P_CACHE_SIZE_BYTES)
    public int getpCacheSizeBytes() {
        return pCacheSizeBytes;
    }

    public void setpCacheSizeBytes(int pCacheSizeBytes) {
        this.pCacheSizeBytes = pCacheSizeBytes;
    }

    @Override
    @Parameter(names = "--testnet-coordinator", description = ConfigDescriptions.COORDINATOR)
    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    @Override
    @Parameter(names = "--validate--testnet--milestone", description = ConfigDescriptions.VALIDATE_TESTNET_MILESTONE_SIG)
    public boolean isValidateTestnetMilestoneSig() {
        return validateTestnetMilestoneSig;
    }

    public void setValidateTestnetMilestoneSig(boolean validateTestnetMilestoneSig) {
        this.validateTestnetMilestoneSig = validateTestnetMilestoneSig;
    }

    @Override
    @Parameter(names = "--min-random-walks", description = ConfigDescriptions.MIN_RANDOM_WALKS)
    public int getMinRandomWalks() {
        return minRandomWalks;
    }

    public void setMinRandomWalks(int minRandomWalks) {
        this.minRandomWalks = minRandomWalks;
    }

    @Override
    @Parameter(names = "--max-random-walks", description = ConfigDescriptions.MAX_RANDOM_WALKS)
    public int getMaxRandomWalks() {
        return maxRandomWalks;
    }

    public void setMaxRandomWalks(int maxRandomWalks) {
        this.maxRandomWalks = maxRandomWalks;
    }

    @Override
    @Parameter(names = "--max-depth", description = ConfigDescriptions.MAX_RANDOM_WALKS)
    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }
}