package com.tahoelafsgui.controller;

import com.tahoelafsgui.config.Constant;
import com.tahoelafsgui.gui.panel.FileScrollPanel;
import com.tahoelafsgui.pojo.FileNode;
import com.tahoelafsgui.pojo.FileStructure;

/**
 * @author liushen
 */
// 文件列表操作
public class FileListController {

    // 读取文件夹文件
    public static void loadDir(String hashVal) {
//        JsonUtil.toJson();
//        JsonUtil.fromJson();
        if (FileStructure.getInstance().getFileStructure().containsKey(hashVal)) {
            FileNode temp = FileStructure.getInstance().getFileStructure().get(hashVal);
            if (!hashVal.isEmpty()) {
                // 清空所有元素
                FileScrollPanel.getFileListModel().removeAllElements();
            }
            // 文件夹，插入文件夹中的元素
            if (temp.isDir()) {
                // 记录父级文件夹
                Constant.setParentNode(temp);
                for (String i : temp.getFileList()) {
                    FileNode cur = FileStructure.getInstance().getFileStructure().get(i);
                    FileScrollPanel.getFileListModel().addElement(cur);
                }
            } else {
                // 文件，插入当前文件
                FileScrollPanel.getFileListModel().addElement(temp);
            }
            System.out.println("成功读取文件");
        } else {
            // 清空所有元素
            FileScrollPanel.getFileListModel().removeAllElements();
            System.out.println("查无此文件");
        }
    }
}
