package server;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConnectionHandler implements Runnable {

    private Map<Socket, String> accounts;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String userEmail;
    private String nickname;

    public ConnectionHandler(Socket socket) {
        this.socket = socket;
        accounts = new HashMap<>();
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // call accountStep() method to take care of user's account
            accountStep();

            // infinite loop to get messages from client
            while (true) {
                String msgFromClient = in.readLine();
                if (msgFromClient.equals("/command")) {
                    commands();
                }
            }
        } catch (IOException e) {
            shutdown();
        } catch (NullPointerException e1) {
            // ignore
        }
    }

    /**
     * Account creation or login stage
     */
    public void accountStep() {
        try {
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

        } catch (IOException e) {
            shutdown();
        }
    }

    /**
     * Create an account
     */
    public void signUp(String email) {
        try {
            // Check if this email already exists
            while (Server.clientList.containsKey(email)) {
                out.println("This email is already registered on the server");
                out.println("Please try another one");
                email = sanitize(in.readLine());
            }

            // Confirm email by sending a 6-digit code
            confirmationEmail(email);

            // Ask for a nickname from the user
            out.println("Please enter a nickname: ");
            nickname = in.readLine();
            while (checkNickname(nickname)) {
                out.println("This nickname is already taken");
                out.println("Please choose another one: ");
                nickname = in.readLine();
            }

            Server.clientHandlers.put(this.nickname, this.socket);

            // Save this email and nickname on the server
            Server.clientList.put(email, nickname);

            // Save a connection with this user and their nickname
            accounts.put(this.socket, nickname);
        } catch (IOException e) {
            shutdown();
        }

    }

    /**
     * Sign in to an existing account
     */
    public void signIn(String email) {
        try {
            // Check if the email is available or not
            while (!Server.clientList.containsKey(email)) {
                out.println("This email is not registered on the server");
                out.println("Please try another email");
                email = sanitize(in.readLine());
            }

            // Confirm the email by sending a 6-digit code
            confirmationEmail(email);
        } catch (IOException e) {
            shutdown();
        }
    }

    /**
     * Send a 6-digit code for email confirmation
     *
     * @param email
     */
    public void confirmationEmail(String email) {
        // Create a random confirmation code
        String randomCode = createConfirmationCode();

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.transport.protocol", "smtp");

        // Code will be sent from this email
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("otaboyev149@gmail.com", "zoebjqhtjtstfjcb");
            }
        });

        try {
            // Prepare the message to send
            Message message = new MimeMessage(session);
            message.setSubject("Confirmation from Messenger application");
            message.setText("Confirmation code: " + randomCode);

            // Add the email address
            Address addressTo = new InternetAddress(email);
            message.setRecipient(Message.RecipientType.TO, addressTo);

            // Send the email
            Transport.send(message);

            // Ask for the confirmation code from the user
            out.println("Please enter a confirmation code: ");
            String enteredCode = in.readLine();

            // Check if the code is valid
            while (!enteredCode.equals(randomCode)) {
                out.println("Confirmation code is not valid!");
                out.println("Please try again: ");
                enteredCode = in.readLine();
            }
            out.println("Email confirmation is successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a 6-digit confirmation code
     *
     * @return
     */
    public String createConfirmationCode() {
        String code = "";
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            code = code + rand.nextInt(10);
        }
        return code;
    }

    /**
     * Check whether an email is valid or not
     *
     * @param email
     * @return
     */
    public boolean checkEmail(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.find();
    }

    /**
     * Check whether a nickname is unique or not
     *
     * @param nickname
     * @return
     */
    public boolean checkNickname(String nickname) {
        return Server.clientList.containsValue(nickname);
    }

    /**
     * Stop the program and close the connection
     */
    public void shutdown() {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
            in.close();
            out.close();
        } catch (IOException e) {
            // ignore
        }
    }

    /**
     * Process user commands
     */
    public void commands() {
        try {
            String command = in.readLine();
            if (command.equals("/searchFriend")) {
                String nickname = in.readLine();
                searchFromServer(nickname);
            } else if (command.equals("/startChat")) {
                Socket friend = Server.clientHandlers.get(in.readLine());

                // Current client to friend
                Thread thread = new Thread();
                thread.start();

                // Friend to current client
                startChat(friend);
            }
        } catch (IOException e) {
            shutdown();
        }
    }

    /**
     * Search for a nickname from the server
     *
     * @param nickname
     */
    public void searchFromServer(String nickname) {

        // Create an ArrayList to save all the matches
        // with the nickname which the user entered
        ArrayList<String> resultsList = new ArrayList<>();

        // Iterate over the Map which contains all the users on the server
        // and print the matches
        for (String nick : Server.clientHandlers.keySet()) {
            if (nick.contains(nickname)) {
                resultsList.add(nick);
            }
        }

        for (int i = 0; i < resultsList.size(); i++) {
            int index = i + 1;
            out.println((index) + ". " + resultsList.get(i));
        }

        // Ask the user to select an option
        out.println("Select the corresponding number (0 for none)");
        try {
            String choose = in.readLine();
            int ch = Integer.parseInt(choose);
            while (ch < 0 || ch > resultsList.size()) {
                out.println("Please select the correct number!");
                choose = in.readLine();
                ch = Integer.parseInt(choose);
            }

            if (ch == 0) {
                out.println("/command");
                out.println("/backToMenu");
            } else {

                out.println("Do you want to chat with " + resultsList.get(ch - 1));
                out.println("1. Yes\n2. No");
                String op = in.readLine();
                int option = Integer.parseInt(op);
                while (option != 1 && option != 2) {
                    out.println("Please select 1 or 2");
                    op = in.readLine();
                    option = Integer.parseInt(op);
                }

                // Notify to stop looping in searching
                out.println("/command");
                out.println("/stopLooping");

                // Add the selected friend to the user's friends list
                if (option == 1) {
                    out.println("/command");
                    out.println("/addFriend");
                    out.println(resultsList.get(ch - 1));

                    // Send a notification to this friend
                    PrintWriter outToFriend = new PrintWriter(Server.clientHandlers.get(resultsList.get(ch - 1)).getOutputStream(), true);
                    outToFriend.println("/command");
                    outToFriend.println("/addedYou");
                    // My nickname
                    outToFriend.println(this.nickname);

                }
                // Or cancel
                else {
                    out.println("/command");
                    out.println("/backToMenu");
                }
            }
        } catch (IOException e) {
            shutdown();
        }
    }

    public void checkOption(String num, int i) {
        String s = "";
        for (int i1 = 0; i1 <= i; i1++) {
            s += i1;
        }
        while (!s.contains(num)) {
            out.println("Please select the correct number!");
        }
    }

    /**
     * Get a message from a friend
     *
     * @param friend
     */
    public void startChat(Socket friend) {
        try {
            BufferedReader inFriend = new BufferedReader(new InputStreamReader(friend.getInputStream()));
            String friendNickname = accounts.get(friend);
            String msgToClient = inFriend.readLine();
            while (!sanitize(msgToClient).equals("/quit")) {
                out.println(friendNickname + ": " + msgToClient);
                msgToClient = inFriend.readLine();
            }
            out.println("The chat has ended");
            out.println("/command");
            out.println("/backToMenu");
        } catch (IOException e) {
            shutdown();
        }
    }

    /**
     * Sanitize user input to avoid injection attacks
     *
     * @param input
     * @return
     */
    public String sanitize(String input) {
        return input.replaceAll("[^A-Za-z0-9]", "");
    }
}
