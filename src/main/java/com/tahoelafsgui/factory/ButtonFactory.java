package com.tahoelafsgui.factory;

import com.tahoelafsgui.command.Command;

import javax.swing.JButton;

/**
 * @author liushen
 */
// 按钮工厂
public interface ButtonFactory {
    JButton createButton(String text);
    JButton createButton(String text, Command command);
}
