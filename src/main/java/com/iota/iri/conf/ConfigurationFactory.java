package com.iota.iri.conf;

import com.beust.jcommander.JCommander;

import java.io.File;

public class ConfigurationFactory {

    public static <T extends Configuration> T parseConfiguration(Class<T> confClass, File confFile, String... argv) throws
            IllegalAccessException, InstantiationException {
        T config = confClass.newInstance();

        config = parseFromFile(config, confFile);
        return parseCli(config, argv);
    }

    private static <T extends Configuration> T parseFromFile(T config, File confFile) {
        return config;
    }


    private static <T extends Configuration> T parseCli(T config, String[] argv) {
        JCommander.newBuilder()
                .addObject(config)
                .allowParameterOverwriting(true)
                .build()
                .parse(argv);

        return config;
    }
}
