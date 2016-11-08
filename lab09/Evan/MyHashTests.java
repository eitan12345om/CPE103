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

public class MyHashTests
{
   MyHash mh = new MyHash();

   @Test
   public void test()
   {
      assertEquals(263409328, mh.hash("FAR"));
      assertEquals(263409328, mh.hash("FAR"));
      assertEquals(430996228, mh.hash("AWAY"));
   }
}
