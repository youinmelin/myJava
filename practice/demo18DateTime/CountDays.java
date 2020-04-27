package demo18DateTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
public class CountDays {
	public static void main(String[] args) throws ParseException {
		long currentTime = System.currentTimeMillis();
		String birthday = "2019 12 04 00 00 00";
		SimpleDateFormat format= new SimpleDateFormat("yyyy MM dd HH mm ss");
			Date birthdayDate = format.parse(birthday);
			System.out.println(birthdayDate);
		Date date = new Date();
		String currentDate = format.format(date);
		long curDateMs = date.getTime();
		System.out.println(curDateMs);
		long birDayMs = birthdayDate.getTime();
		long countDaysMs = curDateMs - birDayMs;
		long countDays = countDaysMs/1000/3600/24;
		System.out.println(countDays + "days");

	}

}
