import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author gregnightingale iterate day by day from start to finish, if it is a
 *         valid date and a valid palindrome then save the result.
 */
public class PalindromeIterativeImpl_MMddyyyy extends DatePalindromeTemplate
		implements Strategy {
	private Date dateIndex;

	public PalindromeIterativeImpl_MMddyyyy(String dateFormat,
			String startDate, String endDate) throws ParseException {
		super(dateFormat, startDate, endDate);
	}

	@Override
	public void solve() {
		dateIndex = this.getStartDate();
		while (dateIndex.compareTo(getEndDate()) <= 0) {
			if (isPalindrome()) {
				this.getResultList().add(
						getStringRepresentationOfCurrentDateIndex());
			}
			incrementDateIndex();
		}
	}

	protected boolean isPalindrome() {
		String dateString = getStringRepresentationOfCurrentDateIndex();
		String front = dateString.substring(0, 4);
		String back = dateString.substring(4, 8);
		if (front.equals(Utils.reverse(back)))
			return true;
		return false;
	}

	private String getStringRepresentationOfCurrentDateIndex() {
		return this.getDateFormat().format(dateIndex);
	}

	private void incrementDateIndex() {
		Calendar c = Calendar.getInstance();
		c.setTime(dateIndex);
		c.add(Calendar.DATE, 1);
		dateIndex = c.getTime();
	}

}
