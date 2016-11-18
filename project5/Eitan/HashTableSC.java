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
   private int size;
   private int collisions;
   private int maxCollisions;

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
   @SuppressWarnings("unchecked")
   public boolean add(T element) {
      // Hash element, then mod by tableSize, then absolute value
      int hash = Math.abs(element.hashCode() % tableSize);

      // Get entry from table
      Entry entry = (Entry) table[hash];
      
      // Check if entry is null
      if (entry == null) {
         table[hash] = new Entry(element);
         size++;
         return true;
      }
      else {
         int numCollisions = 0;

         // Loop through entries in the linked list
         while (true) {
            numCollisions++;
            
            // Check if entry already in linked list
            if (entry.element.equals(element)) {
               // Increment collisions and maxCollisions (if necessary)
               collisions += numCollisions;
               if (maxCollisions < numCollisions) {
                  maxCollisions = numCollisions;
               }
               return false;
            }
            
            // Check if next is null
            if (entry.next == null) {
               entry.next = new Entry(element);
               size++;
               
               // Increment collisions and maxCollisions (if necessary)
               collisions += numCollisions;
               if (maxCollisions < numCollisions) {
                  maxCollisions = numCollisions;
               }
               return true;
            }

            entry = entry.next;
         }
      }     
   }

   @Override
   @SuppressWarnings("unchecked")
   public boolean contains(T element) {
      // Hash element, then mod by tableSize, then absolute value
      int hash = Math.abs(element.hashCode() % tableSize);

      // Get entry from table
      Entry entry = (Entry) table[hash];
      
      // Check if entry is not null
      if (entry != null) {
         // Loop through entries in the linked list
         while (entry != null) {
            // Check if entry already in linked list
            if (entry.element.equals(element)) {
               return true;
            }
            entry = entry.next;
         }
      }   

      return false;
   }

   @Override
   public boolean isEmpty() {
      return size == 0; 
   }

   @Override
   public double loadFactor() { 
      // Ideally around 1 for Separate Chaining strategy
      return (1.0 * size) / tableSize;
   }

   @Override
   @SuppressWarnings("unchecked")
   public boolean remove(T element) {
      // Hash element, then mod by tableSize, then absolute value
      int hash = Math.abs(element.hashCode() % tableSize);

      // Get entry from table
      Entry entry = (Entry) table[hash];
      
      // Check if entry is null
      if (entry == null) {
         return false;
      }
      // Check if current element in specified element
      if (entry.element.equals(element)) {
         entry.next = entry.next == null ? null : entry.next.next;
         size--;
         return true;
      }

      else {
         // Loop through entries in the linked list
         while (entry.next != null) {
            // Check if entry in linked list
            if (entry.next.element.equals(element)) {
               entry.next = entry.next == null ? null : entry.next.next;
               size--; 
               return true;
            }
            
            entry = entry.next;
         }

         return false;
      }     
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
      return collisions;  
   }

   @Override
   public int maxCollisions() {
      return maxCollisions;  
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
