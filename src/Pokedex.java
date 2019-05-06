import java.util.Scanner;

/**
* Pokedex driver class to run app.
* @author JP Whitaker
* @since 4/20/19
*/

public class Pokedex {
   /** Instance of the tree to hold all our nodes. */
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

      while (!endLoop) {
         mainMenuChoice = makeChoice();
         // catch pokemon
         if (mainMenuChoice == 1) {
            chosenPokemon = PokemonFactory.pickAPokemon();
            tree.add(chosenPokemon);
            // System.out.println("Added "+ chosenPokemon.toString());
         }

         // trade pokemon
         if (mainMenuChoice == 2) {
            chosenPokemon = PokemonFactory.pickAPokemon(false);
            try {
               tree.remove(chosenPokemon);
            } catch (TreeException msg) {
               System.out.println("+------------------------"
                   + "----------------------------+");
               System.out.println("|  Sorry, you can't trade "
                   + "a Pokemon you don't have!  |");
               System.out.println("+--------------------------"
                   + "--------------------------+");

            }
         }

         if (mainMenuChoice == 3) {
            tree.printPokeTree();
         }

         // exit
         if (mainMenuChoice == 0) {
            System.exit(0);
         }
      }
   }

   /**
    * makeChoice listens for user input.
    * 
    * @return returns an integer choice for use in 
    * selecting the pokemon to make.
    */
   public static Integer makeChoice() {
      Scanner userIn = new Scanner(System.in);
      boolean endLoop = false;
      String inString = new String("");
      Integer choice = -1;

      while (!endLoop) {
         // menu text
         printMainMenu();
         // read in from user as a String -- much less errors can happen!
         inString = userIn.nextLine();
         // take off any spaces on the string
         inString = inString.trim();

         // convert line to int. if it is not an int, set to 0
         // and ask user to enter a number again.
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
