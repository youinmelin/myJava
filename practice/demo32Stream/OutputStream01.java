package demo32Stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream01 {
    public static void main(String[] args) throws IOException{
        FileOutputStream fos = new FileOutputStream("demo32Stream\\files\\fos.txt");
        fos.write(97);
        fos.close();
    }
}