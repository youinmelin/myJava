package demo23Set;
public class HashCode01 {
	public static void main(String[] args) {
		System.out.println("1".hashCode());
		System.out.println("1".hashCode());
		System.out.println("A".hashCode());
		System.out.println("a".hashCode());
		String str1 = "a";
		String str2 = "a";
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());

	}
}
