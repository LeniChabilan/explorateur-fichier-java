/*
 * ICommandParser.java
 * 
 * Version 1.0
 * Date: December 2025
 * 
 * Copyright (c) 2025 ESIEA. All rights reserved.
 * 
 * Interface defining the contract for command parsers.
 * Parsers convert string input into Command objects.
 */

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
