package com.mydomain;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

/**
 * LightSens.java
 * This class senses light balls and place them into the light bin.
 * @author Wayne Chau
 * June 06 2017
 */
public class LightSens implements Behavior {
	private LightSensor light;
	private boolean suppressed; //end program
	private boolean bool; //cause the actions to be implemented

	public LightSens(LightSensor ls){
		this.light = ls;
	}
	
	@Override
	public boolean takeControl() {
		if (light.getLightValue() > 30) {
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		suppressed = false;
		Motor.B.forward();
		Motor.C.forward();
		light.getLightValue();
		if (light.getLightValue() > 30 && !suppressed) {
			bool = true;
		}
		if (bool == true && !suppressed) {
			Motor.B.forward();
			Motor.C.forward();
			Delay.msDelay(2000);
			pickupBalls();
			Delay.msDelay(1000);
			placeLightBin();
			Thread.yield();
		}

	}

	@Override
	public void suppress() {
		suppressed = true;
	}

	/**
	 * Picks up Light Balls
	 * @Param N/A
	 * @Return N/A
	 */
	public static void pickupBalls() {
		//positions the claw to the ball
		Motor.B.stop();
		Motor.C.rotate(150);
		Delay.msDelay(1000);
		// allows claw to grab the ball
		Motor.B.rotate(25, true);
		Motor.C.rotate(25, true);
		Motor.A.rotateTo(-155);
		Motor.A.stop();
	}
	
	/**
	 * Place Light Balls in the Light Bin
	 * @Param N/A
	 * @Return N/A
	 */
	public static void placeLightBin() {
		Motor.C.stop();
		Motor.B.rotate(-170);
		Motor.B.stop();
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
