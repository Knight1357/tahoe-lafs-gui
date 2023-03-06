import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileNode {
    private String name = "";//文件名
    private String HashVal = "";//hash值
    private boolean isDir = false;//是否是文件
    private Float Size = 0f;//文件大小
    private ArrayList<String> FileContents = new ArrayList<>();//文件内容

    public FileNode(String name, String HashVal) {
        this.name = name;
        this.HashVal = HashVal;
        //判断是不是文件
        String substr = new String(HashVal.substring(4, 7));
//        System.out.println("substr="+substr);
        if (substr.equals("DIR"))
            this.isDir = true;
    }


    @Override
    public String toString() {
        return this.HashVal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashVal() {
        return HashVal;
    }

    public void setHashVal(String hashVal) {
        HashVal = hashVal;
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean dir) {
        isDir = dir;
    }

    public Float getSize() {
        return Size;
    }

    public void setSize(Float size) {
        Size = size;
    }

    public ArrayList<String> getFileContents() {
        return FileContents;
    }

    public void setFileContents(ArrayList<String> fileContents) {
        FileContents = fileContents;
    }
}
