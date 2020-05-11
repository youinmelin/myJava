package demo40Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Stream03Filter {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(19,30,2,0,8,55,47,74);
        stream.filter(num -> num>30).forEach(num-> System.out.println(num));
    }


}