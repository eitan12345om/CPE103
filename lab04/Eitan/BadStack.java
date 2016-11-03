import java.util.NoSuchElementException;

/**
 * A simple bad stack using an array.
 *
 * @author Eitan Simler
 * @version Lab04
 */

public class BadStack<T> implements SimpleStack<T> {

   // Instance Variables
   private T[] arr;
   private int size;

   // Constructor
   @SuppressWarnings("unchecked")
   public BadStack() {
      arr = (T[]) new Object[10];
      size = 0;
   }

   // Methods as required by interface
   public T peek() {
      // Check if stack empty
      if (size < 1) {
         throw new NoSuchElementException();
      }

      return arr[0];
   }

   public T pop() {
      // Check if stack empty
      if (size < 1) {
         throw new NoSuchElementException();
      }
   
      // O(n) implementation to pop
      T temp = arr[0];
      for (int i = 0; i < size; i++) {
         arr[i] = arr[i + 1];
      }
      size--;
      return temp;
   }

   @SuppressWarnings("unchecked")
   public void push(T element) {
      // Check if array capacity needs to be doubled
      if (size == arr.length) {
         T[] temp = (T[]) new Object[arr.length * 2];
         
         // Add elements to temp array
         for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
         }

         arr = temp;
      }

      // O(n) implementation to push
      for (int i = size; i > 0; i--) {
         arr[i] = arr[i-1];
      }
      arr[0] = element;
      size++;
   }

   public int size() {
      return size;
   }

   // Returns capacity of array
   public int capacity() {
      return arr.length;
   }
}
