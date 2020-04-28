package demo23Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashCode02Add {
	public static void main(String[] args) {
		Person adult = new Person();
		System.out.println(adult);
		Person adult2 = new Person("Golin", 40);
		System.out.println(adult2);
		MyHashSet<Person> personSet = new MyHashSet<>();
		personSet.add(adult);
		personSet.add(adult2);
		System.out.println(personSet);
	}
}
