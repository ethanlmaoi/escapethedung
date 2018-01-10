package cpp.edu.cs.cs141.escapethedung;

/**
 * CS141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #2
 *
 * This assignment is a mini game called Escape the Dungeon. The PLAYER
 * is supposed to take 10 steps to escape the dungeon with each step having a chance
 * to go against an enemy, who the player needs to defeat or run away from in order
 * to progress through the dungeon. The player needs to reach the exit before his or her's
 * hit points reaches zero.
 *
 * Ethan Liao
 */

/**
 * This class is the DUNGEON. The DUNGEON keeps track of the number of steps
 * the player. The DUNGEON is created with the number of steps (10) and is able
 * to display information (current state of the dungeon along with 
 * the location of the Player) into the console.
 * 
 * @author Ethan Liao
 */
public class Dungeon 	
{
	/**
	 * This variable will assist the display DUNGEON method by keeping track
	 * of where the PLAYER is (L)
	 */
	private int step;
	
	/**
	 * This boolean will always be TRUE as long as the PLAYER isn't on the last step.
	 * Keeps track of when the game is still in progress.
	 */
	private boolean notlastStep = true;
	
	/**
	 * This constructor creates a DUNGEON.
	 * A DUNGEON will always be created with 10 steps.
	 */
	public Dungeon()
	{
		step = 10;
	}
	
	/**
	 * This method, when called, will print out the currect state of the DUNGEON.
	 * Usually called out when the PLAYER takes a step.
	 */
	public void displayDungeon()
	{
		System.out.print("|");
		for (int i = 0; i < 10; i++)
		{
				if (i == 10 - step)
				{
					System.out.print("L ");
				}
				else
				{
					System.out.print("_ ");
				}
			}
			System.out.print("|\n");
			delay();
	}
	
	/**
	 * This method will have the PLAYER (L) take a step.
	 */
	public void takeNextStep()
	{
		step--;
	}
	
	/**
	 * This method will have the PLAYER (L) go back a step.
	 */
	public void goBackStep()
	{
		step++;
	}
	
	/**
	 * This method will cause the DUNGEON to reset and set steps equals to 10.
	 * Usually called at the end of the game when the PLAYER wants to play again.
	 */
	public void dungeonReset()
	{
		step = 10;
	}
	
	/**
	 * This method inserts a delay between two lines of code.
	 * This is to prevent information from being displayed in large chunks.
	 */
	public void delay()
	{
		try
		{
			Thread.sleep(900);
		}
		catch (InterruptedException ex)
		{
			// do nothing
		}
	}
}
