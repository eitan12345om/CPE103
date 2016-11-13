/**
 * A Quadratic sort class.
 *
 * @author Eitan Simler
 * @version Lab10
 */

public class QuadraticSorts {
   
   public static <T extends Comparable<? super T>> void bubbleSort1(T[] arr) {
   
   }

   public static <T extends Comparable<? super T>> void bubbleSort2(T[] arr) {

   }

   // Method to sort list using selection sort
   public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
      int minIndex;
      T temp;

      // i will indicate the number of sorted elements
      for (int i = 0; i < arr.length - 1; i++) {
         minIndex = i;
         
         // j indicates where to look for minimum
         for (int j = i + 1; j < arr.length; j++) {
            // Check if minIndex is bigger than j
            if (arr[minIndex].compareTo(arr[j]) > 0) {
               minIndex = j;
            }   
         }

         // Swap element at i with minimum element
         temp = arr[minIndex];
         arr[minIndex] = arr[i];
         arr[i] = temp;
      }
   }

   public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
      int prevIndex;
      T element;

      // i will be the location of the next sorted element
      for (int i = 1; i < arr.length; i++) {
         prevIndex = i - 1;
         element = arr[i];

         // Shift elements up
         while (prevIndex >= 0 && element.compareTo(arr[prevIndex]) < 0) {
            arr[prevIndex + 1] = arr[prevIndex];
            prevIndex--;
         }

         // Insert element;
         arr[prevIndex + 1] = element;
      }
   }
}
