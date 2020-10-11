package demo32Stream;

import java.io.FileInputStream;

public class InputStream01 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("demo32Stream\\files\\fos2.txt");
        int b ;
        while ((b = fis.read()) != -1) {
                System.out.print((char)b);
        }
        fis.close();
    }
}