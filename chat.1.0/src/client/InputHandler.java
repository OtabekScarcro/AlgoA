package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class InputHandler implements Runnable {
    private Socket socket;
    private Client client;

    public InputHandler(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = client.getInputStream();
            while (socket.isConnected()) {
                String msgFromServer = in.readLine();

                // If it is "/command", call the commands
                if (msgFromServer.equals("/command")) {
                    CommandManager commandManager = new CommandManager(client);
                    commandManager.handleCommands();
                }
                // Otherwise, print to console
                else {
                    System.out.println(msgFromServer);
                }
            }
        } catch (IOException e) {
            client.shutdown();
        }
    }
}

