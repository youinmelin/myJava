package demo32Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        String filename = "demo32Stream\\files\\1.jpg";
        String newFilename = "demo32Stream\\files\\1New.jpg";
        byte[] b = new byte[1024];
        int i = 0;
        FileInputStream fis = new FileInputStream(filename);
        FileOutputStream fos = new FileOutputStream(newFilename, true);
        while (true) {
            int len = readFile(fis, b);
            //System.out.println(Arrays.toString(b));
            if (len == -1 || i > 1000) {break;}
            writeFile(fos, b, len);
            i++;
        }
    }

    static int readFile(FileInputStream fis, byte[] b) throws IOException {
        int len = fis.read(b);
        System.out.println( len);
        return len;
    }

    static void writeFile(FileOutputStream fos, byte[] b, int len) throws IOException {
        fos.write(b, 0, len);
    }
}