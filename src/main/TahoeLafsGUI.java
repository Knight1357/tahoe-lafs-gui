import javax.swing.*;

public class TahoeLafsGUI {
    private JPanel MainWindows;
    private JPanel UpPanel;
    private JPanel InformationPanel;
    private JPanel OperationPanel;
    private JPanel SearchPanel;
    private JPanel FileOperationPanel;
    private JButton SearchButton;
    private JTextField textField1;
    private JButton UploadButton;
    private JButton DownloadButton;
    private JButton CreateDIrButton;


    public static void main(String[] args) {
        JFrame frame = new JFrame("TahoeLafsGUI");
        frame.setContentPane(new TahoeLafsGUI().MainWindows);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
