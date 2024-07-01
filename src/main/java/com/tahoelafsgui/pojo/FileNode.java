package com.tahoelafsgui.pojo;

import java.util.ArrayList;

/**
 * @author liushen
 */
public class FileNode {
    // 文件名
    private String name = "";
    // hash值
    private String hashVal = "";
    // 是否是文件
    private boolean isDir = false;
    // 文件大小
    private String size = "";
    // 文件内容
    private ArrayList<String> fileContents = new ArrayList<>();

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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashVal() {
        return this.hashVal;
    }

    public void setHashVal(String hashVal) {
        this.hashVal = hashVal;
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean isDir) {
        this.isDir = isDir;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public ArrayList<String> getFileContents() {
        return this.fileContents;
    }

    public void setFileContents(ArrayList<String> fileContents) {
        this.fileContents = fileContents;
    }
}
