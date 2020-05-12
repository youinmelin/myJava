package demo39FunctionalInterface;

import java.util.function.Predicate;

public class Predicate01 {
    public static boolean judgeLength(String str, Predicate<String> pre) {
        boolean ret = pre.test(str);
        return ret;
    }

    public static void main(String[] args) {
        String name = "HarryPotter";
        // name = "Harry";
        boolean ret = judgeLength(name, str ->  /* return */ str.length() > 6);
        System.out.println(ret);
    }
}