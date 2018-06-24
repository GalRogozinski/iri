package com.iota.iri;

import com.beust.jcommander.ParameterException;
import com.iota.iri.conf.Config;
import com.iota.iri.conf.ConfigUtils;
import com.iota.iri.conf.IotaConfig;
import com.iota.iri.service.API;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Main IOTA Reference Implementation starting class.
 */
public class IRI {

    public static final String MAINNET_NAME = "IRI";
    public static final String TESTNET_NAME = "IRI Testnet";
    public static final String VERSION = "1.5.0";

    public static void main(String[] args) throws Exception {
        // Logging is configured first before any references to Logger or LoggerFactory.
        // Any public method or field accessors needed in IRI should be put in IRI and then delegate to IRILauncher. That
        // ensures that future code does not need to know about this setup.
        configureLogging();
        IRILauncher.main(args);
    }

    private static void configureLogging() {
        String config = System.getProperty("logback.configurationFile");
        String level = System.getProperty("logging-level", "").toUpperCase();
        switch (level) {
            case "OFF":
            case "ERROR":
            case "WARN":
            case "INFO":
            case "DEBUG":
            case "TRACE":
                break;
            case "ALL":
                level = "TRACE";
                break;
            default:
                level = "INFO";
        }
        System.getProperties().put("logging-level", level);
        System.out.println("Logging - property 'logging-level' set to: [" + level + "]");
        if (config != null) {
            System.out.println("Logging - alternate logging configuration file specified at: '" + config + "'");
        }
    }

    private static class IRILauncher {
        private static final Logger log = LoggerFactory.getLogger(IRILauncher.class);

        public static Iota iota;
        public static API api;
        public static IXI ixi;

        private static final String TESTNET_FLAG_REQUIRED = "--testnet flag must be turned on to use ";

        public static void main(String [] args) throws Exception {
            IotaConfig config = createConfiguration(args);
            log.info("Welcome to {} {}", config.isTestnet() ? TESTNET_NAME : MAINNET_NAME, VERSION);

            iota = new Iota(config);
            ixi = new IXI(iota);
            api = new API(iota, ixi);
            shutdownHook();

            if (config.isExport()) {
                File exportDir = new File("export");
                if (!exportDir.exists()) {
                    log.info("Create directory 'export'");
                    try {
                        exportDir.mkdir();
                    } catch (SecurityException e) {
                        log.error("Could not create directory", e);
                    }
                }
                exportDir = new File("export-solid");
                if (!exportDir.exists()) {
                    log.info("Create directory 'export-solid'");
                    try {
                        exportDir.mkdir();
                    } catch (SecurityException e) {
                        log.error("Could not create directory", e);
                    }
                }
            }

            try {
                iota.init();
                api.init();
                //TODO redundant parameter but we will touch this when we refactor IXI
                ixi.init(config.getIxiDir());
                log.info("IOTA Node initialised correctly.");
            } catch (Exception e) {
                log.error("Exception during IOTA node initialisation: ", e);
                throw e;
            }
        }

        private static void shutdownHook() {
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                log.info("Shutting down IOTA node, please hold tight...");
                try {
                    ixi.shutdown();
                    api.shutDown();
                    iota.shutdown();
                } catch (Exception e) {
                    log.error("Exception occurred shutting down IOTA node: ", e);
                }
            }, "Shutdown Hook"));
        }

        private static IotaConfig createConfiguration(String[] args) {
            IotaConfig iotaConfig = null;
            try {
                boolean testnet = ArrayUtils.contains(args, Config.TESTNET_FLAG);
                if (IotaConfig.CONFIG_FILE.exists()) {
                    iotaConfig = ConfigUtils.createFromFile(IotaConfig.CONFIG_FILE, testnet);
                }
                else {
                    iotaConfig = ConfigUtils.createIotaConfig(testnet);
                }
                iotaConfig = ConfigUtils.parseFromArgs(args, iotaConfig);
            }
            catch (IOException | IllegalArgumentException e) {
                log.error("There was a problem reading configuration from file" , e);
                log.debug("" ,e);
                System.exit(-1);
            }
            catch (ParameterException e) {
                log.error("There was a problem parsing commandline arguments: {}", e.getMessage());
                log.debug("", e);
                System.exit(-1);
            }
            return iotaConfig;
        }
    }
}