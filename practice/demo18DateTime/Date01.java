package demo18DateTime;

import java.util.Date;

public class Date01 {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());

        method1();
        method2();
        method3();
        
    }

    private static void method3() {
        Date date = new Date();
        long now = date.getTime();
        System.out.println(now);

    }

    private static void method2() {
        Date date = new Date(0L);
        System.out.println(date);
    }

    private static void method1() {
        Date date = new Date();
        System.out.println(date);
    }
}