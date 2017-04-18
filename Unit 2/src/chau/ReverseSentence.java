package chau;

import java.util.Scanner;

/**
 * ReverseSentence.java 
 * April 13, 2017
 * This program takes the sentence inputed by the user and prints it backwards. The word that is capitalized forward will be capitalized backwards in the same area capitalized.
 * @author WayneChau 
 */
public class ReverseSentence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sentence = sc.nextLine().split(" ");
		for (int i = 0; i < sentence.length; i++) {

			for (int j = sentence[i].length() - 1; j >= 0; j--) {
				if (((Character) (sentence[i].charAt(0))).toString().matches("[A-Z]")) {
					if (j == sentence[i].length() - 1) {
						System.out.print(Character.toUpperCase(sentence[i].charAt(j)));
					} else {
						System.out.print(Character.toLowerCase(sentence[i].charAt(j)));
					}
				} else {
					System.out.print(sentence[i].charAt(j));
				}
			}
			System.out.print(" ");
		}
	}
}
