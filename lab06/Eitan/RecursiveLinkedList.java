/**
 * A provided, partially complete, simple, recursive, singly-linked list
 * for CPE 103 Lab 6.
 *
 * @author Hatalsky/Jones (Provided skeleton).
 * 
 * @author Eitan Simler 
 * @version Lab06
 */
// Class invariants:
//
// The head reference is never null.
// The head node's next field will be null when the list is empty.
// The next field of the last node in the list is always null.
public class RecursiveLinkedList<T> implements SimpleList<T> {
   private class Node {
      public Node next;
      public T e;

      public Node() {
      }

      public Node(Node next, T e) {
         this.next = next;
         this.e = e;
      }
   }

   private Node head;
   private Throwable stackTrace;

   public RecursiveLinkedList() {
      head = new Node();
   }

   public void add(T element) {
      head.next = add(head.next, element);
   }
   
   public void addAlt(T element) {
      addAlt(head, element);
   }
   
   public void add(int index, T element) {
      // Check if index too small
      if (index < 0) {
         throw new IndexOutOfBoundsException();    
      }

      add(head, new Node(null, element), index);
   }
   
   public T get(int index) {
      // Check if index is too small
      if (index < 0) {
         throw new IndexOutOfBoundsException();
      }
      return get(head.next, index);
   }
   
   public T remove(int index) {
      // Check if index is too small
      if (index < 0) {
         throw new IndexOutOfBoundsException();
      }
      return remove(head, index);
   }

   public int size() {
      return size(head.next);
   }
   
   public Throwable stackTrace() {
      return stackTrace;
   }

   // Private recursive helper method for public add(T)
   private Node add(Node node, T e) {
      stackTrace = new Throwable();

      if (node == null) {
         return new Node(null, e);
      } else {
         node.next = add(node.next, e);
      }

      return node;
   }

   // Private ALTERNATE recursive helper method for public add(T)
   private void addAlt(Node node, T e){
      stackTrace = new Throwable();

      if (node.next == null) {
         node.next = new Node(null, e);
      }
      else {
         addAlt(node.next, e);
      }
   }

   // Private recursive helper method for public size(int) 
   private int size(Node node) {
      stackTrace = new Throwable();

      if (node == null) {
         return 0;
      }

      return 1 + size(node.next);
   }

   // Private recursive helper method for public get(int)
   private T get(Node node, int index) {
      stackTrace = new Throwable();

      // Check if index out of bounds
      if (node == null) {
         throw new IndexOutOfBoundsException();
      }

      if (index == 0) {
         return node.e;
      }
 
      // Decrement index, 
      return get(node.next, index - 1);
   }

   private void add(Node node, Node newNode, int index) {
      stackTrace = new Throwable();

      // Check if index out of bounds
      if (node == null) {
         throw new IndexOutOfBoundsException();
      }

      if (index == 0) {
         newNode.next = node.next;
         node.next = newNode;
      }
      else {
         // Decrement index, 
         add(node.next, newNode, index - 1);
      }
   }

   private T remove(Node node, int index) {
      stackTrace = new Throwable();

      // Check if index out of bounds
      if (node.next == null) {
         throw new IndexOutOfBoundsException();
      }

      // Remove and return next element
      if (index == 0) {
         T temp = node.next.e;
         node.next = node.next.next;
         return temp;
      }
 
      // Decrement index, 
      return remove(node.next, index - 1);
   }
}
