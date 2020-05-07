package demo36DecodeEncode;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DecodeEncode {
	public static void main(String[] args) throws IOException {
		String filename = "demo36DecodeEncode/files/utf-8.txt";
		String newFilename = "demo36DecodeEncode/files/gbk.txt";
		String charsetRead = "utf-8";
		String charsetWrite = "gbk";
		char[] c = readFile(filename, charsetRead);
		writeFile(newFilename, c, charsetWrite);
	}

	static char[] readFile (String filename, String charsetRead) throws IOException{
		InputStreamReader reader = new InputStreamReader(new FileInputStream(filename), charsetRead);
		char[] c = new char[1024]; 
		int len = reader.read(c); 
		reader.close();
		// System.out.println(c);
		return c;
	}

	static void writeFile(String filename, char[] c, String charsetWrite) throws IOException {
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream
(filename), charsetWrite);
		writer.write(new String(c));
		writer.close();
	}
}
