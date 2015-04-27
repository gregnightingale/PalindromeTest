import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

abstract public class DatePalindromeTemplate implements Strategy {

	private SimpleDateFormat dateFormat;
	private String start, end;
	private Date startDate, endDate;

	private ArrayList<String> resultList = new ArrayList<String>(0);

	@SuppressWarnings("unused")
	private DatePalindromeTemplate() {

	}

	public DatePalindromeTemplate(String dateFormat, String startDate,
			String endDate) throws ParseException {
		setFormat(dateFormat);
		setRange(startDate, endDate);
	}

	private void setFormat(String format) {
		dateFormat = new SimpleDateFormat(format);
	}

	private void setRange(String start, String end) throws ParseException {
		this.start = start;
		this.end = end;
		startDate = dateFormat.parse(start);
		endDate = dateFormat.parse(end);
	}

	@Override
	public String toString() {
		return "Date Palindromes found in range [" + start + "," + end + "]:"
				+ resultList.toString();
	}

	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public ArrayList<String> getResultList() {
		return resultList;
	}

}
