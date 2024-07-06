package com.tahoelafsgui.gui;

import com.tahoelafsgui.gui.panel.FileScrollPanel;
import com.tahoelafsgui.gui.panel.FunctionPanel;

import javax.swing.*;
import java.awt.*;

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

        // 功能模块
        FunctionPanel functionPanel = new FunctionPanel();
        add(functionPanel, BorderLayout.NORTH);

        // 文件列表模块
        FileScrollPanel fileScrollPanel = new FileScrollPanel();
        add(fileScrollPanel, BorderLayout.CENTER);
    }
}
