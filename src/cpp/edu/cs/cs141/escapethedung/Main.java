package cpp.edu.cs.cs141.escapethedung;

/**
 * CS141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #2
 *
 * This game is called Escape the Dungeon. The PLAYER
 * is supposed to take 10 steps to escape the dungeon with each step having a chance
 * to go against an enemy, who the player needs to defeat or run away from in order
 * to progress through the dungeon. The player needs to reach the exit before his or her's
 * hit points reaches zero.
 *
 * Ethan Liao
 */

/**
 * The start of Escape the Dungeon will be ran through
 * this class (Look at main method).
 * 
 * @author Ethan Liao
 */
public class Main 
{
	/**
	 * @param args
	 * This will create an ENGINE then will start the the ENGINE
	 * causing the console to pop up and starting a new game of
	 * Escape the Dungeon!
	 */
	public static void main(String[] args) 
	{
		UI ui = new UI(new ETDEngine());
		ui.playGame();
	}
}