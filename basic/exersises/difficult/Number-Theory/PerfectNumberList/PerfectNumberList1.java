/**
 * Exercise (Perfect and Deficient Numbers): A positive integer is called a
 * perfect number if the sum of all its factors (excluding the number itself,
 * i.e., proper divisor) is equal to its value.
 * For example, the number 6 is perfect because its proper divisors are 1, 2,
 * and 3, and 6=1+2+3; but the number 10 is not perfect because its proper
 * divisors are 1, 2, and 5, and 10≠1+2+5.
 * A positive integer is called a deficient number if the sum of all
 * its proper divisors is less than its value. For example, 10 is a deficient
 * number because 1+2+5<10; while 12 is not because 1+2+3+4+6>12.
 * Write a method called isPerfect(int posInt) that takes a positive integer,
 * and return true if the number is perfect. Similarly, write a method
 * called isDeficient(int posInt) to check for deficient numbers.
 * Using the methods, write a program called PerfectNumberList that prompts user
 * for an upper bound (a positive integer), and lists all the perfect numbers less
 * than or equal to this upper bound. It shall also list all the numbers that
 * are neither deficient nor perfect.
 * The output shall look like:
 * 
 * Enter the upper bound: 1000
 * These numbers are perfect:
 * 6 28 496
 * [3 perfect numbers found (0.30%)]
 * 
 * These numbers are neither deficient nor perfect:
 * 12 18 20 24 30 36 40 42 48 54 56 60 66 70 72 78 80 ......
 * [246 numbers found (24.60%)]
 *
 */

public class PerfectNumberList {

	private boolean isPerfect(int posInt) {
		int sum = 0;
		int factor = posInt - 1;
		while (factor > 0) {
			if (posInt % factor == 0) {
				sum += factor;
			}
			factor--;
		}
		return sum == posInt;
	}

	private boolean notDeficient(int posInt) {
		int sum = 0;
		int factor = posInt - 1;
		while (factor > 0) {
			if (posInt % factor == 0) {
				sum += factor;
			}
			factor--;
		}
		return sum > posInt;
	}

	public int calcPerfect(int upperBound) {
		int count = 0;
		System.out.println("These numbers are perfect:");
		for (int i = 1; i <= upperBound; i++) {
			if (isPerfect(i)) {
				count++;
				System.out.print(i + " ");
			}
		}
		return count;
	}

	public int calcNotDeficient(int upperBound) {
		int count = 0;
		System.out.println("These numbers are neither deficient nor perfect:");
		for (int i = 1; i <= upperBound; i++) {
			if (notDeficient(i)) {
				count++;
				System.out.print(i + " ");
			}
		}
		return count;
	}

}
