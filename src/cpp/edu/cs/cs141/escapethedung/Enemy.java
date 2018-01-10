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
 * This class represents the ENEMY. An enemy will always spawn
 * with a random weapon initiated in the constructor. The enemy will
 * also spawn with 5 health points. This class can also cause the
 * enemy to take damage.
 * 
 * @author Ethan Liao
 */
public class Enemy 
{
	/**
	 * Every ENEMY needs a weapon, which will damage the player.
	 * There is a certain % chance for each weapon.
	 */
	private Gun enemyGun;
	
	/**
	 * This variable will be initiated in the constructor.
	 * Assigned a variable 1-3.
	 */
	private int enemyGunNumber;
	
	
	/**
	 * This variable represents the amt of health the ENEMY has.
	 */
	private int enemyHitPoints;
	
	/**
	 * This constructor will create an enemy.
	 * Every new ENEMY will have 5 health points along with
	 * a random weapon. 50% - Pistol (1) | 35% - Rifle (2) | 15% - Shotgun(3)
	 */
	public Enemy()
	{
		enemyHitPoints = 5;
		
		Random rand = new Random();
		enemyGunNumber = rand.nextInt(100) + 1;
		
		if (enemyGunNumber <= 50)
		{
			enemyGun = new Gun(1);
		}
		else if (enemyGunNumber > 50 && enemyGunNumber <= 85)
		{
			enemyGun = new Gun(2);
		}
		else
		{
			enemyGun = new Gun(3);
		}
	}
	
	/**
	 * @return the GUN Object associated with ENEMY.
	 */
	public Gun getGun()
	{
		return enemyGun;
	}
	
	/**
	 * @return the ENEMY's health points.
	 */
	public int getHitPoints()
	{
		return enemyHitPoints;
	}
	
	/**
	 * @param damage
	 * This method will have the enemy receive a certain amount of damage specified in the parameters.
	 */
	public void takeDamage(int damage)
	{
		enemyHitPoints = enemyHitPoints - damage;
	}
}