/** 
 * Complete the following methods in a class called DateUtil:
 * 
 * - boolean isLeapYear(int year): returns true if the given year is a leap year. 
 * A year is a leap year if it is divisible by 4 but not by 100, or it is divisible by 400.
 * 
 * - boolean isValidDate(int year, int month, int day): returns true if the given year, 
 * month and day constitute a given date. Assume that year is between 1 and 9999, 
 * month is between 1 (Jan) to 12 (Dec) and day shall be between 1 and 28|29|30|31 
 * depending on the month and whether it is a leap year.
 * 
 * - int getDayOfWeek(int year, int month, int day): returns the day of the week,
 * where 0 for SUN, 1 for MON, ..., 6 for SAT, for the given date. Assume that the date is valid.
 * 
 * - String toString(int year, int month, int day): prints the given date 
 * in the format "xxxday d mmm yyyy", e.g., "Tuesday 14 Feb 2012". Assume that the given date is valid.
 * 
 * To find the day of the week (Reference: Wiki "Determination of the day of the week"):
 * 1. Based on the first two digit of the year, get the number from the following "century" table.
 *  -------+---------+--------+--------+--------+--------+--------+--------+
 *  1700-  |  1800-  | 1900-  | 2000-  | 2100-  | 2200-  | 2300-  | 2400-  |
 *    4    |    2    |   0    |   6    |   4    |   2    |   0    |   6    |
 *  -------+---------+--------+--------+--------+--------+--------+--------+
 * Take note that the entries 4, 2, 0, 6 repeat.
 * 
 * 2. Add to the last two digit of the year.
 * 
 * 3. Add to "the last two digit of the year divide by 4, truncate the fractional part".
 * 
 * 4. Add to the number obtained from the following month table:
 * -------------------+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 *                Jan |	Feb | Mar | Apr | May | Jun | Jul | Aug | Sep | Oct | Nov | Dec |
 * -------------------+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * Non-Leap Year  0   | 3   | 3   | 6   | 1   | 4   | 6   | 2   | 5   | 0   | 3   | 5   |
 * -------------------+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * Leap Year	  6   |	2   |                    same as above                          |
 * -------------------+-----+-----------------------------------------------------------+
 * 
 * 5. Add to the day.
 * 
 * 6. The sum modulus 7 gives the day of the week, where 0 for SUN, 1 for MON, ..., 6 for SAT.
 * 
 * For example: 2012, Feb, 17
 * (6 + 12 + 12/4 + 2 + 17) % 7 = 5 (Fri)
 */

package basic.exersises.difficult;

public class DateUtil {
	
	// Day's name – for printing
	String[] strDays = { "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday" };
	
	// Month's name – for printing
	String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
		         "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	/**
	 * A year is a leap year if it is divisible by 4 but not by 100,
	 * or it is divisible by 400.
	 * 
	 * @param year
	 * @return true if the given year is a leap year
	 */
	public boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	/**
	 * Year is between 1700 and 2500, month is between 1 (Jan) to 12 (Dec)
	 * and day shall be between 1 and 28|29|30|31 depending on the month
	 * and whether it is a leap year.
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return true if the given year, month and day constitute a given
	 * date
	 */
	public boolean isValidDate(int day, int month, int year) {
		boolean result = false;
		if ((year > 1700 && year < 2500) && (month > 0 && month <= 12)) {
			if ((month == 1 || month == 3 || month == 5 || month == 7
					|| month == 8 || month == 10 || month == 12)
					&& ((day > 0) && (day <= 31))) {
				result = true;
			} else if ((month == 4 || month == 6 || month == 9 || month == 11)
					&& ((day > 0) && (day <= 30))) {
				result = true;
			} else if ((month == 2)
					&& ((isLeapYear(year)) && ((day > 0) && (day <= 29)) || (!isLeapYear(year))
							&& ((day > 0) && (day <= 28)))) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * Reference: Wiki "Determination of the day of the week"
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return the day of the week, where 0 for SUN, 1 for MON, ...,
	 * 6 for SAT, for the given date.
	 * If date is not valid, returns -1;
	 */
	public int getDayOfWeek(int day, int month, int year) {
		int result = -1;
		if (isValidDate(day, month, year)) {
			switch (year / 100) {
			case 17: result = 4; break;
			case 18: result = 2; break;
			case 19: result = 0; break;
			case 20: result = 6; break;
			case 21: result = 4; break;
			case 22: result = 2; break;
			case 23: result = 0; break;
			case 24: result = 6; break;
			}
		
			switch (month) {
			case 1: result += (isLeapYear(year) ? 6 : 0); break;
			case 2: result += (isLeapYear(year) ? 2 : 3); break;
			case 3: result += 3; break;
			case 4: result += 6; break;
			case 5: result += 1; break;
			case 6: result += 4; break;
			case 7: result += 6; break;
			case 8: result += 2; break;
			case 9: result += 5; break;
			case 10: result += 0; break;
			case 11: result += 3; break;
			case 12: result += 5; break;
			}
			result = (result + (day + (year % 100) + ((year % 100) / 4))) % 7;
		}
		return result;
	}
	
	/**
	 * Prints the given date
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return String representation of the given date
	 * in the format "d mmm yyyy, xxxday", e.g., "14 Feb 2012, Tuesday"
	 */
	public String toString(int day, int month, int year) {
		if (!isValidDate(day, month, year)) {
			return "The date is not valid";
		} else {
			return day + " " + strMonths[month-1] + " " +  year + ", "+ strDays[getDayOfWeek(day, month, year)];
		}
	}
}
