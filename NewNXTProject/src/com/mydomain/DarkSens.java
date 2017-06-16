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

	public DarkSens(LightSensor ls){
		this.light = ls;
	}
	
	@Override
	public boolean takeControl() {
		if (light.getLightValue() < 20 ) {
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		suppressed = false;
		light.getLightValue();
		if (!suppressed) { 
			//execute methods
			pickupBalls();
			Delay.msDelay(1000);
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
		Motor.C.rotate(165);
		Motor.C.stop();
		Delay.msDelay(1000);
		//allows claw to grab the ball
		Motor.B.rotate(25, true);
		Motor.C.rotate(25, true);
		Motor.A.rotateTo(-155);
		Motor.A.stop();
	}

	/**
	 * Place Dark Balls in the Dark Bin
	 * @Param N/A
	 * @Return N/A
	 */
	public static void placeDarkBin() {
		Motor.C.stop();
		Motor.C.rotate(-165); //position to starting position
		Motor.B.rotate(360); //position to bin line
		Motor.B.forward();
		Motor.C.forward();
		Delay.msDelay(2000);
		Motor.A.rotate(155);
	}

	/**
	 * Rotates back towards the pile of Balls
	 * @Param N/A
	 * @Return N/A
	 */
	public static void rotateAround() {
		Motor.C.stop();
		Motor.B.rotate(720); //rotates 180 degrees
		Motor.C.forward();
		Motor.B.forward();
		Motor.C.rotate(360); //position towards pile of balls
		Delay.msDelay(2000);
	}
}
