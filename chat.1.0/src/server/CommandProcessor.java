package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CommandProcessor {
    private BufferedReader in;
    private PrintWriter out;

    public CommandProcessor(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    public void processCommand() throws IOException {
        String command = in.readLine();
        if (command.equals("/searchFriend")) {
            String nickname = in.readLine();
            searchFromServer(nickname);
        } else if (command.equals("/startChat")) {
            // Rest of the start chat logic
        }
    }

    private void searchFromServer(String nickname) throws IOException {
        // Rest of the search from server logic
    }
}
