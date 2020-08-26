package board;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {
	public static String today() {

		SimpleDateFormat date = new SimpleDateFormat("yyyy년 MM/dd HH:mm");

		Date time = new Date();

		String nowdate = date.format(time);

		return nowdate;

	}
}