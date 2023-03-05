import javax.swing.*;
import java.awt.*;

public class FileListRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList<?> list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        FileNode temp=TahoeLafs.fileContents.get(value.toString());
//        System.out.println("Renderer:"+value.toString());
        ImageIcon imageIcon;//图片

        setPreferredSize(new Dimension(100,50));//设置大小
        setText(temp.getName());//设置名字

        if(temp.isDir()) {//设置图标种类
            imageIcon=new ImageIcon("/Users/liushen/Library/CloudStorage/OneDrive-个人/works/Tahoe-Lafs-GUI/Tahoe-Lafs-GUI/image/wenjianjia.png");
        }
        else  {
            imageIcon=new ImageIcon("/Users/liushen/Library/CloudStorage/OneDrive-个人/works/Tahoe-Lafs-GUI/Tahoe-Lafs-GUI/image/wenjian.png");
        }
        //设置图标大小属性
        Image img=imageIcon.getImage();
        img=img.getScaledInstance(50,50,Image.SCALE_DEFAULT);
        imageIcon.setImage(img);
        setIcon(imageIcon);

        setOpaque(true);
        if(isSelected) {		//当某个元素被选中时
            setForeground(Color.WHITE);		//设置前景色（文字颜色）为白色
            setBackground(Color.LIGHT_GRAY);		//设置背景色为蓝色
        } else {		//某个元素未被选中时（取消选中）
            setForeground(Color.BLACK);		//设置前景色（文字颜色）为黑色
            setBackground(Color.WHITE);		//设置背景色为白色
        }

        return this;
    }
}
