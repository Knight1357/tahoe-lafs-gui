import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.FileTime;


//上部分块
class UpPanel extends JPanel {//上部分文件
    public UpPanel() {
        this.setVisible(true);
        this.setSize(600,100);
        this.setPreferredSize(new Dimension(600,100));
        this.setLayout(new BorderLayout());
    }
}


//操作块
class OperatePanel extends JPanel{//文件操作
    public OperatePanel()
    {
        this.setVisible(true);
        this.setSize(600,80);
        this.setPreferredSize(new Dimension(600,90));
        this.setLayout(new GridLayout(2,1,0,0));
    }
}

//搜索块
class SearchPanel extends JPanel {//搜索块
    public SearchPanel() {
        this.setVisible(true);
        this.setSize(600,40);
        this.setPreferredSize(new Dimension(600,40));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }
}

//文字块
class SearchTextFild extends JTextField{//搜索框
    public SearchTextFild()
    {
        this.setVisible(true);
        this.setSize(400,35);
        this.setPreferredSize(new Dimension(400,35));
    }
}

class SearchButton extends UpButton{//搜索按钮
    public SearchButton()
    {
        this.setText("搜索文件");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperate.searchFile();
            }
        });
    }

}


class OperateButtonPanel extends JPanel{//文件操作块
    public OperateButtonPanel()
    {
        this.setVisible(true);
        this.setSize(600,40);
        this.setPreferredSize(new Dimension(600,40));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }
}

class UploadButton extends UpButton{//上传文件按钮
    public UploadButton()
    {
        this.setText("上传文件");
    }
}



class DownloadButton extends UpButton{//下载文件按钮
    public DownloadButton()
    {
        this.setText("下载文件");
    }
}

class MakeDirectoryButton extends UpButton{//新建文件夹按钮
    public MakeDirectoryButton()
    {
        this.setText("新建文件");
    }
}


class InformationPanel extends JPanel{//文件信息栏
    public InformationPanel()
    {
        this.setVisible(true);
        this.setSize(600,20);
        this.setPreferredSize(new Dimension(600,20));
        this.setLayout(new BorderLayout(10,0));
    }
}




class FirstInformationPanel extends JPanel{//前部分文件信息
    public FirstInformationPanel()
    {
        this.setVisible(true);
        this.setPreferredSize(new Dimension(300,20));
        this.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
    }
}

class FileNameLable extends UpLable{//文件名称列
    public FileNameLable()
    {
        this.setText("文件名称");
    }
}

class OtherInformationPanel extends JPanel{//其他信息栏
   public OtherInformationPanel()
    {
        this.setVisible(true);
        this.setPreferredSize(new Dimension(300,20));
        this.setLayout(new GridLayout(1,2,10,0));
    }
}

class FileSizeLable extends UpLable{//文件大小列
    public FileSizeLable()
    {
        this.setText("文件大小");
    }
}

class FileDateLable extends UpLable{//文件时间列
    public FileDateLable()
    {
        this.setText("文件日期");
    }
}


