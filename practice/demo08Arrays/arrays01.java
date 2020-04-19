package demo08Arrays;

import java.util.Arrays;

public class arrays01 {
    public static void main(String[] args) {
        int[] array = {11,32,2,3,4,5,6,7};
        String intStr = Arrays.toString(array);
        System.out.println(intStr);        
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}