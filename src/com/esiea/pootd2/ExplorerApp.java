package com.esiea.pootd2;

import com.esiea.pootd2.controllers.ExplorerController;
import com.esiea.pootd2.interfaces.TextInterface;
/**
 * Main application class for the Explorer.
 */
public class ExplorerApp {
    /**
     * Main method to start the Explorer application.
     * @param args
     */
    public static void main(String[] args) {
        ExplorerController controller = new ExplorerController();
        TextInterface ui = new TextInterface(controller);
        ui.run();
    }
}
