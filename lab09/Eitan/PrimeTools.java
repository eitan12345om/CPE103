import java.util.NoSuchElementException;

/**
 * Class containing multiple methods to deal with prime numbers.
 *
 * @author Eitan Simler
 * @version Lab09
 */

public class PrimeTools {

   // Determines if given number is prime
   public static boolean isPrime(int value) {
      if (value < 2) {
         return false;
      }
      
      if (value < 4) {
         return true;
      }

      // Check if value divisible by 2 or 3
      if (value % 2 == 0 || value % 3 == 0) {
         return false;
      }
     

      int sqrtValue = (int) Math.sqrt(value);
      int i = 5;
      while (i < sqrtValue) {
         if (value % i == 0 || value % (i + 2) == 0) {
            return false;
         }
         i += 6;
      }

      return true;
   }

   public static int nextPrime(int value) {
      if (value < 0) {
         throw new IllegalArgumentException();
      }

      while (value <= Integer.MAX_VALUE ) {
         if (isPrime(value)) {
            return value;
         }
         value++;
      }
      
      throw new NoSuchElementException();
   }
}
