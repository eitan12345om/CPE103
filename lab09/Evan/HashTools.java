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
      for(int i = 0; i < tableSize; i++)
      {
         int hash = hashable.hash(list.get(i));
         test.add(hash);
         if(test.size() > 1)//no point to check before this
         {
            for (int j = 0; j < test.size()-1; j++)//test.size()-1 so it doesnt see itself
            {
               if(hash == test.get(j))
               {
                  collisions++;
                  test.remove(j);
               }
            }
         }
      }
      return collisions;
   }

   public static <T> double avgCollisions(List<T> list, int tableSize, Hashable<T> hashable)
   {
      throw new RuntimeException("Todo");
   }

   public static <T> int maxCollisions(List<T> list, int tableSize, Hashable<T> hashable)
   {
      throw new RuntimeException("Todo");
   }

   public static <T> int unUsed(List<T> list, int tableSize, Hashable<T> hashable)
   {
      throw new RuntimeException("Todo");
   }
}
