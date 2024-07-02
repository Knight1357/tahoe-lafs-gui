package com.tahoelafsgui.gui;

import com.tahoelafsgui.config.Constant;
import com.tahoelafsgui.controller.FileController;
import com.tahoelafsgui.pojo.FileNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author liushen
 */
// 主窗口
public class MainFrame extends JFrame {

    // 初始化窗口
    public MainFrame() {
        setVisible(true);
        setSize(850, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        init();

    }


    public static void addFileNode(String fileName, String hashVal) {
        FileNode fileNode = new FileNode(fileName, hashVal);
        Constant.getParentNode().getFileContents().add(fileNode.getHashVal());
        fileContents.put(fileNode.getHashVal(), fileNode);
    }


    // 初始化块
    void initPanel() {

        fileScrollPanel.setVisible(true);

    }

    // 初始化文本
    void initText() {
//        searchTextField.setVisible(true);
//        searchTextField.setSize(400, 35);
//        searchTextField.setPreferredSize(new Dimension(400, 35));
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
