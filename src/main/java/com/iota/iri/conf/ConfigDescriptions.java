package com.iota.iri.conf;

public class ConfigDescriptions {

    private static final String PROB_OF = "A number between 0 and 1 that represents the probability of ";

    //Docs
    public static final String PORT_DESCRIPTION = "The port that will be used by the API.";
    public static final String API_HOST_DESCRIPTION = "The address of the server that will be used by the API.";
    public static final String UDP_RECIEVER_PORT_DESCRIPTION = "The UDP Reciever Port.";
    public static final String TCP_RECIEVER_PORT_DESCRIPTION = "The TCP Reciever Port.";
    public static final String TESTNET_DESCRIPTION = "The Testnet Description.";
    public static final String REMOTE_LIMIT_API_DESCRIPTION = "Commands that should be ignored by API.";
    public static final String NEIGHBORS_DESCRIPTION = "Urls of peer iota nodes.";
    public static final String IXI_DIR_DESCRIPTION = "The folder where ixi modules should be added for automatic discovery by IRI.";
    public static final String DB_PATH_DESCRIPTION = "The folder where the DB saves its data.";
    public static final String DB_LOG_PATH_DESCRIPTION = "The folder where the DB log path";
    public static final String DB_CACHE_SIZE_DESCRIPTION = "The size of the DB cache";
    public static final String P_REMOVE_REQUEST_DESCRIPTION = PROB_OF + " stopping to request a transaction. This number should be closer to 0 so non-existing transaction hashes will eventually be removed.";
    public static final String P_DROP_TRANSACTION_DESCRIPTION = PROB_OF + "dropping a recieved transaction. This is used only for testing purposes.";
    public static final String P_SELECT_MILESTONE_CHILD = PROB_OF + "requesting a milestone transction from a neighbor";
    public static final String
}
