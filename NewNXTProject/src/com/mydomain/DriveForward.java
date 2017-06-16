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
	public boolean takeControl() {
		return true;
	}
	@Override
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

	@Override
	public void suppress() {
		suppressed = true;
		
	}

}
