package com.mydomain;

import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;

/**
 * EndProgram.java
 * This class ends program once the escape button is pressed.
 * @author Wayne Chau
 * June 06 2017
 */
public class EndProgram implements Behavior{
	@Override
	/**
	 * Escape button triggers the suppress and action when pressed
	 * @param N/A
	 * @return true, false - triggers the suppress and action methods
	 */
	public boolean takeControl() {
		if (Button.ESCAPE.isDown()){ //Escape button ends program
			return true;
		}
		return false;
	}

	/**
	 * Robot exits to the main screen
	 * @param N/A
	 * @return N/A
	 */
	@Override
	public void action() {
		System.exit(0);
	}

	/**
	 * Robot calls this method to suppress the program
	 * @param N/A
	 * @return N/A
	 */
	@Override
	public void suppress() {
	}


}
