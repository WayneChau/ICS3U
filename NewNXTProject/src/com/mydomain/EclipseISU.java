package com.mydomain;

import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * EclipseISU.java
 * This holds the array to run each individual class from least priority to most priority
 * @author Wayne Chau
 * June 06 2017
 */
public class EclipseISU {
	public static void main(String[] args){
		LightSensor light = new LightSensor(SensorPort.S1); //light sensor
		Behavior b1 = new EndProgram(); //ends program if button escape is pressed
		Behavior b2 = new DriveForward(light); //drives forward
		Behavior b3 = new LightSens(light); //picks up ball and place in bin for light balls
		Behavior b4 = new DarkSens(light); //picks up ball and place in bin for dark balls
		Behavior[] behaviors = {b2,b3,b4,b1}; //array from least priority to most priority
		Arbitrator arby = new Arbitrator(behaviors);
		Button.waitForAnyPress(); //program starts when button.ENTER is pressed
		arby.start(); //starts the program
	}
}
