package chau;

import java.util.Scanner;

/**
 * IsPrime.java 
 * April 3, 2017
 * This program finds out if the number entered is prime.
 * @author WayneChau 
 */

public class IsPrime {
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a number");
		int num = s.nextInt();
		boolean z = isPrime (num);
		System.out.println(z);
	}
	
	public static boolean isPrime (int num){
		/**
		 * Method finds out if the number given is a prime number.
		 *@param num Finding if the number given is a prime number entered by the user.
		 *@return True, False Finds out if the number given is a prime number or not.
		 */
		int x;
		for (int i= 2; i<= num/2; i++){
			x = num % i ;
			if (x == 0){
				return false;
			}
		}
		return true;
	}
}
