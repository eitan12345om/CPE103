/**
 * A class containing multiple implementations of Shell Sort.
 *
 * @author Eitan Simler
 * @version Lab11
 */

public class ShellSorts {

   public static <T extends Comparable<? super T>> void shell(T[] array) {
      // TODO: Method body
   }
   
   public static <T extends Comparable<? super T>> void hibbard(T[] array) {
      // TODO: Method body
   }
   
   public static <T extends Comparable<? super T>> void sedgewick(T[] array) {
      // TODO: Method body
   }
   
   public static <T extends Comparable<? super T>> void heapSort(T[] array) {
      // TODO: Method body
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
