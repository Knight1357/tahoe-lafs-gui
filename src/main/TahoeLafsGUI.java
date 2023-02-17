import javax.swing.*;
import java.io.File;

public class TahoeLafsGUI {
    private JPanel MainWindows;
    private JPanel Left;
    private JButton Myfile;
    private JPanel Right;
    private JPanel FileType;
    private JButton Recycle;
    private JPanel Set;
    private JButton Seting;
    private JPanel Function;
    private JPanel FileManagement;
    private JButton Upload;
    private JButton NewFile;
    private JScrollPane FileListScroll;
    public JList<FileNode> FileList=new JList<>();
    public DefaultListModel<FileNode> model=new DefaultListModel<>();



    public static void main(String[] args) {
        JFrame frame = new JFrame("TahoeLafsGUI");
        frame.setContentPane(new TahoeLafsGUI().MainWindows);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        TahoeLafsGUI tahoeLafsGUI=new TahoeLafsGUI();
//        tahoeLafsGUI.Init("data");
        tahoeLafsGUI.loadDir(new File("/Users/liushen/Library/CloudStorage/OneDrive-个人/works"));

    }

    void Init(String path)
    {
        FileList.setModel(model);

        FileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        FileListScroll.add(FileList);


    }

    void loadDir(File dir)
    {
        File[] files =dir.listFiles();
        if(files==null)
            return;
        for(File f:files)
        {
            FileNode temp=new FileNode(f);
            model.addElement(temp);
        }
    }


   private void showFile(String path)
    {

    }

}
