package cpp.edu.cs.cs141.escapethedung;
import java.util.Random;

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
 * This class represents the ITEM DROPs in the game. The item drops can
 * either be a health pack which restores health to the player
 * or an ammo pack which restores ammo to the the player. Also,
 * this can display the information to the console.
 * 
 * @author Ethan Liao
 */
public class ItemDrop 
{
	/**
	 * This variable will determine whether or not the item is a health pack or an ammo pack.
	 */
	int itemDrop; // Health Pack = 1 | Ammo Pack = 2
	
	/**
	 * This constructor will create an ITEM DROP object. In this,
	 * the ITEM DROP object will be initiated; it will either be
	 * an ammo pack (higher chance) or a health pack.
	 */
	public ItemDrop()
	{
		Random rand = new Random();
		int randomDrop = rand.nextInt(100) + 1;
		if (randomDrop <= 30)
		{
			itemDrop = 1;
		}
		else
		{
			itemDrop = 2;
		}
	}
	
	/**
	 * This method will display the function of the item you just picked up.
	 */
	public void displayFunction()
	{
		if (itemDrop == 1)
		{
			System.out.print("You picked up a health pack. You gain 5 health!\n");
		}
		else
		{
			System.out.print("You picked up a mag. Your ammo is now maxed!\n");
		}
	}
	
	/**
	 * @return the number of the ITEM DROP.
	 */
	public int getNumber()
	{
		return itemDrop;
	}
}
