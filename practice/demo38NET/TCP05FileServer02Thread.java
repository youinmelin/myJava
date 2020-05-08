package demo38NET;
// implements Runtable to be a TCP server. 
// to implement two feature : 
// 1, tcp client can upload file,the first message will be the filename;
// 2, if require information is http require, then it will be a http serves;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;

public class TCP05FileServer02Thread implements Runnable {
		
	private ServerSocket server;

	    public TCP05FileServer02Thread(ServerSocket server) {
			this.server = server;
	}

		@Override
		public void run() {
			try {
				
				while (true) {
					System.out.println("Server started. Waiting for clients...");
					Socket client = server.accept();
					System.out.println("one client");
					System.out.println(Thread.currentThread());
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
							os.write("HTTP/1.1 200 OK\r\n".getBytes());
							os.write("Content-Type:text/html\r\n".getBytes());
							os.write("\r\n".getBytes());
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
			catch(IOException e) {
				System.out.println(e);
			}

		}
}
