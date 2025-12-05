/*
 * AbstractInterface.java
 * 
 * Version 1.0
 * Date: December 2025
 * 
 * Copyright (c) 2025 ESIEA. All rights reserved.
 * 
 * Abstract base class for user interfaces in the file explorer.
 * Holds reference to the controller for command execution.
 */

package com.esiea.pootd2.interfaces;
import com.esiea.pootd2.controllers.IExplorerController;

/**
 * Abstract base class for user interfaces in the file explorer.
 */
public class AbstractInterface {
    /**
     * Reference to the explorer controller to handle commands.
     */
    protected IExplorerController controller;

    /**
     * Constructs an AbstractInterface with the specified controller.
     * @param controller the explorer controller to handle commands
     */
    public AbstractInterface(IExplorerController controller) {
        this.controller = controller;
    }
}
