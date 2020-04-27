package demo21Collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;


public class Iterator01 {
	
	public static void main(String[] args) {
		Collection<String> coll = new  ArrayList<>();
		Iterator<String> it = coll.iterator();
		coll.add("Nasa");
		coll.add("Youinme");
		coll.add("Nancy");
		coll.add("Golin");
		System.out.println(it.hasNext());
		String str = it.next();
 		while (it.hasNext()) {
 			System.out.println(it.next());
 		}
	}

}
