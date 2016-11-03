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
      for (int i = 0; i < size; i++) {
         this.enqueue(arr[i]);
      }
   }

   public PriorityQueue(T[] arr, int size, boolean isMax) {
      myList.add(null);
      this.isMax = isMax;
      for (int i = 0; i < size; i++) {
         this.enqueue(arr[i]);
      }
   }

   // Methods as specified by interface
   // TODO: Write separate method called isHigherPriority()
   public T dequeue() {
      // Check if queue is empty
      if (myList.size() == 1) {
         throw new NoSuchElementException();
      }
      
      int index = 1;
      T root = myList.get(1);
      T last = myList.remove(myList.size() - 1);
 
      // If only 1 element in list
      if (root.equals(last)) {
         return root;
      }
      
      boolean isHeap = false;

      while (!isHeap) {
         // Check if there is a left child
         if (index * 2 < myList.size()) {
            // Check if exists right child
            if (index * 2 + 1 < myList.size()) {
               // Check if left child higher priority than or equal to right child
               if (isHigherPriority(myList.get(index * 2), myList.get(index * 2 + 1))) {
                  // Check if last higher priority than or equals to left child
                  if (isHigherPriority(last, myList.get(index * 2))) {
                     isHeap = true;
                  }
                  // Left child is higher priority than last
                  else {
                     myList.set(index, myList.get(index * 2));
                     index *= 2;
                  }
               }
               else { 
                  // Check if last higher priority than or equals to right child
                  if (isHigherPriority(last, myList.get(index * 2 + 1))) {
                     isHeap = true;
                  }
                  // Right child is higher priority than last
                  else {
                     myList.set(index, myList.get(index * 2 + 1));
                     index = index * 2 + 1;
                  }
               }
            }
            else {
               // Check if last higher priority than or equals to left child
               if (isHigherPriority(last, myList.get(index * 2))) {
                  isHeap = true;
               }
               // Left child is higher priority than last
               else {
                  myList.set(index, myList.get(index * 2));
                  index *= 2;
                  isHeap = true;
               }              
            }
         }
         else {
            isHeap = true;
         }
      }
      
      myList.set(index, last);
      return root;
   }

   public void enqueue(T element) {
      // Declare and instantiate index variable to next spot
      int index = myList.size();
      myList.add(null);
      boolean isHeap = false;

      if (isMax) {
         while (!isHeap && index != 1) {
            // Check if element is larger than parent
            if (element.compareTo(myList.get(index / 2)) > 0) {
               // Remove parent and insert to new index
               myList.set(index, myList.get(index / 2));
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
               myList.set(index, myList.get(index / 2));
               index /= 2;
            }  
            else {
               isHeap = true;
            }
         } 
      }
      // Add element
      myList.set(index, element);
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
      // Create new queue for sorting operations
      PriorityQueue<E> myQueue = new PriorityQueue<>(arr, size);
      for (int i = 0; i < size; i++) {
         // Add back to the array
         arr[i] = myQueue.dequeue();
      }
   }

   // Finds kth largest element in array
   public static <E extends Comparable<? super E>> E kth(E[] arr, int size, int k) {
      boolean max = false;
      
      // Check if better to use kth smallest!
      if (k > size - k + 1) {
         k = size - k + 1;
         max = true;
      }

      PriorityQueue<E> myQueue = new PriorityQueue<>(arr, k, max);

      if (max) {
         for (int i = k; i < size; i++) {
            // Check if element from array is smaller
            if (arr[i].compareTo(myQueue.peek()) < 0) {
               myQueue.dequeue();
               myQueue.enqueue(arr[i]);
            }   
         }
      }
      else { 
         for (int i = k; i < size; i++) {
            // Check if element from array is larger
            if (arr[i].compareTo(myQueue.peek()) > 0) {
               myQueue.dequeue();
               myQueue.enqueue(arr[i]);
            }   
         }
      }
      
      // Kth largest
      return myQueue.peek();
   }

   // Private helper method
   private boolean isHigherPriority(T e1, T e2) {
      return isMax ? e1.compareTo(e2) >= 0 : e1.compareTo(e2) <= 0;
   }
}
