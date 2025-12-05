package com.esiea.pootd2.commands;

/**
 * Command representing an error message.
 */
public class ErrorCommand extends Command {
    /**
     * The error message to be returned.
     */
    private final String message;
    
    /**
     * Constructor for ErrorCommand.
     * @param message the error message to be returned
     */
    public ErrorCommand(String message) { 
        this.message = message; 
    }

    /**
     * Executes the error command to return the error message.
     * @return the error message
     */
    public String doCommand() {
        return message;
    }
}
