package com.esiea.pootd2.commands;

import com.esiea.pootd2.controllers.ExplorerController;
import com.esiea.pootd2.models.FolderInode;
import com.esiea.pootd2.models.Inode;

public class MakeDirectoryCommand extends Command {
    private final String name;
    public MakeDirectoryCommand(String name) { this.name = name; }
    public String getName() { return name; }

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
