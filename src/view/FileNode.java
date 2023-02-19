import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileNode {
    File file;
    String name="";
    Icon icon;
    String uri="";
    boolean isDir=false;
    public FileNode(File file)
    {
        this.file=file;
        this.isDir=file.isDirectory();
        if(!this.isDir)
        {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                String line = reader.readLine();
                this.name=line;
                line = reader.readLine();
                this.uri=line;
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            this.name=file.getName();
        }

    }

    @Override
    public String toString() {
        return this.name;
    }
}
