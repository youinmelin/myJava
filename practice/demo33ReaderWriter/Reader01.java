package demo33ReaderWriter;

import java.io.FileReader;
import java.io.IOException;

public class Reader01 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("demo33ReaderWriter\\files\\1.txt");
        char[] chars = new char[50];
        int len = fr.read(chars);
        System.out.println(chars);
        fr.close();
    }
}