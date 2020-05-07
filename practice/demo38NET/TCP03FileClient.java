package demo38NET;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCP03FileClient {

    public static void main(String[] args) throws IOException {
        String path = "demo38NET/files/";
        String filename = "origin.txt";
        FileInputStream fis = new FileInputStream(path + filename);

        String serverIP = "192.168.0.111";
        int serverPort = 2222;
        Socket socket = new Socket(serverIP, serverPort);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        byte[] b = new byte[1024];
        byte[] fName = filename.getBytes();
        int len = fis.read(b);
        os.write(fName);
        int ret = is.read();
        System.out.println(ret);
        os.write(b);

    }
}