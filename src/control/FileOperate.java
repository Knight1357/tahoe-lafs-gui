import java.io.File;

public class FileOperate {

    public void creatFile(String str)
    {
        str=Constant.NOWPATH+"/"+str;
        File file=new File(str);
        file.mkdir();
    }

    public void openFile(String str)
    {
        str=Constant.NOWPATH+"/"+str;
        Constant.NOWPATH=str;
    }

}
