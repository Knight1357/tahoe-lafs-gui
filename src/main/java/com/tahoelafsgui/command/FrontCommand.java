package com.tahoelafsgui.command;

import com.tahoelafsgui.controller.FileOperations;

/**
 * @author liushen
 */
public class FrontCommand implements Command {
    private FileOperations fileOperations;

    public FrontCommand(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

    @Override
    public void execute() {
        fileOperations.goFront();
    }
}
