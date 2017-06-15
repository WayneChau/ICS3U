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
	public boolean takeControl() {
		if (Button.ESCAPE.isDown()){ //Escape button ends program
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		System.exit(0);
	}

	@Override
	public void suppress() {
	}


}
