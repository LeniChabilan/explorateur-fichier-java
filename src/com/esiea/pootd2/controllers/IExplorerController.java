package com.esiea.pootd2.controllers;

/**
 * Interface for the explorer controller.
 */
public interface IExplorerController {
    /**
     * Executes a command given as a string.
     * @param commandStr the command string to execute
     * @return the result of the command execution
     */
    String executeCommand(String commandStr);
}
