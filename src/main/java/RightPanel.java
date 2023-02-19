import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightPanel extends JPanel {
    public RightPanel() {
        this.setVisible(true);
        this.setBackground(Color.PINK);
        this.setLayout(new BorderLayout());
    }
}

class RightButton extends JButton {
    public RightButton(String str) {
        this.setVisible(true);
        this.setSize(120, 40);
        this.setPreferredSize(new Dimension(120, 40));
        this.setBackground(Color.CYAN);
        this.setText(str);
    }
}

class RightUpPanel extends JPanel {
    public RightUpPanel() {
        this.setVisible(true);
        this.setBackground(Color.PINK);
        this.setLayout(new BorderLayout());
    }
}

class RightUpLeftButtonPanel extends JPanel {
    public RightUpLeftButtonPanel() {
        this.setVisible(true);
        this.setSize(240, 40);
        this.setPreferredSize(new Dimension(240, 40));
        this.setBackground(Color.PINK);
        this.setLayout(new GridLayout(1, 2, 0, 0));
    }
}

class RightUploadButton extends RightButton {
    public RightUploadButton(String str) {
        super(str);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("上传文件");
            }
        });

    }
}

class RightNewfileButton extends RightButton {
    public RightNewfileButton(String str) {
        super(str);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("新建文件夹");
                new NewfileDialog();
            }
        });
    }
}

class RightScorllPane extends JScrollPane {
    public RightScorllPane() {
        this.setVisible(true);
    }
}

//class  UploadDialog extends JDialog{
//    public UploadDialog()
//    {
//        this.setTitle("设置");
//        this.setVisible(true);
//        this.setMinimumSize(new Dimension(300,300));
//        this.setPreferredSize(new Dimension(300,300));
//        this.setLocationRelativeTo(null);//设置位置居中
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口关闭
//        //add one label
//        Container contentPane = this.getContentPane();
//        JLabel jLabel = new JLabel("再容器中添加标签");
//        contentPane.add(jLabel);
//        //center 居中
//        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
//    }
//}

class  NewfileDialog extends JDialog{
    String name;
    public NewfileDialog()
    {
        this.setTitle("新建文件夹");
        this.setVisible(true);
        this.setMinimumSize(new Dimension(200,200));
        this.setPreferredSize(new Dimension(200,200));
        this.setLocationRelativeTo(null);//设置位置居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口关闭

//        JTextField text=new JTextField();
//        text.setVisible(true);
//        text.setBounds(1,1,100,20);
//        this.add(text);

    }
}