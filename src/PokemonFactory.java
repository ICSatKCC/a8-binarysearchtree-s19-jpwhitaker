import java.util.Scanner;

public class PokemonFactory {

   /**
    * makeChoice listens for user input.
    * 
    * @return returns an integer choice for use in selecting the pokemon to make.
    */
   public static Integer makeChoice() {
      Scanner userIn = new Scanner(System.in);
      boolean endLoop = false;
      String inString = new String("");
      Integer choice = 0;

      while (!endLoop) {
         // menu text
         printChoices();
         // read in from user as a String -- much less errors can happen!
         inString = userIn.nextLine();
         // take off any spaces on the string
         inString = inString.trim();

         // convert line to int. if it is not an int, set to 0
         // and ask user to enter a number again.
         try {
            choice = Integer.parseInt(inString);
         } catch (NumberFormatException nfe) {
            choice = 0;
         }

         if (choice > 0 && choice <= 9) {
            endLoop = true;
         }
      }
      return choice;
   }

   /**
    * printChoices prints the menu for the user.
    */
   public static void printChoices() {
      System.out.println();
      System.out.println("+----------------------------+");
      System.out.println("|  Choose a Pokemon:         |");
      System.out.println("|  1 for Bulbasaur           |");
      System.out.println("|  2 for Ivysaur             |");
      System.out.println("|  3 for Venusaur            |");
      System.out.println("|  4 for Charmander          |");
      System.out.println("|  5 for Charmeleon          |");
      System.out.println("|  6 for Charizard           |");
      System.out.println("|  7 for Squirtle            |");
      System.out.println("|  8 for Wartortle           |");
      System.out.println("|  9 for Blastoise           |");
      System.out.println("+----------------------------+");
   };

   public static Pokemon pickAPokemon() {
      Pokemon chosenPokemon;
      Integer choice = makeChoice();
      String name = getName();
      chosenPokemon = createPokemon(choice, name);

      return chosenPokemon;
   }

   // overloaded method no name needed for trading pokemon
   public static Pokemon pickAPokemon(boolean chooseName) {
      Pokemon chosenPokemon;
      Integer choice = makeChoice();
      chosenPokemon = createPokemon(choice, "");

      return chosenPokemon;
   }

   /**
    * getName listens for user input to get the pokemon name.
    * 
    * @return Returns the user's pokemon name as a string.
    */
   public static String getName() {
      String hasNameInput = "";
      Scanner userIn = new Scanner(System.in);
      System.out.println("+-------------------------------------+");
      System.out.println("|  Does the Pokemon have a name Y/N?  |");
      System.out.println("+-------------------------------------+");
      hasNameInput = userIn.nextLine();
      String name = "";

      if (hasNameInput.equals("Y") || hasNameInput.equals("y")) {
         System.out.println("+-------------------------------+");
         System.out.println("|  What is the Pokemon's name?  |");
         System.out.println("+-------------------------------+");
         name = userIn.nextLine();
      }
      return name;
   }

   /**
    * createPokemon takes in the the user's choice as an integer and a name and
    * creates the right pokemon.
    * 
    * @param choice an int choice from menu
    * @param name   is a String that can be empty.
    * @return Returns a type of pokemon
    */
   public static Pokemon createPokemon(Integer choice, String name) {
      boolean hasName = name.length() > 0;
      Pokemon newPokemon;

      switch (choice) {
      case 1: // bulbasaur
         if (hasName) {
            newPokemon = new Bulbasaur(name);
         } else {
            newPokemon = new Bulbasaur();
         }
         break;
      case 2: // ivysaur
         if (hasName) {
            newPokemon = new Ivysaur(name);
         } else {
            newPokemon = new Ivysaur();
         }
         break;
      case 3: // venusaur
         if (hasName) {
            newPokemon = new Venusaur(name);
         } else {
            newPokemon = new Venusaur();
         }
         break;
      case 4: // charmander
         if (hasName) {
            newPokemon = new Charmander(name);
         } else {
            newPokemon = new Charmander();
         }
         break;
      case 5: // charmeleon
         if (hasName) {
            newPokemon = new Charmeleon(name);
         } else {
            newPokemon = new Charmeleon();
         }
         break;
      case 6: // charizard
         if (hasName) {
            newPokemon = new Charizard(name);
         } else {
            newPokemon = new Charizard();
         }
         break;
      case 7: // squirtle
         if (hasName) {
            newPokemon = new Squirtle(name);
         } else {
            newPokemon = new Squirtle();
         }
         break;
      case 8: // wartortle
         if (hasName) {
            newPokemon = new Wartortle(name);
         } else {
            newPokemon = new Wartortle();
         }
         break;
      case 9: // blastoise
         if (hasName) {
            newPokemon = new Blastoise(name);
         } else {
            newPokemon = new Blastoise();
         }
         break;

      default:
         return null;
      }
      return newPokemon;
   }
}
