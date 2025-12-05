/*
 * ListCommand.java
 * 
 * Version 1.0
 * Date: December 2025
 * 
 * Copyright (c) 2025 ESIEA. All rights reserved.
 * 
 * Command implementation for listing the contents of the current directory.
 * Displays name and size of each inode.
 */

package com.esiea.pootd2.commands;

import com.esiea.pootd2.controllers.ExplorerController;
import com.esiea.pootd2.models.Inode;

/**
 * Command to list the contents of the current directory.
 */
public class ListCommand extends Command {

    /**
     * Executes the ls command to list the contents of the current directory.
     * @param controller the explorer controller
     * @return result message of the command execution
     */
    public String doCommand(ExplorerController controller) {
        StringBuilder sb = new StringBuilder();
        for (Inode inode : controller.getCurrent().getChildren()) {
            sb.append(inode.getName()).append(" ").append(inode.getSize()).append("\n");
        }
        return sb.toString().trim();
    }
}
