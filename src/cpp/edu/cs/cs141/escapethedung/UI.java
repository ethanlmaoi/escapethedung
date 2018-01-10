package cpp.edu.cs.cs141.escapethedung;

import java.util.Random;
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
 * This is the USER INTERFACE class and this is the most important class.
 * This holds most of the information to the game and will initiate certain
 * classes and methods whenever needed.
 * 
 * @author Ethan Liao
 */
public class UI 
{
	/**
	 * This variable represents an engine that will start the game.
	 */
	private ETDEngine game = null;
	
	/**
	 * This will allow the PLAYER to input into the console.
	 */
	private Scanner keyboard = null;
	
	/**
	 * This will represent a dungeon ( | _ _ _ _ _ _ _ _ _ _ | )
	 * Holds methods to display dungeon on the console.
	 */
	private Dungeon dungeon;
	
	/**
	 * This will represent a PLAYER's GUN.
	 * Holds the attributes of the certain type of gun the PLAYER has.
	 */
	private Gun playerGun;
	
	/**
	 * This will represent an ENEMY.
	 * Holds the attributes the ENEMY has such as health and the type of GUN.
	 */
	private Enemy enemy;
	
	/**
	 * This will keep track of the number of moves left the PLAYER has.
	 * Will be game over when this value reaches 10.
	 */
	private int moveTracker;
	
	/**
	 * @param game
	 * This constructor will generate a USER INTERFACE with the parameter needing an engine for the game.
	 * Also will initiate a Scanner which would allow the PLAYER to input actions into the console.
	 * Also, a dungeon will be created and the moveTracker will be set to 0.
	 */
	public UI(ETDEngine game)
	{
		this.game = game;
		keyboard = new Scanner(System.in);
		dungeon = new Dungeon();
		moveTracker = 0;
	}
	
	/**
	 * This method will basically start and play the game.
	 * Will print the welcome message, then carry the PLAYER through weapon selection.
	 * Introduce the DUNGEON, then continue through the game until the player wins or quits.
	 */
	public void playGame()
	{
		printWelcomeMsg();
		chooseWeapon();
		firstTimeShowDungeon();
		startSteps();
		win();
	}
	
	/**
	 * Will have an introduction, a fun storyline.
	 */
	public void printWelcomeMsg()
	{
		System.out.print("You: Huh?....\n");
		delay();
		delay();
		System.out.print("You: Where the heck am I?...\n\n");
		delay();
		delay();
		System.out.print("HEY YOU!\n\n");
		delay();
		System.out.print("You: Wha.. who said that?\n\n");
		delay();
		System.out.print("I am the EDWIN, THE DUNGEON MASTER.\n");
		delay();
		System.out.print("You have been thrown in this DUNGEON because you have been a very");
		delay();
		System.out.print(" VERY bad person.\n\n");
		delay();
		System.out.print("You: mb lmao\n\n");
		delay();
		System.out.print("If you escape this DUNGEON, you can have your sad, despicable life back.\n\n");
		delay();
		System.out.print("If not..");
		delay();
		System.out.print(" well you can rot in here xD\n\n");
		delay();
		delay();
		System.out.print("So, do you want to try and escape?\n\n");
		delay();
		System.out.print("1. Well..you leave me with no choice..\n2. Hell NAW!\n");
		escapeWelcome();
		delay();
		System.out.print("Press ENTER to continue\n");
		promptEnterKey();
	}
	
	/**
	 * This method is here so the PLAYER can't input another option.
	 */
	public void escapeWelcome()
	{
		while (!keyboard.hasNextInt()) 
		{
			   System.out.println("A number, please!\n");
			   keyboard.nextLine();
		}
		
		int option = keyboard.nextInt();
		
		if (option == 1)
		{
			System.out.print("Alright then.. don't die ;)\n\n");
		}
		else if (option == 2)
		{
			System.out.print("Well that's too bad. You're going to have to go through this dungeon anyways, so I can showcase my (not so) amazing CS skills.\n\n");
			delay();
			delay();
		}
		else
		{
			System.out.print("LMAO good try. That isn't an option\n\n");
			delay();
			System.out.print("So, do you want to try and escape?\n\n");
			delay();
			System.out.print("1. Well..you leave me with no choice..\n2. Hell NAW!\n\n");
			escapeWelcome();
		}
	}
	
	/**
	 * Will prompt the user to (PRESS ENTER TO CONTINUE)
	 */
	public void promptEnterKey()
	{
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	/**
	 * This method Will carry the PLAYER through weapon selection.
	 */
	public void chooseWeapon()
	{
		System.out.print("You can choose from a HUMOUNGOUS");
		delay();
		System.out.print(", EXTRAORDINARY");
		delay();
		System.out.print(", AWARD-WINNING");
		delay();
		System.out.print(" arsenal of 3 weapons.\n");
		delay();
		System.out.print("\nWhich weapon would you like?");
		delay();
		System.out.print("\n\n1. PISTOL\n2. RIFLE\n3. SHOTGUN\n\n");
		
		while (!keyboard.hasNextInt())
		{
			   System.out.println("A number, please!\n");
			   keyboard.nextLine();
		}
		int gunNumber = keyboard.nextInt();
		
		if (gunNumber > 3 || gunNumber < 0 || gunNumber != (int)gunNumber)
		{
			delay();
			System.out.print("\nI cannot give you that weapon!");
			chooseWeapon();
		}
		else
		{
			playerGun = new Gun(gunNumber);
			System.out.print("\nYou picked " + playerGun.getGunName() + " as your weapon!\n\n");
			delay();
		}
	}
	
	/**
	 * This method will introduce the DUNGEON and prompt the player to continue through the dungeon.
	 */
	public void firstTimeShowDungeon()
	{
		System.out.print("Here is the DUNGEON and your health and ammo!\n\n");
		delay();
		System.out.print("On the DUNGEON Display, YOU are the L.");
		delay();
		System.out.print(" Why an L, you ask?\n");
		delay();
		System.out.print("Well that's becau- "); 
		delay();
		System.out.print("never mind.\n\n");
		delay();
		displayHealthAmmo();
		dungeon.displayDungeon();
		System.out.print("Press ENTER to take a step through the DUNGEON\n");
	}
	
	/**
	 * This method will display the health and ammo every time the player does an action to the enemy.
	 */
	public void displayHealthAmmo()
	{
		System.out.print(game.displayHealth() + "   AMMO: "+ Integer.toString(playerGun.getGunAmmo()) + "\n\n");
	}
	
	/**
	 * This method will start the actual gameplay of the game.
	 * Will keep looping until the player wins or dies.
	 */
	public void startSteps()
	{
		boolean another = true;
		while (moveTracker < 10)
		{	
			Random rand = new Random();
			int randomEncounter = rand.nextInt(100) + 1;
			if (another)
			{
				System.out.print("\nTake a step, u won't :) \n");
				another = false;
			}
			else
			{
				System.out.print("\nTake another step :)");
			}
			promptEnterKey();
			
			if (randomEncounter <= 15)
			{
				enemy = new Enemy();
				fightEnemy();
			}
			else
			{
				moveTracker++;
				dungeon.takeNextStep();
				dungeon.displayDungeon();
			}
		}
	}
	
	/**
	 * This method will engage the PLAYER into battle with a new ENEMY
	 */
	public void fightEnemy()
	{
		System.out.print("You have engaged in battle with an ENEMY (5 HP) who has a " + (enemy.getGun()).getGunName() + "!\n\n");
		delay();
		battle();
	}
	
	/**
	 * This is the bread and butter for the battle between the PLAYER and the ENEMY.
	 * This method will keep looping until the ENEMY has 0 health or until the PLAYER dies.
	 */
	public void battle()
	{
		while (enemy.getHitPoints() > 0)
		{
			System.out.print("Do you want to:\n\n1. Shoot\n2. Try to Escape\n\n");
			
			while (!keyboard.hasNextInt()) 
			{
				   System.out.println("A number, please!\n");
				   keyboard.nextLine();
			}
			int choice = keyboard.nextInt();
			if (choice == 1)
			{
				playerGun.checkAmmo();
				if (playerGun.checkLoaded())
				{
					playerGun.useAmmo();
				}
				else
				{
					System.out.print("You have no ammo left in your " + playerGun.getGunName() + ". That leaves you with only one other option...\n");
					battle();
				}
				Random rand = new Random();
				int randomHit = rand.nextInt(100) + 1;
			
				if (randomHit <= playerGun.getGunAccuracy())
				{
					enemy.takeDamage(playerGun.getGunDamage());
					System.out.print("You shot the ENEMY for " + Integer.toString(playerGun.getGunDamage()) + " damage!\n");
					delay();
					System.out.print("The ENEMY now has " + Integer.toString(enemy.getHitPoints()) + " health.\n\n");
					if (checkEnemyAlive())
					{
						enemyAttack();
					}
					else
					{
						break;
					}
				}
				else
				{
					System.out.print("You missed!\n\n");
					enemyAttack();
				}
			}
			else if (choice == 2)
			{
				System.out.print("You are trying to escape...\n\n");
				delay();
			
				Random rand = new Random();
				int randomEscape = rand.nextInt(100) + 1;
			
				if (randomEscape <= 10)
				{
					System.out.print("You have escaped!\n");
					dungeon.goBackStep();
					moveTracker--;
					startSteps();
				}
				else
				{
					System.out.print("LOL NICE TRY, you failed to escape. The battle continues!\n\n");
					enemyAttack();
				}
			}	
		}
	}
	
	/**
	 * This method will cause the ENEMY to attack the PLAYER.
	 * The damage done to the PLAYER depends on the type of GUN the ENEMY has.
	 */
	public void enemyAttack()
	{
		delay();
		Random rand = new Random();
		int randomHitE = rand.nextInt(100) + 1;
		if (randomHitE <= (enemy.getGun()).getGunAccuracy())
		{
			game.playerTakeDamage(enemy.getGun().getGunDamage());
			System.out.print("The ENEMY shot the player for " + Integer.toString((enemy.getGun()).getGunDamage()) + " damage!\n\n");
			delay();
			checkPlayerAlive();
			if (game.getHealth() > 0)
			{
				displayHealthAmmo();
			}
		}
		else
		{
			System.out.print("The ENEMY shot.. and missed the Player!\n\n");
			delay();
			displayHealthAmmo();
			battle();
		}
	}
	
	/**
	 * @return whether or not the enemy is alive
	 * This method will also give the PLAYER a random drop that can
	 * either be a health pack or an ammo pack.
	 */
	public boolean checkEnemyAlive()
	{
		if (enemy.getHitPoints() < 1)
		{
			System.out.print("You killed the enemy!\n");
			delay();
			ItemDrop itemDrop = new ItemDrop();
			itemDrop.displayFunction();
			delay();
			if (itemDrop.getNumber() == 1)
			{
				game.replenishHealth();
			}
			else
			{
				playerGun.replenishAmmo();
			}
			return false;
		} 	
		else
		{
			return true;
		}
	}
	
	/**
	 * This method will check if the player is alive or not.
	 */
	public void checkPlayerAlive()
	{
		if (game.getHealth() < 1)
		{
			gameOver();
		}
	}
	
	/**
	 * This method when called means that the PLAYER successfully went through the
	 * DUNGEON without dying.
	 */
	public void win()
	{
		moveTracker = 0;
		resetGame();
		delay();
		System.out.print("\nYou have successfully escaped the Dungeon! You can have your sad sad life back!\n\n");
		delay();
		winChoice();
	}
	
	/**
	 * This will offer the player a choice to Play Again or Quit
	 */
	public void winChoice()
	{
		System.out.print("I triple dare you to re-enter tho :^)\n\n1. Yes\n2. Nah\n");
		
		while (!keyboard.hasNextInt()) 
		{
			   System.out.println("A number, please!\n");
			   keyboard.nextLine();
		}
		int choice = keyboard.nextInt();
		if (choice == 1)
		{
			playGame();
		}
		else if (choice == 2)
		{
			System.out.print("Thanks for playing!");
		}
		else
		{
			System.out.print("That is not an option!");
			delay();
			winChoice();
		}
	}
	
	/**
	 * This method when called means that the PLAYER died before he or she reached the exit.
	 */
	public void gameOver()
	{
		resetGame();
		dungeon.dungeonReset();
		delay();
		System.out.print("You have been killed...\n\n");
		delay();
		gameOverChoice();
	}
	
	/**
	 * This will offer the player a choice to Play Again or Quit
	 */
	public void gameOverChoice()
	{
		System.out.print("Play Again?\n\n1. Yes\n2. I hate this game\n");
		
		while (!keyboard.hasNextInt()) 
		{
			   System.out.println("A number, please!\n");
			   keyboard.nextLine();
		}
		int choice = keyboard.nextInt();
		if (choice == 1)
		{
			playGame();
		}
		else if (choice == 2)
		{
			System.out.print("Nice Rage Quit!");
			doNothing();
		}
		else
		{
			System.out.print("That is not an option!");
			delay();
			gameOverChoice();
		}
	}
	
	/**
	 * This will reset the game, give a new DUNGEON and replenish health and ammo.
	 */
	public void resetGame()
	{
		dungeon.dungeonReset();
		playerGun.replenishAmmo();
		game.resetHitPoints();
	}
	
	/**
	 * This does nothing, forever :P
	 */
	public void doNothing()
	{
		for (int i = 1; i > 0; i++)
		{
			System.out.print("");
		}
	}
	
	public void checkInt( )
	{
		
	}
	/**
	 * This method inserts a delay between two lines of code.
	 * This is to prevent information from being displayed in large chunks.
	 */
	public void delay()
	{
		try
		{
			Thread.sleep(1250);
		}
		catch (InterruptedException ex)
		{
			// do nothing
		}
	}
}