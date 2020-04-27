package demo18DateTime;
import java.util.Calendar;
import java.util.Date;

public class CalPractice {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		int year = cal.get(Calendar.YEAR);
		System.out.println(year);
		Date date = cal.getTime();
		System.out.println(date);

	}

}
