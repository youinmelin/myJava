package Date;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar.getWeekYear());
        // public int get(int field); 返回给定日历字段的值
        int year = calendar.get(1); // Calendar.YEAR
        int month = calendar.get(Calendar.MONDAY) + 1;
        int day = calendar.get(Calendar.DATE);
        System.out.println(year + "-" + month + "-" + day);

        /*
        public abstract void add(int field, int amount);将指定的时间量添加或减去给定的日历字段
        public final void set ( int year ,int month, int date); 设置当前日历的年月日
         */
        calendar.add(Calendar.MONTH, -12);
        month = calendar.get(2) + 1; // Calendar.MONTH
        System.out.println(month);

        calendar.set(2011,12,04);
        System.out.println(calendar);
    }
}
