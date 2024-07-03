package com.tahoelafsgui.command;

import com.tahoelafsgui.controller.FileOperations;

/**
 * @author liushen
 */
public class UploadCommand implements Command {
    private FileOperations fileOperations;

    public UploadCommand(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

    @Override
    public void execute() {
        fileOperations.uploadFile();
    }
}
