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
	
	public static int greatestCommonFactor (int num1, int num2){
		/**
		 * Method finds the greatest common factor of the number given.
		 *@param num1, num2 Finding the greatest common factor of the given numbers num1 and num2 entered by the user.
		 *@return n The greatest common factor of the given number.
		 */
		int big = Math.max(num1, num2);
		int small = Math.min(num1, num2);
		int n = small;
		while (small % n>0 || big % n>0){
			n--;
		}
		return n;
	}
	
	
		
	

}
