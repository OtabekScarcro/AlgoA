package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ConnectionHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Call accountStep() method to take care of user's account
            AccountManager accountManager = new AccountManager(in, out);
            accountManager.handleAccount();

            // Infinite loop to get messages from the client
            while (true) {
                String msgFromClient = in.readLine();
                if (msgFromClient.equals("/command")) {
                    CommandProcessor commandProcessor = new CommandProcessor(in, out);
                    commandProcessor.processCommand();
                }
            }
        } catch (IOException e) {
            shutdown();
        } catch (NullPointerException e1) {
            // Ignore
        }
    }

    private void shutdown() {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
            in.close();
            out.close();
        } catch (IOException e) {
            // Ignore
        }
    }
}
