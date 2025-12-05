package com.esiea.pootd2.commands;

import com.esiea.pootd2.controllers.ExplorerController;
import com.esiea.pootd2.models.FolderInode;
import com.esiea.pootd2.models.Inode;

/**
 * Command to create a new directory.
 */
public class MakeDirectoryCommand extends Command {
    /**
     * The name of the directory to create.
     */
    private final String name;

    /**
     * Constructor for MakeDirectoryCommand.
     * @param name the name of the directory to create
     */
    public MakeDirectoryCommand(String name) { 
        this.name = name; 
    }

    /**
     * Gets the name of the directory to create.
     * @return the name of the directory
     */
    public String getName() { 
        return name; 
    }

    /**
     * Executes the mkdir command to create a new directory in the current directory.
     * @param controller the explorer controller
     * @return result message of the command execution
     */
    public String doCommand(ExplorerController controller) {
        String name = this.getName();
        // check if name already exists
        for (Inode child : controller.getCurrent().getChildren()) {
            if (child.getName().equals(name)) {
                return "mkdir: cannot create directory '" + name + "': File exists";
            }
        }
        FolderInode newFolder = new FolderInode(name);
        controller.getCurrent().addInode(newFolder);
        return "";

    }
}
