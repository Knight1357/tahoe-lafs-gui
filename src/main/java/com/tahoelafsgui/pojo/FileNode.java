package com.tahoelafsgui.pojo;

import lombok.Data;

import java.io.File;
import java.util.ArrayList;

/**
 * @author liushen
 */
@Data
public class FileNode {
    // 文件名
    private String name;
    // hash值
    private String hashVal;
    // 是否是文件
    private boolean isDir = false;
    // 文件大小
    private String size = "";
    // 文件内容
    private ArrayList<String> fileContents = new ArrayList<>();

    public FileNode(){
    }

    public FileNode(String name, String hashVal) {
        this.name = name;
        this.hashVal = hashVal;
        // 判断是不是文件
        String substr = hashVal.substring(4, 7);
        if ("DIR".equals(substr)) {
            this.isDir = true;
        }
    }

    @Override
    public String toString() {
        return this.hashVal;
    }
    public boolean isDir() {
        return isDir;
    }
}
