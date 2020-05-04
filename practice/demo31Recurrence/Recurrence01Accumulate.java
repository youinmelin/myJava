package demo31Recurrence;

import java.util.Scanner;
public class Recurrence01Accumulate {
    public static void main(String[] args) {
        System.out.println("Please input a integer bigger than zero:");
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int sum = sumRe(num1);
        System.out.println(sum);
    }

    public static int sumRe(int num) {
        if (num < 1) {
            System.out.println("wrong number.");
            return 0;
        }
        if (num == 1){
            return num;
        }else {
            int n = num - 1;
            return num + sumRe(n);
        }
    }
}