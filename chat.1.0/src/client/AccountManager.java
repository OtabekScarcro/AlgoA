package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AccountManager {
    private Client client;
    private BufferedReader in;
    private PrintWriter out;

    public AccountManager(Client client) {
        this.client = client;
        this.in = client.getInputStream();
        this.out = client.getOutputStream();
    }

    public void account() {
        // ...
    }

    // Other methods
}

