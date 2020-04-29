package demo25Map;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Map07Poker {
	public static void main(String[] args) {

		// perpare a set of poker, save each cards in a HashMap, and build a index List
		String strColor = "0123";
		String strNum = "23456789TAJQK";
		HashMap<Integer, String> listPoker = buildPoker(strColor, strNum);
		System.out.println(listPoker);
		// shuffle the index of the List 
//		shufflePoker();
		// distribute cards to 3 players (Lists), each of them have 17 cards,
		// the left 3 cards put into the other List
	//	distributePoker();
		// sort the order of the cards in each players
		//sortPoker();
		// print out the cards of the plays
		//printPoker();
		
	}

	public HashMap<Integer, String> buildPoker (String color, String num) {
		HashMap<Integer, String> map= new HashMap<>();
		for ( int i = 0; i < 52; i++) {
			for ( char charColor : color.toCharArray()) {
				for ( char charNum : num.toCharArray()) {
					String strCard = charColor + charNum;
				}
			}
			map.put(i,strCard);
		}
		map.put(52, "jj");
		map.put(53, "JJ");
		return map;
	}

}

