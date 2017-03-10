package chauelaridi;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import hsa_new.Console;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * ThePunishment.java 
 * February 27, 2017 
 * This program allows a player to play a choose your own adventure game.
 * @author Wayne Chau and Jana ElAridi
 */

public class ThePunishment {
	static Console c = new Console();

	public static void main(String[] args) {
		String usersName; // Stores user's name
		int randomNumber; // Stores a random number generated from 0-5 for the criminal wheel
		int userNumber; // Stores a number picked from 1-3 to see if they are free or not from prison
		String location1; // Stores a location either stairs or hallway
		String location2; // Stores a location either up or down the stairs
		String attackAnswer; // Stores an answer if they want to attack or don't attack the shadow
		String runAnswer; // Stores an answer if they want to run or don't run from prison
		String playAgain; // Stores an answer if they want to play again or quit
		int doorAnswer; // Stores a number 1 or 2 for which door the user want to go through
		String itemUse; // Item they want to use for the doors encountered
		String[] userItem = new String[3]; //Array for the items picked up
		int counter; // Stores number for the array
		String userItemTest; // Test the input for the array
		BufferedImage jpgImage = null; // image
		c.setTextColor(Color.white);
		c.setTextBackgroundColor(Color.black);
		c.clear();
		do{
			c.clear();
			Clip theme = null;
			try {
				//music theme for whole game
				theme = AudioSystem.getClip();
				theme.open(AudioSystem.getAudioInputStream(new File("Resource/horror.wav")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			theme.loop(Clip.LOOP_CONTINUOUSLY);
			try {
				jpgImage = ImageIO.read(new File("Resource/searcher.jpg"));
			} catch (IOException e) {
				System.err.println("There was an error loading the image.");
				e.printStackTrace();
			}
			c.drawImage (jpgImage, 0, 50, c.getWidth(), 450, null);
			c.println("Welcome to Profile Searcher.Please enter your name to proceed.");
			usersName = c.readLine();
			randomNumber = (int) (Math.random()*6); //Generate a random number from 0-5
			if (randomNumber == 2 || randomNumber == 3) {
				c.clear();
				try {
					jpgImage = ImageIO.read(new File("Resource/prison.jpg"));
				} catch (IOException e) {
					System.err.println("There was an error loading the image.");
					e.printStackTrace();
				}
				c.drawImage (jpgImage, 0, 160, c.getWidth(), 425, null);
				c.println("Warning! Our system claims that " + usersName + " is listed as a criminal who commited a\ncrime recently.");
				c.println("You spin the criminal wheel to discover your punishment");
				c.println("The number you spun resulted in you being sent to prison.");
				c.println("However, you're in luck. If you choose the right number, you have a chance to\nbe set free.");
				c.println("Choose a number from 1 to 3");
				userNumber = c.readInt();
				while (userNumber != 2 && userNumber != 1 && userNumber != 3){
					c.println("Try Again");
					userNumber = c.readInt();
				}
				if (userNumber == 3) {
					c.clear();
					try {
						jpgImage = ImageIO.read(new File("Resource/freedom.jpg"));
					} catch (IOException e) {
						System.err.println("There was an error loading the image.");
						e.printStackTrace();
					}
					c.drawImage (jpgImage, 0, 80, c.getWidth(), 450, null);
					c.println("Congratulations!You have choosen the right number!");
					c.println("You are set free and aquitted of all charges!");
				} 
				else if (userNumber == 2 || userNumber == 1){
					c.clear();
					try {
						jpgImage = ImageIO.read(new File("Resource/items.jpg"));
					} catch (IOException e) {
						System.err.println("There was an error loading the image.");
						e.printStackTrace();
					}
					c.drawImage (jpgImage, 0, 80,c.getWidth(), 400, null);
					c.println("Unfortunely the number choosen was not the number that will set you free.");
					c.println("You see 3 items. Which do you choose?");
					c.println("(Screwdriver/Set of keys/Sticky grenades)");
					counter = 0; // counter for array
					userItemTest = c.readLine();
					for (int i=0; i < 2; i++){ // for door #2 to pick up another item
						while (!userItemTest.equalsIgnoreCase("Screwdriver") && !userItemTest.equalsIgnoreCase("Set of keys") && !userItemTest.equalsIgnoreCase("Sticky grenades")){
							c.println("Try Again");
							userItemTest = c.readLine ();
						}
						if (userItemTest.equalsIgnoreCase("Screwdriver") || userItemTest.equalsIgnoreCase("Set of keys") || userItemTest.equalsIgnoreCase("Sticky grenades")){
							userItem [counter] = userItemTest;
							c.clear();
							try {
								jpgImage = ImageIO.read(new File("Resource/opencell.jpg"));
							} catch (IOException e) {
								System.err.println("There was an error loading the image.");
								e.printStackTrace();
							}
							c.drawImage (jpgImage, 0, 100, c.getWidth(), 450, null);
							c.println("A guard came up to your cell and opens up the prison cell to provide you with a hot meal.");
							c.println("As the door is wide open, do you attemp to make a run for it? (Run/Don't Run)");		
							runAnswer = c.readLine();
							while (!runAnswer.equalsIgnoreCase("Run") && !runAnswer.equalsIgnoreCase("Don't Run")){
								c.println("Try Again");
								runAnswer = c.readLine();
							}
							if (runAnswer.equalsIgnoreCase("Run")) {
								c.clear();
								try {
									jpgImage = ImageIO.read(new File("Resource/door.jpg"));
								} catch (IOException e) {
									System.err.println("There was an error loading the image.");
									e.printStackTrace();
								}
								c.drawImage (jpgImage, 0, 80, c.getWidth(), 450, null);
								c.println("You run out of the cell and encounter 2 doors.");
								c.println("Do you want to open door #1 or door #2? (1/2)");
								doorAnswer = c.readInt();
								while (doorAnswer != 1 && doorAnswer != 2){
									c.println("Try Again");
									doorAnswer = c.readInt();
								}
								if (doorAnswer == 1){
									c.clear();
									i = 2;
									try {
										jpgImage = ImageIO.read(new File("Resource/bag.jpg"));
									} catch (IOException e) {
										System.err.println("There was an error loading the image.");
										e.printStackTrace();
									}
									c.drawImage (jpgImage, 0, 100, c.getWidth(), 400, null);
									c.println("The door is stuck.");
									c.println("You decided to use an item you picked up");
									c.println("Which item do you want to use?");
									c.println("(Screwdriver/Set of keys/Sticky grenades)");
									itemUse = c.readLine();
									if (userItem[0].equalsIgnoreCase(itemUse) || userItem[1].equalsIgnoreCase(itemUse) || userItem[2].equalsIgnoreCase(itemUse)) {
										if (itemUse.equalsIgnoreCase("Screwdriver")){
											c.clear();
											try {
												jpgImage = ImageIO.read(new File("Resource/screws.jpg"));
											} catch (IOException e) {
												System.err.println("There was an error loading the image.");
												e.printStackTrace();
											}
											c.drawImage (jpgImage, 0, 100, c.getWidth(), 450, null);
											c.println("You use the screwdriver to open the cover of the door.");
											c.println("However you see over 10 000 bolts screwed on the inside cover.");
											c.println("You got caught RED HANDED!");
										}
										else if (itemUse.equalsIgnoreCase("Sticky grenades")){
											c.clear();
											try {
												jpgImage = ImageIO.read(new File("Resource/grenades.jpg"));
											} catch (IOException e) {
												System.err.println("There was an error loading the image.");
												e.printStackTrace();
											}
											c.drawImage (jpgImage, 0, 100, c.getWidth(), 400, null);
											c.println("You light the grenade.");
											c.println("As the grenade is a sticky grenade you couldn't get it off your hand.");
											c.println("Due to that, you got exploded to death. Shame on you!");
										}
										else {
											c.clear();
											try {
												jpgImage = ImageIO.read(new File("Resource/freedom1.jpg"));
											} catch (IOException e) {
												System.err.println("There was an error loading the image.");
												e.printStackTrace();
											}
											c.drawImage (jpgImage, 0, 100, c.getWidth(), 450, null);
											c.println("Ascess Granted!");
											c.println("You open the door to escape the prison!");			
										}
										if (!userItem[0].equalsIgnoreCase(itemUse) && !userItem[1].equalsIgnoreCase(itemUse) && !userItem[2].equalsIgnoreCase(itemUse)) {
											c.clear();
											try {
												jpgImage = ImageIO.read(new File("Resource/surrounded.jpg"));
											} catch (IOException e) {
												System.err.println("There was an error loading the image.");
												e.printStackTrace();
											}
											c.drawImage (jpgImage, 0, 100, c.getWidth(), 450, null);
											c.println("Sorry, you do not have that item.");
											c.println("You got surrounded before picking an item.");
										}
									}
								}
								else if (doorAnswer == 2) {
									c.clear();
									try {
										jpgImage = ImageIO.read(new File("Resource/items.jpg"));
									} catch (IOException e) {
										System.err.println("There was an error loading the image.");
										e.printStackTrace();
									}
									c.drawImage (jpgImage, 0, 100, c.getWidth(), 450, null);
									counter = counter ++;
									c.println("You find a passage to a airvent which leads you back into prison.");
									c.println("You see the same 3 items on the floor. Which do you choose?");
									c.println("(Screwdriver/Set of keys/Sticky grenades)");
									userItemTest = c.readLine();
									i = 0;
								}
							}
							else if (runAnswer.equalsIgnoreCase("Don't Run")){
								c.clear();
								i = 2;
								try {
									jpgImage = ImageIO.read(new File("Resource/prison.jpg"));
								} catch (IOException e) {
									System.err.println("There was an error loading the image.");
									e.printStackTrace();
								}
								c.drawImage (jpgImage, 0, 100, c.getWidth(), 450, null);
								c.println("You discover you are sentence to death for 300 years.");
							}
						}
					}
				}
			}
			else if (randomNumber == 4) {
				c.clear();
				try {
					jpgImage = ImageIO.read(new File("Resource/execution.jpg"));
				} catch (IOException e) {
					System.err.println("There was an error loading the image.");
					e.printStackTrace();
				}
				c.drawImage (jpgImage, 0, 100, c.getWidth(), 450, null);
				c.println("Warning! Our system claims that " + usersName + " is listed as a criminal who commited\na crime recently.");
				c.println("You spin the criminal wheel to discover your punishment");
				c.println("You have been sentence to execution.");
			}
			else if (randomNumber == 1 || randomNumber == 5 || randomNumber == 0){
				c.clear();
				try {
					jpgImage = ImageIO.read(new File("Resource/abandonedbuilding.jpg"));
				} catch (IOException e) {
					System.err.println("There was an error loading the image.");
					e.printStackTrace();
				}
				c.drawImage (jpgImage, 0, 170, c.getWidth(), 300, null);
				c.println("Warning! Our system claims that " + usersName + " is listed as a criminal who commited\na crime recently.");
				c.println("You spin the criminal wheel to discover your punishment");
				c.println("You have been directed to the abandon building. Legend has it that this\nlocation is haunted.");
				c.println("You hear a loud noise and you decide to check it out.");
				c.println("Do you want to go up the stairs or go down the hallway? (Hallway/Stairs)");
				location1 = c.readLine();
				while (!location1.equalsIgnoreCase("Hallway") && !location1.equalsIgnoreCase("Stairs")){
					c.println("Try Again");
					location1 = c.readLine();
				}
				if (location1.equalsIgnoreCase("Hallway")) {
					c.clear();
					try {
						jpgImage = ImageIO.read(new File("Resource/hallway.jpg"));
					} catch (IOException e) {
						System.err.println("There was an error loading the image.");
						e.printStackTrace();
					}
					c.drawImage (jpgImage, 0, 100, c.getWidth(), 450, null);
					c.println("You find a teleportation.");
					c.println("You enter and teleported back home safely.");
				}
				else if (location1.equalsIgnoreCase("Stairs")){
					c.clear();
					try {
						jpgImage = ImageIO.read(new File("Resource/Stairs.jpg"));
					} catch (IOException e) {
						System.err.println("There was an error loading the image.");
						e.printStackTrace();
					}
					c.drawImage (jpgImage, 0, 60, c.getWidth(), 450, null);
					c.println("You walk halfway up the stairs. You feel a tap on the shoulder.");
					c.println("Do you continue up the stairs or head back down? (Up/Down)");
					location2 = c.readLine();
					while (!location2.equalsIgnoreCase("Up") && !location2.equalsIgnoreCase("Down")){
						c.println("Try Again");
						location2 = c.readLine();
					}
					if (location2.equalsIgnoreCase("Up")) {
						c.clear();
						try {
							jpgImage = ImageIO.read(new File("Resource/demon.jpg"));
						} catch (IOException e) {
							System.err.println("There was an error loading the image.");
							e.printStackTrace();
						}
						c.drawImage (jpgImage, 0, 100, c.getWidth(), 450, null);
						c.println("You encounter a fierce demon who places you into a deep sleep.");
						c.println("Your body was placed in the depths of fire as a sacrifice to his ancestors");
					}
					else {
						c.clear();
						try {
							jpgImage = ImageIO.read(new File("Resource/shadow.jpg"));
						} catch (IOException e) {
							System.err.println("There was an error loading the image.");
							e.printStackTrace();
						}
						c.drawImage (jpgImage, 0, 100, c.getWidth(), 450, null);
						c.println("Suddenly, you see a shadow creeping in the darkness.");
						c.println("Your instincts urge you to grab your knife in your pocket and attack it.");
						c.println("Do you attack it? (Attack/Don't Attack)");
						attackAnswer = c.readLine();
						while (!attackAnswer.equalsIgnoreCase("Attack") && !attackAnswer.equalsIgnoreCase("Don't Attack")){
							c.println("Try Again");
							attackAnswer = c.readLine();
						}
						if (attackAnswer.equalsIgnoreCase("Attack")) {
							c.clear();
							try {
								jpgImage = ImageIO.read(new File("Resource/blood.jpg"));
							} catch (IOException e) {
								System.err.println("There was an error loading the image.");
								e.printStackTrace();
							}
							c.drawImage (jpgImage, 0, 70, c.getWidth(), 450, null);
							c.println("You attack the shadow and bright red blood splatters on your face.");
							c.println("As you feel acomplished, you step on the dead body as you move forward.");
							c.println("However, you notice the dress on a glimpse of your eyesight. The dress triggers\npast memories.");
							c.println("You turn around in shock as you realize it was your mother.");
							c.println("As she was your only option of survival, you were left trapped with no methods\nof escaping the abandon building");
						}
						else {
							c.clear();
							try {
								jpgImage = ImageIO.read(new File("Resource/boat.jpg"));
							} catch (IOException e) {
								System.err.println("There was an error loading the image.");
								e.printStackTrace();
							}
							c.drawImage (jpgImage, 0, 70, c.getWidth(), 450, null);
							c.println("You were lucky you didn't attack it. It was your mother you love so dearly.");
							c.println("Mother: I have spent countless of years searching for you. There is an escape route that I set up.");
							c.println("Mother: Come over here");
							c.println("She leads you to the ladder by removing a heavy book shelf.");
							c.println("Mother: Jump off the abandon building to get on the boat.");
							c.println("Rumor said that the Bermuda Triangle has a portal to another universe.");
							c.println("This universe holds greater potential towards a better life. Since your mother is a navigator you decide to make your escape towards the triangle.");
						}
					}
				}
			}
			c.println("Do you want to play again? (Yes/No)");
			playAgain = c.readLine();}while(playAgain.equalsIgnoreCase("Yes"));
		while (!playAgain.equalsIgnoreCase("Yes") && !playAgain.equalsIgnoreCase("No")){
			c.println("Try Again");
			playAgain = c.readLine();
		}
		if (playAgain.equalsIgnoreCase("No")) {
			c.println("Thanks for Playing!");
		}
	}
}
//Allows the user to play again





