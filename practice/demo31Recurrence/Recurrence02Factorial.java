package demo31Recurrence;

public class Recurrence02Factorial {
    public static void main(String[] args) {
        int num = 10;
        long ret = factorial(num);
        System.out.println(ret);
    }

    public static long factorial(int num) {
        if (num == 1) {
            return num;
        }
        return num * factorial(num - 1);
    }
    
}