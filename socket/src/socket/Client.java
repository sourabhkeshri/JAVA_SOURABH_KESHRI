package socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws InterruptedException, UnknownHostException, IOException {
		
		Socket socket = new Socket("localhost",4000);
		System.out.println("connected with server");
		
	}

}
