/**
* Pokemon Tree, handles adding, removing and traversing of pokenodes.
* @author JP Whitaker
* @since 4/20/19
*/
public class PokeTree {
   /** Root node instance variable. */
   private PokeNode root = null;

   /** Empty constructor, root already initialized. */
   public PokeTree() {
   }

   /**
    * Adds an item to the tree. Non-recursive wrapper method
    * 
    * @param p pokemon to be added
    */
   public void add(Pokemon p) {
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
         return new PokeNode(item, 1, null, null);
      }
      else if (item.getNumber() == node.getKey()) {
         //if pokemon is already in tree, increase the number caught
         node.increaseNumCaught();
         return node;
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

   /**
    * Removes an item from the tree.
    * 
    * @param p An pokemon storing the key to remove.
    */
   public void remove(Pokemon p) {
      root = this.remove(root, p);
   }

   /**
    * Recursively removes an item from the tree.
    * 
    * @param node       The root of the tree/subtree
    * @param p An object storing only the key to remove.
    * @return root of current subtree.
    * @throws TreeException if item not found in tree.
    */
   private PokeNode remove(PokeNode node, Pokemon p) {
      if (node == null) {
         throw new TreeException("Item not found!");
      }

      // if search key is less than node's search key,
      // continue to left subtree
      else if (p.getNumber() < node.getKey()) {
         node.setLeftChild(this.remove(node.getLeftChild(), p));
         return node;
      }
      // if search key is greater than node's search key,
      // continue to right subtree
      else if (p.getNumber() > node.getKey()) {
         node.setRightChild(this.remove(node.getRightChild(), p));
         return node;
      }
      // found node containing object with same search key,
      // so delete it
      else {
         // if its the correct node and it has more that one caught,
         // decrease numCaught
//			System.out.println("NumCaught" + node.getNumCaught());
         if (node.getNumCaught() > 1) {
            node.decreaseNumCaught();
            return node;
         }

         // call private method remove
         node = this.remove(node);
         return node;
      }
   }

   /**
    * Helper method that takes a node out of tree.
    * 
    * @param node The node to remove
    * @return The node that replaces removed node or null.
    */
   private PokeNode remove(PokeNode node) {

      // if node is a leaf,return null
      if (node.getLeftChild() == null && node.getRightChild() == null) {
         return null;
      }
      // if node has a single right child node,
      // then return a reference to the right child node
      else if (node.getLeftChild() == null) {
         return node.getRightChild();
      }
      // if node has a single left child node,
      // then return a reference to the left child node
      else if (node.getRightChild() == null) {
         return node.getLeftChild();
      }
      // if the node has two child nodes
      else {
         // get next Smaller Item, which is Largest Item in Left Subtree
         // The next Smaller Item is stored at the rightmost node in the left
         // subtree.
         Pokemon largestItemInLeftSubtree = 
             this.getItemWithLargestSearchKey(node.getLeftChild());
         
         node.setPokemon(largestItemInLeftSubtree);
         
         node.setLeftChild(
             this.removeNodeWithLargestSearchKey(node.getLeftChild()));
         return node;
      }
   }

   /**
    * Returns the item with the largest search
    * key in the (sub)tree. Helper method
    * for removing interior nodes.
    * 
    * @param node The root of the tree/subtree
    * @return The data item with largest key
    */
   private Pokemon getItemWithLargestSearchKey(PokeNode node) {
      // if no right child, then this node contains the largest item
      if (node.getRightChild() == null) {
         return node.getPokemon();
      }
      // if not, keep looking on the right
      else {
         return this.getItemWithLargestSearchKey(node.getRightChild());
      }
   }

   /**
    * Removes the node with the largest search key. 
    * Helper method for removing
    * interior nodes. Remove the node formerly 
    * occupied by item with largest search
    * key. To be called after item is moved to new node location.
    * 
    * @param node The root of the tree/subtree
    * @return root of (sub)tree with node removed.
    */
   private PokeNode removeNodeWithLargestSearchKey(PokeNode node) {
      // if no right child, then this node contains the largest item
      // so replace it with its left child
      if (node.getRightChild() == null) {
         return node.getLeftChild();
      }
      // if not, keep looking on the right
      else {
         node.setRightChild(
             this.removeNodeWithLargestSearchKey(node.getRightChild()));
         return node;
      }
   }

   /**
    * gets an item from the tree with the same search key.
    * 
    * @param searchKey An object containing the search key
    * @return the data item in the tree with matching key.
    */
   public Pokemon get(Pokemon searchKey) {
      return this.get(root, searchKey);
   }

   /**
    * Recursive method to get an item from the tree.
    * 
    * @param node The root of the tree/subtree
    * @param p A Pokemon storing the key to get.
    * @return the data item in tree with matching key.
    * @throws TreeException if item not found
    */
   private Pokemon get(PokeNode node, Pokemon p) {
      if (node == null) {
         throw new TreeException("Item not found!");
      } else {
         // if the search key matches, return the item's address
         if (p.getNumber() == node.getKey()) {
            return node.getPokemon();
         }
         // if the search key of the searchKey is less than the node,
         // then search the left subtree
         else if (p.getNumber() < node.getKey()) {
            return this.get(node.getLeftChild(), p);
         }
         // if the search key of the searchKey is greater than the node,
         // then search the right subtree
         else {
            return this.get(node.getRightChild(), p);
         }
      }
   }
   
   /** Overloaded wrapper method in order to access private
   * data field root to send  to recursive method.
   */
   public void preOrderPokeTree() {
      preOrderPokeTree(this.root);
   }

   /** The recursive method takes the root as a parameter and will print tree in
   * preorder traversal.
   * @param node is the node to print
   */
   private void preOrderPokeTree(PokeNode node) {
      if (node != null) {

         System.out.println("\n" + node.getPokemon().toString() 
             + "\nCaught: " + node.getNumCaught() + "\n\n");
         System.out.println();
         preOrderPokeTree(node.getLeftChild());
         preOrderPokeTree(node.getRightChild());
      }
   }

   /** 
   * Overloaded wrapper method in order to access private 
   * data field root to send to recursive method.
   */
   public void printPokeTree() {
      String output = printPokeTree(this.root);

      if (output == "") {
         output = "No pokemon to display!  Go catch some!";
      }

      System.out.println(output);

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
         displayNodes = displayNodes + node.getPokemon().toString() 
             + "\nCaught: " + node.getNumCaught() + "\n\n";
         displayNodes = displayNodes + this.printPokeTree(node.getRightChild());
      }
      return displayNodes;
   }

}
