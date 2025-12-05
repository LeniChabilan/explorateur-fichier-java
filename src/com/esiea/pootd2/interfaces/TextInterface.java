/*
 * TextInterface.java
 * 
 * Version 1.0
 * Date: December 2025
 * 
 * Copyright (c) 2025 ESIEA. All rights reserved.
 * 
 * Text-based command-line user interface implementation.
 * Reads commands from standard input and displays results.
 */

package com.esiea.pootd2.interfaces;

import com.esiea.pootd2.controllers.IExplorerController;
import java.util.Scanner;

/**
 * Text-based user interface for the file explorer.
 */
public class TextInterface implements IUserInterface {
    /**
     * Reference to the explorer controller to handle commands.
     */
    private final IExplorerController controller;

    /**
     * Constructs a TextInterface with the specified controller.
     * @param controller the explorer controller to handle commands
     */
    public TextInterface(IExplorerController controller) {
        this.controller = controller;
    }

    /**
     * Runs the text-based user interface, reading commands from standard input.
     */
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            if ("exit".equalsIgnoreCase(line)) {
                System.out.println("Bye!");
                break;
            }
            String out = controller.executeCommand(line);
            if (out != null && !out.isEmpty()) {
                System.out.println(out);
            }
        }
        scanner.close();
    }
}
