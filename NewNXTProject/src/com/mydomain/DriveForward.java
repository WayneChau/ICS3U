package com.mydomain;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;

/**
 * DriveForward.java
 * This class drives the robot forward if a light or dark ball is sensed.
 * @author Wayne Chau
 * June 06 2017
 */
public class DriveForward implements Behavior{
	private boolean suppressed; //end program
	
	@Override
	
	/**
	 * Always true to drive forward
	 * @param N/A
	 * @return true - moves forward if no behavior is met
	 */
	public boolean takeControl() {
		return true;
	}
	@Override
	
	/**
	 * Moves Robot Forward, stops if suppressed
	 * @param N/A
	 * @return N/A
	 */
	public void action() {
		suppressed = false;
		Motor.B.forward();
		Motor.C.forward();
		while (!suppressed){
			Thread.yield();
		}
		Motor.B.stop();
		Motor.C.stop();
	}

	/**
	 * Robot calls this method to suppress the program
	 * @param N/A
	 * @return N/A
	 */
	@Override
	public void suppress() {
		suppressed = true;
		
	}

}
