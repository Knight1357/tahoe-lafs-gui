package RendererTest;

import javax.swing.*;
import java.awt.*;


public class FileListCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<? extends Object> list,Object value,int index,boolean isSelected,boolean cellHasFocus) {
        setText(value.toString());		//设置文字

        if(isSelected) {		//当某个元素被选中时
            setForeground(Color.WHITE);		//设置前景色（文字颜色）为白色
            setBackground(Color.BLUE);		//设置背景色为蓝色
            System.out.println(index+"被选中");
        } else {		//某个元素未被选中时（取消选中）
            setForeground(Color.BLACK);		//设置前景色（文字颜色）为黑色
            setBackground(Color.WHITE);		//设置背景色为白色
        }
        return this;
    }
}


//public class FileListCellRenderer extends DefaultListCellRenderer
//{
//   private FileListCellPanel fileListCellPanel=new FileListCellPanel();
//   private FileOtherInformationPanle otherInformationPanle =new FileOtherInformationPanle();
//    private FileNameCellLable fileName=new FileNameCellLable();
//    private FileSizeCellLable fileSize=new FileSizeCellLable();
//
//    private FileDateCellLable fileDate=new FileDateCellLable();
//    private ImageIcon imageIcon;//图片
//
//    private FileNode fileNode;
//    @Override
//    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
////        fileNode=(FileNode) value;
////        initCell();
////
////        System.out.println("index= "+index+" isSelected= "+isSelected);
////
////        return fileName;
//        setText(value.toString());
//        if(isSelected) {		//当某个元素被选中时
//            setForeground(Color.WHITE);		//设置前景色（文字颜色）为白色
//            setBackground(Color.BLUE);		//设置背景色为蓝色
//            System.out.println(index+"被选中");
//        } else {		//某个元素未被选中时（取消选中）
//            setForeground(Color.BLACK);		//设置前景色（文字颜色）为黑色
//            setBackground(Color.WHITE);		//设置背景色为白色
//        }
//        return this;
//    }
//
//    private void initCell()//初始化
//    {
//        fileName.setText(fileNode.getName());
//        fileSize.setText("null");
//        fileDate.setText("null");
//
//        if (fileNode.isDir()) {//设置图标种类
//            imageIcon = new ImageIcon("image/wenjianjia.png");
//        } else {
//            imageIcon = new ImageIcon("image/wenjian.png");
//        }
//        //设置图标大小属性
//        Image img = imageIcon.getImage();
//        img = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
//        imageIcon.setImage(img);
//        fileName.setIcon(imageIcon);
//
//
//        fileListCellPanel.add(fileName,BorderLayout.WEST);
//        fileListCellPanel.add(otherInformationPanle,BorderLayout.EAST);
//        otherInformationPanle.add(fileSize);
//        otherInformationPanle.add(fileDate);
//
//    }
//
//}

class FileListCellPanel extends JPanel {//文件列表单元格块
    FileListCellPanel()
    {
        this.setVisible(true);
        this.setSize(850,50);
        this.setPreferredSize(new Dimension(850,50));
        this.setLayout(new BorderLayout());
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
        }
    }

    class FileSizeCellLable extends JLabel//文件大小标签
    {
        FileSizeCellLable()
        {
            this.setVisible(true);
            this.setSize(100,50);
            this.setPreferredSize(new Dimension(100,50));
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


