import java.util.List;
import java.util.NoSuchElementException;


/**
 * Provided BST class skeleton for students to complete. This class makes use
 * of Object Oriented structural recursion to solve the problem.
 *
 * Original Revision:
 * @author Hatalsky/Jones
 * @version Lab 7
 *
 * Completed By:
 * @author Your Name Here!
 */
public class BST<T extends Comparable<? super T>> {
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

   ////////////////////////////////////////////////////////////////////////////
   // private EmptyNode class...
   //
   private class EmptyNode implements BSTNode<T> {
      // No instance variables needed or allowed!

      //insert an element with a specific key (while maintining BST structure)
      public BSTNode<T> insert(T element) 
      {
         size++;
         return new Node(element);
      }

      public boolean contains(T element) 
      {
         return false;
      }

      public T minimum(T element) 
      {
         return element;
      }

      public T maximum(T element) 
      {
         return element;
      }

      public void toSortedList(List<T> list) 
      {
         return;
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

      // You may (and probably want to) write constructor(s)
      public Node(T element)
      {
         this.element = element;
         this.left = EMPTY_NODE;
         this.right = EMPTY_NODE;
      }

      public BSTNode<T> insert(T element) 
      {
         int comp = this.element.compareTo(element);
         if(comp > 0)
         {
            left = left.insert(element);
         }
         else if(comp < 0)
         {
            right = right.insert(element);
         }
         return this;
      }

      public boolean contains(T element) 
      {
         int comp = this.element.compareTo(element);

         if(comp == 0)
         {
            return true;
         }
         else if(comp > 0)
         {
            return left.contains(element);
         }
         else 
         {
            return right.contains(element);
         }
      }

      public T minimum(T element) 
      {
         return left.minimum(this.element);
      }

      public T maximum(T element) 
      {
         return right.maximum(this.element);        
      }

      public void toSortedList(List<T> list) 
      {
         left.toSortedList(list);
         list.add(this.element);
         right.toSortedList(list);
      }
   }
}
