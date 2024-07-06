package com.tahoelafsgui.gui.panel;

import com.tahoelafsgui.command.*;
import com.tahoelafsgui.config.Constant;
import com.tahoelafsgui.controller.FileOperations;
import com.tahoelafsgui.factory.ButtonFactory;
import com.tahoelafsgui.factory.FileButtonFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author liushen
 */
// 功能模块
public class FunctionPanel extends JPanel {

    private JButton searchButton;
    private JButton uploadButton;
    private JButton downloadButton;
    private JButton makeDirectoryButton;
    private JButton homeButton;
    private JButton foreButton;
    private JButton backButton;

    JPanel operateButtonPanel;
    JPanel searchPanel;
    JPanel fileSwitchPanel;
    JPanel operatePanel;


    public static JTextField searchTextField = new JTextField();

    public FunctionPanel() {
        // 功能模块设置
        setVisible(true);
        setSize(600, 100);
        setPreferredSize(new Dimension(600, 100));
        setLayout(new BorderLayout());
        InformationPanel informationPanel = new InformationPanel();

        // 命令
        FileOperations fileOperations = new FileOperations();
        // 按钮工厂
        ButtonFactory buttonFactory = new FileButtonFactory();

        // 文件操作模块
        operatePanel = new JPanel();
        operatePanel.setVisible(true);
        operatePanel.setSize(600, 80);
        operatePanel.setPreferredSize(new Dimension(600, 90));
        operatePanel.setLayout(new GridLayout(2, 1, 0, 0));

        // 文件搜索块
        searchPanel = new JPanel();
        searchPanel.setVisible(true);
        searchPanel.setSize(600, 40);
        searchPanel.setPreferredSize(new Dimension(600, 40));
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT));


        // 搜索文本框
        searchTextField.setVisible(true);
        searchTextField.setSize(400, 35);
        searchTextField.setPreferredSize(new Dimension(400, 35));

        // 搜索按钮
        searchButton = buttonFactory.createButton("搜索文件", new SearchCommand(fileOperations));
        searchButton.setSize(80, 35);
        searchButton.setPreferredSize(new Dimension(80, 35));

        // 文件操作按钮块
        operateButtonPanel = new JPanel();
        operateButtonPanel.setVisible(true);
        operateButtonPanel.setSize(400, 40);
        operateButtonPanel.setPreferredSize(new Dimension(400, 40));
        operateButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // 上传文件按钮
        uploadButton = buttonFactory.createButton("上传文件", new UploadCommand(fileOperations));
        uploadButton.setSize(80, 35);
        uploadButton.setPreferredSize(new Dimension(80, 35));


        // 下载文件按钮
        downloadButton = buttonFactory.createButton("下载文件", new DownloadCommand(fileOperations));
        downloadButton.setSize(80, 35);
        downloadButton.setPreferredSize(new Dimension(80, 35));

        // 新建文件按钮
        makeDirectoryButton = buttonFactory.createButton("新建文件", new CreateFinderCommand(fileOperations));
        makeDirectoryButton.setSize(80, 35);
        makeDirectoryButton.setPreferredSize(new Dimension(80, 35));

        // 文件切换
        fileSwitchPanel = new JPanel();
        fileSwitchPanel.setVisible(true);
        fileSwitchPanel.setSize(300, 60);
        fileSwitchPanel.setPreferredSize(new Dimension(300, 60));
        fileSwitchPanel.setLayout(new GridLayout(1, 3, 0, 0));

        // 主页 按钮
        homeButton = buttonFactory.createButton("主页", new HomeCommand(fileOperations));
        homeButton.setSize(80, 35);
        homeButton.setPreferredSize(new Dimension(80, 35));

        // 前按钮
        foreButton = buttonFactory.createButton("前进", new FrontCommand(fileOperations));
        foreButton.setSize(80, 35);
        foreButton.setPreferredSize(new Dimension(80, 35));

        // 退回按钮
        backButton = buttonFactory.createButton("退回", new BackCommand(fileOperations));
        backButton.setSize(80, 35);
        backButton.setPreferredSize(new Dimension(80, 35));

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
