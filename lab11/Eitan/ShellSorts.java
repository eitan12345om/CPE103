/**
 * A class containing multiple implementations of Shell Sort.
 *
 * @author Eitan Simler
 * @version Lab11
 */

public class ShellSorts {

   public static <T extends Comparable<? super T>> void shell(T[] array) {
      shellSort(array, new int[] {128, 64, 32, 16, 8, 4, 2, 1});
   }
   
   public static <T extends Comparable<? super T>> void hibbard(T[] array) {
      shellSort(array, new int[] {255, 127, 63, 31, 15, 7, 3, 1});
   }
   
   public static <T extends Comparable<? super T>> void sedgewick(T[] array) {
      shellSort(array, new int[] {16577, 4193, 1073, 281, 77, 23, 8, 1});
   }
   
   public static <T extends Comparable<? super T>> void heapSort(T[] array) {
      PriorityQueue<T> pq = new PriorityQueue<>();
      pq.sort(array, array.length);
   }

   private static <T extends Comparable<? super T>> void shellSort(T[] array,
         int[] gaps) {
      T temp;
      int j;
      
      // For each gap
      for (int gap : gaps) {
         // Loop through array
         for (int i = 0; i < array.length; i++) {
            temp = array[i];

            // Shift elements until correct location for array[i] is found
            for (j = i; j >= gap && array[j - gap].compareTo(temp) > 0; 
                  j -= gap) {
               array[j] = array[j - gap];
            }

            // Put temp in correct location
            array[j] = temp;
         }
      }
   }
}
