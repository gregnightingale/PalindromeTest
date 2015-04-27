import java.text.ParseException;


/**
 * @author gregnightingale
 * iterate day by day from start to finish,
 * if it is a valid date and a valid palindrome then
 * save the result.
 */
public class PalindromeIterativeImpl_MMddyyyy extends
		DatePalindromeIterativeTemplateMethod {

	public PalindromeIterativeImpl_MMddyyyy(String dateFormat,
			String startDate, String endDate) throws ParseException {
		super(dateFormat, startDate, endDate);
	}

	@Override
	protected void start() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isPalindrome() {
		String dateString = getStringRepresentationOfCurrentDateIndex();
		String front = dateString.substring(0,4);
		String back = dateString.substring(4,8);
		if (front.equals(Utils.reverse(back))) return true;
		return false;
	}

	@Override
	protected String getStringRepresentationOfCurrentDateIndex() {
		return this.getDateFormat().format(this.getDateIndex());
	}

}
