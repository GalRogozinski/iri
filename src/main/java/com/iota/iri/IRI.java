package com.iota.iri;

import com.iota.iri.conf.Configuration;
import com.iota.iri.conf.IotaConfiguration;
import com.iota.iri.service.API;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Main IOTA Reference Implementation starting class
 */
public class IRI {

    private static final Logger log = LoggerFactory.getLogger(IRI.class);

    public static final String MAINNET_NAME = "IRI";
    public static final String TESTNET_NAME = "IRI Testnet";
    public static final String VERSION = "1.4.2.3";
    public static Iota iota;
    public static API api;
    public static IXI ixi;
    public static Configuration configuration;
    private static final String TESTNET_FLAG_REQUIRED = "--testnet flag must be turned on to use ";

    public static void main(final String[] args) throws IOException {
        configuration = new IotaConfiguration();
        log.info("Welcome to {} {}", configuration.isTestnet() ? TESTNET_NAME : MAINNET_NAME, VERSION);
        iota = new Iota(configuration);
        ixi = new IXI(iota);
        api = new API(iota, ixi);
        shutdownHook();

        if (configuration.isDebug()) {
            log.info("You have set the debug flag. To enable debug output, you need to uncomment the DEBUG appender in the source tree at iri/src/main/resources/logback.xml and re-package iri.jar");
        }

        if (configuration.isExport()) {
            File exportDir = new File("export");
            // if the directory does not exist, create it
            if (!exportDir.exists()) {
                log.info("Create directory 'export'");
                try {
                    exportDir.mkdir();
                } catch (SecurityException e) {
                    log.error("Could not create directory", e);
                }
            }
            exportDir = new File("export-solid");
            // if the directory does not exist, create it
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
            ixi.init(configuration.getIxiDir());
        } catch (final Exception e) {
            log.error("Exception during IOTA node initialisation: ", e);
            System.exit(-1);
        }
        log.info("IOTA Node initialised correctly.");
    }

    private static void shutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

            log.info("Shutting down IOTA node, please hold tight...");
            try {
                ixi.shutdown();
                api.shutDown();
                iota.shutdown();
            } catch (final Exception e) {
                log.error("Exception occurred shutting down IOTA node: ", e);
            }
        }, "Shutdown Hook"));
    }
}
