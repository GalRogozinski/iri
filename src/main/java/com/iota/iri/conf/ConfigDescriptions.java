package com.iota.iri.conf;

public class ConfigDescriptions {

    private static final String PROB_OF = "A number between 0 and 1 that represents the probability of ";

    //API
    public static final String PORT_ = "The port that will be used by the API.";
    public static final String API_HOST_ = "The address of the server that will be used by the API.";
    public static final String REMOTE_LIMIT_API_ = "Commands that should be ignored by API.";
    public static final String REMOTE_AUTH = "A string in the form of <user>:<password>. Used to access the API";
    public static final String MAX_FIND_TRANSACTIONS_ = "The maximal number of transactions that may be returned by the \"findTransactions\" API call. If the number of transactions found exceeds this number an error will be returned.";
    public static final String MAX_REQUESTS_LIST_ = "The maximal number of parameters one can place in an API call. If the number parameters exceeds this number an error will be returned";
    public static final String MAX_GET_TRYTES_ = "The maximal number of trytes that may be returned by the \"getTrytes\" API call. If the number of transactions found exceeds this number an error will be returned.";
    public static final String MAX_BODY_LENGTH_ = "The maximal number of characters the body of an API call may hold. If a request body length exeeds this number an error will be returned.";

    //Network
    public static final String UDP_RECIEVER_PORT_ = "The UDP Reciever Port.";
    public static final String TCP_RECIEVER_PORT_ = "The TCP Reciever Port.";
    public static final String P_REMOVE_REQUEST_ = PROB_OF + " stopping to request a transaction. This number should be " +
            "closer to 0 so non-existing transaction hashes will eventually be removed.";
    public static final String SEND_LIMIT = "The maximum number of packets that may be sent by this node in a 1 second interval. If this number is below 0 then there is no limit.";
    public static final String MAX_PEERS = "The maximum number of neighbors this node can have. If 0 then there is no limit.";
    public static final String DNS_REFRESHER_ENABLED = "Reconnect to neighbors that have dynamic IPs.";
    public static final String DNS_RESOLUTION_ENABLED = "Enable using DNS for neighbor peering.";

    //General
    public static final String TESTNET_ = "The Testnet .";
    public static final String NEIGHBORS_ = "Urls of peer iota nodes.";

    //IXI
    public static final String IXI_DIR_ = "The folder where ixi modules should be added for automatic discovery by IRI.";

    //DB
    public static final String DB_PATH_ = "The folder where the DB saves its data.";
    public static final String DB_LOG_PATH_ = "The folder where the DB log path";
    public static final String DB_CACHE_SIZE_ = "The size of the DB cache";
    public static final String MAIN_DB = "The DB used to store the transactions. Currently only rocksdb is supported.";
    public static final String EXPORT = "Enable exporting the transaction data to files.";
    public static final String REVALIDATE = "Reload from the db data about confirmed transaction (milestones), state of the ledger, and transaction metadata.";
    public static final String RESCAN_DB = "Rescan all transaction metadata (Approvees, Bundles, and Tags)";

    //Protocol
    public static final String MWM_ = "The minimum weight magnitude is the number of trailing 0s that must appear in the end of a transaction hash. Increasing this number by 1 will result in proof of work that is 3 times as hard.";
    public static final String TRANSACTION_PACKET_SIZE_ = "The size of the packet in bytes recieved by a node. In the mainnet the packet size should always be 1650. It consists of 1604 bytes of a received transaction and 46 bytes of a requested transaction hash. This value can be changed in order to create testnets with different rules.";
    public static final String REQUEST_HASH_SIZE_ = "The size of the requested hash in a packet. It's size is derived from the minimal MWM value the network accepts. The larger the MWM -> the more trailing zeroes we can ignore -> smaller hash size.";
    public static final String P_DROP_TRANSACTION_ = PROB_OF + "dropping a recieved transaction. This is used only for testing purposes.";
    public static final String P_SELECT_MILESTONE_ = PROB_OF + "requesting a milestone transaction from a neighbor. This should be a high since it is imperative that we find milestones to get transactions confirmed";
    //TODO add a better explanation
    public static final String P_SEND_MILESTONE_ = PROB_OF + "sending a milestone transaction when the node looks for a random transaction to send to a neighbor.";
    //TODO add a better explanation
    public static final String P_REPLY_RANDOM_TIP = PROB_OF + "replying with a random transaction when no transaction is requested by a neighbor.";
    public static final String P_PROPAGATE_REQUEST = PROB_OF + "propagating the request of a transaction to a neighbor node if it can't be found. This should be low since we don't want to propagate non-exisiting transactions that spam the network.";
    public static final String Q_SIZE_NODE_ = "The size of the REPLY, BROADCAST, and RECIEVE network queues.";
    //TODO ask Alon about why we use both LRU and Random cache replacement
    public static final String P_DROP_CACHE_ENTRY_ = PROB_OF + "dropping recently seen transactions out of the network cache.";
    public static final String P_CACHE_SIZE_BYTES_ = "The size of the network cache in bytes";

    //Snapshot
    public static final String SNAPSHOT_TIME_ = "Epoch time of the last snapshot.";
    public static final String SNAPSHOT_FILE_ = "Path of the file that contains the state of the ledger since the last snapshot";
    public static final String SNAPSHOT_SIGNATURE_FILE_ = "Path to the file that validates the snapshot used is indeed valid";
    public static final String MILESTONE_START_INDEX_ = "The start index of the milestones. This index is encoded in each milestone transaction by the coordinator.";
    public static final String NUMBER_OF_KEYS_IN_A_MILESTONE_ = "The height of the merkle tree which in turn determines the number leaves (private keys) that the coordinator can use to sign a message.";


    //Tip Selection
    public static final String MIN_RANDOM_WALKS_ = "The minimal number of random walks (part of the mcmc tip selection algorithm) to perform when selecting transactions to approve.";
    public static final String MAX_RANDOM_WALKS_ = "The maximal number of random walks (part of the mcmc tip selection algorithm) to perform when selecting transactions to approve.";
    public static final String MAX_DEPTH = "The maximal number of previous milestones from where you can perform the random walk";

    //ZMQ
    public static final String ZMQ_ENABLED_ = "Enabling zmq channels.";
    public static final String ZMQ_PORT_ = "The port used to connect to the ZMQ feed";
    public static final String ZMQ_IPC_ = "The path that is used to communicate with ZMQ in IPC";


    //coordinator
    public static final String COORDINATOR_ = "The address of the coordinator";
    public static final String VALIDATE_TESTNET_MILESTONE_SIG_ = "Enable coordinator validation on testnet";
}
