package demo21Collection;

import java.util.ArrayList;
import java.util.Collections;

public class PracticePorker {
    public static void main(String[] args) {
        ArrayList<String> listAll = new ArrayList<>();
        listAll = BuildPorker.build();
        // System.out.println(listAll.toString());
        Collections.shuffle(listAll);
        ArrayList<String> list1= new ArrayList<>();
        ArrayList<String> list2= new ArrayList<>();
        ArrayList<String> list3= new ArrayList<>();
        ArrayList<String> list0= new ArrayList<>();
        for (int i = 1; i <= listAll.size(); i++) {
            if (i < 52) {
                if (i % 3 == 1) {
                    list1.add(listAll.get(i-1));
                }
                if (i % 3 == 2) {
                    list2.add(listAll.get(i-1));
                }
                if (i % 3 == 0) {
                    list3.add(listAll.get(i-1));
                }
            }else {
                list0.add(listAll.get(i-1));
            }
        }
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        System.out.println(list3.toString());
        System.out.println(list0.toString());

    }
}