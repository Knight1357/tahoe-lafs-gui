package UtilTest;

import com.tahoelafsgui.pojo.FileNode;
import com.tahoelafsgui.util.ConfigUtil;
import com.tahoelafsgui.util.JsonUtil;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.HashMap;

public class JsonUtilTest {
    public static void main(String[] args) {




        JsonUtil gsonUtil = JsonUtil.getInstance();
        // 读取配置文件


        // 从 JSON 文件读取配置
        try {
            HashMap hashMap = gsonUtil.fromJsonFile(ConfigUtil.getInstance().getProperty("data.path"), HashMap.class);
            System.out.println("Directory path from config: " + hashMap);

            // 修改配置并写入回 JSON 文件
            gsonUtil.toJsonFile(HashMap.class,ConfigUtil.getInstance().getProperty("test.path"));

        } catch (IOException e) {
            e.printStackTrace();
        }


        // 将 JSON 字符串转换为配置对象
//        Config newConfig = gsonUtil.fromJsonString(jsonString, Config.class);
//        System.out.println("Directory path from new config: " + newConfig.getDirectoryPath());

        // 将配置对象转换为 JSON 字符串
//        String jsonString = gsonUtil.toJsonString(dataPath);
//        System.out.println("JSON String: " + jsonString);


    }
}
