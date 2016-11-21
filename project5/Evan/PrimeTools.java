/**
 *Prime tools class for dealing with prime numbers
 *
 *
 *
 *@author Evaan Jameson
 *@version Lab 09
 */

import java.util.*;

public class PrimeTools
{
   public static boolean isPrime(int value)
   {
      if(value <= 1)
      {
         return false;
      }
      else if(value <= 3)
      {
         return true;
      }
      else if(value%2 == 0 || value%3 == 0)
      {
         return false;
      }
      int sqrtValue = (int)Math.sqrt(value);
      int i = 5;
      while(i <= sqrtValue)
      {
         if(value%i == 0 || value%(i + 2) == 0)
         {
            return false;
         }
         i += 6;
      }
      return true;
   }

   public static int nextPrime(int value)
   {
   

         if(value < 0)
         {
            throw new IllegalArgumentException();
         }
         while(value <= Integer.MAX_VALUE)
         {
            if(isPrime(value))
            {
               return value;
            }
            value++;
         }
         throw new NoSuchElementException();
   }
}
