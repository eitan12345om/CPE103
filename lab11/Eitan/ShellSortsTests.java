import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for ShellSorts
 *
 * @author Eitan Simler
 * @version Lab11
 */

public class ShellSortsTests {

   @Test
   public void test_shell() {
      Integer[] array = new Integer[] {2, 52, 5, 66, 3, 4, 6, 31, 32, 6, 3, 4, 7, 1, 2,
         7, 8};
      ShellSorts.shell(array);
      assertTrue(listEquals(new int[] {1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7, 8,
         31, 32, 52, 66}, array));
   }

   @Test
   public void test_hibbard() {
      Integer[] array = new Integer[] {2, 52, 5, 66, 3, 4, 6, 31, 32, 6, 3, 4, 7, 1, 2,
         7, 8};
      ShellSorts.hibbard(array);
      assertTrue(listEquals(new int[] {1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7, 8,
         31, 32, 52, 66}, array));
   }
   
   @Test
   public void test_sedgewick() {
      Integer[] array = new Integer[] {2, 52, 5, 66, 3, 4, 6, 31, 32, 6, 3, 4, 7, 1, 2,
         7, 8};
      ShellSorts.sedgewick(array);
      assertTrue(listEquals(new int[] {1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7, 8,
         31, 32, 52, 66}, array));
   }

   @Test
   public void test_heapSort() {
      Integer[] array = new Integer[] {2, 52, 5, 66, 3, 4, 6, 31, 32, 6, 3, 4, 7, 1, 2,
         7, 8};
      ShellSorts.heapSort(array);
      assertTrue(listEquals(new int[] {1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7, 8,
         31, 32, 52, 66}, array));
   }
   
   // Private helper method
   private boolean listEquals(int[] a, Integer[] b) {
      if (a.length != b.length) {
         return false;
      }

      for (int i = 0; i < a.length; i++) {
         if (a[i] != b[i]) {
            return false;
         }
      }

      return true;
   }
}
