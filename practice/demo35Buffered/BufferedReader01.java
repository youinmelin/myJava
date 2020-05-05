package demo35Buffered;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class BufferedReader01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("demo35Buffered\\files\\2.txt"));
        String line = br.readLine();
        System.out.println(line);
        String line2 = br.readLine();
        System.out.println(line2);
        br.close();
    }
}