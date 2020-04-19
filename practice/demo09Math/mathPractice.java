package demo09Math;

import java.util.ArrayList;

/**
 * 计算在-10.8到5.9之间，绝对值大于6或者小于2.1的整数的数量
 */
public class mathPractice {
    public static void main(String[] args) {
        int left = (int)Math.ceil(-10.8);
        int right = (int)Math.floor(5.9);
        int count = 0;
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = left; i <= right;) {
            if (Math.abs(i) > 6 || Math.abs(i) < 2.1){
                count++;
                numList.add(i);
            }  
            i++;
        }
        System.out.println(numList);
        System.out.println(count);
    }
}