package com.tahoelafsgui.factory;

import com.tahoelafsgui.command.Command;

import javax.swing.*;

/**
 * @author liushen
 */
public class FileButtonFactory implements ButtonFactory {
    @Override
    public JButton createButton(String text) {
        JButton button = new JButton(text);
        return button;
    }

    // 设置按钮文本和按钮触发命令
    @Override
    public JButton createButton(String text, Command command) {
        JButton button = createButton(text);
        button.addActionListener(e -> {
            try {
                command.execute();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        return button;
    }
}
