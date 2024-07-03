package com.tahoelafsgui.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author liushen
 */
// 读取配置文件
public class ConfigUtil {
    private final Properties properties;

    private ConfigUtil() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static class ConfigUtilHelper {
        private static final ConfigUtil INSTANCE = new ConfigUtil();
    }

    public static ConfigUtil getInstance() {
        return ConfigUtilHelper.INSTANCE;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
