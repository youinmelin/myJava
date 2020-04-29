package demo24Collections;

import java.util.ArrayList;
import java.util.Collections;

public class Collections01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "a","b","c","d","z","y","x");
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
        
        Collections.sort(list);
        System.out.println(list);
    }
}