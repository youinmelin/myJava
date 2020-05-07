package demo38NET;

import java.net.Socket;
import java.io.OutputStream;
import java.io.IOException;

public class TCPClient {
	public static void main(String[] args) throws IOException {
		String serverIP = "192.168.0.104";
		int serverPort = 6000;
		Socket socket = new Socket(serverIP,serverPort);
		OutputStream ops = socket.getOutputStream();
		ops.write(97);

		socket.close();
	}
}
