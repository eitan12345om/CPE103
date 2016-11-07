/**
 * Class that hashes by my standard.
 *
 * @author Eitan Simler
 * @version Lab09
 */

public class MyHash implements Hashable<String> {

   public int hash(String s) {
      // Returns the hashCode designed by me
      int hash = 0;
      int len = s.length();
      int var = 178689;

      for (int i = 0; i < len; i++) {
         var = PrimeTools.nextPrime(var);
         hash = (int) Math.sqrt((hash + var) * var) + s.charAt(i);
      }

      return hash;
   } 
}

