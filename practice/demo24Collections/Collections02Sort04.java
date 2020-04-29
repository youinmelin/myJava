package demo24Collections;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Collections02Sort04 {
	public static void main(String[] args) {
		List<Phone> list = new ArrayList<>();
		list.add(new Phone("iPhone", 5000));
		list.add(new Phone("HuaWei", 4000));
		list.add(new Phone("Mi", 3000));
		list.add(new Phone("redMi", 2000));
		list.add(new Phone("Bodao", 1000));
		Collections.shuffle(list);
		System.out.println(list);

		Collections.sort(list, new Comparator<Phone>() {
			@Override
			public int compare(Phone p1, Phone p2) {
				return p1.getPrice() - p2.getPrice();
			}
		});
		System.out.println(list);
	}
}
