package demo03Anonumous;

import java.util.Scanner;

public class Anonymous01 {
    public static void main(String[] args) {
        // normal approach
        // System.out.println("input a int");
        // Scanner sc = new Scanner(System.in);
        // int num = sc.nextInt();
        // sc.close();
        // System.out.println(num);

        // anonymous object approach
        System.out.println("input another int");
        int num = new Scanner(System.in).nextInt();
        System.out.println(num);
    }

}