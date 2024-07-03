package com.tahoelafsgui.command;


import com.tahoelafsgui.controller.FileOperations;

/**
 * @author liushen
 */
public class DownloadCommand implements Command {
    private FileOperations fileOperations;

    public DownloadCommand(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

    @Override
    public void execute() throws Exception {
        fileOperations.downloadFile();
    }
}
