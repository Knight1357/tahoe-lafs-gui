import javax.swing.*;
import java.io.File;

public class FileNode {
    private File file;

    private boolean isDir=false;
    private Icon icon;


    public FileNode( File file)
    {
        this.file=file;
        this.isDir= file.isDirectory();

    }

}
