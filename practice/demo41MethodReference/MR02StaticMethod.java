package demo41MethodReference;

import java.util.function.Supplier;

public class MR02StaticMethod {
	static int absInt ( int num, Supplier<Integer> sup) {
		return sup.get();
	}

	public static void main(String[] args) {
		int num = -10;
		int num2 = absInt(num, () -> Math.abs(num));
		System.out.println(num2);

		//int num3 = absInt(num, Math::abs);
		//System.out.println(num3);
		// absInt(num, System.out::println);
	}
}

