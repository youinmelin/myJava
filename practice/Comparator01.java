package demo39FunctionalInterface;

import java.util.Comparator;

 // sort the String in an array, by the length of the string

public class Comparator01 {
	public static void main(String[] args) {
		String[] words = {
			"Java", "Python", "Node.js", "PHP", "JavaScript", "C"
		}
		words.sort(words, compareLength());
		System.out.println(words);
	}

	static Comparator<String> compareLength() {
		return (a, b) -> a.length() - b.length(); 
	}
}
