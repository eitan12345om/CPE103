/**
 * An interface for implementing a hash table.
 *
 * @author Eitan Simler
 * @version Project5
 */

public interface HashTable<T> {

   // Add element to table if not already present
   public boolean add(T element);

   // Returns true if this table contains the element
   public boolean contains(T element);

   // Returns true if this table contains no elements
   public boolean isEmpty();

   // Returns the current load factor of the hash table
   public double loadFactor();

   // Removes element from this table if present
   public boolean remove(T element);

   // Returns number of elements in table
   public int size();

   // Returns hash table size
   public int tableSize();
}
