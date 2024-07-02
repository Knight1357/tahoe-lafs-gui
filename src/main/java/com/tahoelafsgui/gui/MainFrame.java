package com.tahoelafsgui.gui;

import com.tahoelafsgui.config.Constant;
import com.tahoelafsgui.controller.FileController;
import com.tahoelafsgui.pojo.FileNode;
import com.tahoelafsgui.pojo.dto.FileNodeDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

/**
 * @author liushen
 */
// 主窗口
public class MainFrame extends JFrame {

    // 上部分
    private static final JPanel upPanel = new JPanel();
    // 文件操作块
    private static final JPanel operatePanel = new JPanel();
    // 文件搜索块
    private static final JPanel searchPanel = new JPanel();
    // 搜索文本框
    public static JTextField searchTextField = new JTextField();
    // 搜索按钮
    private static final JButton searchButton = new JButton();
    // 文件操作按钮块
    private static final JPanel operateButtonPanel = new JPanel();
    // 上传文件按钮
    private static final JButton uploadButton = new JButton();
    // 下载文件按钮
    private static final JButton downloadButton = new JButton();
    // 新建文件按钮
    private static final JButton makeDirectoryButton = new JButton();
    // 文件切换
    private static final JPanel fileSwitchPanel = new JPanel();

    private static final JButton homeButton = new JButton();
    private static final JButton foreButton = new JButton();
    private static final JButton backButton = new JButton();

    // 信息块
    private static final JPanel informationPanel = new JPanel();
    // 首部分信息块
    private static final JPanel firstInformationPanel = new JPanel();
    // 文件名标签
    private static final JLabel fileNameLabel = new JLabel();
    // 文件其他信息块
    private static final JPanel otherInformationPanel = new JPanel();
    // 文件大小标签
    private static final JLabel fileSizeLabel = new JLabel();
    // 文件日期标签
    private static final JLabel fileDateLabel = new JLabel();
    // 下部分
    private static final JScrollPane fileScrollPanel = new JScrollPane();
    // 文件列表
    private static FileNodeDto fileNodeDto = new FileNodeDto();
    // 文件列表模式
    private static final FileListModel fileListModel = new FileListModel();
    // 文件列表渲染器
    private static final FileListCellRenderer fileListCellRenderer = new FileListCellRenderer();
    // 哈希表文件信息存储
    public static HashMap<String, FileNode> fileContents = new HashMap<>();

    // 初始化窗口
    public MainFrame(){
        init();

    }


    public static void addFileNode(String fileName, String hashVal) {
        FileNode fileNode = new FileNode(fileName, hashVal);
        Constant.getParentNode().getFileContents().add(fileNode.getHashVal());
        fileContents.put(fileNode.getHashVal(), fileNode);
    }

    void initButton() {
        searchButton.setText("搜索文件");
        searchButton.setSize(80, 35);
        searchButton.setPreferredSize(new Dimension(80, 35));

        uploadButton.setText("上传文件");
        uploadButton.setSize(80, 35);
        uploadButton.setPreferredSize(new Dimension(80, 35));

        downloadButton.setText("下载文件");
        downloadButton.setSize(80, 35);
        downloadButton.setPreferredSize(new Dimension(80, 35));

        makeDirectoryButton.setText("新建文件");
        makeDirectoryButton.setSize(80, 35);
        makeDirectoryButton.setPreferredSize(new Dimension(80, 35));

        homeButton.setText("home");
        homeButton.setSize(80, 35);
        homeButton.setPreferredSize(new Dimension(80, 35));

        foreButton.setText("前进");
        foreButton.setSize(80, 35);
        foreButton.setPreferredSize(new Dimension(80, 35));

        backButton.setText("退回");
        backButton.setSize(80, 35);
        backButton.setPreferredSize(new Dimension(80, 35));
    }

    // 初始化标签
    void initLabel() {
        fileNameLabel.setVisible(true);
        fileNameLabel.setSize(100, 20);
        fileNameLabel.setPreferredSize(new Dimension(100, 20));
        fileNameLabel.setText("文件名称");

        fileSizeLabel.setVisible(true);
        fileSizeLabel.setSize(100, 20);
        fileSizeLabel.setPreferredSize(new Dimension(100, 20));
        fileSizeLabel.setText("文件大小");

        fileDateLabel.setVisible(true);
        fileDateLabel.setSize(100, 20);
        fileDateLabel.setPreferredSize(new Dimension(100, 20));
        fileDateLabel.setText("文件日期");
    }

    // 初始化块
    void initPanel() {
        setVisible(true);
        setSize(850, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        upPanel.setVisible(true);
        upPanel.setSize(600, 100);
        upPanel.setPreferredSize(new Dimension(600, 100));
        upPanel.setLayout(new BorderLayout());

        operatePanel.setVisible(true);
        operatePanel.setSize(600, 80);
        operatePanel.setPreferredSize(new Dimension(600, 90));
        operatePanel.setLayout(new GridLayout(2, 1, 0, 0));


        searchPanel.setVisible(true);
        searchPanel.setSize(600, 40);
        searchPanel.setPreferredSize(new Dimension(600, 40));
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        operateButtonPanel.setVisible(true);
        operateButtonPanel.setSize(400, 40);
        operateButtonPanel.setPreferredSize(new Dimension(400, 40));
        operateButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        fileSwitchPanel.setVisible(true);
        fileSwitchPanel.setSize(300, 60);
        fileSwitchPanel.setPreferredSize(new Dimension(300, 60));
        fileSwitchPanel.setLayout(new GridLayout(1, 3, 0, 0));


        informationPanel.setVisible(true);
        informationPanel.setSize(600, 20);
        informationPanel.setPreferredSize(new Dimension(600, 20));
        informationPanel.setLayout(new BorderLayout(10, 0));


        firstInformationPanel.setVisible(true);
        firstInformationPanel.setPreferredSize(new Dimension(300, 20));
        firstInformationPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));


        otherInformationPanel.setVisible(true);
        otherInformationPanel.setPreferredSize(new Dimension(300, 20));
        otherInformationPanel.setLayout(new GridLayout(1, 2, 10, 0));

        fileScrollPanel.setVisible(true);

    }

    // 初始化文本
    void initText() {
        searchTextField.setVisible(true);
        searchTextField.setSize(400, 35);
        searchTextField.setPreferredSize(new Dimension(400, 35));
    }

    // 初始化窗口
    void init() {
        // 初始化界面
        // 初始化标签
        initLabel();
        // 初始化块
        initPanel();
        // 初始化上部分
        initTop();
        // 初始化中间部分
        initCenter();
        // 初始化监听器
        initListener();
        // 初始化按钮
        initButton();
        // 初始化文本
        initText();

        show();
        // 读取json文件
        fromJson();
        // 写入json文件
        toJson();
        // 读取根目录
        loadDir(Constant.getUserPath());
    }

    // 读取文件夹文件
    public static void loadDir(String hashVal) {
        toJson();
        fromJson();
        if (fileContents.containsKey(hashVal)) {
            FileNode temp = fileContents.get(hashVal);
            if (!hashVal.isEmpty()) {
                // 清空所有元素
                fileListModel.removeAllElements();
            }
            // 文件夹，插入文件夹中的元素
            if (temp.isDir()) {
                // 记录父级文件夹
                Constant.setParentNode(temp);
                for (String i : temp.getFileContents()) {
                    FileNode cur = fileContents.get(i);
                    fileListModel.addElement(cur);
                }
            } else {
                // 文件，插入当前文件
                fileListModel.addElement(temp);
            }
            System.out.println("成功读取文件");
        } else {
            // 清空所有元素
            fileListModel.removeAllElements();
            System.out.println("查无此文件");
        }
    }

    void initTop()// 初始化上部分
    {
        // 添加上部分块
        add(upPanel, BorderLayout.NORTH);
        // 添加文件操作块
        upPanel.add(operatePanel, BorderLayout.WEST);
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

        upPanel.add(fileSwitchPanel, BorderLayout.EAST);

        fileSwitchPanel.add(homeButton);

        fileSwitchPanel.add(backButton);

        fileSwitchPanel.add(foreButton);
        // 添加信息块
        upPanel.add(informationPanel, BorderLayout.SOUTH);
        // 添加首要信息块
        informationPanel.add(firstInformationPanel, BorderLayout.WEST);
        // 添加文件名列
        firstInformationPanel.add(fileNameLabel);
        // 添加其他信息块
        informationPanel.add(otherInformationPanel, BorderLayout.EAST);
        // 添加文件大小列
        otherInformationPanel.add(fileSizeLabel);
        // 添加文件日期列
        otherInformationPanel.add(fileDateLabel);
    }

    // 初始化中间部分
    void initCenter() {
        // 添加文件列表块
        add(fileScrollPanel, BorderLayout.CENTER);
        // 设置列表模式
        fileNodeDto.setModel(fileListModel);
        // 设置文件列表渲染器
        fileNodeDto.setCellRenderer(fileListCellRenderer);
        // 设置显示的列表
        fileScrollPanel.setViewportView(FILE_DTO);
    }

    // 初始化监听器
    void initListener() {
        searchButton.addActionListener(e -> FileController.searchFile());
        uploadButton.addActionListener(e -> FileController.upLoadFile());
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

        homeButton.addActionListener(e -> FileController.goToHome());
        foreButton.addActionListener(e -> FileController.goToFore());
        backButton.addActionListener(e -> FileController.goToBack());

        FILE_DTO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 左键 双击
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                    // 打开文件夹
                    if (Constant.getIsSelectFileNode().isDir()) {
                        FileController.openDir();
                    } else {
                        // 打开文件
                        FileController.openFile();
                    }
                }
            }
        });
    }
}
