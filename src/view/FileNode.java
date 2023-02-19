import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileNode {
    File file;
    String name;
    Icon icon;

    boolean isDir=false;
    public FileNode(File file)
    {
        this.file=file;
        this.name=file.getName();
        this.isDir=file.isDirectory();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
