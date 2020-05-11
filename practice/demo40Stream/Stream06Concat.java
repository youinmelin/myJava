package demo40Stream;
import java.util.stream.Stream;

public class Stream06Concat {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(0,1,2,3,4,5,6,7);
        Stream<Integer> stream2 = Stream.of(10,11,12,13,14,15,16,17);
        Stream.concat(stream1, stream2).forEach(num -> System.out.println(num));
    }
}