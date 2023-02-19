import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class FileOperate {

    public static void creatFile(String str)
    {
        str=Constant.NOWPATH+"/"+str;
        File file=new File(str);
        file.mkdir();
    }

//    public static void openFile(String str)
//    {
//        str=Constant.NOWPATH+"/"+str;
//        Constant.NOWPATH=str;
//    }

    public static void downLoadFile(FileNode fileNode)
    {

    }
//http://47.115.222.245:3456/uri/URI%3ASSK%3Ai7p4iidbnlkvwuwcqptjbwguqa%3A5w27doa5r7gk7x7ruqdeegxb5izu2atxf6ympunydoexs6hzls3q
    public static void viewFile(FileNode fileNode)
    {
        String url=Constant.HOSTIP+"uri/URI%3ASSK%3A"+fileNode.uri.substring(8);
        if (Desktop.isDesktopSupported()){
            try {
                URI uri = new URI(url);
                Desktop desktop = Desktop.getDesktop(); //创建desktop对象
                //调用默认浏览器打开指定URL
                desktop.browse(uri);

            } catch (URISyntaxException e) {
                e.printStackTrace();

            } catch (IOException e) {
                //如果没有默认浏览器时，将引发下列异常
                e.printStackTrace();
            }
        }
    }

    public static void upLoadFile(FileNode fileNode)
    {

    }

}
