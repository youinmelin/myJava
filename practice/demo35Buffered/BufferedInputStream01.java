package demo35Buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStream01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("demo35Buffered\\files\\1.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] b = new byte[1024];
        int len = bis.read(b);
        System.out.println(new String(b, 0, len));
        bis.close();
    }
}