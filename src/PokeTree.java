
public class PokeTree {
	/** Root node instance variable. */
	private PokeNode root = null;

	public PokeTree() {
		//empty constructor
		//root already init
	}


	/**
	 * Adds an item to the tree.
	 * Non-recursive wrapper method
	 * 
	 * @param p pokemon to be added
	 */
	public void add(Pokemon p) {
		//recursive add method.
		//Should make a new node and put Pokemon p in it with numCaught = 1 if not already in the tree
		//Should increment numCaught if Pokemon p already is in the tree
		root = add(root, p);
	}

	/**
	 * Recusively adds an item to the tree.
	 * 
	 * @param node The root of the tree/subtree
	 * @param item The object to be added
	 * @return The current node
	 */
	private PokeNode add(PokeNode node, Pokemon item) {
		// base case: empty tree or end of a leaf
		if (node == null) {
			//really, set numCaught here??
			return new PokeNode(item, 1 ,null, null);
		}
		// base case: duplicate node, so throw exception
		else if (item.number == node.getKey()) {
			//TODO just increment numCaught
			System.out.println("duplicate");
			return null;
//			throw new TreeException("No duplicate items are allowed!");
		}
		// recursive case: if item is less than current node
		// then move to left child node
		else if (item.number < node.getKey()) {
			// set the node's left child to the
			// left subtree with item added
			node.setLeftChild(this.add(node.getLeftChild(), item));
			return node;
		}
		// recursive case: if item is greater than current node
		// then traverse to right child node
		else {
			// set the node's right child to the
			// right subtree with item added
			node.setRightChild(this.add(node.getRightChild(), item));
			return node;
		}
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

	public Pokemon get(Pokemon searchKey) {
		//Private recursive get method
		//Returns Pokemon object with number == searchKey.getNumber()
		//Should throw an exception if Pokemon with number == searchKey.getNumber() not in the tree
	}
	
	private Pokemon get(PokeNode node, Pokemon searchKey){
		//Private recursive get method
		//Returns Pokemon object with number == searchKey.getNumber()
		//Should throw an exception if Pokemon with number == searchKey.getNumber() not in the tree
	}

	public void preorderPokeTree() {
		//Overloaded wrapper method in order to access private data field root to send to recursive method.
		preorderPokeTree(this.root);
	}

	private void preorderPokeTree(PokeNode root){
		//The recursive method takes the root as a parameter and will print tree in preorder traversal.
		//It is good for debugging purposes.
		// You may copy and paste this into your PokeTree class.
		System.out.println("here");
		if(root != null){
			System.out.println("  " + root.getPokemon( ).toString() + "\nCaught: "+root.getNumCaught( ) );
			preorderPokeTree(root.getLeftChild());
			preorderPokeTree(root.getRightChild());
		}
	}

}
