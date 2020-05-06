package demo34Properties;

import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

public class Properties04Sort {
	public static void main(String[] args) throws IOException {
		String filename = "demo34Properties/files/2.txt";
		FileReader fr = new FileReader(filename);
		Properties prop = new Properties();
		prop.load(fr);
		System.out.println(prop);
		String sortBy = "key";
		boolean ascend = true;
		Properties propSort = collectionSort(prop,sortBy,ascend);
	}

	static Properties collectionSort(Properties prop, String sortBy, boolean ascend) {
		Set<Object> kSet = prop.keySet();
		Collection<Object> vSet = prop.values();
		ArrayList<Object> vList = new ArrayList<Object>(vSet);
		// vList = (ArrayList<String>) vList;
		// Collections.sort(vList);
		System.out.println(kSet);
		System.out.println(vList.get(1) > vList.get(0));
		return prop;
	}
	
}
