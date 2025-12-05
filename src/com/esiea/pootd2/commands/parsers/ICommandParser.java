package com.esiea.pootd2.commands.parsers;

import com.esiea.pootd2.commands.Command;

/**
 * Interface for command parsers.
 */
public interface ICommandParser {
    /**
     * Parses a command line string into a Command object.
     * @param commandLine the command line string
     * @return the parsed Command object
     */
    Command parse(String commandLine);
}
