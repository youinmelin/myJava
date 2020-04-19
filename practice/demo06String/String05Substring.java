package demo06String;
/*
 字符串截取方法
*/

public class String05Substring {
    public static void main(String[] args) {
        String str1 = "Hello world!";
        String str2 = str1.substring(3);
        System.out.println(str2);
        String str3 = str1.substring(6,12);
        System.out.println(str3);
    }
}