package demo33ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Writer01 {
    public static void main(String[] args) throws IOException {
        String content = "Hello \n World!";
        FileWriter fw = new FileWriter("demo33ReaderWriter\\files\\write.txt", true);
        fw.write(content);
        fw.flush();
        fw.close();
    }
}