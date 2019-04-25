
public class PokeNode {
	// Pokemon should be a non-null object.
	// numCaught should be >= 1.
	// lChild and rChild are PokeNodes. They may or not be null depending on your
	// implementation.

	/** Data held in Node. */
	private Pokemon data;
	/** Link to left child Node. */
	private PokeNode left;
	/** Link to right child Node. */
	private PokeNode right;
	/** Number of this type caught */
	private int numCaught = 0;

	public PokeNode(Pokemon P, int numCaught, PokeNode lChild, PokeNode rChild) {
		data = P;
		left = lChild;
		right = rChild;
		this.numCaught = numCaught;
	}

	public Pokemon getPokemon() {
		return data;
	}

	public void setPokemon(Pokemon p) {
		data = p;
	}

	public int getKey() {
		// This method will return the Pokemon species' number of the Pokemon in a given
		// node. This is the key for the PokeTree.
		return data.getNumber();
	}

	public int getNumCaught() {
		// This method will return the numCaught from inside a given node
		return numCaught;
	}

	public PokeNode getLeftChild() {
		// This method will return the left child of a given node
		return this.left;
	}

	public PokeNode getRightChild() {
		// this method will return the right child of a given node
		return this.right;
	}

	public void increaseNumCaught() {
		// increment numCaught in a node
//		System.out.println("INCREMENT NUM CAUGHT");
		this.numCaught++;
	}

	public void decreaseNumCaught() {
		// decrease num caught in a given node
		// throw exception if it becomes < 1.
		this.numCaught--;
		// TODO add exception if < 1;
	}

	public void setLeftChild(PokeNode newLeftChild) {
		// This method will set newLNode as the left child of a node
		left = newLeftChild;
	}

	public void setRightChild(PokeNode newRightChild) {
		// This method will set newRNode as the right child of a node
		right = newRightChild;
	}

	// There is no public setPokemon method. We don't want anybody to change the
	// species of
	// Pokemon in a node that is already part of the tree, this will break the
	// Binary Search
	// Tree rules. You can make a private one as a helper method for removing if you
	// want to.

}
