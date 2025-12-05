package com.esiea.pootd2.interfaces;

import com.esiea.pootd2.controllers.IExplorerController;
import java.util.Scanner;

public class TextInterface implements IUserInterface {
    private final IExplorerController controller;

    public TextInterface(IExplorerController controller) {
        this.controller = controller;
    }

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
