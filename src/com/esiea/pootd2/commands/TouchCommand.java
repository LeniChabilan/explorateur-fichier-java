package com.esiea.pootd2.commands;

import com.esiea.pootd2.controllers.ExplorerController;
import com.esiea.pootd2.models.FileInode;
import com.esiea.pootd2.models.Inode;

public class TouchCommand extends Command {
    private final String name;
    public TouchCommand(String name) { this.name = name; }
    public String getName() { return name; }


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
