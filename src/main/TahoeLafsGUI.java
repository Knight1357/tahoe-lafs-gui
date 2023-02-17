import javax.swing.*;

public class TahoeLafsGUI {
    private JPanel MainWindows;
    private JPanel Left;
    private JButton Myfile;
    private JPanel Right;
    private JPanel File;
    private JButton Recycle;
    private JPanel Set;
    private JButton Seting;
    private JPanel Function;
    private JPanel FileManagement;
    private JButton Upload;
    private JButton NewFile;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TahoeLafsGUI");
        frame.setContentPane(new TahoeLafsGUI().MainWindows);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
