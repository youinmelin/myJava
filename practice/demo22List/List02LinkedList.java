package demo22List;
import java.util.LinkedList;

public class List02LinkedList {
	public static void main(String[] args) {
		LinkedList<String> llish = new LinkedList<>();
		llish.add("a");
		llish.add("b");
		llish.add("c");
		llish.add("d");
		System.out.println(llish.toString());
		System.out.println(llish.getFirst());

	}
}
