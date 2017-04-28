package chau;

import java.util.Scanner;

/**
 * @author 323843193
 *
 */
public class Life {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of living cells you wish to enter");
		int livingCells = sc.nextInt();
		int[][] liveWorld = new int[20][20];
		while (livingCells > 400) {
			System.out.println("Please enter the number of living cells that is less than or equal to 400");
			livingCells = sc.nextInt();
		}
		for (int i = 0; i < livingCells; i++) {
			System.out.println("Please enter the coordinates in rows followed by columns seperated by a space.(X Y)");
			int rowCell = sc.nextInt();
			int columnCell = sc.nextInt();
			while (rowCell >= 20 || columnCell >= 20) {
				System.out.println(
						"Life World is a 20 by 20 grid. Please enter the coordinates from 0-19 for x and y seperated by a space. (X Y)");
				rowCell = sc.nextInt();
				columnCell = sc.nextInt();
			}
			liveWorld[rowCell][columnCell] = 1;
		}
		for (int i = 0; i < liveWorld.length; i++) {
			for (int j = 0; j < liveWorld.length; j++) {
				System.out.print(liveWorld[i][j]);
				if (j == 19) {
					System.out.println(liveWorld[i][j]);
				}
			}
		}
		boolean nextDay = true;
		int counter = 0;
		int alive = livingCells;
		for (int day = 1; nextDay == true; day++) {
			int[][] newWorld = new int [20][20];
			for(int i = 0; i < 20; i ++){
				for(int k = 0; k < 20; k ++){
					newWorld[i][k] = 0;
				}
			}
			counter = 0;
			System.out.println("Do you want to want to continue to the next day? (True/False)");
			nextDay = sc.nextBoolean();
				for (int i = 0; i < liveWorld.length; i++) {
					counter = 0;
					for (int j = 0; j < liveWorld.length; j++) {
						// check top outer layer
						if (i == 0) {
							if (liveWorld[i][j] == 1) {
								// check within the outer layer
								if ((j > 0) && (j < 19)) {
									counter = 0;
									// bottom
									if (liveWorld[i + 1][j] == 1) {
										counter++;
									}
									// bottom left
									if (liveWorld[i + 1][j - 1] == 1) {
										counter++;
									}
									// bottom right
									if (liveWorld[i + 1][j + 1] == 1) {
										counter++;
									}
									if (counter != 2 || counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 2 || counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
								// check left corner
								if (j == 0) {
									counter = 0;
									// bottom
									if (liveWorld[i + 1][j] == 1) {
										counter++;
									}
									// bottom right
									if (liveWorld[i + 1][j + 1] == 1) {
										counter++;
									}
									// right
									if (liveWorld[i][j + 1] == 1) {
										counter++;
									}
									if (counter != 2 || counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 2 || counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
								if (j == 19) {
									counter = 0;
									// bottom
									if (liveWorld[i + 1][j] == 1) {
										counter++;
									}
									// bottom left
									if (liveWorld[i + 1][j - 1] == 1) {
										counter++;
									}
									// left
									if (liveWorld[i][j - 1] == 1) {
										counter++;
									}
									if (counter != 2 || counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 2 || counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
							}
							if (liveWorld[i][j] == 0) {
								// check within the outer layer
								if ((j > 0) && (j < 19)) {
									counter = 0;
									// bottom
									if (liveWorld[i + 1][j] == 1) {
										counter++;
									}
									// bottom left
									if (liveWorld[i + 1][j - 1] == 1) {
										counter++;
									}
									// bottom right
									if (liveWorld[i + 1][j + 1] == 1) {
										counter++;
									}
									if (counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
								// check left corner
								if (j == 0) {
									counter = 0;
									// bottom
									if (liveWorld[i + 1][j] == 1) {
										counter++;
									}
									// bottom right
									if (liveWorld[i + 1][j + 1] == 1) {
										counter++;
									}
									// right
									if (liveWorld[i][j + 1] == 1) {
										counter++;
									}
									if (counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
								if (j == 19) {
									counter = 0;
									// bottom
									if (liveWorld[i + 1][j] == 1) {
										counter++;
									}
									// bottom left
									if (liveWorld[i + 1][j - 1] == 1) {
										counter++;
									}
									// left
									if (liveWorld[i][j - 1] == 1) {
										counter++;
									}
									if (counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
							}
						}
						// check inside the grid
						if ((i > 0) && (i < 19) && (j > 0) && (j < 19)) {
							if (liveWorld[i][j] == 1) {
								counter = 0;
								// check diagonally
								if (liveWorld[i + 1][j + 1] == 1) {
									counter++;
								}
								if (liveWorld[i - 1][j - 1] == 1) {
									counter++;
								}

								if (liveWorld[i + 1][j - 1] == 1) {
									counter++;
								}
								if (liveWorld[i - 1][j + 1] == 1) {
									counter++;
								}
								// check vertically and horizontally
								if (liveWorld[i][j + 1] == 1) {
									counter++;
								}
								if (liveWorld[i][j - 1] == 1) {
									counter++;
								}
								if (liveWorld[i + 1][j] == 1) {
									counter++;
								}
								if (liveWorld[i - 1][j] == 1) {
									counter++;
								}
								if (counter != 2 || counter != 3) {
									newWorld[i][j] = 0;
									alive--;
								} else if (counter == 2 || counter == 3) {
									newWorld[i][j] = 1;
									alive++;
								}
							}
							if (liveWorld[i][j] == 0) {
								counter = 0;
								// check diagonally
								if (liveWorld[i + 1][j + 1] == 1) {
									counter++;
								}
								if (liveWorld[i - 1][j - 1] == 1) {
									counter++;
								}
								if (liveWorld[i + 1][j - 1] == 1) {
									counter++;
								}
								if (liveWorld[i - 1][j + 1] == 1) {
									counter++;
								}
								// check vertically and horizontally
								if (liveWorld[i][j + 1] == 1) {
									counter++;
								}
								if (liveWorld[i][j - 1] == 1) {
									counter++;
								}
								if (liveWorld[i + 1][j] == 1) {
									counter++;
								}
								if (liveWorld[i - 1][j] == 1) {
									counter++;
								}
								if (counter != 3) {
									newWorld[i][j] = 0;
									alive--;
								} else if (counter == 3) {
									newWorld[i][j] = 1;
									alive++;
								}
							}
						}
						// check bottom outer layer
						if (i == 19) {
							if (liveWorld[i][j] == 1) {
								// check excluding outer layer
								if ((j > 0) && (j < 19)) {
									counter = 0;
									// top
									if (liveWorld[i - 1][j] == 1) {
										counter++;
									}
									// top left
									if (liveWorld[i - 1][j - 1] == 1) {
										counter++;
									}
									// top right
									if (liveWorld[i - 1][j + 1] == 1) {
										counter++;
									}
									if (counter != 2 || counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 2 || counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
								if (j == 0) {
									counter = 0;
									// top
									if (liveWorld[i - 1][j] == 1) {
										counter++;
									}
									// top right
									if (liveWorld[i - 1][j + 1] == 1) {
										counter++;
									}
									// left
									if (liveWorld[i][j + 1] == 1) {
										counter++;
									}
									if (counter != 2 || counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 2 || counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
								if (j == 19) {
									counter = 0;
									// top
									if (liveWorld[i - 1][j] == 1) {
										counter++;
									}
									// top left
									if (liveWorld[i - 1][j - 1] == 1) {
										counter++;
									}
									// right
									if (liveWorld[i][j - 1] == 1) {
										counter++;
									}
									if (counter != 2 || counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 2 || counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
							}
							if (liveWorld[i][j] == 0) {
								// check excluding outer layer
								if ((j > 0) && (j < 19)) {
									counter = 0;
									// top
									if (liveWorld[i - 1][j] == 1) {
										counter++;
									}
									// top left
									if (liveWorld[i - 1][j - 1] == 1) {
										counter++;
									}
									// top right
									if (liveWorld[i - 1][j + 1] == 1) {
										counter++;
									}
									if (counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
								if (j == 0) {
									counter = 0;
									// top
									if (liveWorld[i - 1][j] == 1) {
										counter++;
									}
									// top right
									if (liveWorld[i - 1][j + 1] == 1) {
										counter++;
									}
									// right
									if (liveWorld[i][j + 1] == 1) {
										counter++;
									}
									if (counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
								if (j == 19) {
									counter = 0;
									// top
									if (liveWorld[i - 1][j] == 1) {
										counter++;
									}
									// top left
									if (liveWorld[i - 1][j - 1] == 1) {
										counter++;
									}
									// right
									if (liveWorld[i][j - 1] == 1) {
										counter++;
									}
									if (counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
							}
						}
						// check left outer layer
						if (j == 0) {
							if (liveWorld[i][j] == 1) {
								if ((i > 0) && (i < 19)) {
									counter = 0;
									// right
									if (liveWorld[i][j + 1] == 1) {
										counter++;
									}
									// top right
									if (liveWorld[i - 1][j + 1] == 1) {
										counter++;
									}
									// bottom right
									if (liveWorld[i + 1][j + 1] == 1) {
										counter++;
									}
									if (counter != 2 || counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 2 || counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
							}
							if (liveWorld[i][j] == 0) {
								if ((i > 0) && (i < 19)) {
									counter = 0;
									// right
									if (liveWorld[i][j + 1] == 1) {
										counter++;
									}
									// top right
									if (liveWorld[i - 1][j + 1] == 1) {
										counter++;
									}
									// bottom right
									if (liveWorld[i + 1][j + 1] == 1) {
										counter++;
									}
									if (counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
							}
						}
						// check right outer layer
						if (j == 19) {
							if (liveWorld[i][j] == 1) {
								if ((i > 0) && (i < 19)) {
									counter = 0;
									// left
									if (liveWorld[i][j - 1] == 1) {
										counter++;
									}
									// top left
									if (liveWorld[i - 1][j - 1] == 1) {
										counter++;
									}
									// bottom left
									if (liveWorld[i + 1][j - 1] == 1) {
										counter++;
									}
									if (counter != 2 || counter != 3) {
										newWorld[i][j] = 0;
										alive--;
									} else if (counter == 2 || counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
							}
							if (liveWorld[i][j] == 0) {
								if ((i > 0) && (i < 19)) {
									counter = 0;
									// left
									if (liveWorld[i][j - 1] == 1) {
										counter++;
									}
									// top left
									if (liveWorld[i - 1][j - 1] == 1) {
										counter++;
									}
									// bottom left
									if (liveWorld[i + 1][j - 1] == 1) {
										counter++;
									}
									if (counter != 3) {
										 newWorld[i][j] = 0;
										 alive--;
									} else if (counter == 3) {
										newWorld[i][j] = 1;
										alive++;
									}
								}
							}
						}
					}	
				}
				liveWorld = newWorld;
				for (int i = 0; i < liveWorld.length; i++) {
					for (int j = 0; j < liveWorld.length; j++) {
						System.out.print(liveWorld[i][j]);
						if (j == 19) {
							System.out.println(liveWorld[i][j]);
						}
					}
				}
			}
		}
	}

