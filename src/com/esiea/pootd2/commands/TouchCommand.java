/*
 * TouchCommand.java
 * 
 * Version 1.0
 * Date: December 2025
 * 
 * Copyright (c) 2025 ESIEA. All rights reserved.
 * 
 * Command implementation for creating new empty files in the file system.
 * Checks for duplicate names before creation.
 */

package com.esiea.pootd2.commands;

import com.esiea.pootd2.controllers.ExplorerController;
import com.esiea.pootd2.models.FileInode;
import com.esiea.pootd2.models.Inode;
/**
 * Command to create a new empty file.
 */
public class TouchCommand extends Command {
    /**
     * The name of the file to create.
     */
    private final String name;

    /**
     * Constructor for TouchCommand.
     * @param name the name of the file to create
     */
    public TouchCommand(String name) { 
        this.name = name; 
    }

    /**
     * Gets the name of the file to create.
     * @return the name of the file
     */
    public String getName() { 
        return name; 
    }

    /**
     * Executes the touch command to create a new file in the current directory.
     * @param controller the explorer controller
     * @return result message of the command execution
     */
    public String doCommand(ExplorerController controller) {
        String name = this.getName();
        // check if name already exists
        for (Inode child : controller.getCurrent().getChildren()) {
            if (child.getName().equals(name)) {
                return "touch: cannot create file '" + name + "': File exists";
            }
        }
        FileInode newFile = new FileInode(name);
        controller.getCurrent().addInode(newFile);
        return "";
    }
}
