package FactorialServerAndClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FactorialClient {
	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			
			System.out.println("Client started");
			socket = new Socket("localhost", 1669);
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter a number: ");
			int number = Integer.parseInt(userInput.readLine());
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(number);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(in.readLine());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null) {
					socket.close();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
}
