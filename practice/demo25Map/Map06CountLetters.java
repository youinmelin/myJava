package demo25Map;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Map06CountLetters {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a string, I can count how many number of each letter in the string.");
		String str = input.next();
		input.close();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			// System.out.println(str.charAt(i));
			if ( map.get(str.charAt(i)) != null) {
				map.put(str.charAt(i),map.get(str.charAt(i)) + 1);
			}else{
				map.put(str.charAt(i), 1);
			}
		}
		System.out.println(map);
	}
}
