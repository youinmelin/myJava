package demo23Set;
import java.util.HashSet;

public class HashCode02Add {
	public static void main(String[] args) {
		Person adult = new Person();
		System.out.println(adult);
		Person adult2 = new Person("Golin", 40);
		System.out.println(adult2);
		HashSet<Person> personSet = new HashSet<>();
		personSet.add(adult);
		personSet.add(adult2);
		personSet.add(new Person("Golin",23));
		System.out.println(personSet);
	}
}
