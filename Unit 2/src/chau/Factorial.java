package chau;

import java.util.Scanner;

/**
 * Factorial.java 
 * April 3, 2017
 * This program finds the the factorial of the number entered.
 * @author WayneChau 
 */
public class Factorial {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a number");
		double x = s.nextDouble();
		double z = factorial (x);
		System.out.println("The factorial is: " + z);
	}
	
	/**
	 * Method finds the factorial of the number given.
	 *@param x Finding the factorial of the given number given by the user.
	 *@return x, -1, 1 The factorial of the given number.
	 */
	public static double factorial (double x){
		if (x < 0){
			return -1;
		}
		else if (x == 0){
			return 1;
		}
		else {
			for (double y=x-1;y>0;y--){
				x=x*y;
			}
			return x;
		}
	}

}