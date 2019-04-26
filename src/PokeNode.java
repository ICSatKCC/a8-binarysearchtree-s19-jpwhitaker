/**
* Pokemon Node has a Pokemon as data.
* Also contains a left and right node and amt caught.
* @author JP Whitaker
* @since 4/20/19
*/
public class PokeNode {

   /** Data held in Node. */
   private Pokemon data;
   /** Link to left child Node. */
   private PokeNode left;
   /** Link to right child Node. */
   private PokeNode right;
   /** Number of this type caught. */
   private int numCaught = 0;

   /**
   * PokeNode, node with Pokemon payload.
   * 
   * @param p Pokemon class.
   * @param numCaught used so you don't add duplicates in tree
   * @param lChild left child node
   * @param rChild right child node
   */
   public PokeNode(Pokemon p, int numCaught, PokeNode lChild, PokeNode rChild) {
      /** Data payload is always a Pokemon object. */
      data = p;
      /** Left child PokeNode. */
      left = lChild;
      /** Right child PokeNode. */
      right = rChild;
      this.numCaught = numCaught;
   }

   /** Public method returns data payload. 
   * @return Pokemon the payload from node
   */
   public Pokemon getPokemon() {
      return data;
   }
   
   /** Public method setPokemon. 
   * Allowed per class discussion.
   * @param p Pokemon to add
   */
   public void setPokemon(Pokemon p) {
      data = p;
   }

   /** Public method getKey returns key which is == pokemon number.
   * @return int key
   */
   public int getKey() {
      return data.getNumber();
   }
   
   /** Public method getNumCaught.
   * @return int number of pokemon in same node.
   */
   public int getNumCaught() {
      return numCaught;
   }

   /** Public method getLeftChild().
   * @return PokeNode this node's left child node.
   */
   public PokeNode getLeftChild() {
      return this.left;
   }

   /** Public method getRightChild().
   * @return PokeNode this node's right child node.
   */
   public PokeNode getRightChild() {
      return this.right;
   }
   
   /** Public method increaseNumCaught, 
   * called when adding same pokemon to node.
   */
   public void increaseNumCaught() {
      this.numCaught++;
   }

   /** Public method decreaseNumCaught.
   * called when removing extra pokemon from node.
   * @throws NodeException if count is less than one.
   */
   public void decreaseNumCaught() throws NodeException {
      this.numCaught--;
      if (this.numCaught < 0) {
         throw new NodeException("numCaught can't be less than one!");
      }
   }
   
   /** Public method setLeftChild.
   *  Sets newNode as left child of a node
   * @param newLeftChild is the node to be added.
   */
   public void setLeftChild(PokeNode newLeftChild) {
      left = newLeftChild;
   }

   /** Public method setRightChild.
   *  Sets newNode as right child of a node
   * @param newRightChild is the node to be added.
   */
   public void setRightChild(PokeNode newRightChild) {
      right = newRightChild;
   }

}
