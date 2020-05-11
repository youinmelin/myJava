package demo41MethodReference; 
import java.util.function.Consumer;

public class MR01 {
	public static void main(String[] args) {
		String name = "Nasa";

		// use Lambda
		printName(name, str -> System.out.println(str));

		// use method reference
		printName(name, System.out::println);

		// use method reference , by object name referencing method
		UpperCaseClass upper = new UpperCaseClass();
		printUpperCaseName(name, upper::upperCasePrint);

	}
	static void printName(String str, Consumer<String> con) {
		con.accept(str);
	}
	static void printUpperCaseName (String str, Consumer<String> con) {
		con.accept(str);
	}
}
