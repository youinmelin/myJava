package demo05ArrayList;

import java.util.ArrayList;
import java.util.Random;

/* 生成6个1——33之间的随机整数，添加到集合 */
public class ArrayList04Random {
    public static void main(String[] args) {
        ArrayList<Integer> numlist = new ArrayList<>();
        Random ram = new Random();
        for (int i = 0; i < 6; i++) {
            int num = ram.nextInt(33) + 1;
            numlist.add(num);
        }    
        for (int i = 0; i < numlist.size(); i++) {
            System.out.println(numlist.get(i));
        }
    }
}