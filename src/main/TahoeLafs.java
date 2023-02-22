import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TahoeLafs {
   public static MainWindow mainWindow = new MainWindow();

   public static UpPanel upPanel=new UpPanel();

   public static SearchPanel searchPanel=new SearchPanel();

   public static OperateButtonPanel operateButtonPanel=new OperateButtonPanel();
   public static InformationPanel informationPanel=new InformationPanel();
   public static DownPanel downPanel=new DownPanel();
   public static FileList<FileNode> fileList=new FileList<>();
   public static FileListModel fileListModel=new FileListModel();
   public static FileListRenderer fileListRenderer=new FileListRenderer();








   public void Init()//初始化窗口
    {


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

//        fileListModel.removeAllElements();
//        if (files == null)
//            return;
//        for (FileNode f : list) {
//
//            if (f.name.indexOf('.') != 0)
//                fileListModel.addElement(f);
//        }
    }


    public static void main(String[] args) {
        TahoeLafs tahoeLafs=new TahoeLafs();
        tahoeLafs.Init();
    }
}