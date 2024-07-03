package UtilTest;

import com.tahoelafsgui.pojo.FileNode;
import com.tahoelafsgui.util.ConfigUtil;
import com.tahoelafsgui.util.JsonUtil;

import java.io.IOException;
import java.util.HashMap;

public class JsonUtilTest {
    public static void main(String[] args) {

        JsonUtil gsonUtil = JsonUtil.getInstance();

        // 从 JSON 文件读取配置
        try {
            HashMap<String, FileNode> hashMap = new HashMap<>();
            hashMap = gsonUtil.fromJsonFileToMap(hashMap, ConfigUtil.getInstance().getProperty("data.path"));
            System.out.println("Directory path from config: " + hashMap);

            // 修改配置并写入回 JSON 文件
            gsonUtil.toJsonFileFromMap(hashMap, ConfigUtil.getInstance().getProperty("test.path"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
