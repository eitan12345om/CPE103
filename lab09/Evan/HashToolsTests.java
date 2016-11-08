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

public class HashToolsTests
{
   @Test
   public void test()
   {
   
      //Hashes
      StringHash sh = new StringHash();
      BetterHash bh = new BetterHash();
      MyHash mh = new MyHash();
   
      //hashtools file
      HashTools tool = new HashTools();
   
      //delta for equals
     double delta = .001;

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
      //num collisions
      assertEquals(178588, tool.collisions(list, 100, sh));
      assertEquals(178588, tool.collisions(list, 100, bh));
      assertEquals(178588, tool.collisions(list, 100, mh));

      //max collisions
      assertEquals(1881, tool.maxCollisions(list, 100, sh));
      assertEquals(1896, tool.maxCollisions(list, 100, bh));
      assertEquals(1874, tool.maxCollisions(list, 100, mh));

      //avg collisions
      assertEquals(1769.1980198019803, tool.avgCollisions(list, 100, sh),delta);
      assertEquals(1769.1980198019803, tool.avgCollisions(list, 100, bh),delta);
      assertEquals(1769.1980198019803, tool.avgCollisions(list, 100, mh),delta);

      //unused
      assertEquals(0, tool.unused(list, 100, sh));
      assertEquals(0, tool.unused(list, 100, bh));
      assertEquals(0, tool.unused(list, 100, mh));
   }
}
