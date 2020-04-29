package demo25Map;
import java.util.Map;
import java.util.HashMap;

public class Map05Object {
	public static void main(String[] args) {
		Person p1 = new Person("name", 10);
		Person p2 = new Person("child", 7);
		Person p3 = new Person("adult", 30);
		Person p4 = new Person("elder", 80);
		Person p5 = new Person("elder", 80);
		Phone ph1 = new Phone("iphone5", 5000);
		Phone ph2 = new Phone("iphone6", 6000);
		Phone ph3 = new Phone("iphone7", 7000);
		Phone ph4 = new Phone("iphoneX", 8000);
		Phone ph5 = new Phone("iphoneX", 8000);

		Map<Person, Phone> map = new HashMap<>();
		map.put(p1, ph1);
		map.put(p2, ph2);
		map.put(p3, ph3);
		map.put(p4, ph4);
		map.put(p5, ph1);
		map.put(p1, ph5);
		map.put(p2, ph3);
		System.out.println(map.size());
		System.out.println(map);

	}
}
