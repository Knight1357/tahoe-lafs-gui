package com.tahoelafsgui.config;

import java.util.ArrayList;

/**
 * @author liushen
 */ // 配置文件
public class Constant {
    //用户根目录路径
    private static final String USER_PATH = "URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka";

    private static String introducerAPI = "127.0.0.1:3456";

    private static final ArrayList<String> filelocationlist = new ArrayList<>() {
        {
            add(USER_PATH);//初始化链表
        }
    };//控制前进退回

    public static String getIntroducerAPI() {
        return introducerAPI;
    }

    public static String getFileLocationNode(int index) {
        return filelocationlist.get(index);
    }

    public static int getFileLocationListSize() {
        return filelocationlist.size();
    }

    public static void addFileLocationNode(String hashVal) {
        filelocationlist.add(hashVal);
    }


    //文件指向
    public static int currentFile = 0;
    //父级文件夹路径
    private static FileNode parentNode;
    //目前选中的文件
    private static FileNode isSelectFileNode;


    public static FileNode getParentNode() {
        return parentNode;
    }

    public static void setParentNode(FileNode parentNode) {
        Constant.parentNode = parentNode;
    }

    public static String getUserPath() {//获得根目录路径
        return USER_PATH;
    }


    public static FileNode getIsSelectFileNode() {//获得目前选中的文件
        return isSelectFileNode;
    }

    //设置当前选中的文件
    public static void setIsSelectFileNode(FileNode isSelectFileNode) {
        Constant.isSelectFileNode = isSelectFileNode;
        System.out.println("设置了 " + isSelectFileNode.getName());
    }
}
