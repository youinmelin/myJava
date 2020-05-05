package demo35Buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream01 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("demo35Buffered\\files\\1.txt",true);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] b = "NBA\n".getBytes();
        bos.write(b);
        bos.close();
    }
}