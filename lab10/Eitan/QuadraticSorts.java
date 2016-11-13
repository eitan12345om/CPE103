/**
 * A Quadratic sort class.
 *
 * @author Eitan Simler
 * @version Lab10
 */

public class QuadraticSorts {
   
   public static <T extends Comparable<? super T>> void bubbleSort1(T[] arr) {
      T temp;
      boolean swapped = true;

      // Until there are no swaps
      while (swapped) {
         swapped = false;
         
         // Go through list to see if needs swapping
         for (int i = 0; i < arr.length - 1; i++) {
            // Check if needs swapping
            if (arr[i].compareTo(arr[i + 1]) > 0) {
               temp = arr[i];
               arr[i] = arr[i + 1];
               arr[i + 1] = temp;

               swapped = true;
            }
         }
      }
   }

   public static <T extends Comparable<? super T>> void bubbleSort2(T[] arr) {
      T temp;
      boolean swapped = true;
      int n = 0;

      // Until there are no swaps
      while (swapped) {
         swapped = false;
         
         // Go through list to see if needs swapping
         for (int i = 0; i < arr.length - 1 - n; i++) {
            // Check if needs swapping
            if (arr[i].compareTo(arr[i + 1]) > 0) {
               temp = arr[i];
               arr[i] = arr[i + 1];
               arr[i + 1] = temp;

               swapped = true;
            }
         }

         n++;
      }

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
