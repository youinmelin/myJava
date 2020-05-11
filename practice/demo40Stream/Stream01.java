package demo40Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stream01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "aa","ab","c");
        System.out.println(list);
        list.stream().filter((str) -> str.startsWith("a")).forEach((str -> System.out.println(str)));;
        long num = list.stream().filter((str) -> str.startsWith("a")).count();
        System.out.println(num);
    }

}