package demo39FunctionalInterface;

import java.util.Comparator;
import java.util.Arrays;

 // sort the String in an array, by the length of the string

public class Comparator01 {
	public static void main(String[] args) {
		String[] words = {
			"Java", "Python", "Node.js", "PHP", "JavaScript", "C"
		};
		Arrays.sort(words, compareLength());
		System.out.println("sort by length");
		System.out.println(Arrays.toString(words));
		Arrays.sort(words);
		System.out.println("sort by Hash code");
		System.out.println(Arrays.toString(words));
	}

	static Comparator<String> compareLength() {
		return (a, b) -> a.length() - b.length(); 
	}
}
