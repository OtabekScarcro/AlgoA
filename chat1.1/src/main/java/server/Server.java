package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

    // This map contains <userNickname, socket>
    public static Map<String, Socket> clientHandlers;
    // This map contains <userEmail, userNickname>
    public static Map<String, String> clientList;
    private ServerSocket serverSocket;
    private ExecutorService threadPool;

    public Server() {
        clientHandlers = new HashMap<>();
        clientList = new HashMap<>();
        threadPool = Executors.newFixedThreadPool(10); // Adjust the pool size as per your requirements

        try {
            serverSocket = new ServerSocket(2421);
        } catch (IOException e) {
            shutdown();
        }
    }

    @Override
    public void run() {
        System.out.println("Server is running.....");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client has joined!");

                // Save logs every time with connection ID
                ConnectionHandler connectionHandler = new ConnectionHandler(socket);
                threadPool.execute(connectionHandler);
            } catch (IOException e) {
                shutdown();
            }
        }
    }

    public void shutdown() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            // Ignore
        }
    }

    public Map<String, Socket> getClientHandlers() {
        return clientHandlers;
    }

    public Map<String, String> getClientList() {
        return clientList;
    }

    public static void main(String[] args) {
        Server server = new Server();
        new Thread(server).start();
    }
}
