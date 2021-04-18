package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfig {
    public static Config Load(String path) {
        Config config = new Config();

        Properties properties = new Properties();
        try {
            InputStream is = new FileInputStream(path);
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        config.MaxThreading = Integer.parseInt(properties.getProperty("MaxThreading"));
        config.MaxRandomAccountMoney = Integer.parseInt(properties.getProperty("MaxRandomAccountMoney"));

        return config;
    }
}
