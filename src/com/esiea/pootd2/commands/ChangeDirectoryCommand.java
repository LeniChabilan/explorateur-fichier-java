/*
 * ChangeDirectoryCommand.java
 * 
 * Version 1.0
 * Date: December 2025
 * 
 * Copyright (c) 2025 ESIEA. All rights reserved.
 * 
 * Command implementation for changing the current working directory.
 * Supports navigation to child directories and parent directory (..).
 */

package com.esiea.pootd2.commands;

import com.esiea.pootd2.controllers.ExplorerController;
import com.esiea.pootd2.models.FolderInode;
import com.esiea.pootd2.models.Inode;

/**
 * Command to change the current directory.
 */
public class ChangeDirectoryCommand extends Command {
    /**
     * The path to change to.
     */
    private final String path;

    /**
     * Constructor for ChangeDirectoryCommand.
     * @param path the path to change to
     */
    public ChangeDirectoryCommand(String path) { 
        this.path = path; 
    }

    /**
     * Gets the path to change to.
     * @return the path
     */
    public String getPath() { 
        return path; 
    }

    /**
     * Executes the cd command to change the current directory.
     * @param controller the explorer controller
     * @return result message of the command execution
     */
    public String doCommand(ExplorerController controller) {
        String path = this.getPath();
        if (path.equals("..")) {
            if (controller.getCurrent().getParent() != null) {
                controller.setCurrent(controller.getCurrent().getParent());
            }
            return "";
        } else {
            for (Inode child : controller.getCurrent().getChildren()) {
                if (child.getName().equals(path) && child instanceof FolderInode) {
                    controller.setCurrent((FolderInode) child);
                    return "";
                }
            }
            return "cd: no such file or directory: " + path;
        }
    }
}
