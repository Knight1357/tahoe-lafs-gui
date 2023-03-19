import javax.swing.*;
import java.awt.*;


public class FileListCellRenderer implements ListCellRenderer
{
   private FileListCellPanel fileListCellPanel=new FileListCellPanel();

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        FileNode fileNode=(FileNode) value;

        fileListCellPanel.init(fileNode);

        if(isSelected) {		//当某个元素被选中时
            fileListCellPanel.setForeground(Color.WHITE);		//设置前景色（文字颜色）为白色
            fileListCellPanel.setBackground(Color.LIGHT_GRAY);		//设置背景色为蓝色

            System.out.println(index+"被选中");
        } else {		//某个元素未被选中时（取消选中）
            fileListCellPanel.setForeground(Color.BLACK);		//设置前景色（文字颜色）为黑色
            fileListCellPanel.setBackground(Color.WHITE);		//设置背景色为白色
        }
        return fileListCellPanel;
    }

}

class FileListCellPanel extends JPanel {//文件列表单元格块
   private FileOtherInformationPanle otherInformationPanle=new FileOtherInformationPanle();
    private FileNameCellLable fileName;
    private FileSizeCellLable fileSize;
    private FileDateCellLable fileDate;
    private ImageIcon imageIcon;//图片

    private FileNode fileNode;

    FileListCellPanel()
    {
        this.setVisible(true);
        this.setSize(850,50);
        this.setPreferredSize(new Dimension(850,50));
        this.setLayout(new BorderLayout());



       fileName=new FileNameCellLable();
        fileSize=new FileSizeCellLable();

        fileDate=new FileDateCellLable();
    }

   public void init(FileNode fileNode)
    {
        this.setVisible(true);
        this.setSize(850,50);
        this.setPreferredSize(new Dimension(850,50));
        this.setLayout(new BorderLayout());

        fileName.setText(fileNode.getName());
        fileSize.setText("null");
        fileDate.setText("null");

        if (fileNode.isDir()) {//设置图标种类
            imageIcon = new ImageIcon("image/wenjianjia.png");
        } else {
            imageIcon = new ImageIcon("image/wenjian.png");
        }

        //设置图标大小属性
        Image img = imageIcon.getImage();
        img = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        imageIcon.setImage(img);
        fileName.setIcon(imageIcon);


        this.add(fileName,BorderLayout.WEST);
        this.add(otherInformationPanle,BorderLayout.EAST);
        otherInformationPanle.add(fileSize);
        otherInformationPanle.add(fileDate);

    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
//        otherInformationPanle.setBackground(bg);
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
//        otherInformationPanle.setForeground(fg);
    }

    class FileNameCellLable extends JLabel//文件名字标签
    {
        FileNameCellLable()
        {
            this.setVisible(true);
            this.setSize(300,50);
            this.setPreferredSize(new Dimension(300,50));
        }
    }

    class FileOtherInformationPanle extends JPanel{//文件其他信息块
        FileOtherInformationPanle()
        {
            this.setVisible(true);
            this.setPreferredSize(new Dimension(300,50));
            this.setLayout(new GridLayout(1,2,10,0));
//            this.setBackground(Color.white);
        }
    }

    class FileSizeCellLable extends JLabel//文件大小标签
    {
        FileSizeCellLable()
        {
            this.setVisible(true);
            this.setSize(50,50);
            this.setPreferredSize(new Dimension(50,50));
        }
    }

    class FileDateCellLable extends JLabel//文件日期标签
    {
        FileDateCellLable()
        {
            this.setVisible(true);
            this.setSize(100,50);
            this.setPreferredSize(new Dimension(100,50));
        }
    }
}

//class FileCellIcon extends


