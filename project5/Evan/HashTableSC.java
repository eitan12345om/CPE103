/**
 *Hash table class thaat uses separate chaining
 *
 *
 *
 *@author Evan Jameson
 *@version Project 5
 */

public class HashTableSC<T> implements HashTable<T>, HashMetrics
{
   private int tableSize;
   private int size;
   private int collisions;
   private int maxCollisions;
   private Object[] table;

   public HashTableSC(int tableSize)
   {
      if(tableSize < 0)
      {
         throw new IllegalArgumentException();
      }

      this.tableSize = PrimeTools.nextPrime(tableSize);
      this.table = new Object[this.tableSize];
   }

   @SuppressWarnings("unchecked")
   public boolean add(T element)
   {
      int hash = Math.abs(element.hashCode() % tableSize);
      Entry entry = (Entry)table[hash];

      if(entry == null)
      {
         table[hash] = new Entry(element);
         size++;
         return true;
      }
      else
      {
         int numCollisions = 0;

         while(true)
         {
            numCollisions++;
            if(entry.element.equals(element))
            {
               collisions += numCollisions;
               if(maxCollisions < numCollisions)
               {
                  maxCollisions = numCollisions;
               }
               return false;
            }
            if(entry.next == null)
            {
               entry.next = new Entry(element);
               size++;
               collisions += numCollisions;
               if(maxCollisions < numCollisions)
               {
                  maxCollisions = numCollisions;
               }
               return true;
            }
            entry = entry.next;
         }
      }
   }

   @SuppressWarnings("unchecked")
   public boolean contains (T element)
   {
      int hash = Math.abs(element.hashCode() % tableSize);
      Entry entry = (Entry)table[hash];
      if(entry != null)
      {
         while(entry != null)
         {
            if(entry.element.equals(element))
            {
               return true;
            }
            entry = entry.next;
         }
      }
      return false;
   }

   public boolean isEmpty()
   {
      return size == 0;
   }

   public double loadFactor()
   {
      return (double)size/tableSize;
   }

   @SuppressWarnings("unchecked")
   public boolean remove(T element)
   {
      int hash = Math.abs(element.hashCode() % tableSize);
      Entry entry = (Entry)table[hash];
      if(entry == null)
      {
         return false;
      }
      if(entry.element.equals(element))
      {
         table[hash] = entry.next;
         size--;
         return true;
      }
      else
      {
         while(entry.next != null)
         {
            if(entry.next.element.equals(element))
            {
               entry.next = entry.next.next;
               size--;
               return true;
            }
            entry = entry.next;
         }
         return false;
      }
   }

   public int size()
   {
      return size;
   }

   public int tableSize()
   {
      return tableSize;
   }

   public long collisions()
   {
      return collisions;
   }

   public int maxCollisions()
   {
      return maxCollisions;
   }
   
   //Private inner Entry class
   private class Entry
   {
      private T element;
      private Entry next;

      public Entry(T element)
      {
         this.element = element;
         this.next = null;
      }
   }
}
