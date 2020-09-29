package Date;

import java.util.Date;

public class DateDemo02Apis {

    public static void main(String[] args) {
        Date d = new Date();
        // public long getTime(); 获取从1970.1.1到现在的毫秒值
        System.out.println(d.getTime());
        System.out.println(d.getTime() * 1.0 / 1000 / 3600 / 24 / 365);

        // public void setTime(long time); 给定毫秒值,设定时间
        long time = 1000*3600;
        d.setTime(time);
        System.out.println(d);

    }
}
