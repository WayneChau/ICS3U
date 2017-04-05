package chau;

import java.util.Scanner;

/**
 * Gcf.java 
 * April 3, 2017
 * This program finds the greatest common factor of the 2 numbers entered.
 * @author WayneChau 
 */
public class Gcf {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter two numbers.");
		int num1 = s.nextInt();
		int num2 = s.nextInt();
		int z = greatestCommonFactor (num1,num2);
		System.out.println("The greatest common factor is: " + z);
		
	}
	
	/**
	 * Method finds the greatest common factor of the number given.
	 *@param num1, num2 Finding the greatest common factor of the given numbers num1 and num2 entered by the user.
	 *@return n The greatest common factor of the given number.
	 */
	public static int greatestCommonFactor (int num1, int num2){
		int big = Math.max(num1, num2);
		int small = Math.min(num1, num2);
		int n = small;
		while (!isDivisible(small,n)|| !isDivisible(big,n)){
			n--;
		}
		return n;
	}
	
	/**
	 * Method if the two number entered is divisible.
	 *@param numerator, denominator The given numbers entered by the user
	 *@return True, False If the numbers are divisible or not.
	 */
	public static boolean isDivisible (int numerator, int denominator){
		if (numerator%denominator == 0){
			return true;
		}
		return false;
	}
	
	
		
	

}
