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
        FileList fileList=(FileList) list;
        setText(value.toString());
        ImageIcon imageIcon;
        if(value.toString().indexOf('.')!=-1) {
            imageIcon=new ImageIcon("/Users/liushen/Library/CloudStorage/OneDrive-个人/works/Tahoe-Lafs-GUI/Tahoe-Lafs-GUI/image/wenjian.png");
        }
        else  {
            imageIcon=new ImageIcon("/Users/liushen/Library/CloudStorage/OneDrive-个人/works/Tahoe-Lafs-GUI/Tahoe-Lafs-GUI/image/wenjianjia.png");
        }
        Image img=imageIcon.getImage();
        img=img.getScaledInstance(50,50,Image.SCALE_DEFAULT);
        imageIcon.setImage(img);
        setIcon(imageIcon);

        if(isSelected) {		//当某个元素被选中时
            setForeground(Color.WHITE);		//设置前景色（文字颜色）为白色
            setBackground(Color.LIGHT_GRAY);		//设置背景色为蓝色
            System.out.println(index+"被选中");
        } else {		//某个元素未被选中时（取消选中）
            setForeground(Color.BLACK);		//设置前景色（文字颜色）为黑色
            setBackground(Color.WHITE);		//设置背景色为白色
        }

        return this;
    }
}
