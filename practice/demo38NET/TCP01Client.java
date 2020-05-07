package demo38NET;

import java.net.Socket;
import java.io.OutputStream;
import java.io.IOException;

public class TCP01Client {
	public static void main(String[] args) throws IOException {
		String serverIP = "192.168.0.111";
		int serverPort = 2222;
		Socket socket = new Socket(serverIP,serverPort);
		OutputStream ops = socket.getOutputStream();
		ops.write("hello".getBytes());
		socket.close();
	}
}
