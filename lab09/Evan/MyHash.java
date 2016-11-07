/**
 *My hash class implements hashable interface
 *
 *
 *
 *@author Evan Jameson
 *@version Lab09
 */

import java.util.*;

public class MyHash implements Hashable<String>
{
   public int hash(String s)
   {
      int sum = 0;
      for(int i = 0; i < s.length(); i ++)
      {
         int first = s.charAt(i) * 26;
         if(first % 2 == 1)
         {
            first += 12;
         }
         int second = s.charAt(i) * first;
         if(second % 2 == 0)
         {
            second /= 3;
         }
         int third = first * second;
         if(third % 2 == 1)
         {
            third *= 17;
         }
         sum += third;
      }
      return Math.abs(sum);
   }
}
