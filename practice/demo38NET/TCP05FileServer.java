package demo38NET;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;

public class TCP05FileServer {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("input server port");
		int port = sc.nextInt();
		ServerSocket server = new ServerSocket(port);
		while (true) {
			System.out.println("Server started. Waiting for clients...");
			Socket client = server.accept();
			System.out.println("one client");
			InputStream is = client.getInputStream();
			OutputStream os = client.getOutputStream();
			// os.write("Please send a filename first: ".getBytes());
			int eachLen = 128;
			byte[] b = new byte[eachLen];
			// the first data received is filename
			int len = is.read(b);
			if (len != -1) {
				String filename = new String(b, 0, len);
				System.out.println(filename);
				String path = "demo38NET/files/";
				if ( filename.startsWith("GET")) {
					System.out.println("client is a browser");
					os.write("HTTP/1.1 200 OK\n".getBytes());
					os.write("<body><h1> Hello!Browser!</h1></body><".getBytes());
				}else{
					System.out.println("client is a terminal");
					FileOutputStream fos = new FileOutputStream(path+filename, true);
					// then send something to tell client to send the content
					os.write("ok".getBytes());
					// then receive the content of the file
					while (true) {
						len = is.read(b);
						fos.write(b, 0, len);
						String bStr = new String(b, 0, len);
						if (len == -1 || "bye".equals(bStr)) {
							break;
						}
					}
					os.write("received sucessfully!BYE".getBytes());
				}

			}
			System.out.println("client off");
			client.close();
		}

		// server.close();
	}
}
