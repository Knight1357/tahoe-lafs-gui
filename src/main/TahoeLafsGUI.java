import javax.swing.*;
import java.io.File;

public class TahoeLafsGUI {
    private JPanel MainWindows;
    private JPanel UpPanel;
    private JScrollPane DownScrollPanel;


    public static void main(String[] args) {
        JFrame frame = new JFrame("TahoeLafsGUI");
        frame.setContentPane(new TahoeLafsGUI().MainWindows);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
