package basic.exersises.numbertheory;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GCD test = new GCD();

		System.out.print("Enter the first number: ");
		int a = scanner.nextInt();
		
		System.out.print("Enter the second number: ");
		int b = scanner.nextInt();
		scanner.close();
		
		int gcd = test.gcd(a, b);
		int gcdRecursive = test.gcdRecursive(a, b);
		
		if (gcd == -1) {
			System.out.println("Numbers must be positive and first number must be greater then second number");
		} else {
			System.out.printf("%nThe greatest common divisor of %d and %d is %d", a, b, gcd);
			System.out.printf("%nThe greatest common divisor of %d and %d is %d (recursive algorithm)", a, b, gcdRecursive);
		}

	}
}
