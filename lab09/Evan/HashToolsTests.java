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
      assertEquals(4, tool.collisions(list, 7, s));
   }
}
