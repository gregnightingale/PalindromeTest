import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public abstract class DatePalindromeIterativeTemplateMethod extends
		DatePalindromeTemplate {

	private Date dateIndex;

	public DatePalindromeIterativeTemplateMethod(String dateFormat,
			String startDate, String endDate) throws ParseException {
		super(dateFormat, startDate, endDate);
	}

	@Override
	public void solve() {
		start();
		dateIndex = this.getStartDate();
		while (dateIndex.compareTo(getEndDate()) <= 0) {
			if (isPalindrome()) {
				this.getResultList().add(
						getStringRepresentationOfCurrentDateIndex());
			}
			incrementDateIndex();
		}
		stop();
	}

	protected abstract void start();

	protected abstract void stop();

	protected abstract boolean isPalindrome();

	protected abstract String getStringRepresentationOfCurrentDateIndex();

	private void incrementDateIndex() {
		Calendar c = Calendar.getInstance();
		c.setTime(dateIndex);
		c.add(Calendar.DATE, 1);
		dateIndex = c.getTime();
	}

	public Date getDateIndex() {
		return dateIndex;
	}

}
