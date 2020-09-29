package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*

     constructor:
         pubilc SimpleDateFormat();
         pubilc SimpleDateFormat(String pattern);
     Date to String:
         public final String format(Date date);
     String to Date:
         public Date parse(String source);
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String dateStr = simpleDateFormat.format(date);
        System.out.println("空参构造函数: " + dateStr);

        simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        dateStr = simpleDateFormat.format(date);
        System.out.println("自定义模式构造函数: " + dateStr);

        // String to Date
        dateStr = "2011-10-04 14:22:22";
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = simpleDateFormat.parse(dateStr);
        System.out.println(date);






    }

}
