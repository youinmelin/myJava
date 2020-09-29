package Date;

import java.util.Calendar;
import java.util.Scanner;

public class CountFebruaryDays {

    /**
     * 获取任意年的二月有多少天
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("input year: ");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        sc.close();
        int month = 3;
        int day = 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day  );
        calendar.add(Calendar.DATE, -1);
        int newDay = calendar.get(Calendar.DATE);
        System.out.println(newDay);
    }


}
