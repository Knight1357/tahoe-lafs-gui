package com.tahoelafsgui.gui.panel;

import com.tahoelafsgui.gui.FileListCellRenderer;
import com.tahoelafsgui.gui.FileListModel;
import com.tahoelafsgui.pojo.FileNode;
import com.tahoelafsgui.pojo.FileStructure;
import com.tahoelafsgui.pojo.dto.FileNodeDto;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.HashMap;


// 文件列表
public class FileScrollPanel extends JScrollPane {

    // 文件列表
    @Getter
    @Setter
    private static FileListModel fileListModel;

    public FileScrollPanel() {
        fileListModel = new FileListModel();

        setVisible(true);
        HashMap<String, FileNode> fileContents = FileStructure.getFileStructure();
        setVisible(true);
        // 文件列表
        FileNodeDto fileNodeDto = new FileNodeDto();
        // 文件列表模式
        // 文件列表渲染器
        FileListCellRenderer fileListCellRenderer = new FileListCellRenderer();
    }
}
