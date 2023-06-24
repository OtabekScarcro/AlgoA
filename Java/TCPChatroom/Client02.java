package TCPChatroom;

import java.io.IOException;
import java.net.Socket;

public class Client02 implements Runnable{
    
    Socket client;

    @Override
    public void run() {
        try {
            client = new Socket("127.0.0.1", 9999);
            System.out.println("Successfull");
        } catch (Exception e) {
        } finally{
            try{
                client.close();

            } catch(IOException e){
                
            }
        }
    }

    public static void main(String[] args) {
        Client02 client = new Client02();
        client.run();
    }
}
