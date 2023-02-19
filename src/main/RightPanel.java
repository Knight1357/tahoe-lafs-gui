import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
//        this.setBackground(Color.PINK);
        this.setLayout(new BorderLayout());
    }
}

class RightUpLeftButtonPanel extends JPanel {
    public RightUpLeftButtonPanel() {
        this.setVisible(true);
        this.setSize(240, 40);
        this.setPreferredSize(new Dimension(240, 40));
//        this.setBackground(Color.PINK);
        this.setLayout(new GridLayout(1, 3, 0, 0));
    }
}

class RightUploadButton extends RightButton {
    public RightUploadButton(String str) {
        super(str);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("上传文件");
                UploadFile();
            }
        });
    }
    private void UploadFile()
    {
        JFileChooser jFileChooser =new JFileChooser();

        FileNameExtensionFilter fileNameExtensionFilter=new FileNameExtensionFilter("所有文件","jpg");

        jFileChooser.setFileFilter(fileNameExtensionFilter);

        int ret = jFileChooser.showOpenDialog(this);

        if(ret==JFileChooser.APPROVE_OPTION)
        {
            File file=jFileChooser.getSelectedFile();
            System.out.println(file.getAbsolutePath());
        }
    }
}

class RightDownLoadButton extends RightButton {
    public RightDownLoadButton(String str) {
        super(str);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("下载文件");
                DownLoadFile();
            }
        });
    }
    private void DownLoadFile()
    {

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

class  NewfileDialog extends JDialog{
    String name;
    public NewfileDialog()
    {
        this.setTitle("新建文件夹");
        this.setVisible(true);
        this.setSize(200,200);
//        this.setMinimumSize(new Dimension(200,200));
        this.setLocationRelativeTo(null);//设置位置居中
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口关闭
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Color.WHITE);

        JLabel jLabel=new JLabel("文件名字");
        jLabel.setVisible(true);
        this.add(jLabel);

        JTextField text=new JTextField();
        text.setVisible(true);
        text.setSize(80,20);
        text.setPreferredSize(new Dimension(80,20));
        this.add(text);

        JButton jButton =new JButton("确定");
        jButton.setSize(40,40);
        this.add(jButton);

        jButton.addActionListener(new ActionListener() {//确定
            @Override
            public void actionPerformed(ActionEvent e) {
               name= text.getText();
                new FileOperate().creatFile(name);

                TahoeLafs.LoadDir(Constant.NOWPATH);
            }
        });
    }
}

class RightControlButtonPanel extends JPanel{
   public RightControlButtonPanel()
    {
        this.setVisible(true);
        this.setSize(80,40);
        this.setPreferredSize(new Dimension(80,40));
        this.setLayout(new GridLayout(1,2,0,0));
    }
}

class RightBackButton extends JButton{
    public RightBackButton()
    {
        this.setVisible(true);
        this.setSize(40,40);
        this.setPreferredSize(new Dimension(40,40));
        this.setText("后退");
        this.addActionListener(e -> {
            System.out.println("后退");
            PageBack();
        });
    }

    private void PageBack()
    {
        if(Constant.NOWPATH.equals(Constant.HOSTPATH))
            return;
        File parentFile=Constant.NOWPATH.getParentFile();
        TahoeLafs.LoadDir(parentFile);

        Constant.LASTPATH=new File(Constant.NOWPATH.getName());
        Constant.NOWPATH=parentFile;

    }

}

class RightBeforeButton extends JButton{
    public RightBeforeButton()
    {
        this.setVisible(true);
        this.setSize(40,40);
        this.setPreferredSize(new Dimension(40,40));
        this.setText("前进");
        this.addActionListener(e -> {
            System.out.println("前进");
            PageBefore();
        });
    }
    private void PageBefore()
    {
        File lastFile=Constant.NOWPATH;
        TahoeLafs.LoadDir(lastFile);

        Constant.LASTPATH=Constant.NOWPATH;
        Constant.NOWPATH=lastFile;
    }
}