package basic.exersises.numbertheory;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PerfectPrimeFactorList test = new PerfectPrimeFactorList();

		System.out.print("Enter the upper bound: ");
		int number = scanner.nextInt();
		scanner.close();

		int primeFactors = test.productOfPrimeFactorsCounting(number);
		double primesPercent = ((double) primeFactors / number) * 100;
		System.out.println("\n[" + primeFactors + " numbers found ("
				+ primesPercent + "%)]\n");

	}
}
