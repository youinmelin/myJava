package demo26Exception;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Exception04TryCatch {
	public static void main(String[] args) {
		String fileName = "a.log";
		try {
			readFile(fileName);
		}catch ( IOException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}finally {
			System.out.println("Resource released.");
		}

	}

	public static void readFile(String fileName) throws IOException{
		if (!fileName.endsWith(".txt")) {
			throw new IOException("File suffix wrong."); 
		}
		System.out.println(fileName);
	}
}
