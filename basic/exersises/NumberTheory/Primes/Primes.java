/**
 * Exercise (Primes): 
 * A positive integer is a prime if it is divisible by 1 and itself only.
 * Write a method called isPrime(int posInt) that takes a positive integer 
 * and returns true if the number is a prime.
 * Write a program called PrimeList that prompts the user for
 * an upper bound (a positive integer), and lists all the primes less than or
 * equal to it. Also display the percentage of prime (up to 2 decimal places).
 * The output shall look like:
 * Please enter the upper bound: 10000
 * 1 
 * 2 
 * 3 
 * ...... 
 * ...... 
 * 9967 
 * 9973 
 * [1230 primes found (12.30%)]
 * 
 * Hints: To check if a number n is a prime, the simplest way is try dividing
 * n by 2 to √n.
 * 
 */
 
package basic.exersises.numbertheory;

public class Primes {

	/**
	 * checks number is a prime
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
	 * prints founded prime numbers in (0; upperBound)
	 * 
	 * @param upperBound to find prime numbers in (0; upperBound)
	 * @return number of founded prime numbers
	 */
	public int primeNumbers(int upperBound) {
		int count = 0;
		for (int i = 1; i <= upperBound; i++) {
			if (isPrime(i)) {
				System.out.println(i);
				count++;
			}
		}
		return count;
	}

}
