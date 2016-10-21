import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A priority queue.
 *
 * @author Eitan Simler
 * @version Project3
 */

public class PriorityQueue<T extends Comparable<? super T>> implements SimpleQueue<T> {

   // Instance Variables
   private ArrayList<T> myList = new ArrayList<>();
   private boolean isMax;

   // Constuctors
   public PriorityQueue() {
      myList.add(null);
      this.isMax = false;
   }

   public PriorityQueue(boolean isMax) {
      myList.add(null);
      this.isMax = isMax;
   }

   public PriorityQueue(T[] arr, int size) {
      myList.add(null);
      this.isMax = false;
      // FIXME: Needs to have order of heap
      // TODO: Use enqueue method
      for (int i = 0; i < size; i++) {
         myList.add(arr[i]);
      }
   }

   public PriorityQueue(T[] arr, int size, boolean isMax) {
      myList.add(null);
      this.isMax = isMax;
      // FIXME: Needs to have order of heap
      // TODO: Use enqueue method
      for (int i = 0; i < size; i++) {
         myList.add(arr[i]);
      }
   }

   // Methods as specified by interface
   public T dequeue() {
      // Check if queue is empty
      if (myList.size() == 1) {
         throw new NoSuchElementException();
      }
      
      // TODO: Method body
      return null;
   }

   public void enqueue(T element) {
      // Declare and instantiate index variable to next spot
      int index = myList.size();
      boolean isHeap = false;

      if (isMax) {
         while (!isHeap && index != 1) {
            // Check if element is larger than parent
            if (element.compareTo(myList.get(index / 2)) > 0) {
               // Remove parent and insert to new index
               myList.add(index, myList.remove(index / 2));
               index /= 2;
            }  
            else {
               isHeap = true;
            }
         }
      }
      else {
         while (!isHeap && index != 1) {
            // Check if element is less than parent
            if (element.compareTo(myList.get(index / 2)) < 0) {
               // Remove parent and insert to new index
               myList.add(index, myList.remove(index / 2));
               index /= 2;
            }  
            else {
               isHeap = true;
            }
         } 
      }
      // Add element
      myList.add(index, element);
   }

   public T peek() {
      // Check if queue is empty
      if (myList.size() == 1) {
         throw new NoSuchElementException();
      }

      return myList.get(1);
   }
      
   public int size() {
      return myList.size() - 1;
   }

   // Method to sort array in ascending order
   public static <E extends Comparable<? super E>> void sort(E[] arr, int size) {
      // TODO: method body
   }

   // Finds kth largest element in array
   public static <E extends Comparable<? super E>> E kth(E[] arr, int size, int k) {
      // TODO: method body
      return null;
   }
}
