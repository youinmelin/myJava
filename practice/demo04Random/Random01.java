package demo04Random;

import java.util.Random;

public class Random01 {
    public static void main(String[] args) {
        Random ran = new Random();
        System.out.println(ran.nextInt());
        System.out.println(ran.nextDouble());
        System.out.println(ran.nextInt(10));
    }
}