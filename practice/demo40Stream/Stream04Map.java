package demo40Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Stream04Map {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(19,30,2,0,8,55,47,74);
        Stream<String> stream2 ;
        stream2 = stream.map(num -> num + "").limit(5);
        stream2.forEach(str -> System.out.println(str));
    }


}