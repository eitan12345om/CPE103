/**
 * A hash table that uses separate chaining for collisions.
 *
 * @author Eitan Simler
 * @version Project5
 */

public class HashTableSC<T> implements HashTable<T>, HashMetrics {

   // Instance variables
   private int tableSize;
   private Entry[] table;


   // Constructor
   public HashTableSC(int tableSize) {
      this.tableSize = PrimeTools.nextPrime(tableSize);
      this.table = (Entry[]) new Object[this.tableSize];
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
      // TODO: Method body
      return false; 
   }

   @Override
   public double loadFactor() { 
      // TODO: Method body
      return 0.0;
   }

   @Override
   public boolean remove(T element) {
      // TODO: Method body
      return false; 
   }

   @Override
   public int size() {
      // TODO: Method body
      return 0; 
   }

   @Override
   public int tableSize() {
      // TODO: Method body
      return 0;    
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
