import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel {

    public LeftPanel() {
        this.setVisible(true);
        this.setSize(170, 650);
        this.setPreferredSize(new Dimension(170, 650));
//        this.setBackground(Color.orange);
        this.setLayout(new BorderLayout());
    }
}

class LeftDownButtonPanel extends JPanel {
    public LeftDownButtonPanel() {
        this.setVisible(true);
        this.setPreferredSize(new Dimension(170, 50));
        this.setLayout(new GridLayout(1, 1, 0, 0));
    }
}

class LeftUpButtonPanel extends JPanel {
    public LeftUpButtonPanel() {
        this.setVisible(true);
        this.setPreferredSize(new Dimension(170, 100));
        this.setLayout(new GridLayout(2, 1, 0, 0));
    }
}


class LeftButton extends JButton {
    public LeftButton(String str) {
        this.setVisible(true);
        this.setSize(170, 50);
        this.setPreferredSize(new Dimension(170, 50));
        this.setBackground(Color.CYAN);
        this.setText(str);
    }
}

class LeftMyFileButton extends LeftButton {
    public LeftMyFileButton(String str) {
        super(str);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("我的文件");
            }
        });
    }
}

class LeftRecycelButton extends LeftButton {
    public LeftRecycelButton(String str) {
        super(str);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("回收站");
            }
        });
    }
}

class LeftSetButton extends LeftButton {
    public LeftSetButton(String str) {
        super(str);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("设置");
                new SetDialog();
            }
        });
    }
}

class SetDialog extends JDialog{
    public SetDialog()
    {
        this.setTitle("设置");
        this.setVisible(true);
        this.setMinimumSize(new Dimension(300,300));
        this.setPreferredSize(new Dimension(300,300));
        this.setLocationRelativeTo(null);//设置位置居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口关闭
        //add one label
        Container contentPane = this.getContentPane();
        JLabel jLabel = new JLabel("再容器中添加标签");
        contentPane.add(jLabel);
        //center 居中
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
}








