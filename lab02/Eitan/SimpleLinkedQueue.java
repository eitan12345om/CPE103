import java.util.NoSuchElementException;

/**
 * A simple linked queue.
 *
 * @author Eitan Simler
 * @version Lab02
 */

public class SimpleLinkedQueue<T> implements SimpleQueue<T> {

   // Instance Variables
   private Node head;
   private int size;

   // Constructor
   public SimpleLinkedQueue() {
      this.size = 0;
      head = new Node(null);
   }

   // Methods as required by interface
   public T dequeue() throws NoSuchElementException {
      // Check if queue is empty
      if (size == 0) {
         throw new NoSuchElementException();
      }

      // Create reference to soon-to-be removed node
      Node aNode = head.next;

      // Remove links to this node
      head.next = aNode.next;
      aNode.next.prev = head;

      // Decrement size
      size--;

      // Return removed node element
      return aNode.element;
   }

   public void enqueue(T element) {
      // Create new node with specified element
      Node newNode = new Node(element);

      // Create links to newNode
      newNode.prev = head.prev;
      head.prev.next = newNode;
      newNode.next = head;
      head.prev = newNode;

      // Increment size
      size++;
   }

   public T peek() throws NoSuchElementException {
      // Check if queue is empty
      if (size == 0) {
         throw new NoSuchElementException();
      }

      // Return element at front of queue
      return head.next.element;
   }

   public int size() {
      return size;
   }

   // Private inner class node
   private class Node {

      // Instance Variables
      Node next, prev;
      T element;

      // Constructor
      public Node(T element) {
         this.next = this;
         this.prev = this;
         this.element = element;
      }
   }
}
