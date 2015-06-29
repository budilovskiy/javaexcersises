/**
 * Exercise (Prime Factors): 
 * Write a method isProductOfPrimeFactors(int posInt) that takes a positive integer,
 * and return true if the product of all its prime factors (excluding 1 and the number 
 * itself) is equal to its value. 
 * For example, the method returns true for 30 (30=2×3×5) and false for 20 (20≠2×5). 
 * You may need to use the isPrime() method in the previous exercise.
 * Write a program called PerfectPrimeFactorList that prompts user for an upper bound. 
 * The program shall display all the numbers (less than or equal to the upper bound) that
 * meets the above criteria. The output shall look like:
 * 
 * Enter the upper bound: 100
 * These numbers are equal to the product of prime factors: 
 * 1 6 10 14 15 21 22 26 30 33 34 35 38 39 42 46 51 55 57 58 62 65 66 69 70 74 77 78 82 85 86 87 91 93 94 95 
 * [36 numbers found (36.00%)]
 * 
 */

package basic.exersises.numbertheory;

public class PerfectPrimeFactorList {

	/**
	 * Checks number is a prime
	 * 
	 * @param posInt is the number to check is it prime
	 * @return true if posInt is a prime
	 */
	private boolean isPrime(int posInt) {
		int maxFactor = (int) Math.sqrt(posInt);
		for (int factor = 2; factor <= maxFactor; factor++) {
			if (posInt % factor == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if the given number is equal to product of prime factors of this number
	 * 
	 * @param posInt
	 * @return true if the product of all posInt prime factors (excluding 1 and the
	 *         number itself) is equal to posInt value
	 */
	private boolean isProductOfPrimeFactors(int posInt) {
		int product = 1;
		for (int i = 2; i < posInt; i++) {
			if (posInt % i == 0) {
				product *= isPrime(i) ? i : 1;
			}
		}
		return posInt == product;
	}

	/**
	 * @param upperBound
	 * @return counter of founded numbers in (0; upperBound]
	 */
	public int productOfPrimeFactorsCounting(int upperBound) {
		int count = 0;
		for (int i = 1; i <= upperBound; i++) {
			if (isProductOfPrimeFactors(i)) {
				System.out.print(i + " ");
				count++;
			}
		}
		return count;
	}

}
