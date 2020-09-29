package Date;

import java.util.Date;

public class DateDemo01 {
    public static void main(String[] args) {
        // Date类的两种构造方法
        Date date = new Date();
        System.out.println(date) ;

        // public Date(long date); 分配一个Date对象,并将其初始化为表示从标准基准时间(1970.1.1 00:00:00 格林威治时间)起指定的毫秒值
        long num = 1000*60*60;
        Date date1 = new Date(num);
        System.out.println(date1);
    }
}
