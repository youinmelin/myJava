package demo39FunctionalInterface;

import java.util.function.Consumer;

public class Consumer01 {
	public static void useString(String str, Consumer<String> con) {
		con.accept(str);
	}

	public static void main(String[] args) {
		String name = "Nasa";
		useString(name, (one) -> System.out.println(one));

		useString(name, (one) ->{
			String reverseOne = new StringBuilder(one).reverse().toString();
			System.out.println(reverseOne);
		} );
		
	}
}
