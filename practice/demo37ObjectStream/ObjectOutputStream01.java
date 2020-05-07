package demo37ObjectStream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class ObjectOutputStream01{
	public static void main(String[] args) throws IOException  {
		Phone one = new Phone("iphone8", 5000);
		Phone two = new Phone("iphonex", 6000);
		Phone three = new Phone("iphone7", 4000);
		Phone four = new Phone("redmi", 2000);
		Phone five = new Phone("huawei", 3000);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("demo37ObjectStream/files/object.txt"));
		oos.writeObject(one);
		oos.writeObject(two);

		oos.close();

	}
}
