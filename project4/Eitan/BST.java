import java.util.List;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Provided BST class skeleton for students to complete. This class makes use
 * of Object Oriented structural recursion to solve the problem.
 *
 * Original Revision:
 * @author Hatalsky/Jones
 * @version Project4 
 *
 * Completed By:
 * @author Eitan Simler
 */
public class BST<T extends Comparable<? super T>> implements Iterable<T> {
   // Instance variables for BST class.
   // These are the only ones allowed!
   private final BSTNode<T> EMPTY_NODE = new EmptyNode();
   private BSTNode<T> root = EMPTY_NODE;
   private int size;

   // Polymorphic BST node type!
   private interface BSTNode<T> {
      public BSTNode<T> insert(T element);
      public boolean contains(T element);
      public T minimum(T minimum);
      public T maximum(T maximum);
      public void toSortedList(List<T> list);
      public BSTNode<T> remove(T element);
      public int treeHeight();
      public long internalPathLength(long depth);
      public T get(T element); 
   }
   ////////////////////////////////////////////////////////////////////////////
   // BST class methods...
   //

   /**
    * Inserts an element into the BST.  If the element is already in the BST,
    * the element being inserted is discarded.
    *
    * @param element The element to insert into the BST
    *
    * @throws IllegalArgumentException if the element is null
    */
   public void insert(T element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }

      root = root.insert(element);
   }

   /**
    * Determines whether or not an element is in the BST.
    *
    * @param element the element to search for in the BST
    *
    * @return true if the element is in the BST, false otherwise
    */
   public boolean contains(T element) {
      if (element == null) {
         return false;
      }

      return root.contains(element);
   }

   /**
    * Finds the minimum element in the BST.
    *
    * @return the minimum element in the BST
    *     
    * @throws NoSuchElementException if the BST is empty
    */
   public T minimum() {
      if (size == 0) {
         throw new NoSuchElementException();
      }

      return root.minimum(((Node)root).element);
   }

   /**
    * Finds the maximum element in the BST.
    *
    * @return the maximum element in the BST
    *
    * @throws NoSuchElementException if the BST is empty
    */
   public T maximum() {
      if (size == 0) {
         throw new NoSuchElementException();
      }

      return root.maximum(((Node)root).element);
   }

   /**
    * Takes the elements in the BST and places them in ascending order into the
    * list.
    *
    * @param list the list in which you will place elements
    */
   public void toSortedList(List<T> list) {
      root.toSortedList(list);
   }

   public int size() {
      return size;
   }

   /**
    * Removes specific element of tree
    *
    * @param element the element to remove
    * @return the removed element
    */
   public void remove(T element) {
      root = root.remove(element);
      size--;
   }

   /**
    * Discovers the height of the tree
    *
    * @return the tree height
    */
   public int treeHeight() {
      return root.treeHeight();
   }

   /**
    * Finds the path length of the tree
    *
    * @return the path length
    */
   public long internalPathLength() {
      if (root.equals(EMPTY_NODE)) {
         return -1;
      }
      return root.internalPathLength(0);
   }

   /**
    * Finds and returns specified element in tree
    *
    * @return the element if it is in the tree
    */
   public T get(T element) {
      return root.get(element);
   }

   /**
    * Creates in-order iterator over BST
    *
    * @return iterator over BST
    */
   public Iterator<T> iterator() {
      return new BSTIterator();
   }

   ////////////////////////////////////////////////////////////////////////////
   // private EmptyNode class...
   //
   private class EmptyNode implements BSTNode<T> {
      // No instance variables needed or allowed!

      public BSTNode<T> insert(T element) {
         size++;
         return new Node(element);
      }

      public boolean contains(T element) {
         return false;
      }

      public T minimum(T element) {
         return element;
      }

      public T maximum(T element) {
         return element;
      }

      public void toSortedList(List<T> list) {
         // Do nothing with emptyNodes
	 return;
      }

      public BSTNode<T> remove(T element) {
         // Element not in list
         throw new NoSuchElementException();
      }

      public int treeHeight() {
         // Subtract 1 so that empty tree ends up with height of -1
         return -1;
      }

      public long internalPathLength(long depth) {
         return 0;
      }

      public T get(T element) {
         // Element is not in tree so throw exception
         throw new NoSuchElementException();
      }
   }

   ////////////////////////////////////////////////////////////////////////////
   // private Node class...
   //
   private class Node implements BSTNode<T> {
      // These are the only instance variables needed and the only ones
      // allowed!
      T element;
      BSTNode<T> left, right;

      // Constructor
      public Node(T element) {
         this.element = element;
         this.left = this.right = EMPTY_NODE;
      }

      public BSTNode<T> insert(T element) {
         int temp = this.element.compareTo(element);

         // If element is smaller than node
         if (temp > 0) {
            left = left.insert(element);
         }

         // If element is bigger than node
         else if (temp < 0) {
            right = right.insert(element);
         }

         return this;
      }

      public boolean contains(T element) {
         // >= 1 if current node bigger than element; <= -1 if smaller. 0 if equal
	 int temp = this.element.compareTo(element);
         
         return (temp == 0) ? true : ((temp > 0) ?
            left.contains(element) : right.contains(element));
      }

      public T minimum(T element) {
         // Min will always be as far left as possible
	 return left.minimum(this.element);
      }

      public T maximum(T element) {
         // Max will always be as far right as possible
	 return right.maximum(this.element);
      }

      public void toSortedList(List<T> list) {
         // Add everything smaller first, then current node then bigger elements
	 left.toSortedList(list);
	 list.add(this.element);
	 right.toSortedList(list);
      }

      public BSTNode<T> remove(T element) {
         int temp = this.element.compareTo(element);

         // Check if this is specified element
         if (temp == 0) {
            
            boolean existLeft = left.getClass() == Node.class;
            boolean existRight = right.getClass() == Node.class;

            // Check if no children
            if (!existLeft && !existRight) {
               return EMPTY_NODE;
            }
            // Check if left child exists but right doesn't
            else if (existLeft && !existRight) {
               return left;                                     
            } 
            // Check if right child exists but left doesn't
            else if (!existLeft && existRight) {
               return right;
            }
            // Otherwise both children exist
            else { 
               this.element = right.minimum(((Node) right).element);
               right = right.remove(this.element);
               return this;
            }
         }
         else {
            if (temp > 0) {
               left = left.remove(element);
            } 
            else {
               right = right.remove(element);
            }
            
            return this;
         }
      }

      public int treeHeight() {
         // Determine whether left or right is larger and return it
         return 1 + Math.max(left.treeHeight(), right.treeHeight());
      }
      
      public long internalPathLength(long depth) {
         // In order traversal of the tree
         return left.internalPathLength(1 + depth) + depth
            + right.internalPathLength(1 + depth);
      }

      public T get(T element) {
         // >= 1 if current node bigger than element; <= -1 if smaller.
         // 0 if equal
	 int temp = this.element.compareTo(element);
         
         return (temp == 0) ? element : ((temp > 0) ?
            left.get(element) : right.get(element));
      }
   }

   private class BSTIterator implements Iterator<T> {
 
      // Instance variables
      private SimpleArrayStack<Node> stack = new SimpleArrayStack<>();

      // Constructor
      public BSTIterator() {
         addStack(root);
      }

      // Methods as required by interface
      public boolean hasNext() {
         // Returns true if size is bigger than 0, false otherwise
         return stack.size() > 0;
      }

      public T next() {
         // Check if any elements in stack
         if (!hasNext()) {
            throw new NoSuchElementException();
         }

         // Create local variable to keep track of pop
         Node popReturn = stack.pop(); 
         addStack(popReturn.right);

         // Return next element
         return popReturn.element;
      }

      public void remove() {
         // Method not supported by this iterator
         throw new UnsupportedOperationException();
      }

      // Private auxillery method
      private void addStack(BSTNode<T> node) {
         // Traverse right (if possible), then all the way left (if possible)
         BSTNode<T> aNode = node;
         while (aNode.getClass() == Node.class) {
            stack.push((Node) aNode);
            aNode = ((Node) aNode).left;
         }                  
      }
   }
}
