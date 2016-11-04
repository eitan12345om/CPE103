/**
 *junit tests for Binary Heap Utilities class
 *
 *
 *
 *@author Evan Jameson
 *@version Lab 05
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;

public class BinaryHeapUtilitiesTests
{
   BinaryHeapUtilities bnu = new BinaryHeapUtilities();	

   /*=============================|height() tests|=============================*/

   @Test
   public void test1_Height()
   {
      assertEquals(0, bnu.height(1));
   }

   @Test
   public void test2_Height()
   {
      assertEquals(1, bnu.height(2));
   }

   @Test
   public void test3_Height()
   {
      assertEquals(1, bnu.height(3));
   }

   @Test
   public void test4_Height()
   {
      assertEquals(2, bnu.height(4));
   }

   @Test
   public void test5_Height()
   {
      assertEquals(5, bnu.height(32));
   }

   @Test (expected = IllegalArgumentException.class)
   public void test6_badHeight()
   {
      assertEquals(0, bnu.height(0));
   }

   @Test (expected = IllegalArgumentException.class)
   public void test7_badHeight()
   {
      assertEquals(0, bnu.height(-1));
   }

   /*=============================|isHeap() tests|=============================*/

   @Test
   public void test1_isHeap()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertTrue(bnu.isHeap(heap, 4));
   }

   @Test
   public void test2_isHeap()
   {
      Integer[] heap = new Integer[] {0,1,1,1,1};
      assertTrue(bnu.isHeap(heap, 4));
   }

   @Test
   public void test3_isHeap()
   {
      Integer[] heap = new Integer[] {0,7,20,7,28,72,42,80,41,41,98,74,43};
      assertTrue(bnu.isHeap(heap, 12));
   }

   @Test
   public void test4_isHeap()
   {
      Integer[] heap = new Integer[] {0,-5,-4,-3,-2,-1,0,1};
      assertTrue(bnu.isHeap(heap, 7));
   }

   @Test
   public void test5_isHeap()
   {
      Integer[] heap = new Integer[] {0,-20,10,-5,12,14,-1,2};
      assertTrue(bnu.isHeap(heap, 7));
   }

   @Test 
   public void test6_isHeap_badSize()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertFalse(bnu.isHeap(heap, 0));
   }

   @Test
   public void test7_isHeap_badHeap()
   {
      Integer[] heap = new Integer[] {0,1,2,3,2,1,0};
      assertFalse(bnu.isHeap(heap,6));
   }

   /*=============================|parentOf() tests|===========================*/

   @Test
   public void test1_parentOf()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)1,bnu.parentOf(2, heap, 4));
   }

   @Test
   public void test2_parentOf()
   {
      Integer[] heap = new Integer[] {0,1,1,1,1};
      assertEquals((Object)1,bnu.parentOf(4, heap, 4));
   }

   @Test
   public void test3_parentOf()
   {
      Integer[] heap = new Integer[] {0,7,20,7,28,72,42,80,41,41,98,74,43};
      assertEquals((Object)42,bnu.parentOf(12, heap, 12));
   }

   @Test
   public void test4_parentOf()
   {
      Integer[] heap = new Integer[] {0,-5,-4,-3,-2,-1,0,1};
      assertEquals((Object)(-3),bnu.parentOf(7, heap, 7));
   }

   @Test
   public void test5_parentOf()
   {
      Integer[] heap = new Integer[] {0,-20,10,-5,12,14,-1,2};
      assertEquals((Object)(-20),bnu.parentOf(2,heap,7));
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void test6_parentOf_indexLow1()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)1,bnu.parentOf(0,heap,4));
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void test7_parentOf_indexLow2()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)1,bnu.parentOf(-1,heap,4));
   }

   @Test (expected = NoSuchElementException.class)
   public void test8_parentOf_indexHigh1()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)1,bnu.parentOf(1,heap,4));
   }

   @Test (expected = IllegalArgumentException.class)
   public void test9_parentOf_badHeap1()
   {
      Integer[] heap = new Integer[] {0,1,2,3,2,1,0};
      assertEquals((Object)1,bnu.parentOf(2,heap,6));
   }

   /*=============================|leftChildOf() tests|========================*/
   
   @Test
   public void test1_leftChildOf()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)2,bnu.leftChildOf(1, heap, 4));
   }

   @Test
   public void test2_leftChildOf()
   {
      Integer[] heap = new Integer[] {0,1,1,1,1};
      assertEquals((Object)1,bnu.leftChildOf(2, heap, 4));
   }

   @Test
   public void test3_leftChildOf()
   {
      Integer[] heap = new Integer[] {0,7,20,7,28,72,42,80,41,41,98,74,43};
      assertEquals((Object)98,bnu.leftChildOf(5, heap, 12));
   }

   @Test
   public void test4_leftChildOf()
   {
      Integer[] heap = new Integer[] {0,-5,-4,-3,-2,-1,0,1};
      assertEquals((Object)(-2),bnu.leftChildOf(2, heap, 7));
   }

   @Test
   public void test5_leftChildOf()
   {
      Integer[] heap = new Integer[] {0,-20,10,-5,12,14,-1,2};
      assertEquals((Object)(-1),bnu.leftChildOf(3,heap,7));
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void test6_leftChildOf_indexLow1()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)1,bnu.leftChildOf(0,heap,4));
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void test7_leftChildOf_indexLow2()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)1,bnu.leftChildOf(-1,heap,4));
   }

   @Test (expected = NoSuchElementException.class)
   public void test8_leftChildOf_indexHigh1()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)1,bnu.leftChildOf(3,heap,4));
   }

   @Test (expected = NoSuchElementException.class)
   public void test9_leftChildOf_indexHigh2()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)1,bnu.leftChildOf(4,heap,4));
   }

   @Test (expected = IllegalArgumentException.class)
   public void test10_leftChildOf_badHeap1()
   {
      Integer[] heap = new Integer[] {0,1,2,3,2,1,0};
      assertEquals((Object)1,bnu.leftChildOf(2,heap,6));
   }

   /*=============================|rightChildof() tests|=======================*/

   @Test
   public void test1_rightChildOf()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)3,bnu.rightChildOf(1, heap, 4));
   }

   @Test
   public void test2_rightChildOf()
   {
      Integer[] heap = new Integer[] {0,1,1,1,1};
      assertEquals((Object)1,bnu.rightChildOf(1, heap, 4));
   }

   @Test
   public void test3_rightChildOf()
   {
      Integer[] heap = new Integer[] {0,7,20,7,28,72,42,80,41,41,98,74,43};
      assertEquals((Object)72,bnu.rightChildOf(2, heap, 12));
   }

   @Test
   public void test4_rightChildOf()
   {
      Integer[] heap = new Integer[] {0,-5,-4,-3,-2,-1,0,1};
      assertEquals((Object)(-1),bnu.rightChildOf(2, heap, 7));
   }

   @Test
   public void test5_rightChildOf()
   {
      Integer[] heap = new Integer[] {0,-20,10,-5,12,14,-1,2};
      assertEquals((Object)2,bnu.rightChildOf(3,heap,7));
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void test6_rightChildOf_indexLow1()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)1,bnu.rightChildOf(0,heap,4));
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void test7_rightChildOf_indexLow2()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)1,bnu.rightChildOf(-1,heap,4));
   }

   @Test (expected = NoSuchElementException.class)
   public void test8_rightChildOf_indexHigh1()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)1,bnu.rightChildOf(2,heap,4));
   }

   @Test (expected = NoSuchElementException.class)
   public void test9_rightChildOf_indexHigh2()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)1,bnu.rightChildOf(3,heap,4));
   }

   @Test (expected = NoSuchElementException.class)
   public void test10_rightChildOf_indexHigh3()
   {
      Integer[] heap = new Integer[] {0,1,2,3,4};
      assertEquals((Object)1,bnu.rightChildOf(4,heap,4));
   }

   @Test (expected = IllegalArgumentException.class)
   public void test11_rightChildOf_badHeap1()
   {
      Integer[] heap = new Integer[] {0,1,2,3,2,1,0};
      assertEquals((Object)1,bnu.rightChildOf(2,heap,6));
   }
}
