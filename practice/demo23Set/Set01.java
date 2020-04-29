package demo23Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set01 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		for ( Integer i : set) {
			System.out.println(i);
		}
		System.out.println(it.hashCode());
	}
}
