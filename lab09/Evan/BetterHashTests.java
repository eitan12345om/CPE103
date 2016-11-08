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

public class BetterHashTests
{

   BetterHash bh = new BetterHash();

   @Test
   public void test()
   {
      System.out.print(bh.hash("AWAY"));
      assertEquals(665017, bh.hash("FAR"));
      assertEquals(665017, bh.hash("FAR"));
      assertEquals(60148722,bh.hash("AWAY"));
   }
}
