import javax.swing.*;
import java.awt.*;

public class Main {
    private JFrame frame=new JFrame("Taheo-Lafs");
    private GridBagLayout gridBagLayout=new GridBagLayout();
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private Panel leftPanel=new Panel();
    private JButton leftButton=new JButton();

    void Init()
    {
        frame.setLayout(gridBagLayout);
        frame.setSize(1100,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.CYAN);
        frame.setVisible(true);

        gridBagConstraints.fill=gridBagConstraints.BOTH;//该方法是为了设置如果组件所在的区域比组件本身要大时的显示情况




        leftPanel.setLayout(gridBagLayout);
        leftPanel.setSize(70,650);

        leftButton.setSize(70,70);



    }

    public static void main(String[] args)
    {
        new Main().Init();
    }
}