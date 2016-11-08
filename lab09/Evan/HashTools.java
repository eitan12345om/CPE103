/**
 *Hash tools class
 *
 *
 *
 *@author Evan Jameson
 *@version Lab 09
 */

import java.util.*;

public class HashTools
{
   private static PrimeTools pt = new PrimeTools();

   public static <T> int collisions(List<T> list, int tableSize, Hashable<T> hashable)
   {
      ArrayList<Integer> test = new ArrayList<>();//list of hashes created
      int collisions = 0;

      if(!pt.isPrime(tableSize))
      {
         tableSize = pt.nextPrime(tableSize);
      }
      for(int i = 0; i < list.size(); i++)
      {
         int hash = Math.abs(hashable.hash(list.get(i))%tableSize);
         
         if(test.contains(hash))
         {
            collisions++;
         }
         test.add(hash);
      }
      return collisions;
   }

   public static <T> double avgCollisions(List<T> list, int tableSize, Hashable<T> hashable)
   {
      ArrayList<Integer> test = new ArrayList<>();//list of hashes created
      ArrayList<Integer> colliders = new ArrayList<>(); // hashes tht had collisions
      double collisions = 0;

      if(!pt.isPrime(tableSize))
      {
         tableSize = pt.nextPrime(tableSize);
      }
      for(int i = 0; i < list.size(); i++)
      {
         int hash = Math.abs(hashable.hash(list.get(i))%tableSize);
         
         if(test.contains(hash))
         {
            if(!colliders.contains(hash))
            {
               colliders.add(hash);
            }
            collisions++;
         }
         test.add(hash);
      }
      return ((collisions/colliders.size()) + 1);
   }

   public static <T> int maxCollisions(List<T> list, int tableSize, Hashable<T> hashable)
   {
      ArrayList<Integer> test = new ArrayList<>();//list of hashes created

      int collisions = 0;
      int maxCollisions = 0;

      if(!pt.isPrime(tableSize))
      {
         tableSize = pt.nextPrime(tableSize);
      }

      int[] hashes = new int[tableSize];

      for(int i = 0; i < list.size(); i++)
      {
         int hash = Math.abs(hashable.hash(list.get(i))%tableSize);
      
         if(hashes[hash] >= 0)
         {
            hashes[hash] += 1;
         }
         if(hashes[hash] > maxCollisions)
         {
            maxCollisions = hashes[hash];
         }
      }
      return maxCollisions;
   }

   public static <T> int unUsed(List<T> list, int tableSize, Hashable<T> hashable)
   {
      int size = 0;
      if(!pt.isPrime(tableSize))
      {
         tableSize = pt.nextPrime(tableSize);
      }

      Integer[] hashes = new Integer[tableSize];

      for(int i = 0 ;i < list.size(); i++)
      {  
         int hash  = Math.abs(hashable.hash(list.get(i))%tableSize);
         if(hashes[hash] == null)
         {
            hashes[hash] = hash;
            size++;
         }
      }
      return tableSize - size;
   }
}
