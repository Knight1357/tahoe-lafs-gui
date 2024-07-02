package com.tahoelafsgui.gui.panel;

import com.tahoelafsgui.pojo.FileNode;

import javax.swing.*;
import java.awt.*;

// 文件列表单元格块
public class FileListCellPanel extends JPanel {

    public FileListCellPanel() {
        this.setVisible(true);
        this.setSize(850, 50);
        this.setPreferredSize(new Dimension(850, 50));
        this.setLayout(new BorderLayout());
    }

    public void init(FileNode fileNode) {
        // 显示其他信息
        JPanel otherInformationPanel = new JPanel();
        otherInformationPanel.setVisible(true);
        otherInformationPanel.setPreferredSize(new Dimension(300, 50));
        otherInformationPanel.setLayout(new GridLayout(1, 2, 10, 0));
        // 显示文件名
        JLabel fileName = new JLabel();
        fileName.setVisible(true);
        fileName.setSize(300, 50);
        fileName.setPreferredSize(new Dimension(300, 50));
        // 显示文件大小
        JLabel fileSize = new JLabel();
        fileSize.setVisible(true);
        fileSize.setSize(50, 50);
        fileSize.setPreferredSize(new Dimension(50, 50));
        // 显示文件数据
        JLabel fileDate = new JLabel();
        fileDate.setVisible(true);
        fileDate.setSize(100, 50);
        fileDate.setPreferredSize(new Dimension(100, 50));

        fileName.setText(fileNode.getName());
        fileSize.setText("null");
        fileDate.setText("null");

        // 图片
        ImageIcon imageIcon;
        // 设置图标种类
        if (fileNode.isDir()) {
            imageIcon = new ImageIcon("image/wenjianjia.png");
        } else {
            imageIcon = new ImageIcon("image/wenjian.png");
        }

        // 设置图标大小属性
        Image img = imageIcon.getImage();
        img = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        imageIcon.setImage(img);
        fileName.setIcon(imageIcon);

        this.add(fileName, BorderLayout.WEST);
        this.add(otherInformationPanel, BorderLayout.EAST);
        otherInformationPanel.add(fileSize);
        otherInformationPanel.add(fileDate);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
    }
}
