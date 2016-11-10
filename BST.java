import java.util.List;
import java.util.NoSuchElementException;
import java.util.Iterator;


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

   /*==========================|My public Methods|===========================*/


   public void remove(T element)
   {
      root = root.remove(element);
      size--;
   }

   //has private helper method
   public int treeHeight()
   {
      return root.treeHeight();
   }

   public long internalPathLength()
   {
      if(root == EMPTY_NODE)
      {
         return -1;
      }
      return root.internalPathLength(0);
   }

   public T get(T element)
   {
      return root.get(element);
   }

   public Iterator<T> iterator()
   {
      return new Ticker();
   }

   /*========================================================================*/

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

      public BSTNode<T> remove(T element)
      {
         throw new NoSuchElementException();
      }

      public int treeHeight()
      {
         return -1; //the empty node shouldn't be included in height
      }

      public long internalPathLength(long depth)
      {
         return 0;
      }

      public T get(T element)
      {
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

      public BSTNode<T> remove(T element)
      {
         int comp = this.element.compareTo(element);
         if(comp == 0)
         {
            boolean leftNode = left.getClass() == Node.class;
            boolean rightNode = right.getClass() == Node.class;

            if(!rightNode && !leftNode)
            {
               return EMPTY_NODE;
            }
            else if(leftNode && !rightNode)
            {
               return left;
            }
            else if(!leftNode && rightNode)
            {
               return right;
            }
            else
            {
               this.element = right.minimum(((Node)right).element);
               right = right.remove(this.element);
               return this;
            }
         }
         else
         {
            if(comp > 0)
            {
               left = left.remove(element);
            }
            else
            {
               right = right.remove(element);
            }
            return this;
         }
      }

      public int treeHeight()
      {  
         return 1 + Math.max(left.treeHeight(),right.treeHeight());
      }

      public long internalPathLength(long depth)
      {
         return left.internalPathLength(depth + 1) + depth + right.internalPathLength(depth + 1);
      }

      public T get (T element)
      {
         int comp = this.element.compareTo(element);

         if(comp == 0)
         {
            return this.element;
         }
         else if (comp > 0) //this.element > element
         {
           return left.get(element);
         }
         return right.get(element);
      }
   }
   ////////////////////////////////////////////////////////////////////////////
   //private iterator class
   //
   private class Ticker implements Iterator<T>
   {
      SimpleArrayStack<Node> stack = new SimpleArrayStack<>();

      public Ticker()
      {
         pushStack(root);   
      }

      public boolean hasNext()
      {
         return stack.size() > 0;
      }

      public T next()
      {
         if(!hasNext())
         {
            throw new NoSuchElementException();
         }
         
         Node pop = stack.pop();
         pushStack(pop.right);
         

         return pop.element;
      }

      public void remove()
      {
         throw new UnsupportedOperationException();
      }


      //Private method to add to the stack
      private void pushStack(BSTNode<T> node)
      {
         BSTNode<T> newNode = node;

         while(newNode.getClass() == Node.class)
         {
            stack.push((Node) newNode);
            newNode = ((Node) newNode).left;
         }
      }
   }
}
