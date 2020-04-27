package demo21Collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;


public class Iterator02For {
	
	public static void main(String[] args) {
		Collection<String> coll = new  ArrayList<>();
		Iterator<String> it = coll.iterator();
		coll.add("Nasa");
		coll.add("Youinme");
		coll.add("Nancy");
		coll.add("Golin");
		for(String str: coll) {
			System.out.println(str);
		}
	}

}
