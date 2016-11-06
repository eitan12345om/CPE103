/**
 * Interface for hash classes.
 *
 * @author Eitan Simler
 * @version Lab09
 */

public interface Hashable<T> {

   // Returns hash code for specified object
   public int hash(T input);
}
