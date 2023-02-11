import javax.swing.*;
import java.awt.*;

public class Main {
    private JFrame frame=new JFrame("Taheo-Lafs");
    private GridBagLayout gridBagLayout=new GridBagLayout();
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private Panel leftPanel=new Panel();

    private JButton homePageButton=new JButton();
    private JButton transmissionButton=new JButton();
    private JButton setButton=new JButton();

    private Panel middlePanel=new Panel();

    void Init()
    {
        gridBagConstraints.fill=gridBagConstraints.BOTH;//该方法是为了设置如果组件所在的区域比组件本身要大时的显示情况
//        gridBagLayout.setConstraints(leftPanel,gridBagConstraints);

//        frame.setLayout(gridBagLayout);
        frame.setLayout(new FlowLayout());
        frame.setSize(1100,650);
        frame.setMinimumSize(new Dimension(1100,650));
//        frame.setMaximumSize(new Dimension(1100,650));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



        leftPanel.setLayout(new GridBagLayout());
        leftPanel.setSize(70,650);
        leftPanel.setBackground(Color.CYAN);

        homePageButton.setText("首页");
        homePageButton.setSize(70,70);
        homePageButton.setBackground(Color.GRAY);
        homePageButton.setLocation(0,0);


        transmissionButton.setText("传输");
        transmissionButton.setSize(70,70);
        transmissionButton.setBackground(Color.GRAY);
        transmissionButton.setLocation(0,70);

        setButton.setText("设置");
        setButton.setSize(70,70);
        setButton.setBackground(Color.GRAY);
//        setButton.setLocation(0,650-110);

        middlePanel.setLayout(new CardLayout());
        middlePanel.setLocation(70,0);
        middlePanel.setSize(170,650);;
        middlePanel.setBackground(Color.PINK);






        leftPanel.add(homePageButton);
        leftPanel.add(transmissionButton);
        leftPanel.add(setButton);

        frame.add(leftPanel);
        frame.add(middlePanel);
    }

    public static void main(String[] args)
    {
        new Main().Init();
    }
}