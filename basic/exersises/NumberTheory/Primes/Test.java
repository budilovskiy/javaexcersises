package basic.exersises.numbertheory;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Primes test = new Primes();
		
		System.out.print("Enter the upper bound: ");
		int number = scanner.nextInt();
		scanner.close();
		
		int primeNumbers = test.primeNumbers(number);
		double primesPercent = ((double)primeNumbers/number) * 100;
		System.out.println("\n[" + primeNumbers + " prime numbers found (" + primesPercent + "%)]\n");
		
	}
}
