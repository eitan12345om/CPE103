/**
 *Better hash class implements hashable interface
 *
 *
 *
 *@author Evan Jameson
 *@version Lab 09
 */

import java.util.*;
import java.lang.*;

public class BetterHash implements Hashable<String>
{
 /*  public BetterHash()
   {

   }*/

   public int hash(String s)
   {
      int hash = 0;
      int len = s.length();

      for(int i = 0; i < len; i++)
      {
         hash = hash * 97 + s.charAt(i);
      }
      return hash;
   }
}
