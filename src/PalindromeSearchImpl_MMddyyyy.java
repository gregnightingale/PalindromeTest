import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author gregnightingale when finding palindromes in the form MMddyyyy we can
 *         optimize by first looking at the yyyy part and checking if the
 *         reverse will result in valid MMdd combination, if not we save having
 *         to iterate through each day of that year.
 */
public class PalindromeSearchImpl_MMddyyyy extends
		DatePalindromeSearchTemplateMethod {

	public PalindromeSearchImpl_MMddyyyy(String dateFormat, String startDate,
			String endDate) throws ParseException {
		super(dateFormat, startDate, endDate);
	}

	@Override
	protected void preProcess() {
		System.out.println("preProcess()");
	}

	@Override
	protected boolean search() {
		System.out.println("search()");

		int startYear, endYear;
		startYear = Integer.parseInt(Utils.getYear(getStartDate()));
		endYear = Integer.parseInt(Utils.getYear(getEndDate()));

		for (int year = startYear; year <= endYear; year++) {
			String paddedYear = String.format("%04d", year);
			if (isYearPossiblePalindrome(paddedYear)) {
				String backhalf = paddedYear;
				StringBuilder builder = new StringBuilder();
				builder.append(Utils.reverse(backhalf)).append(backhalf);
				String possibleDate = builder.toString();
				if (isValidDate(possibleDate)) {
					this.getResultList().add(possibleDate);
				}
			}
		}

		return true;
	}

	private boolean isValidDate(String possibleDate) {
		try {
			SimpleDateFormat sdf = getDateFormat();
			sdf.setLenient(false);
			sdf.parse(possibleDate);
		} catch (ParseException e1) {
			System.out.println("Unparseable date:" + possibleDate);
			return false;
		}
		return true;
	}

	private boolean isYearPossiblePalindrome(String year) {
		String reverseYear = Utils.reverse(year);
		String palDay = reverseYear.substring(2, 4);
		String palMonth = reverseYear.substring(0, 2);
		if (isPossiblyValidMonth(palMonth) && isPossiblyValidDay(palDay)) {
			return true;
		}
		return false;
	}

	@Override
	protected void postProcess() {
		System.out.println("postProcess()");
		// TODO Auto-generated method stub
	}

	private boolean isPossiblyValidDay(String palDay) {
		int d = Integer.parseInt(palDay);
		if (d > 0 && d <= 31)
			return true;
		return false;
	}

	private boolean isPossiblyValidMonth(String palMonth) {
		int m = Integer.parseInt(palMonth);
		if (m > 0 && m <= 12)
			return true;
		return false;
	}

}
