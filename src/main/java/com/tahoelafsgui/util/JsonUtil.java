package com.tahoelafsgui.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tahoelafsgui.pojo.FileNode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author liushen
 */
public class JsonUtil {
    Gson gson;
    public JsonUtil(){
        gson=new Gson();
    }

    // 写入json文件
    public void toJson() {
        // 写入到data.json文件
        try {
            FileWriter writer = new FileWriter("src/main/resources/data/Data.json");
            gson.toJson(fileContents, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 读取json文件
    public void fromJson() {
        // 读取json
        FileReader reader = null;
        try {
            // 读取的json文件
            reader = new FileReader("src/main/resources/data/Data.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        fileContents = gson.fromJson(reader, new TypeToken<HashMap<String, FileNode>>() {
        }.getType());
        System.out.println(fileContents);
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
