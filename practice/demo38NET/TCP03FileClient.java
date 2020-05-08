package demo38NET;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCP03FileClient {

    public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
        String path = "demo38NET/files/";
        String filename = "origin.txt";
        FileInputStream fis = new FileInputStream(path + filename);
		System.out.println("please input server IP: ");
        String serverIP = sc.next();
		System.out.println("please input server port: ");
        int serverPort = sc.nextInt();
        Socket socket = new Socket(serverIP, serverPort);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        byte[] fName = filename.getBytes();
		// first, send filename
        os.write(fName);
		// then, server reply a message
        int ret = is.read();
        System.out.println(ret);
		// finally, send the content of the file to server
        byte[] b = new byte[1024];
        int receiveLen = fis.read(b);
        os.write(b);
		// socket.shutdownOutput();

    }
}
