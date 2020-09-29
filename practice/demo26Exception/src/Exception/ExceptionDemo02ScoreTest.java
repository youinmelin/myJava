package Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
自定义异常
 */
public class ExceptionDemo02ScoreTest {
    public static void main(String[] args) throws ScoreException {
        Teacher teacher = new Teacher();
        int score = -10;
        teacher.checkScore(score);
    }
}
