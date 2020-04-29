package demo25Map;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Map07Poker {
	public static void main(String[] args) {

		// perpare a set of poker, save each cards in a HashMap, and build a index List
		String strColor = "0123";
		String strNum = "23456789TAJQK";
		HashMap<Integer, String> mapPoker = buildPoker(strColor, strNum);
		System.out.println(mapPoker);
		// shuffle the index of the List
		List<Integer> indexList = shufflePoker();
		System.out.println(indexList);
		// distribute cards to 3 players (Lists), each of them have 17 cards,
		// the left 3 cards put into the other List
		ArrayList<String>[] players = distributePoker(mapPoker, indexList);
		// sort the order of the cards in each players
		sortPoker(players);
		// print out the cards of the plays
		System.out.println(players[0]);
		System.out.println(players[1]);
		System.out.println(players[2]);
		System.out.println(players[3]);
		// printPoker();

	}

		static HashMap<Integer, String> buildPoker(String color, String num) {
			HashMap<Integer, String> map= new HashMap<>();
			String strCard = new String();
			int i = 0;
			for ( char charColor : color.toCharArray()) {
				for ( char charNum : num.toCharArray()) {
					strCard = String.valueOf(charColor) + String.valueOf(charNum);
					map.put(i,strCard);
					i++;
				}
			}
			map.put(52, "jj");
			map.put(53, "JJ");
			return map;
		}


		static List<Integer> shufflePoker() {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < 54; i++) {
				list.add(i);	
			}
			Collections.shuffle(list);
			return list;
		}

		static ArrayList<String>[] distributePoker (HashMap<Integer, String> map, List<Integer> list) {
			ArrayList<String>[] players = new ArrayList[4];
			players[0] = new ArrayList<>();
			players[1] = new ArrayList<>();
			players[2] = new ArrayList<>();
			players[3] = new ArrayList<>();
			
			for (int i = 0; i < list.size(); i++) {
				if (i < 51) {
					if (i % 3 == 0) {
						players[0].add(map.get(list.get(i)));
					}else if (i % 3 == 1) {
						players[1].add(map.get(list.get(i)));
					}else if (i % 3 == 2) {
						players[2].add(map.get(list.get(i)));
					}	
				}else {
						players[3].add(map.get(list.get(i)));
				}
			}
			return players;
		}

		static void sortPoker(ArrayList<String>[] players) {
			for ( ArrayList<String> list : players) {
				Collections.sort(list);
			}
		}
}
