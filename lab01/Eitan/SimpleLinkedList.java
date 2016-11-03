/**
 * This class will be a simple representation of a linked list.
 *
 * @author Eitan Simler
 * @version Lab01
 */

public class SimpleLinkedList<T> implements SimpleList<T> {

   // Instance Variables
   private Node head;
   private int size;

   // Constructor
   public SimpleLinkedList() {
      this.size = 0;
      head = new Node(null);
   }

   public void add(T element) {
      // Create new node with specified element
      Node newNode = new Node(element);
      
      // Create links to new node
      newNode.prev = head.prev;
      head.prev.next = newNode;
      newNode.next = head;
      head.prev = newNode;

      // Increment size
      size++;
   }

   // Methods as required by the interface
   public void add(int index, T element) throws IndexOutOfBoundsException {
      // Check if index is valid
      if (index > size || index < 0) {
         throw new IndexOutOfBoundsException();
      }

      // Create new node with specified element
      Node newNode = new Node(element);

      // Retrieve node at index to link newNode
      Node aNode = head;
      for (int i = 0; i < index; i++) {
         aNode = aNode.next;
      }

      // Link newNode to list
      newNode.next = aNode.next;
      aNode.next.prev = newNode;
      newNode.prev = aNode;
      aNode.next = newNode;
      
      // Increment size
      size++;
   }

   public T get(int index) throws IndexOutOfBoundsException {
      // Check if index is valid
      if (index >= size || index < 0) {
         throw new IndexOutOfBoundsException();
      }

      // Retrieve correct node
      Node aNode = head.next;
      for (int i = 0; i < index; i++) {
         aNode = aNode.next;
      }
      
      // return specificed element of node at index
      return aNode.element;
   }

   public T remove(int index) throws IndexOutOfBoundsException {
      // Check if index is valid
      if (index >= size || index < 0) {
         throw new IndexOutOfBoundsException();
      }
      
      // Retrieve correct node
      Node aNode = head.next;
      for (int i = 0; i < index; i++) {
         aNode = aNode.next;
      }
      
      // Remove links to this node
      aNode.prev.next = aNode.next;
      aNode.next.prev = aNode.prev;

      // Decrement size
      size--;

      // Return specified element of removed node
      return aNode.element;
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
