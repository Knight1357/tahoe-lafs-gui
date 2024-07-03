package com.tahoelafsgui.controller;

import com.tahoelafsgui.config.Constant;
import com.tahoelafsgui.gui.panel.FunctionPanel;
import com.tahoelafsgui.pojo.FileStructure;
import com.tahoelafsgui.util.ConfigUtil;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author liushen
 */
public class FileOperations {


    // 创建文件夹
    public void createFinder() throws Exception {
        String fileName = "TEST";
        String hashVal = Constant.getParentNode().getHashVal();
        String urlString = "https://" + ConfigUtil.getInstance().getProperty("introducer.ip") + "/uri/" + URLEncoder.encode(hashVal, StandardCharsets.UTF_8) + "?t=mkdir&name=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8);
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // 获取响应代码
        int responseCode = connection.getResponseCode();
        // 获取文件名
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String newFilehashVal = response.toString();
            // 输出文件节点
            System.out.println(newFilehashVal);
            // 更新文件
            FileStructure.getInstance().addFileNode(fileName, newFilehashVal);
            FileListController.loadDir(hashVal);
        } else {
            // 请求失败
            System.out.println("HTTP请求失败，错误码为：" + responseCode);
            // 弹出
            JOptionPane.showMessageDialog(null, "创建失败\n" + "HTTP请求失败，错误码为：" + responseCode);
        }
    }

    // 下载文件
    public void downloadFile() throws Exception {
        // 获取选中文件的hash
        String hashVal = Constant.getIsSelectFileNode().getHashVal();
        // 获取文件名
        String fileName = Constant.getIsSelectFileNode().getName();
        String urlString = "https://" + ConfigUtil.getInstance().getProperty("introducer.ip") + "/uri/" + URLEncoder.encode(hashVal, StandardCharsets.UTF_8);

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "image/png");

        // 获取响应代码
        int responseCode = connection.getResponseCode();

        // 响应成功
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = connection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            FileOutputStream fileOutputStream = new FileOutputStream("data/download/" + fileName);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read(buffer, 0, 1024)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            fileOutputStream.close();
            bufferedInputStream.close();
            inputStream.close();
            System.out.println("文件下载完成！");
        } else {
            System.out.println("HTTP请求失败，错误码为：" + responseCode);
            // 弹窗
            JOptionPane.showMessageDialog(null, "下载失败\n" + "HTTP请求失败，错误码为：" + responseCode);
        }
    }

    // 上传文件
    public void uploadFile() {
        System.out.println("上传文件");
    }

    // 搜索文件
    public void searchFile() {
        System.out.println("搜索文件");
        // 获取搜索框内容
        String hashVal = FunctionPanel.searchTextField.getText();
        System.out.println("查询" + hashVal);
        // 如果存在这个文件
        if (FileStructure.getInstance().getFileStructure().containsKey(hashVal)) {
            FileListController.loadDir(hashVal);
        } else {
            // 不存在
            FileListController.loadDir(hashVal);
        }
    }

    // 双击打开文件夹
    public void openDir() {
        if (Constant.getIsSelectFileNode().isDir()) {
            Constant.addFileLocationNode(Constant.getIsSelectFileNode().getHashVal());
            Constant.currentFile++;
            FileListController.loadDir(Constant.getIsSelectFileNode().getHashVal());
        }
    }

    public void openFile() {
        if (!Constant.getIsSelectFileNode().isDir()) {
            System.out.println("打开文件");
        }
    }

    // 回到主页
    public void goToHome() {
        System.out.println("回到主页");
        FileListController.loadDir(Constant.getUserPath());
        System.out.println("成功回到主页");
    }

    // 前进
    public void goToFore() {
        System.out.println("向前");
        if (Constant.currentFile < Constant.getFileLocationListSize() - 1) {
            Constant.currentFile++;
            FileListController.loadDir(Constant.getFileLocationNode(Constant.currentFile));
            System.out.println("成功向前");
        }
    }

    // 后退
    public void goToBack() {
        System.out.println("后退");
        if (Constant.currentFile > 0) {
            Constant.currentFile--;
            FileListController.loadDir(Constant.getFileLocationNode(Constant.currentFile));
            System.out.println("成功退回");
        }
    }
}
