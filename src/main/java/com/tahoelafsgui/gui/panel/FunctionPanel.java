package com.tahoelafsgui.gui.panel;

import com.tahoelafsgui.config.Constant;
import com.tahoelafsgui.controller.FileController;

import javax.swing.*;
import java.awt.*;

/**
 * @author liushen
 */
// 功能模块
public class FunctionPanel extends JPanel {

    public static JTextField searchTextField = new JTextField();

    public FunctionPanel() {
        // 功能模块设置
        setVisible(true);
        setSize(600, 100);
        setPreferredSize(new Dimension(600, 100));
        setLayout(new BorderLayout());

        InformationPanel informationPanel = new InformationPanel();


        // 文件操作模块
        JPanel operatePanel = new JPanel();
        operatePanel.setVisible(true);
        operatePanel.setSize(600, 80);
        operatePanel.setPreferredSize(new Dimension(600, 90));
        operatePanel.setLayout(new GridLayout(2, 1, 0, 0));

        // 文件搜索块
        JPanel searchPanel = new JPanel();
        searchPanel.setVisible(true);
        searchPanel.setSize(600, 40);
        searchPanel.setPreferredSize(new Dimension(600, 40));
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT));


        // 搜索文本框
        searchTextField.setVisible(true);
        searchTextField.setSize(400, 35);
        searchTextField.setPreferredSize(new Dimension(400, 35));

        // 搜索按钮
        JButton searchButton = new JButton();
        searchButton.setText("搜索文件");
        searchButton.setSize(80, 35);
        searchButton.setPreferredSize(new Dimension(80, 35));
        searchButton.addActionListener(e -> FileController.searchFile());


        // 文件操作按钮块
        JPanel operateButtonPanel = new JPanel();
        operateButtonPanel.setVisible(true);
        operateButtonPanel.setSize(400, 40);
        operateButtonPanel.setPreferredSize(new Dimension(400, 40));
        operateButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // 上传文件按钮
        JButton uploadButton = new JButton();
        uploadButton.setText("上传文件");
        uploadButton.setSize(80, 35);
        uploadButton.setPreferredSize(new Dimension(80, 35));
        uploadButton.addActionListener(e -> FileController.upLoadFile());


        // 下载文件按钮
        JButton downloadButton = new JButton();
        downloadButton.setText("下载文件");
        downloadButton.setSize(80, 35);
        downloadButton.setPreferredSize(new Dimension(80, 35));
        downloadButton.addActionListener(e -> {
            // 不是文件夹可以下载
            if (!Constant.getIsSelectFileNode().isDir()) {
                try {
                    System.out.println("下载文件正常");
                    FileController.downLoadFile();
                } catch (Exception ex) {
                    System.out.println("下载文件异常");
                    throw new RuntimeException(ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "下载失败\n无法下载文件夹");
            }
        });

        // 新建文件按钮
        JButton makeDirectoryButton = new JButton();
        makeDirectoryButton.setText("新建文件");
        makeDirectoryButton.setSize(80, 35);
        makeDirectoryButton.setPreferredSize(new Dimension(80, 35));
        // 新建文件
        makeDirectoryButton.addActionListener(e -> {
            String str = JOptionPane.showInputDialog(null, "请输入文件名称：\n", "新建文件", JOptionPane.PLAIN_MESSAGE);
            System.out.println(str);
            if (!str.isEmpty()) {
                try {
                    System.out.println("新建文件正常");
                    FileController.creatFile(str);
                } catch (Exception ex) {
                    System.out.println("新建文件异常");
                    throw new RuntimeException(ex);
                }
            }
        });

        // 文件切换
        JPanel fileSwitchPanel = new JPanel();
        fileSwitchPanel.setVisible(true);
        fileSwitchPanel.setSize(300, 60);
        fileSwitchPanel.setPreferredSize(new Dimension(300, 60));
        fileSwitchPanel.setLayout(new GridLayout(1, 3, 0, 0));

        // home 按钮
        JButton homeButton = new JButton();
        homeButton.setText("home");
        homeButton.setSize(80, 35);
        homeButton.setPreferredSize(new Dimension(80, 35));
        homeButton.addActionListener(e -> FileController.goToHome());

        // 前按钮
        JButton foreButton = new JButton();
        foreButton.setText("前进");
        foreButton.setSize(80, 35);
        foreButton.setPreferredSize(new Dimension(80, 35));
        foreButton.addActionListener(e -> FileController.goToFore());

        // 退回按钮
        JButton backButton = new JButton();
        backButton.setText("退回");
        backButton.setSize(80, 35);
        backButton.setPreferredSize(new Dimension(80, 35));
        backButton.addActionListener(e -> FileController.goToBack());

        // 添加文件操作块
        add(operatePanel, BorderLayout.WEST);
        // 添加搜索块
        operatePanel.add(searchPanel);
        // 添加搜索文本框
        searchPanel.add(searchTextField);
        // 添加搜索按钮
        searchPanel.add(searchButton);
        // 添加文件操作块
        operatePanel.add(operateButtonPanel);
        // 添加上传文件按钮
        operateButtonPanel.add(uploadButton);
        // 添加下载文件按钮
        operateButtonPanel.add(downloadButton);
        // 添加新建文件夹按钮
        operateButtonPanel.add(makeDirectoryButton);

        add(fileSwitchPanel, BorderLayout.EAST);

        fileSwitchPanel.add(homeButton);

        fileSwitchPanel.add(backButton);

        fileSwitchPanel.add(foreButton);

        // 添加信息块
        add(informationPanel, BorderLayout.SOUTH);
    }
}
