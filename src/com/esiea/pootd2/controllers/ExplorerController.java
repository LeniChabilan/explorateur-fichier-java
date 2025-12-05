package com.esiea.pootd2.controllers;

import com.esiea.pootd2.commands.*;
import com.esiea.pootd2.commands.parsers.UnixLikeCommandParser;
import com.esiea.pootd2.models.*;

/**
 * Implementation of the explorer controller.
 */
public class ExplorerController implements IExplorerController {
    /**
     * Root folder of the file system.
     */
    private final FolderInode root;
    /**
     * Current working directory.
     */
    private FolderInode current;
    /**
     * Parser for Unix-like command syntax.
     */
    private final UnixLikeCommandParser parser = new UnixLikeCommandParser();

    /**
     * Constructs an ExplorerController with an initial root folder.
     */
    public ExplorerController() {
        this.root = new FolderInode("/");
        this.root.setParent(null);
        this.current = root;
    }

    /**
     * Gets the current working directory.
     * @return the current working directory
     */
    public FolderInode getCurrent() {
        return current;
    }

    /**
     * Sets the current working directory.
     * @param folder the new current working directory
     */
    public void setCurrent(FolderInode folder) {
        this.current = folder;
    }

    /**
     * Executes a command given as a string.
     * @param commandStr the command string to execute
     * @return the result of the command execution
     */
    @Override
    public String executeCommand(String commandStr) {
        Command command = parser.parse(commandStr);
        return doCommand(command);
    }

    /**
     * Executes the given Command object.
     * @param cmd the Command to execute
     * @return the result of the command execution
     */
    private String doCommand(Command cmd) {
        if (cmd instanceof ListCommand) return ((ListCommand) cmd).doCommand(this);
        if (cmd instanceof ChangeDirectoryCommand) return ((ChangeDirectoryCommand) cmd).doCommand(this);
        if (cmd instanceof MakeDirectoryCommand) return ((MakeDirectoryCommand) cmd).doCommand(this);
        if (cmd instanceof TouchCommand) return ((TouchCommand) cmd).doCommand(this);
        if (cmd instanceof ErrorCommand) return ((ErrorCommand) cmd).doCommand();
        return "Unhandled command";
    }
}
