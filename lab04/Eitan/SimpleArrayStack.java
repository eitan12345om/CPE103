import java.util.NoSuchElementException;

/**
 * A simple stack using an array.
 *
 * @author Eitan Simler
 * @version Lab04
 */

public class SimpleArrayStack<T> implements SimpleStack<T> {

   // Instance Variables
   private T[] arr;
   private int size;

   // Constructor
   @SuppressWarnings("unchecked")
   public SimpleArrayStack() {
      arr = (T[]) new Object[10];
      size = 0;
   }

   // Methods as required by interface
   public T peek() {
      // Check if stack empty
      if (size < 1) {
         throw new NoSuchElementException();
      }
      
      return arr[size-1];
   }

   public T pop() {
      // Check if stack empty
      if (size < 1) {
         throw new NoSuchElementException();
      }
    
      // Not necessary to nullify element
      size--;
      return arr[size];
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


      // Add element
      arr[size] = element;
      
      // Increment size
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
