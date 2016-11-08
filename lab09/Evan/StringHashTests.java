/**
 *JUnit Tests for hastools class
 *
 *
 *
 *@author Evan Jameson
 *@version Lab09
 */

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;

public class StringHashTests
{
   @Test
   public void test()
   {
   
      //Hash
      StringHash sh = new StringHash();

      //for reading in file
      File file = new File("dictionary.txt");
      ArrayList<String> list = new ArrayList<>(); 
      try
      {
        Scanner sc = new Scanner(file);

        //reading in dictionary
        while(sc.hasNext())
        {
            list.add(sc.next());
        }
        sc.close();
         
      }
      catch(FileNotFoundException e)
      {
         e.printStackTrace();
      }

      for(int i = 0; i < list.size(); i++)
      {
        assertEquals(list.get(i).hashCode(), sh.hash(list.get(i)));
      }
   }
}
