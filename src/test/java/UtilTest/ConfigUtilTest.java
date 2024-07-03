package UtilTest;

import com.tahoelafsgui.util.ConfigUtil;

public class ConfigUtilTest {
    public static void main(String[] args) {
        // 读取配置属性示例
        ConfigUtil configManager = ConfigUtil.getInstance();

        String directoryPath = configManager.getProperty("introducer.ip");
        System.out.println("Introducer ip from config: " + directoryPath);

        String dataPath = configManager.getProperty("data.path");
        System.out.println("Data path from config: " + dataPath);

        String picsPath = configManager.getProperty("pics.path");
        System.out.println("Pictures path from config: " + picsPath);

    }
}
