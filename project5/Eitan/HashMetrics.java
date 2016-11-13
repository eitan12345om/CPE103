/**
 * An interface for counting collisions in a hash table.
 *
 * @author Eitan Simler
 * @version Project5
 */

public interface HashMetrics {

   // Returns total number of collisions during all add calls
   public long collisions();

   // Returns maximum number of collisions during single add call
   public int maxCollisions();
}
