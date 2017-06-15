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
	private LightSensor light;
	private boolean bool; //cause actions to be implemented

	public DriveForward(LightSensor ls){
		this.light = ls;
	}
	
	@Override
	public boolean takeControl() {
		if (light.getLightValue() > 20){
			return false;
			}
			return true;
	}

	@Override
	public void action() {
		if (light.getLightValue() > 20){
			bool = false;
		}
		if (bool == false){
			Motor.B.stop();
			Motor.C.stop();
		}
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
