package demo18DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormat01 {
    public static void main(String[] args) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
        System.out.println(date.format(new Date()));
        String ymd = "2020 12 04 12:00:00";
        try {
            System.out.println(date.parse(ymd));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}