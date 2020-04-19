package demo05ArrayList;

import java.util.ArrayList;

public class ArrayList02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        System.out.println(list.get(1));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+":"+list.get(i));
        }
    }

}