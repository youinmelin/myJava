package demo19System;
import java.util.Arrays;
public class SystemPractice {
	public static void main(String[] args) {
		int[] array1 = {
			1,1,1,1,1,1
		};
		int[] array2 ={
			0,0,0,0,0,0
		};
		System.arraycopy(array1, 0, array2, 3, 3);
		for (int i = 0; i < array2.length; i++) {
			System.out.println(array2[i]);
		}
		System.out.println(Arrays.toString(array2));
	}

}
