import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for TSort.
 *
 * @author Eitan Simler
 * @version Lab12
 */

public class TSortTests {

   @Test (expected=IllegalArgumentException.class)
   public void test_TSort_Empty() {
      TSort.tsort("");
   }
   
   @Test (expected=IllegalArgumentException.class)
   public void test_TSort_oddEdges1() {
      TSort.tsort("101");
   }
   
   @Test (expected=IllegalArgumentException.class)
   public void test_TSort_oddEdges2() {
      TSort.tsort("101 304 5");
   }
   
   @Test (expected=IllegalArgumentException.class)
   public void test_TSort_Cycle() {
      TSort.tsort("101 102 102 101");
   }

   @Test
   public void test_TSort1() {
      String edges = "101 102 102 103";
      String returnValue = "101\n102\n103\n";
      assertEquals(returnValue, TSort.tsort(edges));
   }
   
   @Test
   public void test_TSort2() {
      String edges = "blue black red blue red green green blue green purple purple blue";
      String returnValue = "red\ngreen\npurple\nblue\nblack\n";
      assertEquals(returnValue, TSort.tsort(edges));
   }
   
   @Test
   public void test_TSort3() {
      String edges = "1 2 1 9 1 8 9 8 9 10 8 11 10 11 2 3 3 11 3 4 4 7 4 5 7 5 7 13 7 6 6 14 6 12";
      String returnValue = "1\n9\n10\n8\n2\n3\n4\n7\n6\n12\n14\n13\n5\n11\n";
      assertEquals(returnValue, TSort.tsort(edges));
   }
}
