package demo39FunctionalInterface;

import java.util.Arrays;
import java.util.Comparator;

public class Comparator02 {
    public static void main(String[] args) {
        Phone[] phones = {
            new Phone("iphone X", 6000), new Phone("ipad", 3000), new Phone("iphone 7", 4000), new Phone("redMi", 2000)
            , new Phone("iphone max", 8000)
        };
        Arrays.sort(phones, sortPrice());
        System.out.println(Arrays.toString(phones));

        Arrays.sort(phones, new Comparator<Phone>() {
			@Override
			public int compare(Phone o1, Phone o2) {
				return o2.getPrice() -  o1.getPrice();
			}
        });
        System.out.println(Arrays.toString(phones));
    }

    public static Comparator<Phone> sortPrice() {
        return (one, two) -> one.getPrice() - two.getPrice();
    }
        
}