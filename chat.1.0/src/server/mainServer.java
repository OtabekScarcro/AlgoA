package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class mainServer implements Runnable{

    private ServerSocket serverSocket;
    private Socket socket;
    private ExecutorService poll;


    public mainServer(){
        try {
            serverSocket = new ServerSocket(2421);
            poll = Executors.newCachedThreadPool();
        } catch (IOException e){
            shutdown();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                socket = serverSocket.accept();

                AccountStep newAccount = new AccountStep(socket);
                newAccount.run();

                System.out.println("New client has joined!");
                // save Logs everytime with connection ID
                ConnectionHandler connectionHandler = new ConnectionHandler(socket);
                poll.execute(connectionHandler);
            } catch (Exception e) {
                shutdown();
            }
        }
    }




    /**
     * stop everything
     */
    public void shutdown(){
        try {
            if (!serverSocket.isClosed()) {
                serverSocket.close();
            }
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e){
            // ignore
        }
    }


    public static void main(String[] args) {
        mainServer server = new mainServer();
        System.out.println("Server is running.....");
        server.run();

    }


}
