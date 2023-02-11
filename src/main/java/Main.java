import javax.swing.*;
import java.awt.*;

public class Main {
    private JFrame frame=new JFrame("Taheo-Lafs");
    private GridBagLayout gbl=new GridBagLayout();
    private GridBagConstraints gbc = new GridBagConstraints();
    private Panel leftPanel=new Panel();
    private JButton leftButton=new JButton();

    void Init()
    {
        frame.setLayout(gbl);
        frame.setVisible(true);
        frame.setSize(1100,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        leftPanel.setLayout(gbl);
        leftPanel.setSize(70,650);

        leftButton.setSize(70,70);



    }

    public static void main(String[] args)
    {
        new Main().Init();
    }
}