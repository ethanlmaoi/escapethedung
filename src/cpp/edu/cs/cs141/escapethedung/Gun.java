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
 * This class represents the GUNs in the game. The player will
 * have a gun chosen at the beginning of the game and the enemy will
 * always spawn with a random GUN. This class holds all the attributes
 * of the GUN and will check if it is loaded.
 * @author Ethan
 */
public class Gun
{
	/**
	 * This variable will determine which type of gun the GUN class is. 
	 */
	private int gun;
	
	/**
	 * This will give the GUN a name.
	 */
	private String gunName;
	
	/**
	 * This variable will determine the GUN's accuracy.
	 */
	private int gunAccuracy;
	
	/**
	 * This variable will determine the GUN's damage.
	 */
	private int gunDamage;
	
	/**
	 * This variable will determine the GUN's ammo.
	 */
	private int gunAmmo;
	
	/**
	 * This variable will hold the GUN's max ammo.
	 */
	private int gunMaxAmmo;
	
	/**
	 * This boolean will check if the gun is loaded. Turns false if ammo hits 0.
	 */
	private boolean gunLoaded = true;
	
	/**
	 * @param gunNumber
	 * This constructor will create a GUN object. There are three types of gun
	 * and each gun has attributes: name, accuracy, damage, ammo, and max ammo.
	 * Below is a list of weapons along with the descriptions of the weapons.
	 * 1 - PISTOL | Accuracy: 75% | Damage: 1 | Ammo: 15 | Max Ammo: 15
	 * 2 - RIFLE | Accuracy: 65% | Damage: 2 | Ammo: 10 | Max Ammo: 10
	 * 3 - SHOTGUN | Accuracy: 40% | Damage: 5 | Ammo: 5 | Max Ammo: 5
	 */
	public Gun(int gunNumber)
	{
		gun = gunNumber;
		if (gunNumber == 1)
		{
			gunName = "PISTOL";
			gunAccuracy = 75;
			gunDamage = 1;
			gunAmmo = 15;
			gunMaxAmmo = 15;
		}
		else if (gunNumber == 2)
		{
			gunName = "RIFLE";
			gunAccuracy = 65;
			gunDamage = 2;
			gunAmmo = 10;
			gunMaxAmmo = 10;

		}
		else if (gunNumber == 3)
		{
			gunName = "SHOTGUN";
			gunAccuracy = 40;
			gunDamage = 5;
			gunAmmo = 5;
			gunMaxAmmo = 5;
		}
	}
	
	/**
	 * @return the name of the GUN.
	 */
	public String getGunName()
	{
		return gunName;
	}
	
	/**
	 * @return the accuracy of the GUN.
	 */
	public int getGunAccuracy()
	{
		return gunAccuracy;
	}
	
	/**
	 * @return the damage the GUN will deal.
	 */
	public int getGunDamage()
	{
		return gunDamage;
	}
	
	/**
	 * @return the ammo the GUN currently has.
	 */
	public int getGunAmmo()
	{
		return gunAmmo;
	}
	
	/**
	 * This method will reduce the current ammo in the GUN by 1.
	 */
	public void useAmmo()
	{
		gunAmmo--;
	}
	
	/**
	 * This method will replenish the ammo inside GUN to the max ammo it can hold.
	 */
	public void replenishAmmo()
	{
		gunAmmo = gunMaxAmmo;
	}
	
	/**
	 * @return the max ammo a GUN can hold.
	 */
	public int getMaxAmmo()
	{
		return gunMaxAmmo;
	}
	
	/**
	 * Will check if there is ammo inside the GUN.
	 */
	public void checkAmmo()
	{
		if (gunAmmo < 1)
		{
			gunLoaded = false;
		}
	}
	
	/**
	 * @return will check if the GUN is loaded with ammo.
	 */
	public boolean checkLoaded()
	{
		return gunLoaded;
	}
}
