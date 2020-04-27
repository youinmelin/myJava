package demo20StringBuilder;

public class Sb02Append {
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder();
		str.append("Begin ");
		str.append(100);
		str.append('z');
		// str.append([" Python ", " JavaScript ", " Java ", " php "]); wrong
		System.out.println(str);
	}
}
