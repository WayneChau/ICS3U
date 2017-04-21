package chau;

/**
 * PerfectIntegers.java
 * April 21, 2017
 * The program determines if the factors of the number less than 100 can add up to equal the number checked excluding the number checked itself.
 * @author Wayne Chau
 */
public class PerfectIntegers {
	public static void main(String[] args) {
		for (int a = 1; a <= 100; a++) {
			if (isPerfect(a) == true) {
				System.out.println(a + ":It is a perfect interger.");
			}

		}
	}

	/**
	 * Method test each number to see if it is a factor of the number being checked and is added together excluding the number itself.
	 *@param a The number being checked to see if it is a perfect integer.
	 *@return True, False Determines whether or not the number is the sum of the factorial excluding itself.
	 */
	public static boolean isPerfect(int a) {
		int sum = 0;
		for (int i = 1; i < a; i++) {
			if (a % i == 0) {
				sum = sum + i;
			}
		}
		if (sum == a) {
			return true;
		}
		return false;
	}

}
