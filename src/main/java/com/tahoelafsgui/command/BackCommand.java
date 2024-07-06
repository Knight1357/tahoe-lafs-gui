package com.tahoelafsgui.command;

import com.tahoelafsgui.controller.FileOperations;

/**
 * @author liushen
 */
public class BackCommand implements Command {
    private FileOperations fileOperations;

    public BackCommand(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

    @Override
    public void execute() {
        fileOperations.goBack();
    }
}
