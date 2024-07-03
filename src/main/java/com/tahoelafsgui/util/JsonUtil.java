package com.tahoelafsgui.util;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.tahoelafsgui.pojo.FileNode;
import com.tahoelafsgui.pojo.FileStructure;

import java.io.*;
import java.util.HashMap;

/**
 * @author liushen
 */
public class JsonUtil {
    private static JsonUtil instance;
    private final Gson gson;

    private JsonUtil() {
        gson = new Gson();
    }

    public static JsonUtil getInstance() {
        if (instance == null) {
            synchronized (JsonUtil.class) {
                if (instance == null) {
                    instance = new JsonUtil();
                }
            }
        }
        return instance;
    }

    // 将 JSON 文件转换为对象
    public <T> T fromJsonFile(String filePath, Class<T> classOfT) throws IOException {
        try (Reader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, classOfT);
        } catch (JsonIOException | JsonSyntaxException e) {
            throw new IOException("Failed to parse JSON from file", e);
        }
    }

    // 将对象转换为 JSON 文件
    public void toJsonFile(Object src, String filePath) throws IOException {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(src, writer);
        } catch (JsonIOException e) {
            throw new IOException("Failed to write JSON to file", e);
        }
    }

    // 将 JSON 字符串转换为对象
    public <T> T fromJsonString(String jsonString, Class<T> classOfT) {
        return gson.fromJson(jsonString, classOfT);
    }

    // 将对象转换为 JSON 字符串
    public String toJsonString(Object src) {
        return gson.toJson(src);
    }
}

