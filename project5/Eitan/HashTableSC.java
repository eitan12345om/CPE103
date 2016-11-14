/**
 * A hash table that uses separate chaining for collisions.
 *
 * @author Eitan Simler
 * @version Project5
 */

public class HashTableSC<T> implements HashTable<T>, HashMetrics {

   // Instance variables
   private int tableSize;
   private Object[] table;
   private int size = 0;

   // Constructor
   public HashTableSC(int tableSize) {
      // Check if tableSize is negative
      if (tableSize < 0) {
         throw new IllegalArgumentException();
      }

      // Make tableSize next prime
      this.tableSize = PrimeTools.nextPrime(tableSize);
      this.table = new Object[this.tableSize];
   }

   // Methods as required by HashTable
   @Override
   public boolean add(T element) {
      // TODO: Method body
      return false;
   }

   @Override
   public boolean contains(T element) {
      // TODO: Method body
      return false; 
   }

   @Override
   public boolean isEmpty() {
      return size == 0; 
   }

   @Override
   public double loadFactor() { 
      // Ideally around 1 for Separate Chaining strategy
      return size / tableSize;
   }

   @Override
   public boolean remove(T element) {
      // TODO: Method body
      return false; 
   }

   @Override
   public int size() {
      return size; 
   }

   @Override
   public int tableSize() {
      return tableSize;    
   }
   
   // Methods as required by HashMetrics
   @Override
   public long collisions() {
      // TODO: Method body
      return 0;  
   }

   @Override
   public int maxCollisions() {
      // TODO: Method body
      return 0;  
   }

   // Private inner class to represent an entry
   private class Entry {
      // Instance variable
      private T element;
      private Entry next;

      // Constructor
      public Entry(T element) {
         this.element = element;
         this.next = null;
      }
   }
}
