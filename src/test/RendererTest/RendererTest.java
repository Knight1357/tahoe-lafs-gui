package RendererTest;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class RendererTest {
    public static void main(String[] args) {
        JFrame jf=new JFrame("列表对象获取");
        jf.setSize(500,300);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);


        FileListModel<FileNode> dfl=new FileListModel<FileNode>();

        FileNode f1=new FileNode("666666666","2212133");
        FileNode f2=new FileNode("6222666666","6222666666");

        dfl.addElement(f1);
        dfl.addElement(f2);

        JList<FileNode> jl=new JList();
        jl.setModel(dfl);
        FileListCellRenderer fileListCellRenderer =new FileListCellRenderer();
        jl.setCellRenderer(fileListCellRenderer);		//设置渲染器为我们自己的

        FileScrollPanel jsp=new FileScrollPanel();
        jsp.setBounds(14, 13, 431, 210);
        jsp.setViewportView(jl);

        JPanel jp=new JPanel();
        jf.getContentPane().add(jp);
        jp.setLayout(null);
        jp.add(jsp);
        jf.show();
        /**
         使用Object的toString()方法，用控制台输出获取到的表格的第1、2、3、4个内容。
         */
        System.out.println(jl.getModel().getElementAt(0).toString());
        System.out.println(jl.getModel().getElementAt(1).toString());
        System.out.println(jl.getModel().getElementAt(2).toString());
        System.out.println(jl.getModel().getElementAt(3).toString());
    }
}


class FileScrollPanel extends JScrollPane {
    public FileScrollPanel()
    {
        this.setVisible(true);

    }
}