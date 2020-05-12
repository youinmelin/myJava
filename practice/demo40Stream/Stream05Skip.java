package demo40Stream;
import java.util.stream.Stream;

public class Stream05Skip {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(0,1,2,3,4,5,6,7);
        stream.skip(5).forEach(num->System.out.println(num));
    }
}