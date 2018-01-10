package cpp.edu.cs.cs141.escapethedung;

import java.util.Scanner;

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
 * This class represents the ENGINE of the game and is
 * the entity that represents an instance of the game. 
 * The ENGINE Keeps track of the player's hit points (along with
 * methods to modify the hit points) and a method
 * to display the health in the console.
 * 
 * @author Ethan Liao
 */
public class ETDEngine 
{
	
	/**
	 * This Scanner will allow the PLAYER to input inside the console.
	 */
	private Scanner keyboard = null;
	
	/**
	 * This variable represents the amount of hit points the player has.
	 */
	private int playerHitPoints;
	
	/**
	 * This constructor will create an ENGINE which will initiate the
	 * player with 20 hit points. Will also initialize the Scanner.
	 */
	public ETDEngine()
	{
		playerHitPoints = 20;
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * @return the current player's hit points.
	 */
	public int getHealth()
	{
		return playerHitPoints;
	}
	
	/**
	 * @return a String which contains information to the Player's health.
	 */
	public String displayHealth() 
	{
		return "HEALTH: " + Integer.toString(playerHitPoints);
	}
	
	/**
	 * @param damage
	 * A method that causes the player to lose health points which
	 * depends on the damage inserted in the parameters.
	 */
	public void playerTakeDamage(int damage)
	{
		playerHitPoints = playerHitPoints - damage;
	}
	
	/**
	 * A method that causes the PLAYER to gain 5 hit points.
	 */
	public void replenishHealth()
	{
		playerHitPoints+=5;
	}
	
	/**
	 * A method that resets the PLAYER's health to 20.
	 */
	public void resetHitPoints()
	{
		playerHitPoints = 20;
	}
}
