/*
 * UnixLikeCommandParser.java
 * 
 * Version 1.0
 * Date: December 2025
 * 
 * Copyright (c) 2025 ESIEA. All rights reserved.
 * 
 * Parser implementation for Unix-like command syntax.
 * Supports commands: ls, cd, mkdir, touch.
 */

package com.esiea.pootd2.commands.parsers;

import com.esiea.pootd2.commands.*;

/**
 * Parser for Unix-like command syntax.
 */
public class UnixLikeCommandParser implements ICommandParser {

    /**
     * Parses a command line string into a Command object.
     * @param commandLine the command line string
     * @return the parsed Command object, or an ErrorCommand if parsing fails
     */
    @Override
    public Command parse(String commandLine) {
        if (commandLine == null || commandLine.trim().isEmpty()) {
            return new ErrorCommand("Empty command");
        }
        String[] parts = splitArguments(commandLine);
        return mapCommand(parts);
    }

    /**
     * Splits the command line into arguments.
     * @param line the command line string
     * @return an array of arguments
     */
    private String[] splitArguments(String line) {
        return line.trim().split("\\s+");
    }

    /**
     * Maps the command name and arguments to a Command object.
     * @param parts the command and its arguments
     * @return the corresponding Command object
     */
    private Command mapCommand(String[] parts) {
        String cmd = parts[0];
        switch (cmd) {
            case "ls":
                return new ListCommand();
            case "cd":
                if (parts.length < 2) return new ErrorCommand("cd: missing operand");
                return new ChangeDirectoryCommand(parts[1]);
            case "mkdir":
                if (parts.length < 2) return new ErrorCommand("mkdir: missing operand");
                return new MakeDirectoryCommand(parts[1]);
            case "touch":
                if (parts.length < 2) return new ErrorCommand("touch: missing operand");
                return new TouchCommand(parts[1]);
            default:
                return new ErrorCommand("Unknown command: " + cmd);
        }
    }
}
