package com.iota.iri.conf;

import java.util.List;
import java.util.Set;

public class IotaConfiguration implements Configuration {


    private int port;

    private String apiHost;

    private int udpRecieverPort;

    private int tcpRecieverPort;

    private boolean testnet;

    private boolean debug;

    private Set<String> remoteLimitApi;

    private String remoteAuth;

    private Set<String> neighbors;

    private Set<String> ixiDir;

    private String dbPath;

    private String dbLogPath;

    private int dbCacheSize;

    private float pRemoveRequest;

    private float pDropTransaction;

    private float pSelectMilestoneChild;

    private float pReplyRandomTipProbability;

    private float pPropagateRequestProbability;

    private String mainDb;

    private boolean export;

    private int sendLimit;

    private int maxPeers;

    private boolean dnsResolutionEnabled;

    private boolean dnsRefresherEnabled;

    private String coordinator;

    private boolean dontValidateTestnetMilestoneSig;

    private boolean revalidate;

    private boolean rescanDb;

    private int minRandomWalks;

    private int maxRandomWalks;

    private int maxFindTransactions;

    private int maxRequestList;

    private int maxGetTrytes;

    private int maxBodyLength;

    private int maxDepth;

    private int minimumWeightMagnitude;



}
