package demo06String;

public class String02Pool {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        char[] charArray = {'a','b','c'};
        String str3 = new String(charArray);

        byte[] byteArray = {97,98,99};
        String str4 = new String(byteArray);

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);
        System.out.println(str2 == str4);
    }
}