package demo38NET;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(2222);
        Socket socket = ss.accept();
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        int length = 10;
        byte[] b = new byte[length];
        while (true) {
            int len = is.read(b);
            // System.out.print(len);
            System.out.print(new String(b, 0, len));
            if (len < length) {break;}
        }
        socket.close();
        ss.close();

    }
}