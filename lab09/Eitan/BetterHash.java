/**
 * A btter hash class.
 *
 * @author Eitan Simler
 * @version Lab09
 */

public class BetterHash implements Hashable<String> {

   public int hash(String s) {
      int hash = 0;
      int len = s.length();

      for (int i = 0; i < len; i++) {
         // There are 95 displayable ASCII characters, 97 is the next prime...
         hash = hash * 97 + s.charAt(i);
      }

      return hash;
   }
}
