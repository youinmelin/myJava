package demo26Exception;

public class Exception01Throw {
	public static void main(String[] args) {
		// int[] arr = null;
		int[] arr = new int[]{ 1,2,3,4,5 };
		int ret = getElement(arr, 5);
		System.out.println(ret);
	}

	public static int getElement(int[] arr, int index) {
		if (arr  == null) {
			throw new NullPointerException(" The argument arr is null.");
		}
		if (index < 0 || index >= arr.length) {
			throw new ArrayIndexOutOfBoundsException("The index exceed the range of array.");
		}
		int ele = arr[index];
		return ele;
	}

}
