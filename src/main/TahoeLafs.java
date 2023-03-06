import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

public class TahoeLafs {
    //主窗口
    public static MainWindow mainWindow = new MainWindow();
    //上部分
    public static UpPanel upPanel = new UpPanel();
    public static OperatePanel operatePanel = new OperatePanel();
    public static SearchPanel searchPanel = new SearchPanel();
    public static SearchTextFild searchTextFild = new SearchTextFild();
    public static SearchButton searchButton = new SearchButton();
    public static OperateButtonPanel operateButtonPanel = new OperateButtonPanel();
    public static UploadButton uploadButton = new UploadButton();
    public static DownloadButton downloadButton = new DownloadButton();
    public static MakeDirectoryButton makeDirectoryButton = new MakeDirectoryButton();
    public static InformationPanel informationPanel = new InformationPanel();
    public static FirstInformationPanel firstInformationPanel = new FirstInformationPanel();
    public static FileNameLable fileNameLable = new FileNameLable();
    public static OtherInformationPanel otherInformationPanel = new OtherInformationPanel();
    public static FileSizeLable fileSizeLable = new FileSizeLable();
    public static FileDateLable fileDateLable = new FileDateLable();
    //下部分
    public static FileListPanel fileListPanel = new FileListPanel();
    public static FileList<FileNode> fileList = new FileList<>();
    public static FileListModel fileListModel = new FileListModel();
    public static FileListRenderer fileListRenderer = new FileListRenderer();
    public static HashMap<String, FileNode> fileContents = new HashMap<>();

//    public static HashMap<String, FileNode> fileContents;


    public void Init()//初始化窗口
    {
        mainWindow.add(upPanel, BorderLayout.NORTH);
        upPanel.add(operatePanel, BorderLayout.WEST);
        operatePanel.add(searchPanel);
        searchPanel.add(searchTextFild);
        searchPanel.add(searchButton);
        operatePanel.add(operateButtonPanel);
        operateButtonPanel.add(uploadButton);
        operateButtonPanel.add(downloadButton);
        operateButtonPanel.add(makeDirectoryButton);
        upPanel.add(informationPanel, BorderLayout.SOUTH);
        informationPanel.add(firstInformationPanel, BorderLayout.WEST);
        firstInformationPanel.add(fileNameLable);
        informationPanel.add(otherInformationPanel, BorderLayout.EAST);
        otherInformationPanel.add(fileSizeLable);
        otherInformationPanel.add(fileDateLable);
        mainWindow.add(fileListPanel, BorderLayout.CENTER);
        fileListPanel.setViewportView(fileList);
        fileList.setModel(fileListModel);
        fileList.setCellRenderer(fileListRenderer);


//        FileNode Host = new FileNode("User", "URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka");
//        FileNode f1 = new FileNode("2022级郑州轻工业大学新生赛报名表.xlsx", "URI:SSK:3qylezfxtxvoifdfreayse556u:yvlag2qazwtukwdu7afwvzmbo3k7bqlk4bg4q25btj6jjvklgrmq");
//        FileNode f2 = new FileNode("新建 DOCX 文档.docx", "URI:SSK:iazixx4xacu5hx3nhbpq5lyxfe:bywfn7lus5kz34z4icecaxwxcl7bkpese6eh2rds5h7iagfy2x2q");
//        Host.getFileContents().add("URI:SSK:3qylezfxtxvoifdfreayse556u:yvlag2qazwtukwdu7afwvzmbo3k7bqlk4bg4q25btj6jjvklgrmq");
//        Host.getFileContents().add("URI:SSK:iazixx4xacu5hx3nhbpq5lyxfe:bywfn7lus5kz34z4icecaxwxcl7bkpese6eh2rds5h7iagfy2x2q");
//        fileContents.put("URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka", Host);
//        fileContents.put("URI:SSK:3qylezfxtxvoifdfreayse556u:yvlag2qazwtukwdu7afwvzmbo3k7bqlk4bg4q25btj6jjvklgrmq", f1);
//        fileContents.put("URI:SSK:iazixx4xacu5hx3nhbpq5lyxfe:bywfn7lus5kz34z4icecaxwxcl7bkpese6eh2rds5h7iagfy2x2q", f2);

        //读取json
        FileReader reader = null;
        try {
            reader = new FileReader("data.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        fileContents = gson.fromJson(reader, HashMap.class);
        System.out.println(fileContents);
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//写入json
//        try {
//            Gson gson = new Gson();
//            FileWriter writer = new FileWriter("data.json");
//            gson.toJson(fileContents, writer);
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        for(FileNode i:Host.FileContents)
//        {
//            System.out.println(i);
//        }


        System.out.println("test:" + fileContents.get("URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka"));
        LoadDir("URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka");


    }


    public static void LoadDir(String HashVal) {
        FileNode temp = (FileNode) fileContents.get(HashVal);
        System.out.println(temp);
//        for(FileNode i:temp.FileContents)
//        {
//            System.out.println(i);
//        }
//        System.out.println(temp.isDir);
        fileListModel.removeAllElements();
        if (temp.isDir()) {
            for (String i : temp.getFileContents()) {
                FileNode cur = fileContents.get(i);
                fileListModel.addElement(cur);
            }
        }

    }


    public static void main(String[] args) throws IOException {
        TahoeLafs tahoeLafs = new TahoeLafs();
        tahoeLafs.Init();
    }
}