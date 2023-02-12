import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow()
    {
        this.setTitle("Tahoe-Lafs");
        this.setVisible(true);//设置可视
        this.setSize(1100,650);
        this.setMinimumSize(new Dimension(1100,650));
        this.setLocationRelativeTo(null);//设置位置居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口关闭
        this.setLayout(new BorderLayout());

//        Container container=this.getContentPane();
//        container.setBackground(Color.PINK);

       this.add(new LeftPanel(),BorderLayout.WEST);
        this.add(new MiddlePanel(),BorderLayout.CENTER);



    }

}
