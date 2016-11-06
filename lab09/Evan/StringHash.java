/**
 *String hash class tat implements Hashable interface
 *
 *
 *
 *@author Evan Jameson
 *@version Lab 09
 */

import java.util.*;

public class StringHash implements Hashable<String>
{
   public int hash(String s)
   {
      return s.hashCode();
   }
}
