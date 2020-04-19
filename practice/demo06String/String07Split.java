package demo06String;

public class String07Split {
    public static void main(String[] args) {
        String str = new String();
        str = "Hello the world!";
        String[] strArray = str.split(" ");
        System.out.println(strArray);
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }
        str = "Hello.the.world!";
        String[] strArray1 = str.split("\\.");
        System.out.println(strArray1);
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray1[i]);
        }
    }
}