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

    public FolderInode getCurrent() {
        return current;
    }

    public void setCurrent(FolderInode folder) {
        this.current = folder;
    }

    @Override
    public String executeCommand(String commandStr) {
        Command command = parser.parse(commandStr);
        return doCommand(command);
    }

    private String doCommand(Command cmd) {
        if (cmd instanceof ListCommand) return ((ListCommand) cmd).doCommand(this);
        if (cmd instanceof ChangeDirectoryCommand) return ((ChangeDirectoryCommand) cmd).doCommand(this);
        if (cmd instanceof MakeDirectoryCommand) return ((MakeDirectoryCommand) cmd).doCommand(this);
        if (cmd instanceof TouchCommand) return ((TouchCommand) cmd).doCommand(this);
        if (cmd instanceof ErrorCommand) return ((ErrorCommand) cmd).doCommand();
        return "Unhandled command";
    }
}
