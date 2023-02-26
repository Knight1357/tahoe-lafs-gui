import javax.swing.*;
import java.awt.*;
import java.nio.file.attribute.FileTime;


//上部分块
class UpPanel extends JPanel {
    public UpPanel() {
        this.setVisible(true);
        this.setSize(600,100);
        this.setPreferredSize(new Dimension(600,100));
        this.setLayout(new BorderLayout());
    }
}


//操作块
class OperatePanel extends JPanel{
    public OperatePanel()
    {
        this.setVisible(true);
        this.setSize(600,80);
        this.setPreferredSize(new Dimension(600,90));
        this.setLayout(new GridLayout(2,1,0,0));
    }
}

//搜索块
class SearchPanel extends JPanel {
    public SearchPanel() {
        this.setVisible(true);
        this.setSize(600,40);
        this.setPreferredSize(new Dimension(600,40));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }
}

//文字块
class SearchTextFild extends JTextField{
    public SearchTextFild()
    {
        this.setVisible(true);
        this.setSize(400,35);
        this.setPreferredSize(new Dimension(400,35));
    }
}

class SearchButton extends UpButton{
    public SearchButton()
    {
        this.setText("搜索文件");
    }
}


class OperateButtonPanel extends JPanel{
    public OperateButtonPanel()
    {
        this.setVisible(true);
        this.setSize(600,40);
        this.setPreferredSize(new Dimension(600,40));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }
}

class UploadButton extends UpButton{
    public UploadButton()
    {
        this.setText("上传文件");
    }
}



class DownloadButton extends UpButton{
    public DownloadButton()
    {
        this.setText("上传文件");
    }
}

class MakeDirectoryButton extends UpButton{
    public MakeDirectoryButton()
    {
        this.setText("新建文件");
    }
}


class InformationPanel extends JPanel{
    public InformationPanel()
    {
        this.setVisible(true);
        this.setSize(600,20);
        this.setPreferredSize(new Dimension(600,20));
        this.setLayout(new BorderLayout(10,0));
    }
}




class FirstInformationPanel extends JPanel{
    public FirstInformationPanel()
    {
        this.setVisible(true);
        this.setPreferredSize(new Dimension(300,20));
        this.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
    }
}

class FileNameLable extends UpLable{
    public FileNameLable()
    {
        this.setText("文件名称");
    }
}

class OtherInformationPanel extends JPanel{
   public OtherInformationPanel()
    {
        this.setVisible(true);
        this.setPreferredSize(new Dimension(300,20));
        this.setLayout(new GridLayout(1,2,10,0));
    }
}

class FileSizeLable extends UpLable{
    public FileSizeLable()
    {
        this.setText("文件大小");
    }
}

class FileDateLable extends UpLable{
    public FileDateLable()
    {
        this.setText("文件日期");
    }
}


