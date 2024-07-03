package com.tahoelafsgui.command;

import com.tahoelafsgui.controller.FileOperations;

/**
 * @author liushen
 */
public class SearchCommand implements Command {
    private FileOperations fileOperations;

    public SearchCommand(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

    @Override
    public void execute() {
        fileOperations.searchFile();
    }
}
