package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainMenuManager {
    private Client client;
    private BufferedReader in;
    private PrintWriter out;
    private Scanner scanner;

    public MainMenuManager(Client client) {
        this.client = client;
        this.in = client.getInputStream();
        this.out = client.getOutputStream();
        this.scanner = client.getScanner();
    }

    public void handleCommands() {
        // ...
    }

    // Other methods
}
