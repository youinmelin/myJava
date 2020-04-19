package demo06String;

public class String01 {
    public static void main(String[] args) {
        String str1 = new String();
        System.out.println("str1:"+str1);

        char[] charArray = {'A', 'B', 'C'};
        String str2 = new String(charArray);
        System.out.println("str2:"+str2);

        byte[] byteArray = {97, 98, 99};
        String str3 = new String(byteArray);
        System.out.println("str3:"+str3);

        String str4 = "ABCabc";
        System.out.println("str4:"+str4);

    }
}