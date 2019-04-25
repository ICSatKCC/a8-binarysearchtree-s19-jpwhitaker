
public class PokeTree {
	/** Root node instance variable. */
	private PokeNode root = null;

	public PokeTree() {
		// empty constructor
		// root already init
	}

	/**
	 * Adds an item to the tree. Non-recursive wrapper method
	 * 
	 * @param p pokemon to be added
	 */
	public void add(Pokemon p) {
		// recursive add method.
		// Should make a new node and put Pokemon p in it with numCaught = 1 if not
		// already in the tree
		// Should increment numCaught if Pokemon p already is in the tree
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
			// really, set numCaught here??
			return new PokeNode(item, 1, null, null);
		}
		// base case: duplicate node, so throw exception
		else if (item.number == node.getKey()) {
			// TODO just increment numCaught
			node.increaseNumCaught();
			return null;
			// throw new TreeException("No duplicate items are allowed!");
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

	public void remove(Pokemon p) {
		// Hint: Do this part last, it is hardest because you have to reorder the tree
		// Wrapper method that calls recursive remove method with root
	}

	private PokeNode remove(PokeNode node, Pokemon p) {
		// Hint: Do this part last, it is hardest because you have to reorder the tree
		// decrements numCaught
		// Removes Pokemon p from the tree if numCaught == 0
		// Throws exception if p not in the tree

	}

	

	/**
	 * gets an item from the tree with the same search key.
	 * 
	 * @param searchKey An object containing the search key
	 * @return the data item in the tree with matching key.
	 */
	public Pokemon get(Pokemon searchKey) {
		// Private recursive get method
		// Returns Pokemon object with number == searchKey.getNumber()
		// Should throw an exception if Pokemon with number == searchKey.getNumber() not
		// in the tree
		return this.get(root, searchKey);
	}

	/**
	 * Recursive method to get an item from the tree.
	 * 
	 * @param node      The root of the tree/subtree
	 * @param searchKey An object storing the key to get.
	 * @return the data item in tree with matching key.
	 * @throws TreeException if item not found
	 */
	private Pokemon get(PokeNode node, Pokemon searchKey) {
		// Private recursive get method
		// Returns Pokemon object with number == searchKey.getNumber()
		// Should throw an exception if Pokemon with number == searchKey.getNumber() not
		// in the tree
		// if not found, throw exception
		if (node == null) {
			throw new TreeException("Item not found!");
		} else {
			// if the search key matches, return the item's address
			if (searchKey.getNumber() == node.getKey()) {
				return node.getPokemon();
			}
			// if the search key of the searchKey is less than the node,
			// then search the left subtree
			else if (searchKey.getNumber() < node.getKey()) {
				return this.get(node.getLeftChild(), searchKey);
			}
			// if the search key of the searchKey is greater than the node,
			// then search the right subtree
			else {
				return this.get(node.getRightChild(), searchKey);
			}
		}
	}

	public void preOrderPokeTree() {
		// Overloaded wrapper method in order to access private data field root to send
		// to recursive method.
		preOrderPokeTree(this.root);
	}

	private void preOrderPokeTree(PokeNode root) {
		// The recursive method takes the root as a parameter and will print tree in
		// preorder traversal.
		// It is good for debugging purposes.
		// You may copy and paste this into your PokeTree class.

		if (root != null) {
			System.out.println("  " + root.getPokemon().toString() + "\nCaught: " + root.getNumCaught());
			preOrderPokeTree(root.getLeftChild());
			preOrderPokeTree(root.getRightChild());
		}
	}
	
	public void printPokeTree() {
		// Overloaded wrapper method in order to access private data field root to send
		// to recursive method.
		System.out.println( printPokeTree(this.root));
	}

	/**
	 * inOrder display of nodes, with newline between each node.
	 * 
	 * @param node The root of the tree/subtree
	 * @return an inorder String of the tree
	 */
	private String printPokeTree(PokeNode node) {
		String displayNodes = "";
		if (node != null) {
			displayNodes = displayNodes + this.printPokeTree(node.getLeftChild());
			displayNodes = displayNodes + node.getPokemon().toString() + "\n";
			displayNodes = displayNodes + this.printPokeTree(node.getRightChild());
		}
		
		return displayNodes;
	}

}
