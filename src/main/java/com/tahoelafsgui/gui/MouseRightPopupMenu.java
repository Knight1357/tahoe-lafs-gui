package com.tahoelafsgui.gui;

import javax.swing.*;

/**
 * @author liushen
 */
public class MouseRightPopupMenu extends JPopupMenu {
    public MouseRightPopupMenu() {
        super();
        JMenuItem open = new JMenuItem("打开");
        JMenuItem download = new JMenuItem("下载");
        JMenuItem copy = new JMenuItem("复制");
        JMenuItem paste = new JMenuItem("粘贴");
        JMenuItem shear = new JMenuItem("剪切");
        JMenuItem rename = new JMenuItem("重命名");
        JMenuItem delete = new JMenuItem("删除");

        this.add(open);
        this.add(download);
        this.add(copy);
        this.add(paste);
        this.add(shear);
        this.add(rename);
        this.add(delete);

        open.addActionListener(e -> System.out.println("打开"));
        download.addActionListener(e -> System.out.println("下载"));
        copy.addActionListener(e -> System.out.println("复制"));
        paste.addActionListener(e -> System.out.println("粘贴"));
        shear.addActionListener(e -> System.out.println("剪切"));
        rename.addActionListener(e -> System.out.println("重命名"));
        delete.addActionListener(e -> System.out.println("删除"));
    }
}
