import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;

/**
 * Binary Heap Utility Methods.
 *
 * @author Eitan Simler
 * @version Lab05
 */

public class BinaryHeapUtilities {

   // Calculates the height of the heap given it's size
   public static int height(int size) {
      // Check if size is non-positive
      if (size < 1) {
         throw new IllegalArgumentException();
      }

      return (int) (Math.log(size) / Math.log(2));
   }

   // Checks if data is binary heap
   // - Children >= Parent
   // - First value at index 1
   public static <T extends Comparable<? super T>> boolean isHeap(T[] heap, 
         int size) {
      // Check if size less than 1  
      if (size < 1) {
         return false;
      }
 
      // For each element, check if parent is less than the element
      for (int i = size; i > 1; i--) {
         if (heap[i].compareTo(heap[i/2]) < 0) {
            return false;
         }
      }

      return true;
   }

   // Returns parent of element
   public static <T extends Comparable<? super T>> T parentOf(int index,
         T[] heap, int size) {
      // Check if index non-positive or greater than size
      if (index < 1 || index > size) {
         throw new IndexOutOfBoundsException();
      }
      // Check if element doesn't have parent (i.e. root)
      if (index == 1) {
         throw new NoSuchElementException();   
      }
      // Check if heap is a heap
      if (!isHeap(heap, size)) {
         throw new IllegalArgumentException(); 
      }

      return heap[index / 2];
   }

   // Returns left child of element
   public static <T extends Comparable<? super T>> T leftChildOf(int index,
         T[] heap, int size) {
      // Check if index non-positive or greater than size
      if (index < 1 || index > size) {
         throw new IndexOutOfBoundsException();
      }
      // Check if element doesn't have left-child
      if (index * 2 > size) {
         throw new NoSuchElementException();   
      }
      // Check if heap is a heap
      if (!isHeap(heap, size)) {
         throw new IllegalArgumentException(); 
      }

      return heap[index * 2];
   }

   // Returns right child of element
   public static <T extends Comparable<? super T>> T rightChildOf(int index,
         T[] heap, int size) {
      // Check if index non-positive or greater than size
      if (index < 1 || index > size) {
         throw new IndexOutOfBoundsException();
      }
      // Check if element doesn't have left-child
      if (index * 2 + 1 > size) {
         throw new NoSuchElementException();   
      }
      // Check if heap is a heap
      if (!isHeap(heap, size)) {
         throw new IllegalArgumentException(); 
      }

      return heap[index * 2 + 1];
   }
}
