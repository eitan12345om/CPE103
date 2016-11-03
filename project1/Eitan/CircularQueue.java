import java.util.NoSuchElementException;

/**
 * A simple circular array-based queue.
 *
 * @author Eitan Simler
 * @version Project1
 */

public class CircularQueue<T> implements SimpleQueue<T> {

   // Instance variables
   private T[] arr;
   private int size = 0;
   private int back = -1;
   private int front = 0;
   public static final int INITIAL_LENGTH = 10;

   // Constructors
   @SuppressWarnings("unchecked")
   public CircularQueue() {
      arr = (T[]) new Object[INITIAL_LENGTH];
   }

   @SuppressWarnings("unchecked")
   public CircularQueue(int initialCapacity) {
      // Check if initialCapacity is non-positive
      if (initialCapacity < 1) {
         throw new MyException();
      }

      arr = (T[]) new Object[initialCapacity];
   }

   // Methods as required by the interface
   public T dequeue() {
      // Check if queue is empty
      if (size == 0) {
         throw new NoSuchElementException();
      }

      // Retrieve object to be deleted (overwritten at a later time)
      T value = arr[front];

      // Move front forwards
      front = (front + 1) % arr.length;
     
      // Decrement size
      size--;

      return value;
   }

   @SuppressWarnings("unchecked")
   public void enqueue(T element) {
      // Check if queue is full
      if (size == arr.length) {
         T[] temp = (T[]) new Object[arr.length * 2];
         
         // Add old elements to new array
         for (int i = 0; i < size; i++) {
            temp[i] = arr[(front + i) % size];
         }

         // Reassign front and back
         front = 0;
         back = size - 1;

         // Reassign arr to temp
         arr = temp;
      }

      // Increment back without having bad indices
      back = (back + 1) % arr.length;

      // Add element to queue
      arr[back] = element;

      // Increment size
      size++;
   }

   public T peek() {
      // Check if queue is empty
      if (size == 0) {
         throw new NoSuchElementException();
      }
      
      // Return element at front of list
      return arr[front];  
   }

   public int size() {
      return size;  
   }

   // Method for testing purposes only
   public Object[] unusualMethodForTestingPurposesOnly() {
      return arr;
   }

   // Exception class to indicate exception in second constructor
   public static class MyException extends RuntimeException {
   
      // Constructors
      public MyException() {
         super();     
      }

      public MyException(String s) {
         super(s);
      }
   }
}
