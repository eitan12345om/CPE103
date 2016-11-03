import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;

/**
 * Binary Heap Utility Method Tests.
 *
 * @author Eitan Simler
 * @version Lab05
 */

public class BinaryHeapUtilitiesTests {

   // height tests
   @Test (expected=IllegalArgumentException.class)
   public void testHeight_illegalSize() {
      BinaryHeapUtilities.height(0);
   }
   
   @Test (expected=IllegalArgumentException.class)
   public void testHeight_illegalSize2() {
      BinaryHeapUtilities.height(-1);
   }

   @Test 
   public void testHeight() {
      assertEquals(0, BinaryHeapUtilities.height(1));
   }
   
   @Test 
   public void testHeight2() {
      assertEquals(1, BinaryHeapUtilities.height(2));
   }

   @Test 
   public void testHeight3() {
      assertEquals(1, BinaryHeapUtilities.height(3));
   }
   
   @Test 
   public void testHeight4() {
      assertEquals(2, BinaryHeapUtilities.height(4));
   }

   // isHeap tests
   @Test
   public void testIsHeap_sizeTooSmall() {
      assertEquals(false, BinaryHeapUtilities.isHeap(new Integer[] {0}, 0));   
   }

   @Test
   public void testIsHeap_false1() {
      Integer[] heap = new Integer[] {0, 5, 4, 3, 2, 1};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_false2() {
      Integer[] heap = new Integer[] {0, 5, 5, 5, 5, 1};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_false3() {
      Integer[] heap = new Integer[] {0, 1, 1, 0, 2, 4};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_false4() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4, 1};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_false5() {
      Integer[] heap = new Integer[] {0, 1, 1, 1, 1, 0};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_true1() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4, 5};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_true2() {
      Integer[] heap = new Integer[] {0, 5, 5, 5, 5, 5};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_true3() {
      Integer[] heap = new Integer[] {0, 1, 1, 1, 2, 4};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_true4() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 2, 2};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_true5() {
      Integer[] heap = new Integer[] {0, 1, 1, 1, 1, 1};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_false1_Character() {
      Character[] heap = new Character[] {null, 'b', 'a', 'b', 'b', 'c'};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_false2_Character() {
      Character[] heap = new Character[] {null, 'b', 'b', 'b', 'b', 'a'};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_false3_Character() {
      Character[] heap = new Character[] {' ', 'a', 'b', 'c', 'd', 'a'};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_false4_Character() {
      Character[] heap = new Character[] {' ', 'a', 'b', 'b', 'c', 'a'};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_false5_Character() {
      Character[] heap = new Character[] {' ', 'a', 'a', 'a', 'a', 'A'};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_true1_Character() {
      Character[] heap = new Character[] {' ', 'A', 'B', 'b', 'c', 'C'};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_true2_Character() {
      Character[] heap = new Character[] {' ', 'A', 'B', 'B', 'B', 'B'};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }
   
   @Test
   public void testIsHeap_true3_Character() {
      Character[] heap = new Character[] {' ', 'A', 'A', 'A', 'a', 'C'};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }
   
   @Test
   public void testIsHeap_true4_Character() {
      Character[] heap = new Character[] {' ', 'A', 'B', 'C', 'D', 'e'};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }
   
   @Test 
   public void testIsHeap_true5_Character() {
      Character[] heap = new Character[] {' ', 'A', 'B', 'C', 'D', 'E'};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }
   
   @Test
   public void testIsHeap_false1_String() {
      String[] heap = new String[] {null, "b", "a", "b", "b", "c"};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_false2_String() {
      String[] heap = new String[] {null, "b", "b", "b", "b", "a"};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_false3_String() {
      String[] heap = new String[] {" ", "a", "b", "c", "d", "a"};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_false4_String() {
      String[] heap = new String[] {" ", "a", "b", "b", "c", "a"};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_false5_String() {
      String[] heap = new String[] {" ", "a", "a", "a", "a", "A"};
      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_true1_String() {
      String[] heap = new String[] {" ", "A", "B", "b", "c", "C"};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   @Test
   public void testIsHeap_true2_String() {
      String[] heap = new String[] {" ", "A", "B", "B", "B", "B"};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }
   
   @Test
   public void testIsHeap_true3_String() {
      String[] heap = new String[] {" ", "A", "A", "A", "a", "C"};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }
   
   @Test
   public void testIsHeap_true4_String() {
      String[] heap = new String[] {" ", "A", "B", "C", "D", "e"};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }
   
   @Test 
   public void testIsHeap_true5_String() {
      String[] heap = new String[] {" ", "A", "B", "C", "D", "E"};
      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 5));   
   }

   // parentOf tests
   @Test (expected=IndexOutOfBoundsException.class)
   public void testParentOf_illegalIndex() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4};
      BinaryHeapUtilities.parentOf(0, heap, 4);
   }
   
   @Test (expected=IndexOutOfBoundsException.class)
   public void testParentOf_illegalIndexBiggerThanSize() {
      Integer[] heap = new Integer[] {0, 1};
      BinaryHeapUtilities.parentOf(2, heap, 1);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testParentOf_illegalIndex_illegalHeap() {
      Integer[] heap = new Integer[] {0, 5, 3, 1, 1};
      BinaryHeapUtilities.parentOf(0, heap, 4);
   }
   
   @Test (expected=IndexOutOfBoundsException.class)
   public void testParentOf_illegalIndexBiggerThanSize_illegalHeap() {
      Integer[] heap = new Integer[] {0, 5, 2, 3, 4, 5};
      BinaryHeapUtilities.parentOf(6, heap, 5);
   }

   @Test (expected=NoSuchElementException.class)
   public void testParentOf_index1Exception() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4};
      BinaryHeapUtilities.parentOf(1, heap, 4);
   }

   @Test (expected=NoSuchElementException.class)
   public void testParentOf_index1Exception_illegalHeap() {
      Integer[] heap = new Integer[] {0, 5, 2, 3, 4};
      BinaryHeapUtilities.parentOf(1, heap, 4);
   }

   @Test (expected=IllegalArgumentException.class)
   public void testParentOf_illegalHeap() {
      Integer[] heap = new Integer[] {0, 1, 23, 3, 4, 5, 6, 7, 8};
      BinaryHeapUtilities.parentOf(4, heap, 8);
   }

   @Test (expected=IllegalArgumentException.class)
   public void testParentOf_illegalHeap2() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 1, 1, 6, 7, 8};
      BinaryHeapUtilities.parentOf(4, heap, 8);
   }

   @Test (expected=IllegalArgumentException.class)
   public void testParentOf_illegalHeap3() {
      Integer[] heap = new Integer[] {0, 2, 1, 1, 1, 1, 1, 1, 1};
      BinaryHeapUtilities.parentOf(4, heap, 8);
   }
   
   @Test (expected=IllegalArgumentException.class)
   public void testParentOf_illegalHeap4() {
      Integer[] heap = new Integer[] {0, 5, 2, 3, 1, 1, 6, 7, 8};
      BinaryHeapUtilities.parentOf(4, heap, 8);
   }

   @Test (expected=IllegalArgumentException.class)
   public void testParentOf_illegalHeap5() {
      Integer[] heap = new Integer[] {0, 5, 1, 1, 1, 6, 7, 8, 9};
      BinaryHeapUtilities.parentOf(4, heap, 8);
   }

   @Test
   public void testParentOf_good() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4};
      assertEquals(2, (int) BinaryHeapUtilities.parentOf(4, heap, 4)); 
   }

   @Test
   public void testParentOf_good2() {
      Integer[] heap = new Integer[] {0, 1, 1, 1, 1};
      assertEquals(1, (int) BinaryHeapUtilities.parentOf(3, heap, 4)); 
   }

   @Test
   public void testParentOf_good3() {
      Integer[] heap = new Integer[] {0, 2, 2, 3, 2};
      assertEquals(2, (int) BinaryHeapUtilities.parentOf(2, heap, 4)); 
   }

   @Test
   public void testParentOf_good4() {
      Integer[] heap = new Integer[] {0, 2, 3, 7, 10};
      assertEquals(3, (int) BinaryHeapUtilities.parentOf(4, heap, 4)); 
   }

   @Test
   public void testParentOf_good5() {
      Integer[] heap = new Integer[] {0, 2, 3, 7, 10, 15, 12, 45, 22};
      assertEquals(10, (int) BinaryHeapUtilities.parentOf(8, heap, 8)); 
   }

   @Test
   public void testParentOf_good6() {
      Integer[] heap = new Integer[] {0, 2, 3, 7, 10, 15, 12, 45, 22};
      assertEquals(3, (int) BinaryHeapUtilities.parentOf(4, heap, 8)); 
   }

   @Test
   public void testParentOf_good_Character() {
      Character[] heap = new Character[] {' ', 'a', 'b', 'c', 'd'};
      assertEquals('b', (char) BinaryHeapUtilities.parentOf(4, heap, 4)); 
   }

   @Test
   public void testParentOf_good2_Character() {
      Character[] heap = new Character[] {'0', 'a', 'b', 'c', 'd'};
      assertEquals('a', (char) BinaryHeapUtilities.parentOf(3, heap, 4)); 
   }

   @Test
   public void testParentOf_good3_Character() {
      Character[] heap = new Character[] {'0', 'b', 'b', 'c', 'b'};
      assertEquals('b', (char) BinaryHeapUtilities.parentOf(2, heap, 4)); 
   }

   @Test
   public void testParentOf_good4_Character() {
      Character[] heap = new Character[] {'0', 'b', 'c', 'g', 'h'};
      assertEquals('c', (char) BinaryHeapUtilities.parentOf(4, heap, 4)); 
   }

   @Test
   public void testParentOf_good5_Character() {
      Character[] heap = new Character[] {0, 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
      assertEquals('e', (char) BinaryHeapUtilities.parentOf(8, heap, 8)); 
   }

   @Test
   public void testParentOf_good6_Character() {
      Character[] heap = new Character[] {0, 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
      assertEquals('c', (char) BinaryHeapUtilities.parentOf(4, heap, 8)); 
   }

   @Test
   public void testParentOf_good_String() {
      String[] heap = new String[] {" ", "a", "b", "c", "d"};
      assertEquals("b", BinaryHeapUtilities.parentOf(4, heap, 4)); 
   }

   @Test
   public void testParentOf_good2_String() {
      String[] heap = new String[] {"0", "a", "b", "c", "d"};
      assertEquals("a", BinaryHeapUtilities.parentOf(3, heap, 4)); 
   }

   @Test
   public void testParentOf_good3_String() {
      String[] heap = new String[] {"0", "b", "b", "c", "b"};
      assertEquals("b", BinaryHeapUtilities.parentOf(2, heap, 4)); 
   }

   @Test
   public void testParentOf_good4_String() {
      String[] heap = new String[] {"0", "b", "c", "g", "h"};
      assertEquals("c", BinaryHeapUtilities.parentOf(4, heap, 4)); 
   }

   @Test
   public void testParentOf_good5_String() {
      String[] heap = new String[] {"0", "b", "c", "d", "e", "f", "g", "h", "i"};
      assertEquals("e", BinaryHeapUtilities.parentOf(8, heap, 8)); 
   }

   @Test
   public void testParentOf_good6_String() {
      String[] heap = new String[] {"0", "b", "c", "d", "e", "f", "g", "h", "i"};
      assertEquals("c", BinaryHeapUtilities.parentOf(4, heap, 8)); 
   }
   
   // leftChildOf tests
   @Test (expected=IndexOutOfBoundsException.class)
   public void testLeftChildOf_illegalIndex() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4};
      BinaryHeapUtilities.leftChildOf(0, heap, 4);
   }
   
   @Test (expected=IndexOutOfBoundsException.class)
   public void testLeftChildOf_illegalIndexBiggerThanSize() {
      Integer[] heap = new Integer[] {0, 1};
      BinaryHeapUtilities.leftChildOf(2, heap, 1);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testLeftChildOf_illegalIndex_illegalHeap() {
      Integer[] heap = new Integer[] {0, 5, 3, 1, 1};
      BinaryHeapUtilities.leftChildOf(0, heap, 4);
   }
   
   @Test (expected=IndexOutOfBoundsException.class)
   public void testLeftChildOf_illegalIndexBiggerThanSize_illegalHeap() {
      Integer[] heap = new Integer[] {0, 5, 4, 1, 1};
      BinaryHeapUtilities.leftChildOf(5, heap, 4);
   }

   @Test (expected=NoSuchElementException.class)
   public void testLeftChildOf_NoLeftChild() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4};
      BinaryHeapUtilities.leftChildOf(4, heap, 4);
   }
   
   @Test (expected=NoSuchElementException.class)
   public void testLeftChildOf_NoLeftChild_illegalHeap() {
      Integer[] heap = new Integer[] {0, 5, 4, 1, 2};
      BinaryHeapUtilities.leftChildOf(4, heap, 4);
   }

   @Test 
   public void testLeftChildOf_good1() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4};
      assertEquals(2, (int) BinaryHeapUtilities.leftChildOf(1, heap, 4));
   }

   @Test 
   public void testLeftChildOf_good2() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4};
      assertEquals(4, (int) BinaryHeapUtilities.leftChildOf(2, heap, 4));
   }

   @Test 
   public void testLeftChildOf_good3() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
      assertEquals(6, (int) BinaryHeapUtilities.leftChildOf(3, heap, 8));
   }

   @Test 
   public void testLeftChildOf_good4() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
      assertEquals(8, (int) BinaryHeapUtilities.leftChildOf(4, heap, 8));
   }
   
   @Test 
   public void testLeftChildOf_good5() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      assertEquals(10, (int) BinaryHeapUtilities.leftChildOf(5, heap, 10));
   }

   @Test 
   public void testLeftChildOf_good1_Character() {
      Character[] heap = new Character[] {' ', 'a', 'b', 'c', 'd'};
      assertEquals('b', (char) BinaryHeapUtilities.leftChildOf(1, heap, 4));
   }

   @Test 
   public void testLeftChildOf_good2_Character() {
      Character[] heap = new Character[] {0, 'a', 'b', 'c', 'd'};
      assertEquals('d', (char) BinaryHeapUtilities.leftChildOf(2, heap, 4));
   }

   @Test 
   public void testLeftChildOf_good3_Character() {
      Character[] heap = new Character[] {0, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
      assertEquals('f', (char) BinaryHeapUtilities.leftChildOf(3, heap, 8));
   }

   @Test 
   public void testLeftChildOf_good4_Character() {
      Character[] heap = new Character[] {0, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
      assertEquals('h', (char) BinaryHeapUtilities.leftChildOf(4, heap, 8));
   }
   
   @Test 
   public void testLeftChildOf_good5_Character() {
      Character[] heap = new Character[] {0, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
      assertEquals('j', (char) BinaryHeapUtilities.leftChildOf(5, heap, 10));
   }
   
   @Test 
   public void testLeftChildOf_good1_String() {
      String[] heap = new String[] {" ", "a", "b", "c", "d"};
      assertEquals("b", BinaryHeapUtilities.leftChildOf(1, heap, 4));
   }

   @Test 
   public void testLeftChildOf_good2_String() {
      String[] heap = new String[] {"Jones", "a", "b", "c", "d"};
      assertEquals("d", BinaryHeapUtilities.leftChildOf(2, heap, 4));
   }

   @Test 
   public void testLeftChildOf_good3_String() {
      String[] heap = new String[] {"Brian", "a", "b", "c", "d", "e", "f", "g", "h"};
      assertEquals("f", BinaryHeapUtilities.leftChildOf(3, heap, 8));
   }

   @Test 
   public void testLeftChildOf_good4_String() {
      String[] heap = new String[] {null, "a", "b", "c", "d", "e", "f", "g", "h"};
      assertEquals("h", BinaryHeapUtilities.leftChildOf(4, heap, 8));
   }
   
   @Test 
   public void testLeftChildOf_good5_String() {
      String[] heap = new String[] {"moose", "a", "b", "c", "d", "e", "f", "g", "h", "i", "zebra"};
      assertEquals("zebra", BinaryHeapUtilities.leftChildOf(5, heap, 10));
   }

   // rightChildOf tests
   @Test (expected=IndexOutOfBoundsException.class)
   public void testRightChildOf_illegalIndex() {
      Integer[] heap = new Integer[] {0, 5, 3, 1, 1};
      BinaryHeapUtilities.rightChildOf(0, heap, 4);
   }
   
   @Test (expected=IndexOutOfBoundsException.class)
   public void testRightChildOf_illegalIndexBiggerThanSize() {
      Integer[] heap = new Integer[] {0, 1};
      BinaryHeapUtilities.rightChildOf(2, heap, 1);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testRightChildOf_illegalIndex_illegalHeap() {
      Integer[] heap = new Integer[] {0, 5, 3, 1, 1};
      BinaryHeapUtilities.rightChildOf(0, heap, 4);
   }
   
   @Test (expected=IndexOutOfBoundsException.class)
   public void testRightChildOf_illegalIndexBiggerThanSize_illegalHeap() {
      Integer[] heap = new Integer[] {0, 5, 4, 1, 1};
      BinaryHeapUtilities.rightChildOf(5, heap, 4);
   }

   @Test (expected=NoSuchElementException.class)
   public void testRightChildOf_NoRightChild() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4};
      BinaryHeapUtilities.rightChildOf(2, heap, 4);
   }

   @Test (expected=NoSuchElementException.class)
   public void testRightChildOf_NoLeftChild_illegalHeap() {
      Integer[] heap = new Integer[] {0, 5, 4, 1, 2};
      BinaryHeapUtilities.rightChildOf(4, heap, 4);
   }

   @Test 
   public void testRightChildOf_good1() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4};
      assertEquals(3, (int) BinaryHeapUtilities.rightChildOf(1, heap, 4));
   }

   @Test 
   public void testRightChildOf_good2() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4, 5};
      assertEquals(5, (int) BinaryHeapUtilities.rightChildOf(2, heap, 5));
   }

   @Test 
   public void testRightChildOf_good3() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
      assertEquals(7, (int) BinaryHeapUtilities.rightChildOf(3, heap, 8));
   }

   @Test 
   public void testRightChildOf_good4() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
      assertEquals(9, (int) BinaryHeapUtilities.rightChildOf(4, heap, 9));
   }
   
   @Test 
   public void testRightChildOf_good5() {
      Integer[] heap = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
      assertEquals(11, (int) BinaryHeapUtilities.rightChildOf(5, heap, 11));
   }

   @Test 
   public void testRightChildOf_good1_Character() {
      Character[] heap = new Character[] {' ', 'a', 'b', 'c', 'd'};
      assertEquals('c', (char) BinaryHeapUtilities.rightChildOf(1, heap, 4));
   }

   @Test 
   public void testRightChildOf_good2_Character() {
      Character[] heap = new Character[] {'0', 'a', 'b', 'c', 'd', 'e'};
      assertEquals('e', (char) BinaryHeapUtilities.rightChildOf(2, heap, 5));
   }

   @Test 
   public void testRightChildOf_good3_Character() {
      Character[] heap = new Character[] {'0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
      assertEquals('g', (char) BinaryHeapUtilities.rightChildOf(3, heap, 8));
   }

   @Test 
   public void testRightChildOf_good4_Character() {
      Character[] heap = new Character[] {'0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
      assertEquals('i', (char) BinaryHeapUtilities.rightChildOf(4, heap, 9));
   }
   
   @Test 
   public void testRightChildOf_good5_Character() {
      Character[] heap = new Character[] {'0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
      assertEquals('k', (char) BinaryHeapUtilities.rightChildOf(5, heap, 11));
   }

   @Test 
   public void testRightChildOf_good1_String() {
      String[] heap = new String[] {" ", "a", "b", "c", "d"};
      assertEquals("c", BinaryHeapUtilities.rightChildOf(1, heap, 4));
   }

   @Test 
   public void testRightChildOf_good2_String() {
      String[] heap = new String[] {"Hiya", "a", "b", "c", "d", "e"};
      assertEquals("e", BinaryHeapUtilities.rightChildOf(2, heap, 5));
   }

   @Test 
   public void testRightChildOf_good3_String() {
      String[] heap = new String[] {"Hello", "a", "b", "c", "d", "e", "f", "g", "h"};
      assertEquals("g", BinaryHeapUtilities.rightChildOf(3, heap, 8));
   }

   @Test 
   public void testRightChildOf_good4_String() {
      String[] heap = new String[] {"", "a", "b", "c", "d", "e", "f", "g", "h", "i"};
      assertEquals("i", BinaryHeapUtilities.rightChildOf(4, heap, 9));
   }
   
   @Test 
   public void testRightChildOf_good5_String() {
      String[] heap = new String[] {null, "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
      assertEquals("k", BinaryHeapUtilities.rightChildOf(5, heap, 11));
   }
}
