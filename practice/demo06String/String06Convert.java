package demo06String;

/* 
String  与转换相关的常用方法
*/

public class String06Convert {
    public static void main(String[] args) {
        String str = "This is the Java.";
        char[] charArray = str.toCharArray();
        byte[] byteArray = str.getBytes();
        System.out.println(charArray);
        System.out.println(byteArray);

        String str3 = str.replace("Java", "Python");
        System.out.println(str3);
    }
}