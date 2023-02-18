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

    public DefaultListModel model=new DefaultListModel();
    public JList fileList=new JList();




    public static void main(String[] args) {
        JFrame frame = new JFrame("Tahoe-Lafs");
        frame.setContentPane(new TahoeLafsGUI().MainWindows);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        TahoeLafsGUI tahoeLafsGUI=new TahoeLafsGUI();
//        tahoeLafsGUI.loadDir(new File("C:/"));
        tahoeLafsGUI.Init("data");


    }

    void Init(String path)
    {

        model.addElement("1");
        model.addElement("2");
        model.addElement("3");
        model.addElement("4");

        fileList.setModel(model);
        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        FileListScroll.setViewportView(fileList);

        FileListScroll.setVisible(true);
        fileList.setVisible(true);



    }

//    void loadDir(File dir)
//    {
//        File[] files =dir.listFiles();
//        if(files==null)
//            return;
//        for(File f:files)
//        {
//            FileNode temp=new FileNode(f);
//            model.addElement(temp);
//        }
//    }

}
