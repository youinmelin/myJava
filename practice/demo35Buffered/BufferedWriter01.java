package demo35Buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter01 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("demo35Buffered\\files\\2.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Use BufferWriter to write data.");
        bw.newLine();
        bw.close();
    }
}