package com.tahoelafsgui.command;

import com.tahoelafsgui.controller.FileOperations;

/**
 * @author liushen
 */
public class CreateFinderCommand implements Command{
    private FileOperations fileOperations;

    public CreateFinderCommand() {
        this.fileOperations = fileOperations;
    }

    @Override
    public void execute() throws Exception {
        fileOperations.createFinder();
    }
}
