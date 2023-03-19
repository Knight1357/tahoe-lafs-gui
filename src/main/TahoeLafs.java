import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;

public class TahoeLafs {
    //主窗口
    public static MainWindow mainWindow = new MainWindow();//主窗口
    //上部分
    public static UpPanel upPanel = new UpPanel();//上部分
    public static OperatePanel operatePanel = new OperatePanel();//文件操作块
    public static SearchPanel searchPanel = new SearchPanel();//文件搜索块
    public static SearchTextFild searchTextFild = new SearchTextFild();//搜索文本框
    public static SearchButton searchButton = new SearchButton();//搜索按钮
    public static OperateButtonPanel operateButtonPanel = new OperateButtonPanel();//文件操作按钮块
    public static UploadButton uploadButton = new UploadButton();//上传文件按钮
    public static DownloadButton downloadButton = new DownloadButton();//下载文件按钮
    public static MakeDirectoryButton makeDirectoryButton = new MakeDirectoryButton();//新建文件按钮
    public static InformationPanel informationPanel = new InformationPanel();//信息块
    public static FirstInformationPanel firstInformationPanel = new FirstInformationPanel();//首部分信息块
    public static FileNameLable fileNameLable = new FileNameLable();//文件名标签
    public static OtherInformationPanel otherInformationPanel = new OtherInformationPanel();//文件其他信息块
    public static FileSizeLable fileSizeLable = new FileSizeLable();//文件大小标签
    public static FileDateLable fileDateLable = new FileDateLable();//文件日期标签
    //下部分
    public static CenterPanel centerPanel = new CenterPanel();//中间块
    public static FileScrollPanel fileScrollPanel=new FileScrollPanel();
    public static FileList<FileNode> fileList = new FileList<>();//文件列表
    public static FileListModel fileListModel = new FileListModel();//文件列表模式
    public static FileListCellRenderer fileListCellRenderer = new FileListCellRenderer();//文件列表渲染器
    public static HashMap<String, FileNode> fileContents = new HashMap<>();//哈希表文件信息存储


    void initTop()//初始化上部分
    {
        mainWindow.add(upPanel, BorderLayout.NORTH);//添加上部分块

        upPanel.add(operatePanel, BorderLayout.WEST);//添加文件操作块

        operatePanel.add(searchPanel);//添加搜索块

        searchPanel.add(searchTextFild);//添加搜索文本框

        searchPanel.add(searchButton);//添加搜索按钮

        operatePanel.add(operateButtonPanel);//添加文件操作块

        operateButtonPanel.add(uploadButton);//添加上传文件按钮

        operateButtonPanel.add(downloadButton);//添加下载文件按钮

        operateButtonPanel.add(makeDirectoryButton);//添加新建文件夹按钮

        upPanel.add(informationPanel, BorderLayout.SOUTH);//添加信息块

        informationPanel.add(firstInformationPanel, BorderLayout.WEST);//添加首要信息块

        firstInformationPanel.add(fileNameLable);//添加文件名列

        informationPanel.add(otherInformationPanel, BorderLayout.EAST);//添加其他信息块

        otherInformationPanel.add(fileSizeLable);//添加文件大小列

        otherInformationPanel.add(fileDateLable);//添加文件日期列
    }

    void initCenter()//初始化中间部分
    {
        mainWindow.add(fileScrollPanel, BorderLayout.CENTER);//添加文件列表块

        fileList.setModel(fileListModel);//设置列表模式
        fileList.setCellRenderer(fileListCellRenderer);//设置文件列表渲染器
        fileScrollPanel.setViewportView(fileList);//设置显示的列表

    }

    void toJson()//写入json文件
    {
        ////写入json
        //初始化
//        FileNode Host = new FileNode("User", "URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka");
//        FileNode f1 = new FileNode("2022级郑州轻工业大学新生赛报名表.xlsx", "URI:SSK:3qylezfxtxvoifdfreayse556u:yvlag2qazwtukwdu7afwvzmbo3k7bqlk4bg4q25btj6jjvklgrmq");
//        FileNode f2 = new FileNode("新建 DOCX 文档.docx", "URI:SSK:iazixx4xacu5hx3nhbpq5lyxfe:bywfn7lus5kz34z4icecaxwxcl7bkpese6eh2rds5h7iagfy2x2q");
//        Host.getFileContents().add("URI:SSK:3qylezfxtxvoifdfreayse556u:yvlag2qazwtukwdu7afwvzmbo3k7bqlk4bg4q25btj6jjvklgrmq");
//        Host.getFileContents().add("URI:SSK:iazixx4xacu5hx3nhbpq5lyxfe:bywfn7lus5kz34z4icecaxwxcl7bkpese6eh2rds5h7iagfy2x2q");
//        fileContents.put("URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka", Host);
//        fileContents.put("URI:SSK:3qylezfxtxvoifdfreayse556u:yvlag2qazwtukwdu7afwvzmbo3k7bqlk4bg4q25btj6jjvklgrmq", f1);
//        fileContents.put("URI:SSK:iazixx4xacu5hx3nhbpq5lyxfe:bywfn7lus5kz34z4icecaxwxcl7bkpese6eh2rds5h7iagfy2x2q", f2);

        //写入到data.json文件
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("data/Data.json");
            gson.toJson(fileContents, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void fromJson()//读取json文件
    {
        //读取json
        FileReader reader = null;
        try {
            reader = new FileReader("data/Data.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        fileContents = gson.fromJson(reader, new TypeToken<HashMap<String, FileNode>>() {
        }.getType());
        System.out.println(fileContents);
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    void initWindows()//初始化窗口
    {
        //初始化界面
        initTop();//初始化上部分
        initCenter();//初始化中间部分
        mainWindow.show();

        fromJson();//读取json文件

//        toJson();//写入json文件

        //测试输出
        for (FileNode value : fileContents.values()) {
            System.out.println(value);
        }

        System.out.println("test:" + fileContents.get("URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka"));

        //读取根目录
        loadDir("URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka");

    }


    public static void loadDir(String hashVal) {    //读取文件夹文件

        if (fileContents.containsKey(hashVal)) {
            FileNode temp = fileContents.get(hashVal);
            if(!hashVal.isEmpty())
                fileListModel.removeAllElements();//清空所有元素

            if (temp.isDir()) {//文件夹，插入文件夹中的元素
                for (String i : temp.getFileContents()) {
                    FileNode cur = fileContents.get(i);
                    fileListModel.addElement(cur);
                }
            } else {//文件，插入当前文件
                fileListModel.addElement(temp);
            }
            System.out.println("成功读取文件");
        } else {
            fileListModel.removeAllElements();//清空所有元素
            System.out.println("查无此文件");
        }
    }


    public static void main(String[] args) throws IOException {
        TahoeLafs tahoeLafs = new TahoeLafs();
        tahoeLafs.initWindows();
    }
}