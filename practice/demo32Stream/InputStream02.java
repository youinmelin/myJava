package demo32Stream;
import java.io.FileInputStream;
import java.io.IOException;

public class InputStream02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("demo32Stream\\files\\fos2.txt");
        int num = 5;
        byte[] bytes = new byte[num];
        int len ;
        while ((len = fis.read(bytes)) != -1) {
            System.out.print(new String(bytes, 0 , len));
        }
        fis.close();
    }
}