package demo38NET;

// Create multithreading to call method in TCP05FileServer02Thread

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class ThreadRun {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("input server port");
		int port = sc.nextInt();
		ServerSocket server = new ServerSocket(port);

		TCP05FileServer02Thread tcpServer = new TCP05FileServer02Thread(server);
		Thread thread = new Thread(tcpServer);
		thread.start();
		new Thread(tcpServer).start();
	}
}

