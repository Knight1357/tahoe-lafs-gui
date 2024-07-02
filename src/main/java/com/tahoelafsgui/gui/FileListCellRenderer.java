package com.tahoelafsgui.gui;

import com.tahoelafsgui.config.Constant;
import com.tahoelafsgui.pojo.FileNode;

import javax.swing.*;
import java.awt.*;

/**
 * @author liushen
 */
public class FileListCellRenderer implements ListCellRenderer {
    private final FileListCellPanel fileListCellPanel = new FileListCellPanel();

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        FileNode fileNode = (FileNode) value;

        fileListCellPanel.init(fileNode);
        // 当某个元素被选中时，某个元素未被选中时（取消选中）
        if (isSelected) {
            // 设置前景色（文字颜色）为白色
            fileListCellPanel.setForeground(Color.WHITE);
            // 设置背景色为蓝色
            fileListCellPanel.setBackground(Color.LIGHT_GRAY);
            Constant.setIsSelectFileNode(fileNode);
        } else {
            // 设置前景色（文字颜色）为黑色
            fileListCellPanel.setForeground(Color.BLACK);
            // 设置背景色为白色
            fileListCellPanel.setBackground(Color.WHITE);
        }
        return fileListCellPanel;
    }

}




