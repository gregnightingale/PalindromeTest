import java.text.ParseException;

public abstract class DatePalindromeSearchTemplateMethod extends
		DatePalindromeTemplate {

	public DatePalindromeSearchTemplateMethod(String dateFormat,
			String startDate, String endDate) throws ParseException {
		super(dateFormat, startDate, endDate);
	}

	@Override
	public void solve() {
		while (true) {
			preProcess();
			if (search())
				break;
			postProcess();
		}
	}

	protected abstract void preProcess();

	protected abstract boolean search();

	protected abstract void postProcess();
}
