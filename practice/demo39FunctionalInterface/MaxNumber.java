package demo39FunctionalInterface;

import java.util.function.Supplier;

public class MaxNumber {
	public static int maxNumber(Supplier<Integer> sup) {
		return sup.get();
	}
	
	public static void main(String[] args) {
		int[] arr = {
			100,200,99,-30,47,4747,20
		};
		int ret = maxNumber(() -> {
			int max = arr[0];
			for(int num: arr) {
				max = num > max ? num : max;
			}
			return max;
		});
		System.out.println(ret);
	}
}

