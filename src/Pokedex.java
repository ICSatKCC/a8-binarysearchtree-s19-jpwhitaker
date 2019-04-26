import java.util.Scanner;

public class Pokedex {
	// The driver program should have a menu loop with these options:
	//
	// Catch Pokemon
	// Add new Pokemon to the PokeTree
	// Increase the count of number caught of a Pokemon already in the tree.
	// Use your sub-menu from Assignment 4 or 5 to choose Pokemon
	// Trade Pokemon
	// Lower the quantity of a caught Pokemon in the PokeTree.
	// Make sure you can't trade Pokemon you don't have! Caught quantity cannot
	// become negative.
	// Remove Pokemon from the tree that are all traded away.
	// Use your sub-menu from Assignment 4 or 5 to choose Pokemon
	// Print Pokedex
	// Print all the Pokemon in the Pokedex ordered by number (inorder traversal)
	// and how many of each have been caught.
	// Quit
	/**
	 * This program lets you add Pokemon to an array, List the pokemon in the array,
	 * and exit the program.
	 * 
	 * @param args are arguments passed in from command line
	 */

	private static PokeTree tree = new PokeTree();

	/**
	 * Main method lets each player pick a pokemon.
	 * 
	 * @param args take in args from command line.
	 */
	public static void main(String[] args) {
		int mainMenuChoice;
		boolean endLoop = false;
		Pokemon chosenPokemon;
		
		while(!endLoop) {
			mainMenuChoice = makeChoice();
			//catch pokemon
			if(mainMenuChoice == 1) {
				chosenPokemon = PokemonFactory.pickAPokemon();
				tree.add(chosenPokemon);
	//			System.out.println("Added "+ chosenPokemon.toString());
			}
			
			//trade pokemon
			if(mainMenuChoice == 2) {
				chosenPokemon = PokemonFactory.pickAPokemon(false);
				try {
					tree.remove(chosenPokemon);
				} catch (TreeException msg) {
					System.out.println("+----------------------------------------------------+");
					System.out.println("|  Sorry, you can't trade a Pokemon you don't have!  |");
					System.out.println("+----------------------------------------------------+");

				}
			}
			
			if(mainMenuChoice == 3) {
				tree.printPokeTree();
			}
			
			//exit
	        if(mainMenuChoice == 0) {
	       	 System.exit(0);
	        }
		}
		

	}
	
	
		/**
	    * makeChoice listens for user input.
	    * @return returns an integer choice 
	    * for use in selecting the pokemon to make.
	   */
	   public static Integer makeChoice() {
	      Scanner userIn = new Scanner(System.in);
	      boolean endLoop = false;
	      String inString = new String("");
	      Integer choice = -1;
	      
	      while (!endLoop) {
	         //menu text
	         printMainMenu();
	         //read in from user as a String -- much less errors can happen!
	         inString = userIn.nextLine();
	         //take off any spaces on the string
	         inString = inString.trim();
	         
	         //convert line to int.  if it is not an int, set to 0
	         //and ask user to enter a number again.
	         try {
	            choice = Integer.parseInt(inString);
	         } catch (NumberFormatException nfe) {
	            choice = -1;
	         }
	         

	         if (choice >= 0 && choice <= 3) {
	            endLoop = true;
	         }     
	      }
	      return choice;
	   }
	
	

	/**
	 * printChoices prints the menu for the user.
	 */
	public static void printMainMenu() {
		System.out.println();
		System.out.println("+------------------------------+");
		System.out.println("|  What would you like to do?  |");
		System.out.println("|  1. Catch Pokemon            |");
		System.out.println("|  2. Trade Pokemon            |");
		System.out.println("|  3. Print Pokedex            |");
		System.out.println("|  0. Quit                     |");
		System.out.println("+------------------------------+");
	};
}
