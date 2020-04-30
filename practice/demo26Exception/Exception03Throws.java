package demo26Exception;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Exception03Throws{
	public static void main(String[] args) throws FileNotFoundException,IOException{
		String fileName = "c:\\\\a.txt";
		readFile(fileName);
		fileName = "a.log";
		readFile(fileName);
	}

	public static void readFile(String fileName) throws FileNotFoundException, IOException{
		if (!fileName.startsWith("c:")) {
			throw new FileNotFoundException("File path wrong."); 
		}
		if (!fileName.endsWith(".txt")) {
			throw new IOException("File suffix wrong."); 
		}
		System.out.println(fileName);
	}
}
