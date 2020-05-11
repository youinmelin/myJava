package demo40Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Stream02ForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "aa","ab","c");
        System.out.println(list);
        Stream<String> stream1 = list.stream();
        stream1.forEach(str -> System.out.println(str.length()));

        Stream<String> stream2 = Stream.of("a", "b", "c");
        stream2.forEach(str -> System.out.println(str));
    }


}