package demo37ObjectStream;

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ObjectInputStream01 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("demo37ObjectStream/files/object.txt"));
		Object one = ois.readObject();
		System.out.println(one);
		Object two = ois.readObject();
		System.out.println(two);
		Object three = ois.readObject();
		System.out.println(three);
		ois.close();
	}
}
