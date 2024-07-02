package com.tahoelafsgui.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * @author liushen
 */
// 文件结构
@Data
public class FileStructure {
    // 哈希表文件信息存储
    @Getter
    @Setter
    public static HashMap<String, FileNode> fileStructure;

    public FileStructure(HashMap<String, FileNode> hashMap) {
        fileStructure = hashMap;
    }

    public FileStructure() {
        fileStructure = new HashMap<>();
    }

    public static void addFileNode(String fileName, String newUrl) {
        fileStructure.get(fileName).addFile(newUrl);
    }
}
