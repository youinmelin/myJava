package demo35Buffered;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.util.HashMap;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Map;

public class BufferedSortLine {
	public static void main(String[] args) throws IOException {
		String filename = "demo35Buffered/files/content.txt";
		HashMap<String, String> fileMap = readFile(filename);
		System.out.println(fileMap);
		String newFilename ="demo35Buffered/files/contentNew.txt";
		writeFile(fileMap, newFilename);
		File newFile = new File(newFilename);
		System.out.println(newFile);
	}
	
	static HashMap<String, String> readFile(String filename) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(filename));
		HashMap<String, String> fileMap = new HashMap<>();
		String line = "";
		while (true){
			line = br.readLine();
			if (line == null){
				break; }
			fileMap.put(line.substring(0,1), line);			
		}
		br.close();
		return fileMap;
	}

	static void writeFile (HashMap<String, String> fileMap, String newFilename) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(newFilename));	
		for( Map.Entry<String, String> key: fileMap.entrySet()) {
			String value = key.getValue();
			System.out.println(value);
			bw.write(value);
			bw.newLine();
		}
		bw.close();
	}
}
