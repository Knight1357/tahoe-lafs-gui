package RendererTest;

import java.awt.*;
import javax.swing.*;

public class CRTest extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        // 设置文字
        setText(value.toString());

        if (isSelected) {
            // 当某个元素被选中时
            // 设置前景色（文字颜色）为白色
            setForeground(Color.WHITE);
            // 设置背景色为蓝色
            setBackground(Color.BLUE);
            System.out.println(index + "被选中");
        } else {
            // 某个元素未被选中时（取消选中）
            // 设置前景色（文字颜色）为黑色
            setForeground(Color.BLACK);
            // 设置背景色为白色
            setBackground(Color.WHITE);
        }
        return this;
    }
}