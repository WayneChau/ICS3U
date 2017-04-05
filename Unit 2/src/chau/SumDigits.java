package chau;

import java.util.Scanner;

/**
 * SumDigits.java 
 * April 3, 2017
 * This program finds the sum of the numbers that makes up the number within the number entered.
 * @author WayneChau 
 */
public class SumDigits {
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a number.");
		int sum = s.nextInt();
		int z = sumDigit (sum);
		System.out.println("The sum of the digits entered is: " + z);
	}

	/**
	 * Method finds the sum of the numbers that makes up the number within the number given.
	 *@param num Finding the sum of the numbers that makes up the number of the given number sum entered by the user.
	 *@return sum The sum of the numbers that makes up the given number.
	 */
	public static int sumDigit (int num){
		int sum = 0;
		while(num>=1){
			sum =sum + num%10;
			num = num/10;
		}
		return sum;
	}
}
