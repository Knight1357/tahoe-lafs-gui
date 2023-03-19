import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {//主窗口设置

    public MainWindow() {
        this.setTitle("Tahoe-Lafs");
        this.setVisible(true);//设置可视
        this.setSize(900, 700);
        this.setMinimumSize(new Dimension(900, 700));
        this.setLocationRelativeTo(null);//设置位置居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口关闭
        this.setLayout(new BorderLayout());
    }
}
