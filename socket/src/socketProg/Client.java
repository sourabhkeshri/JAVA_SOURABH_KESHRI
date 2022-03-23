package socketProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws InterruptedException, UnknownHostException, IOException {
		
		Socket socket = new Socket("localhost",4000);
		System.out.println("connected with server");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		
		String msg;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter msg to send server:");
			msg = sc.nextLine();
			out.println(msg);
			String response = in.readLine();
			System.out.println(response);
			
		}while(!"exit".equalsIgnoreCase(msg));
		
	}

}
