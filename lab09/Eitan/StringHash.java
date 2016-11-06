/**
 * Class that hashes by String.
 *
 * @author Eitan Simler
 * @version Lab09
 */

public class StringHash implements Hashable<String> {

   public int hash(String s) {
      // Returns the hashCode from String class
      return s.hashCode();
   } 
}
