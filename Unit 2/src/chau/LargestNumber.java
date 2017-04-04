package chau;

import java.util.Scanner;

/**
 * LargestNumber.java 
 * April 3, 2017
 * This program finds the largest number of the numbers entered.
 * @author WayneChau 
 */

public class LargestNumber {
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the amount of integers you want to enter.");
		int numAmount = s.nextInt();
		int [] num = new int[numAmount];
		System.out.println("Please enter the numbers within the amount.");
		for(int a = 0; a < numAmount; a++){
			num[a] = s.nextInt();
		}
		System.out.println("You've have entered the maxmimum amount.");
		int z = largestNum (num);
		System.out.println("The largest number is: " + z);
	}
	public static int largestNum (int[]num){
		/**
		 * Method finds the largest number of the numbers given.
		 *@param [] num Finding the largest number of the given numbers entered by the user in an array.
		 *@return x The largest number of the given numbers.
		 */
		int x = num[0];
		for (int i =1; i< num.length;i++){
			x = Math.max(x, num[i]);
		}
		return x;
	}

}
