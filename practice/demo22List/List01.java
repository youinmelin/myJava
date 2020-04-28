package demo22List;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class List01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		System.out.println(list.toString());
		list.add(0, "A");
		System.out.println(list.toString());
		list.set(1, "B");
		System.out.println(list.toString());
		list.remove(2);
		System.out.println(list.toString());
		Iterator<String> it = list.iterator();
		if (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
