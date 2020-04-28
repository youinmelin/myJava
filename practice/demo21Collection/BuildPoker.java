package demo21Collection;

import java.util.ArrayList;

public class BuildPoker {
    private static String[] typeStr = {"0","1","2","3"};
    private static String[] numStr = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
    static ArrayList<String> build() {
        ArrayList<String> list = new ArrayList<>();
        for (String t : typeStr) {
            for (String n : numStr) {
                // System.out.println(t+n);
                list.add(t+n);
            }
        }
        list.add("J0");
        list.add("J1");
        System.out.println(list.size());
        return list;
    }

}
