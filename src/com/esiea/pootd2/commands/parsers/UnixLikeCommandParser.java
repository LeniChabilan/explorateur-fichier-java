package com.esiea.pootd2.commands.parsers;

import com.esiea.pootd2.commands.*;

public class UnixLikeCommandParser implements ICommandParser {

    @Override
    public Command parse(String commandLine) {
        if (commandLine == null || commandLine.trim().isEmpty()) {
            return new ErrorCommand("Empty command");
        }
        String[] parts = splitArguments(commandLine);
        return mapCommand(parts);
    }

    private String[] splitArguments(String line) {
        // implémentation simple : split sur les espaces (ne gère pas les quotes)
        return line.trim().split("\\s+");
    }

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
