package com.esiea.pootd2.commands;

import com.esiea.pootd2.controllers.ExplorerController;
import com.esiea.pootd2.models.FolderInode;
import com.esiea.pootd2.models.Inode;

public class ChangeDirectoryCommand extends Command {
    private final String path;
    public ChangeDirectoryCommand(String path) { this.path = path; }
    public String getPath() { return path; }


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
