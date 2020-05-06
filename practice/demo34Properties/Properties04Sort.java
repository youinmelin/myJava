package demo34Properties;

import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
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
		LinkedHashMap<String, String> map = collectionSort(prop,sortBy,ascend);
		System.out.println(map);
	}

	static LinkedHashMap<String, String> collectionSort(Properties prop, String sortBy, boolean ascend) {
		Set<String> kSet = prop.stringPropertyNames();
		// Set to List
		ArrayList<String> kList = new ArrayList<>(kSet) ;
		Collections.sort(kList);
		// System.out.println(kList);
		LinkedHashMap<String, String> mapSortByKey = new LinkedHashMap<>();
		for (String key : kList) {
			String value = prop.getProperty(key);
			mapSortByKey.put(key, value);
		}
		// vList = (ArrayList<String>) vList;
		// Collections.sort(vList);
		// System.out.println(kSet);
		// System.out.println(vList.get(1) > vList.get(0));
		return mapSortByKey;
	}
	
}
