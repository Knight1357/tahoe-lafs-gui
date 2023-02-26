import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TahoeLafs {
    //主窗口
   public static MainWindow mainWindow = new MainWindow();
//上部分
   public static UpPanel upPanel=new UpPanel();

   public static OperatePanel operatePanel=new OperatePanel();
   public static SearchPanel searchPanel=new SearchPanel();

   public static SearchTextFild searchTextFild=new SearchTextFild();

   public static SearchButton searchButton=new SearchButton();

   public static OperateButtonPanel operateButtonPanel=new OperateButtonPanel();

   public static UploadButton uploadButton=new UploadButton();

   public static DownloadButton downloadButton=new DownloadButton();

   public static MakeDirectoryButton makeDirectoryButton=new MakeDirectoryButton();
   public static InformationPanel informationPanel=new InformationPanel();

   public static FirstInformationPanel firstInformationPanel=new FirstInformationPanel();


   public static FileNameLable fileNameLable=new FileNameLable();

    public static OtherInformationPanel otherInformationPanel=new OtherInformationPanel();


   public static FileSizeLable fileSizeLable=new FileSizeLable();

   public static FileDateLable fileDateLable=new FileDateLable();
   //下部分
   public static DownPanel downPanel=new DownPanel();
   public static FileList<FileNode> fileList=new FileList<>();
   public static FileListModel fileListModel=new FileListModel();

   public static FileListRenderer fileListRenderer=new FileListRenderer();








   public void Init()//初始化窗口
    {
        mainWindow.add(upPanel,BorderLayout.NORTH);

        upPanel.add(operatePanel,BorderLayout.WEST);

        operatePanel.add(searchPanel);

        searchPanel.add(searchTextFild);
        searchPanel.add(searchButton);

        operatePanel.add(operateButtonPanel);

        operateButtonPanel.add(uploadButton);
        operateButtonPanel.add(downloadButton);
        operateButtonPanel.add(makeDirectoryButton);

        upPanel.add(informationPanel,BorderLayout.SOUTH);

        informationPanel.add(firstInformationPanel,BorderLayout.WEST);
        firstInformationPanel.add(fileNameLable);

        informationPanel.add(otherInformationPanel,BorderLayout.EAST);

        otherInformationPanel.add(fileSizeLable);
        otherInformationPanel.add(fileDateLable);

        mainWindow.add(downPanel,BorderLayout.CENTER);

        downPanel.setViewportView(fileList);
        fileList.setModel(fileListModel);






    }

    public static void LoadDir() {


    }


    public static void main(String[] args) {
        TahoeLafs tahoeLafs=new TahoeLafs();
        tahoeLafs.Init();
    }
}