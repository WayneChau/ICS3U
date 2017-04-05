package chau;

import java.util.Scanner;

/**
 * IsPrime.java \
 * April 3, 2017 
 * This program finds out if the number entered is prime.
 * @author WayneChau
 */
public class IsPrime {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a number");
		int num = s.nextInt();
		boolean z = isPrime(num);
		System.out.println(z);
	}

	/**
	 * Method finds out if the number given is a prime number.
	 * @param num Finding if the number given is a prime number entered by the user.
	 * @return True, False Finds out if the number given is a prime number or not.
	 */
	public static boolean isPrime(int num) {
		int x;
		for (int i = 2; i <= num / 2; i++) {
			if (isDivisible(num, i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Method if the two number entered is divisible.
	 *@param numerator The given numbers entered by the user
	 *@param denominator The counter for the for loop
	 *@return True, False If the numbers are divisible or not.
	 */
	public static boolean isDivisible(int numerator, int denominator) {
		if (numerator % denominator == 0) {
			return true;
		}
		return false;
	}

}
