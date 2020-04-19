package demo02Scanner;

import java.util.Scanner;

/* input three numbers, return the Max one */

public class Demo01ScannerMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input 1st int");
        int num1 = sc.nextInt();
        System.out.println("input 2nd int");
        int num2 = sc.nextInt();
        System.out.println("input 3rd int");
        int num3 = sc.nextInt();
        sc.close();
        int maxNum = getMax(num1, num2, num3);
        System.out.println("The max one is: " + maxNum);
    }
    public static int getMax(int n1, int n2, int n3) {
        int[] array = new int[]{n1,n2,n3};
        int maxNum = array[0];
        // return n1 + n2 + n3;
        for (int i = 0; i < array.length; i++) {
             maxNum = maxNum > array[i] ? maxNum: array[i];
        }
        return maxNum;
    }
}