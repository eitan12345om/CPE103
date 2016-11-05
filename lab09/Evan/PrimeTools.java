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
   public PrimeTools()
   {

   }

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
      for(int i = 5; (i*i) <= value; i+=6)
      {
         if(value%i == 0 || value%(i + 2) == 0)
         {
            return false;
         }
      }
      return true;
   }

   public static int nextPrime(int value)
   {
      int test = value + 1;
      if(value <= 1)
      {
         throw new IllegalArgumentException();
      }
      while(test < Integer.MAX_VALUE)
      {
         if(isPrime(test))
         {
            return test;
         }
         test++;
      }
      throw new NoSuchElementException();
   }
}
