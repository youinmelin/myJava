package demo39FunctionalInterface;

import java.util.function.Function;

public class Function01 {
    public static Integer switchType(String str, Function<String, Integer> fun) {
        return fun.apply(str);
    }

    public static void main(String[] args) {
        String str = "100";
        Integer num = switchType(str, numStr -> Integer.parseInt(str));
        System.out.println(num.getClass());
    }
}