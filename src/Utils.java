import java.text.SimpleDateFormat;
import java.util.Date;


public class Utils {
	public static String getYear(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(date);
	}
	public static String getMonth(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return sdf.format(date);
	}
	public static String getDay(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		return sdf.format(date);
	}
	public static String reverse(String in) {
		return new StringBuilder(in).reverse().toString();
	}

}
