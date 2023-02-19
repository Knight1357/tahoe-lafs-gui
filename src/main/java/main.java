import javax.swing.*;
import java.awt.*;
import java.io.File;

public class main {
    MainWindow mainWindow = new MainWindow();
    LeftPanel leftPanel = new LeftPanel();
    LeftUpButtonPanel leftUpButtonPanel = new LeftUpButtonPanel();
    LeftDownButtonPanel leftDownButtonPanel = new LeftDownButtonPanel();
    LeftMyFileButton leftMyFileButton = new LeftMyFileButton("我的文件");
    LeftRecycelButton leftRecycelButton = new LeftRecycelButton("回收站");
    LeftSetButton leftSetButton = new LeftSetButton("设置");
    RightPanel rightPanel = new RightPanel();
    RightUpPanel rightUpPanel = new RightUpPanel();
    RightScorllPane rightScorllPane = new RightScorllPane();
    RightUpLeftButtonPanel rightUpLeftButtonPanel = new RightUpLeftButtonPanel();
    RightUploadButton rightUploadButton = new RightUploadButton("上传文件");
    RightNewfileButton rightNewfileButton = new RightNewfileButton("新建文件夹");

    FileListModel<FileNode> fileListModel = new FileListModel<>();
    FileListRenderer fileListRenderer = new FileListRenderer();
    FileList<FileNode> fileList = new FileList<>();


    public void Init()//初始化窗口
    {
        mainWindow.add(leftPanel, BorderLayout.WEST);
        leftPanel.add(leftUpButtonPanel, BorderLayout.NORTH);
        leftUpButtonPanel.add(leftMyFileButton);
        leftUpButtonPanel.add(leftRecycelButton);
        leftPanel.add(leftDownButtonPanel, BorderLayout.SOUTH);
        leftDownButtonPanel.add(leftSetButton);

        mainWindow.add(rightPanel, BorderLayout.CENTER);
        rightPanel.add(rightUpPanel, BorderLayout.NORTH);
        rightUpPanel.add(rightUpLeftButtonPanel, BorderLayout.WEST);
        rightUpLeftButtonPanel.add(rightUploadButton);
        rightUpLeftButtonPanel.add(rightNewfileButton);
        rightPanel.add(rightScorllPane, BorderLayout.CENTER);

        rightScorllPane.setViewportView(fileList);
        fileList.setModel(fileListModel);
        fileList.setCellRenderer(fileListRenderer);
//        fileList.setSelectionModel(ListSelectionModel.SINGLE_SELECTION);

        String path = Constant.NOWPATH;
        File dir = new File(path);
        LoadDir(dir);
    }

    public void LoadDir(File dir) {
        File[] files = dir.listFiles();
        if (files == null)
            return;
        for (File f : files) {
            FileNode temp = new FileNode(f);
            System.out.println(temp.file.getName());
            if (temp.name.indexOf('.') != 0)
                fileListModel.addElement(temp);
        }
    }


    public static void main(String[] args) {
        new main().Init();
    }
}