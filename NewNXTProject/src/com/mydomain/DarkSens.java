package com.mydomain;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

/**
 * DarkSens.java
 * This class senses dark balls and place them into the dark bin.
 * @author Wayne Chau
 * June 06 2017
 */
public class DarkSens implements Behavior {
	private LightSensor light;
	private boolean suppressed; //ends program
	private boolean bool2; //cause actions to be implemented

	public DarkSens(LightSensor ls){
		this.light = ls;
	}
	
	@Override
	public boolean takeControl() {
		if (light.getLightValue() > 20) {
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		suppressed = false;
		light.getLightValue();
		if (light.getLightValue() > 20 && !suppressed) { 
			bool2 = true;
		}
		if (bool2 == true && !suppressed) { //positions the claw to grab the ball
			Motor.B.forward();
			Motor.C.forward();
			Delay.msDelay(500);
			pickupBalls();
			placeDarkBin();
			Thread.yield();
		}

	}

	@Override
	public void suppress() {
		suppressed = true;
	}

	/**
	 * Picks up Dark Balls
	 * @Param N/A
	 * @Return N/A
	 */
	public static void pickupBalls() {
		//positions the claw to the ball
		Motor.B.stop();
		Motor.C.rotate(220);
		Delay.msDelay(600);
		//allows claw to grab the ball
		Motor.B.rotate(200, true);
		Motor.C.rotate(200, true);
		Motor.A.rotateTo(-125);
		Motor.A.stop();
	}

	/**
	 * Place Dark Balls in the Dark Bin
	 * @Param N/A
	 * @Return N/A
	 */
	public static void placeDarkBin() {
		Motor.C.stop();
		Motor.B.rotate(300);
		Motor.B.forward();
		Motor.C.forward();
		Delay.msDelay(5000);
		Motor.A.rotate(105);
	}

	/**
	 * Rotates back towards the pile of Balls
	 * @Param N/A
	 * @Return N/A
	 */
	public static void rotateAround() {
		Motor.C.stop();
		Motor.B.rotate(720);
		Motor.C.forward();
		Motor.B.forward();
		Delay.msDelay(5000);
	}
}
