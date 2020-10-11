package demo32Stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream02 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("demo32Stream\\files\\fos2.txt");
        String str = "Java!";
        byte[] ary = str.getBytes();
        fos.write(ary);
        fos.write("\n Python \n".getBytes());
        fos.write(ary,1,2);
        fos.close();
    }
}