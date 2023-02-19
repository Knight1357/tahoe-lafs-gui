import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TahoeLafs {
   public static MainWindow mainWindow = new MainWindow();
    public  static LeftPanel leftPanel = new LeftPanel();
    public  static  LeftUpButtonPanel leftUpButtonPanel = new LeftUpButtonPanel();
    public  static  LeftDownButtonPanel leftDownButtonPanel = new LeftDownButtonPanel();
    public static  LeftMyFileButton leftMyFileButton = new LeftMyFileButton("我的文件");
    public   static LeftRecycelButton leftRecycelButton = new LeftRecycelButton("回收站");
    public   static LeftSetButton leftSetButton = new LeftSetButton("设置");
    public  static  RightPanel rightPanel = new RightPanel();
    public  static RightUpPanel rightUpPanel = new RightUpPanel();
    public   static RightScorllPane rightScorllPane = new RightScorllPane();
    public  static RightUpLeftButtonPanel rightUpLeftButtonPanel = new RightUpLeftButtonPanel();

    public  static RightControlButtonPanel rightControlButtonPanel=new RightControlButtonPanel();

    public static RightBackButton rightBackButton=new RightBackButton();
    public static RightBeforeButton rightBeforeButton =new RightBeforeButton();
    public  static  RightUploadButton rightUploadButton = new RightUploadButton("上传文件");

    public  static RightDownLoadButton rightDownLoadButton=new RightDownLoadButton("下载文件");
    public static  RightNewfileButton rightNewfileButton = new RightNewfileButton("新建文件夹");

    public static  FileListModel<FileNode> fileListModel = new FileListModel<>();
    public static  FileListRenderer fileListRenderer = new FileListRenderer();
    public  static FileList<FileNode> fileList = new FileList<>();


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
        rightUpLeftButtonPanel.add(rightDownLoadButton);
        rightUpLeftButtonPanel.add(rightNewfileButton);
        rightUpPanel.add(rightControlButtonPanel,BorderLayout.EAST);
        rightControlButtonPanel.add(rightBackButton);
        rightControlButtonPanel.add(rightBeforeButton);
        rightPanel.add(rightScorllPane, BorderLayout.CENTER);

        rightScorllPane.setViewportView(fileList);
        fileList.setModel(fileListModel);
        fileList.setCellRenderer(fileListRenderer);
//        fileList.setSelectionModel(ListSelectionModel.SINGLE_SELECTION);

        File dir = Constant.NOWPATH;
        LoadDir(dir);
    }

    public static void LoadDir(File dir) {
        File[] files = dir.listFiles();

        ArrayList<FileNode> list=new ArrayList<>();
        for(File f:files)
        {
            FileNode temp = new FileNode(f);
            System.out.println(temp.name);
            list.add(temp);
        }
        list.sort(new Comparator<FileNode>() {
            @Override
            public int compare(FileNode a, FileNode b) {
                if(a.isDir&&!b.isDir)
                    return -1;
                if(!a.isDir&&b.isDir)
                    return 1;
                else {
                    return a.name.compareTo(b.name);
                }
            }
        });

        fileListModel.removeAllElements();
        if (files == null)
            return;
        for (FileNode f : list) {

            if (f.name.indexOf('.') != 0)
                fileListModel.addElement(f);
        }
    }


    public static void main(String[] args) {
        TahoeLafs tahoeLafs=new TahoeLafs();
        tahoeLafs.Init();
    }
}