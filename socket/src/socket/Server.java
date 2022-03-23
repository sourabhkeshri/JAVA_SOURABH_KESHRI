package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket socket = new ServerSocket(4000);
		System.out.println("waiting for client to connect");
		Socket clientSocket = socket.accept();
		System.out.println("Client connected");

	}

}
