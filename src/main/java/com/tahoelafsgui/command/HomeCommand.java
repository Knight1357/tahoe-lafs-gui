package com.tahoelafsgui.command;

import com.tahoelafsgui.controller.FileOperations;

/**
 * @author liushen
 */
public class HomeCommand implements Command {
    private FileOperations fileOperations;

    public HomeCommand(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

    @Override
    public void execute() {
        fileOperations.goHome();
    }
}
