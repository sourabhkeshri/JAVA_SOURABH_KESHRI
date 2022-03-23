package socketProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket socket = new ServerSocket(4000);
		System.out.println("waiting for client to connect");
		Socket clientSocket = socket.accept();
		System.out.println("Client connected");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
		
		String msg;
		Scanner sc = new Scanner(System.in);
		do {
			msg = in.readLine();
			System.out.println("Client sent:"+msg);
			String response = sc.nextLine();
			out.println("server sent:"+response);
			
			
		}while(!"exit".equalsIgnoreCase(msg));

	}

}
