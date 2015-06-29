/**
 * Test class for the DateUtil.
 * 
 * Generates random date between 01.01.1700 and 31.12.2499 and print date
 * in the format "d mmm yyyy, xxxday", e.g., "14 Feb 2012, Tuesday";
 * Also prints if the given year is leap or not.
 */

package basic.exersises.difficult;

public class Test {

	public static void main(String[] args) {
		DateUtil du = new DateUtil();

		// generate random date
		int year = 1700 + (int) (Math.random() * 800);
		int day = (int) (Math.random() * 32);
		int month = (int) (Math.random() * 13);

		// print date and is year is leap
		System.out.println("Year " + year
				+ (du.isLeapYear(year) ? " is leap" : " is not leap"));
		System.out.println(du.toString(day, month, year));
	}

}
