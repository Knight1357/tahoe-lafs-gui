import javax.swing.*;
import java.awt.*;

public class Tahoe {

    public void Init()//初始化窗口
    {

        JFrame frame = new JFrame("Taheo-Lafs");//新建一个窗口
         frame.setVisible(true);//设置窗口可视
        frame.setSize(1100, 650);//设置窗口大小
        frame.setLocationRelativeTo(null);//设置窗口居中
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭

        frame.setLayout(new FlowLayout());






        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        Panel leftPanel = new Panel();

        JButton homePageButton = new JButton();
        JButton transmissionButton = new JButton();
        JButton setButton = new JButton();

        Panel middlePanel = new Panel();


        gridBagConstraints.fill = gridBagConstraints.BOTH;//该方法是为了设置如果组件所在的区域比组件本身要大时的显示情况
//        gridBagLayout.setConstraints(leftPanel,gridBagConstraints);


        leftPanel.setLayout(new GridBagLayout());
        leftPanel.setSize(70, 650);
        leftPanel.setBackground(Color.CYAN);

        homePageButton.setText("首页");
        homePageButton.setSize(70, 70);
        homePageButton.setBackground(Color.GRAY);
        homePageButton.setLocation(0, 0);


        transmissionButton.setText("传输");
        transmissionButton.setSize(70, 70);
        transmissionButton.setBackground(Color.GRAY);
        transmissionButton.setLocation(0, 70);

        setButton.setText("设置");
        setButton.setSize(70, 70);
        setButton.setBackground(Color.GRAY);
//        setButton.setLocation(0,650-110);

        middlePanel.setLayout(new CardLayout());
        middlePanel.setLocation(70, 0);
        middlePanel.setSize(170, 650);
        ;
        middlePanel.setBackground(Color.PINK);


        leftPanel.add(homePageButton);
        leftPanel.add(transmissionButton);
        leftPanel.add(setButton);

        frame.add(leftPanel);
        frame.add(middlePanel);
    }

    public static void main(String[] args) {
        new Tahoe().Init();
    }
}