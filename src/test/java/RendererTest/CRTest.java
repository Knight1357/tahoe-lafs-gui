package RendererTest;

import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class CRTest extends DefaultListCellRenderer {
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