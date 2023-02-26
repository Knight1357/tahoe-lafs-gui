import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileNode {
    String name="";
    String URI="";
    boolean isDir=false;
    Float Size=0f;
    public FileNode(String name,String URI)
    {
        this.name=name;
        this.URI=URI;
    }

    @Override
    public String toString() {
        return this.name+" "+URI;
    }
}
