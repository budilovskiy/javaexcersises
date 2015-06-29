package basic.exersises.numbertheory;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PerfectNumberList test = new PerfectNumberList();
		
		System.out.print("Enter the upper bound: ");
		int number = scanner.nextInt();
		
		int perfectNumbers = test.calcPerfect(number);
		double perfectPercent = ((double)perfectNumbers/number) * 100;
		System.out.println("\n[" + perfectNumbers + " perfect numbers found (" + perfectPercent + "%)]\n");
		
		int notDeficient = test.calcNotDeficient(number);
		double notDefPrcent = ((double)notDeficient/number) * 100;
		System.out.println("\n[" + notDeficient + " perfect numbers found (" + notDefPrcent + "%)]\n");
	}
}
