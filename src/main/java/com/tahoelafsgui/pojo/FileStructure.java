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
    @Setter
    private static HashMap<String, FileNode> fileStructure;

    // 单例实例
    private static FileStructure instance;

    // 私有构造函数，防止外部实例化
    private FileStructure() {
        fileStructure = new HashMap<>();
    }

    // 提供一个全局访问点获取单例实例
    public static synchronized FileStructure getInstance() {
        if (instance == null) {
            instance = new FileStructure();
        }
        return instance;
    }

    public HashMap<String, FileNode> getFileStructure() {
        return fileStructure;
    }

    public void addFileNode(String fileName, String newUrl) {
        if (fileStructure.containsKey(fileName)) {
            fileStructure.get(fileName).addFile(newUrl);
        } else {
            // 如果不存在则新建一个 FileNode 对象并添加
            FileNode fileNode = new FileNode(fileName, "");
            fileNode.addFile(newUrl);
            fileStructure.put(fileName, fileNode);
        }
    }
}

