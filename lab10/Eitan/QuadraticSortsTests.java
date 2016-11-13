import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for QuadraticSorts.
 *
 * @author Eitan Simler
 * @version Lab10
 */

public class QuadraticSortsTests {

   @Test
   public void test_selectionSort1() {
      Integer[] arr = new Integer[] {5, 8, 2, 3, 7, 1, 9};
      QuadraticSorts.selectionSort(arr);
      assertTrue(listEquals(new Integer[] {1, 2, 3, 5, 7, 8, 9}, arr));
   }
   
   @Test
   public void test_selectionSort2() {
      Integer[] arr = new Integer[] {5, 5, 5, 3, 7, 1, 9};
      QuadraticSorts.selectionSort(arr);
      assertTrue(listEquals(new Integer[] {1, 3, 5, 5, 5, 7, 9}, arr));
   }
   
   @Test
   public void test_selectionSort3() {
      Integer[] arr = new Integer[] {5, 5, 5, 3, 7, 1, 9, -4, 7};
      QuadraticSorts.selectionSort(arr);
      assertTrue(listEquals(new Integer[] {-4, 1, 3, 5, 5, 5, 7, 7, 9}, arr));
   }
   
   @Test
   public void test_selectionSort4() {
      String[] arr = new String[] {"a", "aa", "a", "ba", "ab", "aac"};
      QuadraticSorts.selectionSort(arr);
      assertTrue(listEquals(new String[] {"a", "a", "aa", "aac", "ab", "ba"}, arr));
   }
   
   @Test
   public void test_selectionSort5() {
      String[] arr = new String[] {"ba", "a", "aa", "a", "ba", "ab", "aac"};
      QuadraticSorts.selectionSort(arr);
      assertTrue(listEquals(new String[] {"a", "a", "aa", "aac", "ab", "ba", "ba"}, arr));
   }

   // Private heper method
   private static <T> boolean listEquals(T[] expected, T[] given) {
      if (expected.length != given.length) {
         return false;
      }

      for (int i = 0; i < expected.length; i++) {
         if (!expected[i].equals(given[i])) {
            return false;
         }
      }

      return true;
   }
}
