package Integer;

public class IntegerDemo {
    public static void main(String[] args) {
        Integer a = 2; // 自动装箱
        a += 10; // 自动拆箱,需要判断a != null
        int b = a;
        System.out.println(a);
        System.out.println(b);
        // 静态方法获取对象,代替已过时的构造函数
        Integer d = Integer.valueOf(10);
        Integer e = Integer.valueOf("10");
        // Integer to String
        String strA = a.toString();
        strA = a + "";
        strA = String.valueOf(a);
        System.out.println(strA);
        // String to Integer
        String strB = "111";
        Integer numB = Integer.valueOf(strB);
        System.out.println(numB);
        // String to int
        int numC = Integer.parseInt(strB);
        System.out.println(numC);
        // Integer to int
        int intB = numB.intValue();
        // int to Integer
        Integer c = (int) 5;


    }
}
