
package chau;

import java.util.Scanner;

/**
 * IsPalindrome.java 
 * April 18, 2017
 * This program determines if the word entered by the user is palindrome or not.
 * @author WayneChau 
 */
public class IsPalindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a word.");
		String word = sc.nextLine();
		if (isPalindrome(word)){
			System.out.println("This is palindrome.");
		}
		else{
			System.out.println("This is not palindrome.");
		}
	}
	
	/**
	 * Method reverses the word and determines if the reverse word is equal to the word forwards.
	 *@param word The word entered by the user.
	 *@return True, False Determines whether or not the word entered is palidrome.
	 */
	public static boolean isPalindrome(String word) {
		String s = "";
		for (int j=word.length();j>0;j--){
			s=s+word.charAt(j-1);
		}
		if (s.equalsIgnoreCase(word)){
			return true;
		}
		return false;
	}
}
