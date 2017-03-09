/**
 * 
 */
package chau;

import hsa_new.Console;

/**
 * HelloConsole.java
 * This program
 * February 24, 2017
 * @author Wayne Chau
 */
public class HelloConsole {
	public static void main(String[] args) {
		Console c = new Console(32,80);
		double money;
		c.println("Please enter the cost of your products below");
		money = c.readDouble();
		money = money * 1.13;
		Math.round(money);
		c.println("With tax, the total cost of your order is:" + money);
		
	
		

	}

}
