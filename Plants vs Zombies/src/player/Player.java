package player;
import java.util.Scanner;
import run.Level;

/** 
 * @author Jolar Tabungar
 * 
 *  Player class is responsible for all player input and actions
 *
 */
public class Player {
	
	//The player's suntotal
	private int sunTotal;
	//The player's level
	private Level level;
	//Reads the player input
	private Scanner reader;
	
	/**
	 * Constructs a player with the given level
	 * @param level
	 */
	public Player(Level level) {
		this.level = level;
		//Starting suntotal
		sunTotal = 100; 
		reader = new Scanner(System.in);
	}
	
	/**
	 * Requests the users input for his/her move
	 * Ex. > place sunflower 2 3; places a sunflower at (2, 3) if enough sun is available
	 * 	   > remove 2 3; removes plant at 2 3
	 */
	public void getPlayerAction() {
		printHelp();
						 
		System.out.print("> ");
		String input = reader.nextLine();
		
		String action = null;
		String plantType = null;
		int xPos = 0;
		int yPos = 0;
		
		//Break up the input into parts
		Scanner tokenizer = new Scanner(input);
		
		if (tokenizer.hasNext()) {
			//Read the first word, the action word
            action = tokenizer.next();      
            //If action is place
            if(tokenizer.hasNext() && action.equals("place")) {
            	//Get the plant type to be placed
                plantType = tokenizer.next();    
            }
            
            //Get the x and y coordinates of placement
            if (tokenizer.hasNext()) {
            	
            	xPos = Integer.parseInt(tokenizer.next());
            	yPos = Integer.parseInt(tokenizer.next());
            }
            
        }
		
		tokenizer.close();
		
		//If action is place, tell level to add the plant
		if (action.equals("place")) {
			//If placement was successful, then nothing else happens
			if (level.addPlant(plantType, xPos, yPos));
			//Else, not enough sun message is printed
			else {
				System.out.println("Not enough sun.");
				getPlayerAction();
			}
		} 
		
		//Else if, action is remove, so remove the plant
		else if (action.equals("remove")) {
			level.removePlant(xPos,yPos);
		}
		
		//Else if, action is skip, so do nothing
		else if (action.equals("skip"));
		
		else if (action.equals("help")) {
			printHelp();
		}
		
		else if (action.equals("types")) {
			printTypes();
		}
		
		//Else move is not accepted, input error
		else {
			System.out.println("Error. Incorrect input of move.");
		}
		
	}
	
	/**
	 * Prints the plant types the user can place
	 */
	public void printTypes() {
		System.out.println(
				"----------------------------------" +
				"Plant Types: " +
				"sunflower = " + SUNFLOWER_BUYTHRESHOLD + " sun" +
				"peashooter = " + PEASHOOTER_BUYTHRESHOLD + " sun");
	}
	
	/**
	 * Prints the list of player commands
	 */
	public void printHelp() {
		System.out.println(
				"----------------------------------" +
				"Commands:\n" + 
				"place plantType x y\n" +
				"remove x y\n" +
				"skip\n" +
				"types\n" +
				"help\n" +
				"----------------------------------"
				);
	}
	
	/**
	 * @return the current suntotal of player
	 */
	public int getSunTotal() {
		return sunTotal;
	}
	
	/**
	 * Sets the suntotal of the player
	 * @param newtotal the new suntotal of the player
	 */
	public void setSunTotal(int newtotal) {
		sunTotal = newtotal;
	}
}
