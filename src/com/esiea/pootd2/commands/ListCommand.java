package com.esiea.pootd2.commands;

import com.esiea.pootd2.controllers.ExplorerController;
import com.esiea.pootd2.models.Inode;

public class ListCommand extends Command {

    public String doCommand(ExplorerController controller) {
        StringBuilder sb = new StringBuilder();
        for (Inode inode : controller.getCurrent().getChildren()) {
            sb.append(inode.getName()).append(" ").append(inode.getSize()).append("\n");
        }
        return sb.toString().trim();
    }
}
