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
