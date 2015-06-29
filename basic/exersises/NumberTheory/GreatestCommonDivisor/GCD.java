/**
 * 
 * Exercise (Greatest Common Divisor): 
 * One of the earlier known algorithms is the Euclid algorithm to find the GCD of 
 * two integers (developed by the Greek Mathematician Euclid around 300BC). By definition, 
 * GCD(a, b) is the greatest factor that divides both a and b. Assume that a and b are 
 * positive integers, and a≥b, the Euclid algorithm is based on these two properties:
 * 
 * GCD(a, 0) = a
 * GCD(a, b) = GCD(b, a mod b), where (a mod b) denotes the remainder of a divides by b.
 * 
 * For example,
 * 
 * GCD(15, 5) = GCD(5, 0) = 5
 * GCD(99,88) = GCD(88,11) = GCD(11,0) = 11
 * GCD(3456,1233) = GCD(1233,990) = GCD(990,243) = GCD(243,18) = GCD(18,9) = GCD(9,0) = 9
 * 
 * The pseudocode for the Euclid algorithm is as follows:
 * 
 * GCD(a, b)    // assume that a ≥ b
 * while (b != 0) {
 * 	  // Change the value of a and b: a ← b, b ← a mod b, and repeat until b is 0
 * 	  temp ← b
 * 	  b ← a mod b
 * 	  a ← temp
 * }
 * // after the loop completes, i.e., b is 0, we have GCD(a, 0)
 * GCD is a
 * 
 * Write a method called gcd() with the following signature:
 * public static int gcd(int a, int b)
 * Your methods shall handle arbitrary values of a and b, and check for validity.
 * 
 * TRY: Write a recursive version called gcdRecursive() to find the GCD.
 * 
 */

package basic.exersises.numbertheory;

public class GCD {

	/**
	 * calulate gcd in loop
	 * 
	 * @param a
	 * @param b
	 * @return gcd if a and b is positive and a > b, else return -1
	 */
	public int gcd(int a, int b) {
		if ((a >= b) && (a >= 0) && (b >= 0)) {
			while (b != 0) {
				int tmp = b;
				b = a % b;
				a = tmp;
			}
			return a;
		} else {
			return -1;
		}
	}

	/**
	 * calculate gcd in recursion
	 * 
	 * @param a
	 * @param b
	 * @return gcd if a and b is positive and a > b, else return -1
	 */
	public int gcdRecursive(int a, int b) {
		if ((a >= b) && (a >= 0) && (b >= 0)) {
			return (b == 0) ? a : gcdRecursive(b, a % b);
		} else {
			return -1;
		}
	}

}
