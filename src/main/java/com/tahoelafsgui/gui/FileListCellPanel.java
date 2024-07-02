package com.tahoelafsgui.gui;

import com.tahoelafsgui.pojo.FileNode;

import javax.swing.*;
import java.awt.*;

public // 文件列表单元格块
class FileListCellPanel extends JPanel {
    private final FileOtherInformationPanel otherInformationPanel = new FileOtherInformationPanel();
    private final FileNameCellLabel fileName;
    private final FileSizeCellLable fileSize;
    private final FileDateCellLabel fileDate;

    FileListCellPanel() {
        this.setVisible(true);
        this.setSize(850, 50);
        this.setPreferredSize(new Dimension(850, 50));
        this.setLayout(new BorderLayout());


        fileName = new FileNameCellLabel();
        fileSize = new FileSizeCellLable();
        fileDate = new FileDateCellLabel();
    }

    public void init(FileNode fileNode) {
        this.setVisible(true);
        this.setSize(850, 50);
        this.setPreferredSize(new Dimension(850, 50));
        this.setLayout(new BorderLayout());

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

    // 文件名字标签
    static class FileNameCellLabel extends JLabel {
        FileNameCellLabel() {
            this.setVisible(true);
            this.setSize(300, 50);
            this.setPreferredSize(new Dimension(300, 50));
        }
    }

    // 文件其他信息块
    static class FileOtherInformationPanel extends JPanel {

        FileOtherInformationPanel() {
            this.setVisible(true);
            this.setPreferredSize(new Dimension(300, 50));
            this.setLayout(new GridLayout(1, 2, 10, 0));
        }
    }

    // 文件大小标签
    static class FileSizeCellLable extends JLabel {
        FileSizeCellLable() {
            this.setVisible(true);
            this.setSize(50, 50);
            this.setPreferredSize(new Dimension(50, 50));
        }
    }

    // 文件日期标签
    static class FileDateCellLabel extends JLabel {
        FileDateCellLabel() {
            this.setVisible(true);
            this.setSize(100, 50);
            this.setPreferredSize(new Dimension(100, 50));
        }
    }
}
