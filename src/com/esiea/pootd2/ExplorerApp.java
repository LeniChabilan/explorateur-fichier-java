package com.esiea.pootd2;

import com.esiea.pootd2.controllers.ExplorerController;
import com.esiea.pootd2.interfaces.TextInterface;
import com.esiea.pootd2.interfaces.HttpInterface;


/**
 * Main application class for the Explorer.
 */
public class ExplorerApp {
    /**
     * Main method to start the Explorer application.
     * @param args command line arguments
     *             - Use "http" to start with HTTP interface
     *             - Use "text" to start with text interface
     */
    public static void main(String[] args) {
        // Check if an argument is provided
        if (args.length == 0) {
            System.err.println("Error: You must specify an interface type.");
            System.exit(1);
        }
        
        ExplorerController controller = new ExplorerController();
        String interfaceType = args[0].toLowerCase();
        
        switch (interfaceType) {
            case "http":
                HttpInterface httpUi = new HttpInterface(controller);
                httpUi.run();
                break;
                
            case "text":
                TextInterface textUi = new TextInterface(controller);
                textUi.run();
                break;
                
            default:
                System.err.println("Error: Invalid interface type '" + args[0] + "'");
                System.exit(1);
        }
    }
}