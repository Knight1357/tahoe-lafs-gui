package com.tahoelafsgui.controller;

import com.tahoelafsgui.Main;
import com.tahoelafsgui.config.Constant;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @author liushen
 */
public class FileOperate {
    //创建文件夹
    public static void creatFile(String fileName) throws Exception {
        System.out.println("创建文件夹");
        //http://47.115.222.245:3456/uri/URI%3ADIR2%3Awti64bj6ovkrubpngomrldezpi%3Ai7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka?t=mkdir-immutable&name=666nb
//URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka

        String hashVal = Constant.getParentNode().getHashVal();
        String urlString = "http://" + Constant.getIntroducerAPI() + "/uri/" + URLEncoder.encode(hashVal, StandardCharsets.UTF_8) + "?t=mkdir&name=" + URLEncoder.encode(fileName, "UTF-8");
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        //获取响应代码
        int responseCode = connection.getResponseCode();
        //获取文件名
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String newFilehashVal = response.toString();
            //输出文件节点
            System.out.println(newFilehashVal);
            //更新文件
            Main.addFileNode(fileName, newFilehashVal);
            Main.loadDir(hashVal);
        } else {
            //请求失败
            System.out.println("HTTP请求失败，错误码为：" + responseCode);
            //弹出
            JOptionPane.showMessageDialog(null, "创建失败\n" + "HTTP请求失败，错误码为：" + responseCode);
        }
    }

    public static void downLoadFile() throws Exception//下载文件
    {
        System.out.println("下载文件");

        //获取选中文件的hash
        String hashVal = Constant.getIsSelectFileNode().getHashVal();
        //获取文件名
        String fileName = Constant.getIsSelectFileNode().getName();
        String urlString = "http://" + Constant.getIntroducerAPI() + "/uri/" + URLEncoder.encode(hashVal, StandardCharsets.UTF_8);

        //String urlString = "http://47.115.222.245:3456/uri/URI%3ACHK%3Axd3cxxdh4jk6ys5mhfzox6mdgy%3Amauyymc77s3cwdexcx5a2awpiji4bp5dwv6t4l4b4jouavqgfb4a%3A3%3A10%3A655074";

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "image/png");

        //获取响应代码
        int responseCode = connection.getResponseCode();

        //响应成功
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
            //弹窗
            JOptionPane.showMessageDialog(null, "下载失败\n" + "HTTP请求失败，错误码为：" + responseCode);
        }

    }

    //上传文件
    public static void upLoadFile() {
        System.out.println("上传文件");
    }

    //搜索文件
    public static void searchFile() {
        System.out.println("搜索文件");
        //获取搜索框内容
        String hashVal = Main.searchTextField.getText();
        System.out.println("查询" + hashVal);
        //如果存在这个文件
        if (Main.fileContents.containsKey(hashVal)) {
            Main.loadDir(hashVal);
        } else {
            //不存在
            Main.loadDir(hashVal);
        }
    }

    //双击打开文件夹
    public static void openDir() {
        if (Constant.getIsSelectFileNode().isDir()) {
            Constant.addFileLocationNode(Constant.getIsSelectFileNode().getHashVal());
            Constant.currentFile++;
            Main.loadDir(Constant.getIsSelectFileNode().getHashVal());
        }
    }

    public static void openFile() {
        if (!Constant.getIsSelectFileNode().isDir()) {
            System.out.println("打开文件");
        }
    }

    //回到主页
    public static void goToHome() {
        System.out.println("回到主页");
        Main.loadDir(Constant.getUserPath());
        System.out.println("成功回到主页");
    }

    //前进
    public static void goToFore() {
        System.out.println("向前");
        if (Constant.currentFile < Constant.getFileLocationListSize() - 1) {
            Constant.currentFile++;
            Main.loadDir(Constant.getFileLocationNode(Constant.currentFile));
            System.out.println("成功向前");

        }
    }

    //后退
    public static void goToBack() {
        System.out.println("后退");
        if (Constant.currentFile > 0) {
            Constant.currentFile--;
            Main.loadDir(Constant.getFileLocationNode(Constant.currentFile));
            System.out.println("成功退回");
        }
    }

}
