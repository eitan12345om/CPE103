/**
 *JUnit Tests for the shell sorts class
 *
 *
 *
 *@author Evan Jameson
 *@version lab11
 */

import org.junit.*;
import static org.junit.Assert.*;

public class ShellSortsTests
{
   @Test
   public void test1_shellSort() 
   {
      Integer[] array = new Integer[] {5, 8, 2, 3, 7, 1, 9};
      ShellSorts.shell(array);
      assertTrue(check(new Integer[] {1, 2, 3, 5, 7, 8, 9}, array));
   }
   
   @Test
   public void test2_shellSort() 
   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9};
      ShellSorts.shell(array);
      assertTrue(check(new Integer[] {1, 3, 5, 5, 5, 7, 9}, array));
   }
   
   @Test
   public void test3_shellSort() 
   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9, -4, 7};
      ShellSorts.shell(array);
      assertTrue(check(new Integer[] {-4, 1, 3, 5, 5, 5, 7, 7, 9}, array));
   }

   @Test
   public void test4_hibbard() 
   {
      Integer[] array = new Integer[] {5, 8, 2, 3, 7, 1, 9};
      ShellSorts.hibbard(array);
      assertTrue(check(new Integer[] {1, 2, 3, 5, 7, 8, 9}, array));
   }
   
   @Test
   public void test5_hibbard() 
   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9};
      ShellSorts.hibbard(array);
      assertTrue(check(new Integer[] {1, 3, 5, 5, 5, 7, 9}, array));
   }
   
   @Test
   public void test6_hibbard() 
   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9, -4, 7};
      ShellSorts.hibbard(array);
      assertTrue(check(new Integer[] {-4, 1, 3, 5, 5, 5, 7, 7, 9}, array));
   }

   @Test
   public void test7_sedgewick() 
   {
      Integer[] array = new Integer[] {5, 8, 2, 3, 7, 1, 9};
      ShellSorts.sedgewick(array);
      assertTrue(check(new Integer[] {1, 2, 3, 5, 7, 8, 9}, array));
   }
   
   @Test
   public void test8_sedgewick() 
   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9};
      ShellSorts.sedgewick(array);
      assertTrue(check(new Integer[] {1, 3, 5, 5, 5, 7, 9}, array));
   }
   
   @Test
   public void test9_sedgewick() 

   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9, -4, 7};
      ShellSorts.sedgewick(array);
      assertTrue(check(new Integer[] {-4, 1, 3, 5, 5, 5, 7, 7, 9}, array));
   }

   @Test
   public void test10_heapSort() 
   {
      Integer[] array = new Integer[] {5, 8, 2, 3, 7, 1, 9};
      ShellSorts.heapSort(array);
      assertTrue(check(new Integer[] {1, 2, 3, 5, 7, 8, 9}, array));
   }
   
   @Test
   public void test11_heapSort() 
   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9};
      ShellSorts.heapSort(array);
      assertTrue(check(new Integer[] {1, 3, 5, 5, 5, 7, 9}, array));
   }
   
   @Test
   public void test12_heapSort() 
   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9, -4, 7};
      ShellSorts.heapSort(array);
      assertTrue(check(new Integer[] {-4, 1, 3, 5, 5, 5, 7, 7, 9}, array));
   }

   private static <T> boolean check(T[] expected, T[] given) 
   {
      if (expected.length != given.length) 
      {
         return false;
      }

      for (int i = 0; i < expected.length; i++) 
      {
         if (!expected[i].equals(given[i])) 
         {
            return false;
         }
      }
      return true;
   }
}
