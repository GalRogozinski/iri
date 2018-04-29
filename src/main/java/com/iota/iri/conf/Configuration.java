package com.iota.iri.conf;

import java.util.Collection;

/**
 * Main configuration interface
 */
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

    String PROB_OF = "A number between 0 and 1 that represents the probability of ";

    //Docs
    //API
    String PORT_DESCRIPTION = "The port that will be used by the API.";
    String API_HOST_DESCRIPTION = "The address of the server that will be used by the API.";
    String REMOTE_LIMIT_API_DESCRIPTION = "Commands that should be ignored by API.";
    String MAX_FIND_TRANSACTIONS_DESCRIPTION = "The maximal number of transactions that may be returned by the \"findTransactions\" API call. If the number of transactions found exceeds this number an error will be returned.";
    String MAX_REQUSTS_LISTS_DESCRIPTION = "The maximal number of parameters one can place in an API call. If the number parameters exceeds this number an error will be returned";
    String MAX_GET_TRYTES_DESCRIPTION = "The maximal number of trytes that may be returned by the \"getTrytes\" API call. If the number of transactions found exceeds this number an error will be returned.";
    String MAX_BODY_LENGTH_DESCRIPTION = "The maximal number of characters the body of an API call may hold. If a request body length exeeds this number an error will be returned.";

    //Network
    String UDP_RECIEVER_PORT_DESCRIPTION = "The UDP Reciever Port.";
    String TCP_RECIEVER_PORT_DESCRIPTION = "The TCP Reciever Port.";
    String P_REMOVE_REQUEST_DESCRIPTION = PROB_OF + " stopping to request a transaction. This number should be " +
            "closer to 0 so non-existing transaction hashes will eventually be removed.";
    String P_DROP_TRANSACTION_DESCRIPTION = PROB_OF + "dropping a recieved transaction. This is used only for testing purposes.";
    String P_SELECT_MILESTONE_DESCRIPTION = PROB_OF + "requesting a milestone transaction from a neighbor. This should be a high since it is imperative that we find milestones to get transactions confirmed";
    //TODO add a better explanation
    String P_SEND_MILESTONE_DESCRIPTION = PROB_OF + "sending a milestone transaction when the node looks for a random transaction to send to a neighbor.";
    //TODO add a better explanation
    String P_REPLY_RANDOM_TIP = PROB_OF + "replying with a random transaction when no transaction is requested by a neighbor.";
    String P_PROPAGATE_REQUEST = PROB_OF + "propagating the request of a transaction to a neighbor node if it can't be found. This should be low since we don't want to propagate non-exisiting transactions that spam the network.";
    String SEND_LIMIT = "The maximum number of packets that may be sent by this node in a 1 second interval. If this number is below 0 then there is no limit.";
    String MAX_PEERS = "The maximum number of neighbors this node can have. If 0 then there is no limit.";
    String DNS_REFRESHER_ENABLED = "Reconnect to neighbors that have dynamic IPs.";
    String DNS_RESOLUTION_ENABLED = "Enable using DNS for neighbor peering.";
    String NEIGHBORS_DESCRIPTION = "Urls of peer iota nodes.";

    //General
    String TESTNET_DESCRIPTION = "The Testnet Description.";

    //IXI
    String IXI_DIR_DESCRIPTION = "The folder where ixi modules should be added for automatic discovery by IRI.";

    //DB
    String DB_PATH_DESCRIPTION = "The folder where the DB saves its data.";
    String DB_LOG_PATH_DESCRIPTION = "The folder where the DB log path";
    String DB_CACHE_SIZE_DESCRIPTION = "The size of the DB cache";
    String MAIN_DB = "The DB used to store the transactions. Currently only rocksdb is supported.";
    String EXPORT = "Enable exporting the transaction data to files.";
    String REVALIDATE = "Reload from the db data about confirmed transaction (milestones), state of the ledger, and transaction metadata.";
    String RESCAN_DB = "Rescan all transaction metadata (Approvees, Bundles, and Tags)";

    //Protocol
    String MWM_DESCRIPTION = "The minimum weight magnitude is the number of trailing 0s that must appear in the end of a transaction hash. Increasing this number by 1 will result in proof of work that is 3 times as hard.";
    String TRANSACTION_PACKET_SIZE_DESCRIPTION = "The size of the packet in bytes recieved by a node. In the mainnet the packet size should always be 1650. It consists of 1604 bytes of a received transaction and 46 bytes of a requested transaction hash. This value can be changed in order to create testnets with different rules.";
    String REQUEST_HASH_SIZE_DESCRIPTION = "The size of the requested hash in a packet. It's size is derived from the minimal MWM value the network accepts. The larger the MWM -> the more trailing zeroes we can ignore -> smaller hash size.";

    //Snapshot
    String SNAPSHOT_TIME_DESCRIPTION = "Epoch time of the last snapshot.";
    String SNAPSHOT_SIGNATURE_FILE_DESCRIPTION = "Path to the file that validates the snapshot used is indeed valid";
    String MILESTONE_START_INDEX_DESCRIPTION = "The start index of the milestones. This index is encoded in each milestone transaction by the coordinator.";
    String NUMBER_OF_KEYS_IN_A_MILESTONE_DESCRIPTION = "The height of the merkle tree which in turn determines the number leaves (private keys) that the coordinator can use to sign a message.";
    String SNAPSHOT_FILE_DESCRIPTION = "Path of the file that contains the state of the ledger since the last snapshot";


    //Tip Selection
    String MIN_RANDOM_WALKS_DESCRIPTION = "The minimal number of random walks (part of the mcmc tip selection algorithm) to perform when selecting transactions to approve.";
    String MAX_RANDOM_WALKS_DESCRIPTION = "The maximal number of random walks (part of the mcmc tip selection algorithm) to perform when selecting transactions to approve.";
    String MAX_DEPTH_DESCRIPTION = "The maximal number of previous milestones from where you can perform the random walk";

    //ZMQ
    String ZMQ_ENABLED_DESCRIPTION = "Enabling zmq channels.";
    String ZMQ_PORT_DESCRIPTION = "The port used to connect to the ZMQ feed";
    String ZMQ_IPC_DESCRIPTION = "The path that is used to communicate with ZMQ in IPC";
    String Q_SIZE_NODE_DESCRIPTION = "The size of the REPLY, BROADCAST, and RECIEVE network queues.";
    //TODO ask Alon about why we use LRU and Random cache replacement
    String P_DROP_CACHE_ENTRY_DESCRIPTION = PROB_OF + "dropping recently seen transactions out of the network cache.";
    String P_CACHE_SIZE_BYTES_DESCRIPTION = "The size of the network cache in bytes";

    //coordinator
    String COORDINATOR_DESCRIPTION = "The address of the coordinator";
    String VALIDATE_TESTNET_MILESTONE_SIG_DESCRIPTION = "Enable coordinator validation on testnet";










//API

    /**
     * @return {@value #PORT_DESCRIPTION}
     */
    int getPort();

    /**
     * @return {@value #API_HOST_DESCRIPTION}
     */
    String getApiHost();

    /**
     * @return {@value REMOTE_LIMIT_API_DESCRIPTION}
     */
    Collection<String> getRemoteLimitApi();

    /**
     *
     * @return
     */
    int getMaxFindTransactions();

    int getMaxRequestList();

    int getMaxGetTrytes();

    int getMaxBodyLength();


    //Network

    int getUdpRecieverPort();

    int getTcpRecieverPort();

    float getpRemoveRequest();

    float getpDropTransaction();

    int getpDropSelectMilestone();

    float getpSendMilestone();

    float getpReplyRandomTip();

    float getpPropagateRequest();



    /**
     * @return {@value #TESTNET_DESCRIPTION}
     */
    boolean isTestnet();

    /**
     * @return is in debug mode
     */
    boolean isDebug();


    /**
     * This returns the user credentials needed to connect to the API
     *
     * @return String in the format {user_name}:{password}. {@code Null} or empty strings mean all users can access
     * the API
     **/
    String getRemoteAuth();

    /**
     * @return {@value NEIGHBORS_DESCRIPTION}
     */
    Collection<String> getNeighbors();

    /**
     * @return
     */
    String getIxiDir();

    String getDbPath();

    String getDbLogPath();

    int getDbCacheSize();

    float getRemoveRequestProbability();

    float getDropTransactionProbability();

    float getpSelectMilestoneChild();

    float getSendMilestoneProbability();

    float getReplyRandomTipProbability();

    float getPropagateRequestProbability();

    int getTransactionPacketSize();

    String getMainDb();

    boolean isExportingDataToFiles();

    int getSendLimit();

    int getMaxPeers();

    boolean isDnsRefresherEnabled();

    boolean isDnsResolutionEnabled();

    boolean isRevalidatingTangle();

    boolean isRescanDb();

    int getMinimumWeightMagnitude();

    int getMinRandomWalks();

    int getMaxRandomWalks();

    int getMaxDepth();


//    int getMaxFind
}