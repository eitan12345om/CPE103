import java.util.*;

/**
 * Class containing various static methods for evaluating hasing algorithms.
 *
 * @author Eitan Simler
 * @version Lab09
 */

public class HashTools {

   // Determines number of hash code collisions
   public static <T> int collisions(List<T> list, int tableSize, Hashable<T> hashable) {
      // Use nextPrime for tableSize
      tableSize = PrimeTools.nextPrime(tableSize);
      
      // Simulate hash table
      boolean[] arr = new boolean[tableSize];
      
      // Variables to help with calulcations
      int counter = 0;
      int result;

      // Loop through each element
      for (T el : list) {
         // Store result of hashing
         result = Math.abs(hashable.hash(el) % tableSize);
         // Check if array spot already "filled"
         if (!arr[result]) {
            arr[result] = true;
         }
         // Spot is filled. Increment counter
         else {
            counter++;
         }
      }

      return counter;
   }
   
   // Determines max number of hash code collisions in one place
   public static <T> int maxCollisions(List<T> list, int tableSize, Hashable<T> hashable) {
      // Use nextPrime for tableSize
      tableSize = PrimeTools.nextPrime(tableSize);
      
      // Simulate hash table
      int[] arr = new int[tableSize];
      
      // Variables to help with calulcations
      int result;
      int maximum = 0;

      // Loop through each element
      for (T el : list) {
         // Store result of hashing
         result = Math.abs(hashable.hash(el) % tableSize);
         
         arr[result] += 1;

         // Check if maximum is less than new number
         if (maximum < arr[result]) {
            maximum = arr[result];
         }
      }

      return maximum;
   }

   // Determines the average length of collisions
   public static <T> double avgCollisions(List<T> list, int tableSize, Hashable<T> hashable) {
      // Return result of collisions and divides by size of list
      tableSize = PrimeTools.nextPrime(tableSize);
      return list.size() / ((double) (tableSize - unused(list, tableSize, hashable)));
   }

   // Determines number of unused hash table cells
   public static <T> int unused(List<T> list, int tableSize, Hashable<T> hashable) {
      // Use nextPrime for tableSize
      tableSize = PrimeTools.nextPrime(tableSize);
      
      // Simulate hash table
      boolean[] arr = new boolean[tableSize];
      
      // Variable to help with calulcations
      int counter = tableSize;
      int result;

      // Loop through each element
      for (T el : list) {
         // Store result of hashing
         result = Math.abs(hashable.hash(el) % tableSize);
         // Check if array spot already "filled"
         if (!arr[result]) {
            counter--;
            arr[result] = true;
         }
      }

      return counter;
   }
}
