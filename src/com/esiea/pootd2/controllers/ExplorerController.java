package com.esiea.pootd2.controllers;

import com.esiea.pootd2.commands.*;
import com.esiea.pootd2.commands.parsers.UnixLikeCommandParser;
import com.esiea.pootd2.models.*;

public class ExplorerController implements IExplorerController {
    private final FolderInode root;
    private FolderInode current;
    private final UnixLikeCommandParser parser = new UnixLikeCommandParser();

    public ExplorerController() {
        this.root = new FolderInode("/");
        this.root.setParent(null);
        this.current = root;
    }

    @Override
    public String executeCommand(String commandStr) {
        Command command = parser.parse(commandStr);
        return doCommand(command);
    }

    private String doCommand(Command cmd) {
        if (cmd instanceof ListCommand) return doList((ListCommand) cmd);
        if (cmd instanceof ChangeDirectoryCommand) return doCd((ChangeDirectoryCommand) cmd);
        if (cmd instanceof MakeDirectoryCommand) return doMkdir((MakeDirectoryCommand) cmd);
        if (cmd instanceof TouchCommand) return doTouch((TouchCommand) cmd);
        if (cmd instanceof ErrorCommand) return ((ErrorCommand) cmd).getMessage();
        return "Unhandled command";
    }

    private String doList(ListCommand cmd) {
        StringBuilder sb = new StringBuilder();
        for (Inode inode : current.getChildren()) {
            sb.append(inode.getName()).append(" ").append(inode.getSize()).append("\n");
        }
        return sb.toString().trim();
    }

    private String doCd(ChangeDirectoryCommand cmd) {
        String path = cmd.getPath();
        if ("/".equals(path)) {
            current = root;
            return "";
        }
        if ("..".equals(path)) {
            if (current.getParent() != null) {
                current = current.getParent();
            }
            return "";
        }
        // support simple relative path (single folder) and absolute like /something
        if (path.startsWith("/")) {
            // absolute: simple name after /
            String[] parts = path.substring(1).split("/");
            FolderInode node = root;
            for (String p : parts) {
                if (p.isEmpty()) continue;
                boolean found = false;
                for (Inode child : node.getChildren()) {
                    if (child instanceof FolderInode && child.getName().equals(p)) {
                        node = (FolderInode) child;
                        found = true;
                        break;
                    }
                }
                if (!found) return "cd: no such file or directory: " + path;
            }
            current = node;
            return "";
        } else {
            // relative
            for (Inode child : current.getChildren()) {
                if (child instanceof FolderInode && child.getName().equals(path)) {
                    current = (FolderInode) child;
                    return "";
                }
            }
            return "cd: no such file or directory: " + path;
        }
    }

    private String doMkdir(MakeDirectoryCommand cmd) {
        String name = cmd.getName();
        // check if name already exists
        for (Inode child : current.getChildren()) {
            if (child.getName().equals(name)) {
                return "mkdir: cannot create directory '" + name + "': File exists";
            }
        }
        FolderInode newFolder = new FolderInode(name);
        current.addInode(newFolder);
        return "";
    }

    private String doTouch(TouchCommand cmd) {
        String name = cmd.getName();
        for (Inode child : current.getChildren()) {
            if (child.getName().equals(name)) {
                return ""; // déjà présent ; toucher ne fait rien pour notre TD
            }
        }
        FileInode file = new FileInode(name);
        current.addInode(file);
        return "";
    }
}
