package client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Scanner sc;
    private ExecutorService poll;
    private boolean done;

    public Client() {
        try {
            socket = new Socket("127.0.0.1", 2421);
            poll = Executors.newCachedThreadPool();
            done = false;
        } catch (IOException e) {
            shutdown();
        }
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            sc = new Scanner(System.in);

            // Create an account or log in to an existing account
            AccountManager accountManager = new AccountManager(this);
            accountManager.account();

            // Start input messages from the server
            // If the message is "/command", call the commands function
            // Otherwise, print the message to the console
            Thread thread = new Thread(new InputHandler(socket, this));
            thread.start();

            // Start input messages from the user
            // Call the main menu commands method to get a command from the main window
            MainMenuManager mainMenuManager = new MainMenuManager(this);
            mainMenuManager.handleCommands();

        } catch (IOException e) {
            shutdown();
        }
    }

    // Other methods

    public void shutdown() {
        // ...
    }

    public BufferedReader getInputStream() {
        return in;
    }

    public PrintWriter getOutputStream() {
        return out;
    }

    public Scanner getScanner() {
        return sc;
    }
}
