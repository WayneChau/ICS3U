package chau;

/**
 * PerfectTriple.java 
 * April 20, 2017
 * The program checks all values for two numbers from 0 to 100 to determined if they are a perfect square. If they are a perfect square they will be printed in a a2 + b2 = c2.
 * @author WayneChau 
 */
public class PerfectTriple {
	public static void main(String[] args) {
		for (int a= 0; a <= 100; a++){
			for (int b= 0; b <= 100; b++){
				double c = Math.pow(a, 2) + Math.pow(b,  2);
				if (perfectSquare(a, b) == true){
					System.out.println(a + "+" + b + "=" + c);
				}
			}
		}
		
	}
	
	/**
	 *The method checks if the values from 0-100 are perfect squared.
	 *@param a, b The two variables checked.
	 *@return True, False Determines whether or not the values are perfect squared.
	 */
	public static boolean perfectSquare (int a, int b){
		int srt = (int)Math.sqrt(a);
		int srt2 = (int)Math.sqrt(b);
		double check = Math.pow(srt,2);
		double check2 = Math.pow(srt2,2);
		if (a == check){
			return true;
		}
		if (b == check2){
			return true;
		}
		return false;	
	}
	
}

