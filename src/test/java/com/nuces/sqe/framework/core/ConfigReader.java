package com.nuces.sqe.framework.core;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static Properties load(String filename) {
        Properties props = new Properties();
        try (FileInputStream file = new FileInputStream("src/test/resources/" + filename)) {
            props.load(file);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file: " + filename, e);
        }
        return props;
    }
}
