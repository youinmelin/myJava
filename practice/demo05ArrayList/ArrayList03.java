package demo05ArrayList;

import java.util.ArrayList;

public class ArrayList03 {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (Integer i = 0; i < 20; i++) {
            numList.add(i);
        }
        System.out.println(numList);
    }
}