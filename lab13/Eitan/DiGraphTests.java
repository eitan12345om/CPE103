import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;
import java.io.*;

/**
 * DiGraph tests.
 *
 * @author Eitan Simler
 * @version Lab13
 */

public class DiGraphTests {

   private final double DELTA = 1e-8;

   @Test (expected = FileNotFoundException.class)
   public void test_NoFile() throws FileNotFoundException {
      DiGraph DG = new DiGraph("hello.txt");
   }
   
   @Test (expected = IllegalArgumentException.class)
   public void test_EmptyText() throws FileNotFoundException {
      DiGraph DG = new DiGraph("empty_text.txt");
   }
   
   @Test (expected = IllegalArgumentException.class)
   public void test_MalformedText() throws FileNotFoundException {
      DiGraph DG = new DiGraph("malformed_text.txt");
   }
   
   @Test (expected = IllegalArgumentException.class)
   public void test_NegativeEdge() throws FileNotFoundException {
      DiGraph DG = new DiGraph("negative_edge_text.txt");
   }
   
   //@Test (expected = IllegalArgumentException.class)
   //public void test_NoVertex() throws FileNotFoundException {
   //   DiGraph DG = new DiGraph("inputText9.20");
   //   DG.setStart("v11");
   //}
   
   @Test
   public void test_V1() throws FileNotFoundException {
      DiGraph DG = new DiGraph("inputText9.20");
      DG.setStart("v1");
      assertEquals(0, DG.getDistanceTo("v7"), DELTA);
   }
}
