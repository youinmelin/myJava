package demo41MethodReference;

import java.util.Arrays;

public class MR03BuildArray {
	public static int[] build(int length, ArrayBuilder ab) {
		return ab.buildArray(length);
	}

	public static void main(String[] args) {
		int length = 10;
		// int[] arrayInt = build(length, l -> new int[l]);
		int[] arrayInt = build(length, int[]::new);
		System.out.println(arrayInt);
		System.out.println(Arrays.toString(arrayInt));
	}

}
