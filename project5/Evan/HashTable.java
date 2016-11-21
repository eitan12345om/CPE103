/**
 *Hash Table interface
 *
 *
 *
 *@author Evan Jameson
 *@version Project 5
 */

public interface HashTable<T>
{
   public boolean add(T element);
   public boolean contains(T element);
   public boolean isEmpty();
   public double loadFactor();
   public boolean remove(T element);
   public int size();
   public int tableSize();
}  
