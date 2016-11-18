/**
 * JUnit tests for QuadraticSorts
 *
 * @author Evan Jameson
 * @version Lab10
 */

import org.junit.*;
import static org.junit.Assert.*;

public class QuadraticSortsTests 
{

   @Test
   public void test1_selectionSort() 
   {
      Integer[] array = new Integer[] {5, 8, 2, 3, 7, 1, 9};
      QuadraticSorts.selectionSort(array);
      assertTrue(check(new Integer[] {1, 2, 3, 5, 7, 8, 9}, array));
   }
   
   @Test
   public void test2_selectionSort() 
   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9};
      QuadraticSorts.selectionSort(array);
      assertTrue(check(new Integer[] {1, 3, 5, 5, 5, 7, 9}, array));
   }
   
   @Test
   public void test3_selectionSort() 
   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9, -4, 7};
      QuadraticSorts.selectionSort(array);
      assertTrue(check(new Integer[] {-4, 1, 3, 5, 5, 5, 7, 7, 9}, array));
   }

   @Test
   public void test4_insertionSort() 
   {
      Integer[] array = new Integer[] {5, 8, 2, 3, 7, 1, 9};
      QuadraticSorts.insertionSort(array);
      assertTrue(check(new Integer[] {1, 2, 3, 5, 7, 8, 9}, array));
   }
   
   @Test
   public void test5_insertionSort() 
   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9};
      QuadraticSorts.insertionSort(array);
      assertTrue(check(new Integer[] {1, 3, 5, 5, 5, 7, 9}, array));
   }
   
   @Test
   public void test6_insertionSort() 
   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9, -4, 7};
      QuadraticSorts.insertionSort(array);
      assertTrue(check(new Integer[] {-4, 1, 3, 5, 5, 5, 7, 7, 9}, array));
   }

   @Test
   public void test7_bubbleSort1() 
   {
      Integer[] array = new Integer[] {5, 8, 2, 3, 7, 1, 9};
      QuadraticSorts.bubbleSort1(array);
      assertTrue(check(new Integer[] {1, 2, 3, 5, 7, 8, 9}, array));
   }
   
   @Test
   public void test8_bubbleSort1() 
   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9};
      QuadraticSorts.bubbleSort1(array);
      assertTrue(check(new Integer[] {1, 3, 5, 5, 5, 7, 9}, array));
   }
   
   @Test
   public void test9_bubbleSort1() 

   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9, -4, 7};
      QuadraticSorts.bubbleSort1(array);
      assertTrue(check(new Integer[] {-4, 1, 3, 5, 5, 5, 7, 7, 9}, array));
   }
   
   @Test
   public void test10_bubbleSort2() 
   {
      Integer[] array = new Integer[] {5, 8, 2, 3, 7, 1, 9};
      QuadraticSorts.bubbleSort2(array);
      assertTrue(check(new Integer[] {1, 2, 3, 5, 7, 8, 9}, array));
   }
   
   @Test
   public void test11_bubbleSort2() 
   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9};
      QuadraticSorts.bubbleSort2(array);
      assertTrue(check(new Integer[] {1, 3, 5, 5, 5, 7, 9}, array));
   }
   
   @Test
   public void test12_bubbleSort2() 
   {
      Integer[] array = new Integer[] {5, 5, 5, 3, 7, 1, 9, -4, 7};
      QuadraticSorts.bubbleSort2(array);
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