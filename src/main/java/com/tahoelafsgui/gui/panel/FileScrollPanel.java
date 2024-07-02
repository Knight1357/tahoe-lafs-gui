package com.tahoelafsgui.gui.panel;

import com.tahoelafsgui.gui.FileListCellRenderer;
import com.tahoelafsgui.gui.FileListModel;
import com.tahoelafsgui.pojo.FileNode;
import com.tahoelafsgui.pojo.dto.FileNodeDto;

import javax.swing.*;
import java.util.HashMap;


// 文件列表
public class FileScrollPanel extends JScrollPane {

    // 哈希表文件信息存储
    HashMap<String, FileNode> fileContents = new HashMap<>();

    public FileScrollPanel() {

        setVisible(true);

        // 文件列表
        FileNodeDto fileNodeDto = new FileNodeDto();
        // 文件列表模式
        FileListModel fileListModel = new FileListModel();
        // 文件列表渲染器
        FileListCellRenderer fileListCellRenderer = new FileListCellRenderer();
    }
}
