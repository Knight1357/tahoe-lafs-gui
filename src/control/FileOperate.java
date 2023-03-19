public class FileOperate {

    public static void creatFile(String str)//创建文件
    {

    }

    public static void downLoadFile(FileNode fileNode)//下载文件
    {


    }

    public static void upLoadFile(FileNode fileNode)//上传文件
    {

    }

    public static void searchFile()//搜索文件
    {
        String hashVal=TahoeLafs.searchTextFild.getText();//获取搜索框内容
        System.out.println("查询"+hashVal);
        if(TahoeLafs.fileContents.containsKey(hashVal))//如果存在这个文件
        {
            TahoeLafs.loadDir(hashVal);
        }
        else//不存在
        {
            TahoeLafs.loadDir(hashVal);
        }
    }
}
