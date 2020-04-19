package demo04Random;

import java.util.Random;

// 根据n值，获取[1,n]随机整数 
public class Random02 {
    public static void main(String[] args) {
        Random ram = new Random();
        for (int i = 0; i < 100; i++) {
            int num = 1 + ram.nextInt(10);
            System.out.println(num);
        }
    }
}