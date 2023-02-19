import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileNode {
    File file;
    String name;
    Icon icon;
    public FileNode(File file)
    {
        this.file=file;
        this.name=file.getName();
//        if(this.name.indexOf('.')==-1)
//        {
//            icon=new ImageIcon("/Users/liushen/Library/CloudStorage/OneDrive-个人/works/Tahoe-Lafs-GUI/Tahoe-Lafs-GUI/image/wenjianjia.png");
//        }
//        else
//        {
//            icon=new ImageIcon("/Users/liushen/Library/CloudStorage/OneDrive-个人/works/Tahoe-Lafs-GUI/Tahoe-Lafs-GUI/image/wenjian.png");
//        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
