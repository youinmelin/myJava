package demo39FunctionalInterface;

import java.util.function.Predicate;

public class Predicate02And {
    public static boolean checkStr(String str, Predicate<String> p1, Predicate<String> p2) {
        // boolean ret1 = p1.test(str);
        // boolean ret2 = p2.test(str);
        // boolean retLast = ret1 &&ret2;
        boolean retLast = p1.and(p2).test(str);
        return retLast;
    }

    public static void main(String[] args) {
        String name = "HarryPotter";
        // name = "Harry";
        boolean ret = checkStr(name, 
            (str)->{ return str.length() > 6; },
            (str) -> { return !str.contains(" ");}
            );
        System.out.println(ret);
    }
    
}