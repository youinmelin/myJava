package Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo01 {
    public static void main(String[] args) throws ParseException {
//        method();
        method2();
    }
    // 编译时异常
    public static void method2() throws ParseException {
        String s = "2000-01-01";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date data = simpleDateFormat.parse(s);
        System.out.println(data);
    }
    // 运行时异常
    public static void method() {
        int[] arr = {1, 2, 3} ;
        System.out.println(arr[3]); // ArrayIndexOutOfBoundsException
    }
}
