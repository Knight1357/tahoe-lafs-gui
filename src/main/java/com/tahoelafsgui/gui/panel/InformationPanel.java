package com.tahoelafsgui.gui.panel;

import javax.swing.*;
import java.awt.*;


/**
 * @author liushen
 */
// 信息块
public class InformationPanel extends JPanel {
    // 信息块设置
    public InformationPanel() {

        setVisible(true);
        setSize(600, 20);
        setPreferredSize(new Dimension(600, 20));
        setLayout(new BorderLayout(10, 0));

        // 首部分信息块
        JPanel firstInformationPanel = new JPanel();
        firstInformationPanel.setVisible(true);
        firstInformationPanel.setPreferredSize(new Dimension(300, 20));
        firstInformationPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        // 文件名标签
        JLabel fileNameLabel = new JLabel();
        fileNameLabel.setVisible(true);
        fileNameLabel.setSize(100, 20);
        fileNameLabel.setPreferredSize(new Dimension(100, 20));
        fileNameLabel.setText("文件名称");

        // 文件其他信息块
        JPanel otherInformationPanel = new JPanel();
        otherInformationPanel.setVisible(true);
        otherInformationPanel.setPreferredSize(new Dimension(300, 20));
        otherInformationPanel.setLayout(new GridLayout(1, 2, 10, 0));

        // 文件大小标签
        JLabel fileSizeLabel = new JLabel();
        fileSizeLabel.setVisible(true);
        fileSizeLabel.setSize(100, 20);
        fileSizeLabel.setPreferredSize(new Dimension(100, 20));
        fileSizeLabel.setText("文件大小");

        // 文件日期标签
        JLabel fileDateLabel = new JLabel();
        fileDateLabel.setVisible(true);
        fileDateLabel.setSize(100, 20);
        fileDateLabel.setPreferredSize(new Dimension(100, 20));
        fileDateLabel.setText("文件日期");

        // 添加首要信息块
        add(firstInformationPanel, BorderLayout.WEST);
        // 添加文件名列
        firstInformationPanel.add(fileNameLabel);
        // 添加其他信息块
        add(otherInformationPanel, BorderLayout.EAST);
        // 添加文件大小列
        otherInformationPanel.add(fileSizeLabel);
        // 添加文件日期列
        otherInformationPanel.add(fileDateLabel);
    }
}
