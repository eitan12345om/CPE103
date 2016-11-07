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

public class HashToolsTests
{
   StringHash s = new StringHash();
   HashTools tool = new HashTools();
   double delta = .00001;
   @Test
   public void test1_collisions()
   {
      ArrayList<String> list = new ArrayList<>();
      list.add("john");
      list.add("joe");
      list.add("joe");
      list.add("john");
      list.add("sam");
      list.add("john");
      list.add("sam");
      list.add("john");
      list.add("john");
      list.add("john");
      assertEquals(7, tool.collisions(list, 10, s));
      assertEquals(2.3333333, tool.avgCollisions(list, 10, s), delta);
      assertEquals(5, tool.maxCollisions(list, 10, s));
   }

   @Test
   public void test2_collisions()
   {
   
   }
}
