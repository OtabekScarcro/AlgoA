package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AccountManager {
    private BufferedReader in;
    private PrintWriter out;

    public AccountManager(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    public void handleAccount() throws IOException {
        // Ask the user whether they have an account or not
        out.println("1. Sign up");
        out.println("2. Sign in");
        String choose = sanitize(in.readLine());
        while (!choose.equals("1") && !choose.equals("2")) {
            out.println("Please select 1 or 2");
            choose = sanitize(in.readLine());
        }

        // Ask for the user's email address
        out.println("Please enter your email: ");
        String userEmail = sanitize(in.readLine());
        while (!checkEmail(userEmail)) {
            out.println("Please enter a valid email address: ");
            userEmail = sanitize(in.readLine());
        }

        // Sign up or log in with that email
        if (choose.equals("1")) {
            signUp(userEmail);
            out.println("A new account has been created successfully!");
            out.println("/stop");
        } else {
            signIn(userEmail);
            out.println("Logged in successfully!");
            out.println("/stop");
        }
    }

    private void signUp(String email) throws IOException {
        // Rest of the sign up logic
    }

    private void signIn(String email) throws IOException {
        // Rest of the sign in logic
    }

    private boolean checkEmail(String email) {
        // Rest of the email validation logic
        return false;
    }

    private String sanitize(String input) {
        // Rest of the input sanitization logic
        return input;
    }
}
