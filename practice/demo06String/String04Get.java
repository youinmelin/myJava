package demo06String;

public class String04Get {
    public static void main(String[] args) {
        String str = "abdc123214";
        System.out.println(str.length());

        String str1 = "hello ";
        String str2 = "world";
        String str3 = str1.concat(str2);
        System.out.println(str3);

        System.out.println(str1.charAt(1));
        System.out.println(str3.indexOf("or"));
    }
}