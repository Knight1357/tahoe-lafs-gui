import javax.swing.*;
import java.io.File;

public class FileNode {
    private String fileName;
    private String fileKey;
    private Float fileSize;
    private String fileDate;
    private boolean isDir=false;
    public FileNode( FileNode fileNode)
    {
        this.fileName=fileNode.fileName;
        this.fileKey=fileNode.fileKey;
        this.fileSize=fileNode.fileSize;
        this.fileDate=fileNode.fileDate;
    }
}
