import java.io.File;

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

}
