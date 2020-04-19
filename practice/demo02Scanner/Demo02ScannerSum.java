package demo02Scanner;

import java.util.Scanner;

public class Demo02ScannerSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input 1st int");
        int num1 = sc.nextInt();
        System.out.println("input 2nd int");
        int num2 = sc.nextInt();
        sc.close();

        int sum = sumTwo(num1, num2);
        System.out.println("the sum is: " + sum);
    }

    public static int sumTwo(int num1, int num2) {
        return num1 + num2;
    }

}