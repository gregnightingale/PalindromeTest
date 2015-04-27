import java.text.ParseException;

public class PalindromeDemo {

	public static void clientCode(Strategy strat) {
		strat.solve();
	}

	public static void main(String[] args) throws ParseException {
		System.out.println("starting...");
		// if (args.length != 2) {
		// System.out.println("must have 2 arguments");
		// return;
		// }
		// String date1 = args[0];
		// String date2 = args[1];
		long startTime = System.currentTimeMillis();
		// ... do something ...
		Strategy special = new PalindromeSearchImpl_MMddyyyy("MMddyyyy",
				"01010001", "12319999");
		special.solve();
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("SPECIAL:" + special.toString());
		System.out.println("elapsed time: " + elapsedTime + "ms");

		startTime = System.currentTimeMillis();
		Strategy iterate = new PalindromeIterativeImpl_MMddyyyy("MMddyyyy",
				"01010001", "12319999");
		iterate.solve();
		System.out.println("ITERATE:" + iterate.toString());
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("elapsed time: " + elapsedTime + "ms");
		
		System.out.println("done...");
	}

}
