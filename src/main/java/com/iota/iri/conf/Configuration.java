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
    String PORT_DESCRIPTION = "The port that will be used by the API.";
    String API_HOST_DESCRIPTION = "The address of the server that will be used by the API.";
    String UDP_RECIEVER_PORT_DESCRIPTION = "The UDP Reciever Port.";
    String TCP_RECIEVER_PORT_DESCRIPTION = "The TCP Reciever Port.";
    String TESTNET_DESCRIPTION = "The Testnet Description.";
    String REMOTE_LIMIT_API_DESCRIPTION = "Commands that should be ignored by API.";
    String NEIGHBORS_DESCRIPTION = "Urls of peer iota nodes.";
    String IXI_DIR_DESCRIPTION = "The folder where ixi modules should be added for automatic discovery by IRI.";
    String DB_PATH_DESCRIPTION = "The folder where the DB saves its data.";
    String DB_LOG_PATH_DESCRIPTION = "The folder where the DB log path";
    String DB_CACHE_SIZE_DESCRIPTION = "The size of the DB cache";
    String P_REMOVE_REQUEST_DESCRIPTION = PROB_OF + " stopping to request a transaction. This number should be " +
            "closer to 0 so non-existing transaction hashes will eventually be removed.";
    String P_DROP_TRANSACTION_DESCRIPTION = PROB_OF + "dropping a recieved transaction. This is used only for testing purposes.";
    String P_SELECT_MILESTONE_DESCRIPTION = PROB_OF + "requesting a milestone transaction from a neighbor. This should be a high since it is imperative that we find milestones to get transactions confirmed";
    String P_SEND_MILESTONE_DESCRIPTION = PROB_OF + "sending a milestone transaction when the node looks for a random transaction to send to a neighbor.";
    String P_REPLY_RANDOM_TIP = PROB_OF + "replying with a random transaction when no transaction is requested by a neighbor.";
    String P_PROPAGATE_REQUEST = PROB_OF + "propagating the request of a transaction to a neighbor node if it can't be found. This should be low since we don't want to propagate non-exisiting transactions that spam the network.";
    String MAIN_DB = "The DB used to store the transactions. Currently only rocksdb is supported.";
    String EXPORT = "Should"





    /**
     * @return {@value #PORT_DESCRIPTION}
     */
    int getApiPort();

    /**
     * @return {@value #API_HOST_DESCRIPTION}
     */
    String getApiHost();

    /**
     *
     * @return {@value #UDP_RECIEVER_PORT_DESCRIPTION}
     */
    int getUdpRecieverPort();

    /**
     * @return {@value #TCP_RECIEVER_PORT_DESCRIPTION}
     */
    int getTcpRecieverPort();


    /**
     * @return {@value #TESTNET_DESCRIPTION}
     */
    boolean isTestnet();

    /**
     * @return is in debug mode
     */
    boolean isDebug();

    /**
     * @return {@value REMOTE_LIMIT_API_DESCRIPTION}
     */
    Collection<String> getRemoteLimitApi();

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

    float getSelectMilestoneChildProbability();

    float getSendMilestoneProbability();

    float getReplyRandomTipProbability();

    float getPropagateRequestProbability();

    String getMainDb();

    boolean isExportingDataToFiles();

    int getSendLimit();

    int getMaxPeers();

    boolean isDnsRefresherEnabled();

    boolean isDnsResolutionEnabled();

    boolean isRevalidatingTangle();

    boolean isRescanningDb();

    int getMinimumWeightMagnitude();

    int getMinRandomWalks();

    int getMaxRandomWalks();

    int getMaxDepth();
}