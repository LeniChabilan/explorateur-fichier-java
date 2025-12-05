/*
 * IExplorerController.java
 * 
 * Version 1.0
 * Date: December 2025
 * 
 * Copyright (c) 2025 ESIEA. All rights reserved.
 * 
 * Interface defining the contract for explorer controllers.
 * Provides command execution functionality.
 */

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
