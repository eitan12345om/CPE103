import java.util.NoSuchElementException;

/**
 * A simple singly linked stack.
 *
 * @author Eitan Simler
 * @version Project2
 */

public class SimpleLinkedStack<T> implements SimpleStack<T> {

   // Instance Variables
   private Node top;
   private int size;

   // Constructor
   public SimpleLinkedStack() {
      this.size = 0;
   }


   // Methods as required by interface
   public T peek() {
      // Check if stack empty
      if (size == 0) {
         throw new NoSuchElementException();
      }
 
      return top.element;
   }

   public T pop() {
      // Check if stack empty
      if (size == 0) {
         throw new NoSuchElementException();
      }

      // Create reference for return
      Node temp = top;

      top = top.next;
      size--;

      return temp.element;
   }

   public void push(T element) {
      // Add new node to top and switch top
      Node aNode = new Node(element);
      aNode.next = top;
      top = aNode;
   
      size++;
   }

   public int size() {
      return size;
   }


   // Private inner class
   private class Node {
      
      // Instance Variables
      private Node next;
      private T element;

      // Constructor
      public Node(T element) {
         this.element = element;
         this.next = this;
      }
   }
}
