import pokemon.*;
public class PokeTree {

	
	public PokeTree() {
		//empty constructor
	}
	
	public void add(Pokemon p) {
		//recursive add method.
		//Should make a new node and put Pokemon p in it with numCaught = 1 if not already in the tree
		//Should increment numCaught if Pokemon p already is in the tree
	}
	
	
	public void remove( Pokemon p) {
		//Hint: Do this part last, it is hardest because you have to reorder the tree
		//Wrapper method that calls recursive remove method with root
	}
	
	private PokeNode remove(PokeNode node, Pokemon p) {
		// Hint: Do this part last, it is hardest because you have to reorder the tree
		// decrements numCaught
		// Removes Pokemon p from the tree if numCaught == 0
		// Throws exception if p not in the tree

	}
	
}
