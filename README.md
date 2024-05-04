# tahoe-lafs-gui

tahoe-lafs-gui 是一个用于 tahoe-lafs 分布式存储系统的 GUI 客户端。它提供了一个简单直观的界面，通过发送和接收 HTTP 请求来执行分布式存储系统的文件操作。

## 功能特性

- 通过 GUI 客户端上传、下载、删除文件等文件操作。
- 支持与 tahoe-lafs 分布式存储系统的通信，通过 HTTP 请求与服务器进行交互。
- 使用 Java Swing 编写的用户界面，易于使用和定制。

## 安装说明

1. 克隆本仓库到本地计算机：
```shell
git clone https://github.com/Knight1357/tahoe-lafs-gui.git
```
2. 进入项目目录：
```shell
cd tahoe-lafs-gui
```
3. 编译运行项目:
```shell
javac TahoeLafs
java TahoeLafs
```

## 使用指南
1. 启动 GUI 前, 你应先运行 tahoe-lafs 系统
2. 在 Constant 中, 修改运行 tahoe-lafs 主机的ip, 以及新建的根目录文件夹
3. 编译运行 TahoeLafs
