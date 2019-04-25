
public class Pokedex {
	//	The driver program should have a menu loop with these options:
	//
	//		Catch Pokemon
	//		Add new Pokemon to the PokeTree
	//		Increase the count of number caught of a Pokemon already in the tree.
	//		Use your sub-menu from Assignment 4 or 5 to choose Pokemon
	//		Trade Pokemon
	//		Lower the quantity of a caught Pokemon in the PokeTree.
	//		Make sure you can't trade Pokemon you don't have! Caught quantity cannot become negative.
	//		Remove Pokemon from the tree that are all traded away.
	//		Use your sub-menu from Assignment 4 or 5 to choose Pokemon
	//		Print Pokedex
	//		Print all the Pokemon in the Pokedex ordered by number (inorder traversal) and how many of each have been caught.
	//		Quit
	/**
	 * This program lets you add Pokemon to an array,
	 * List the pokemon in the array,
	 * and exit the program.
	 * @param args are arguments passed in from command line
	 */
	
	private static PokeTree tree = new PokeTree();

	/**
	 * Main method lets each player pick a pokemon.
	 * @param args take in args from command line.
	 */
	public static void main(String [] args) {

		//menu text
		printMainMenu();
		System.out.println("----------");
		//adding a pokemon to a node
		Pokemon chosenPokemon;
		chosenPokemon = PokemonFactory.pickAPokemon();
		tree.add(chosenPokemon);
		
		tree.preorderPokeTree();
		
		chosenPokemon = PokemonFactory.pickAPokemon();
		tree.add(chosenPokemon);
		
		tree.preorderPokeTree();
		
		chosenPokemon = PokemonFactory.pickAPokemon();
		tree.add(chosenPokemon);
		
		tree.preorderPokeTree();
	}

	/**
	 * printChoices prints the menu for the user.
	 */
	public static void printMainMenu() {
		System.out.println("What would you like to do?");
		System.out.println("1. Catch Pokemon");
		System.out.println("2. Trade Pokemon");
		System.out.println("3. Print Pokedex");
		System.out.println("3. Quit");

	};
}
