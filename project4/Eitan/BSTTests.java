import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * JUnit tests for BST.
 *
 * @author Eitan Simler
 * @version Project4
 */

public class BSTTests {

   // Variable for testing
   Random rand = new Random();

   @Test
   public void test1() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      assertTrue(tree.contains(5));
      assertFalse(tree.contains(6));
      assertEquals(5, (int) tree.minimum());
      assertEquals(5, (int) tree.maximum());
      assertEquals(1, tree.size());
   }

   @Test
   public void test2() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      assertTrue(tree.contains(5));
      assertTrue(tree.contains(3));
      assertFalse(tree.contains(1));
      assertEquals(2, tree.size());
      assertEquals(3, (int) tree.minimum());
      assertEquals(5, (int) tree.maximum());
   }

   @Test
   public void test3() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(7);
      tree.insert(2);
      assertTrue(tree.contains(5));
      assertTrue(tree.contains(7));
      assertTrue(tree.contains(2));
      assertFalse(tree.contains(1));
      assertEquals(3, tree.size());
      assertEquals(2, (int) tree.minimum());
      assertEquals(7, (int) tree.maximum());
   }
   
   @Test
   public void test4() {
      BST<Integer> tree = new BST<>();
      for (int i = 0; i < 10; i++) {
         tree.insert(i);
      }
      for (int i = 0; i < 10; i++) {
         assertTrue(tree.contains(i));
      }
      assertEquals(0, (int) tree.minimum());
      assertEquals(9, (int) tree.maximum());
      assertEquals(10, tree.size());
   }

   @Test
   public void test5() {
      BST<Integer> tree = new BST<>();
      for (int i = 10; i > 0; i--) {
         tree.insert(i);
      }
      for (int i = 10; i > 0; i--) {
         assertTrue(tree.contains(i));
      }
      assertEquals(1, (int) tree.minimum());
      assertEquals(10, (int) tree.maximum());
      assertEquals(10, tree.size());
   }

   @Test
   public void test6() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(4);
      tree.insert(0);
      tree.insert(2);
      tree.insert(1);
      tree.insert(10);
      tree.insert(8);
      tree.insert(7);
      tree.insert(9);
      tree.insert(6);
      assertEquals(11, tree.size());
      tree.insert(10);
      tree.insert(8);
      tree.insert(7);
      tree.insert(9);
      tree.insert(6);
      assertEquals(11, tree.size());
      assertEquals(0, (int) tree.minimum());
      assertEquals(10, (int) tree.maximum());
   }

   @Test
   public void test7() { 
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(4);
      tree.insert(0);
      tree.insert(2);
      tree.insert(1);
      tree.insert(10);
      tree.insert(8);
      tree.insert(7);
      tree.insert(9);
      tree.insert(6);
      tree.insert(10);
      tree.insert(8);
      tree.insert(7);
      tree.insert(9);
      tree.insert(6);
      assertEquals(11, tree.size());
      assertEquals(0, (int) tree.minimum());
      assertEquals(10, (int) tree.maximum());
      ArrayList<Integer> arr = new ArrayList<>();
      tree.toSortedList(arr);
      assertTrue(listEquals(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, arr));
   }


   @Test
   public void test_Character1() {
      BST<Character> tree = new BST<>();
      tree.insert('a');
      assertTrue(tree.contains('a'));
      assertFalse(tree.contains('f'));
      assertEquals('a', (char) tree.minimum());
      assertEquals('a', (char) tree.maximum());
      assertEquals(1, tree.size());
   }

   @Test
   public void test_Character2() {
      BST<Character> tree = new BST<>();
      tree.insert('e');
      tree.insert('c');
      assertTrue(tree.contains('e'));
      assertTrue(tree.contains('c'));
      assertFalse(tree.contains('b'));
      assertEquals(2, tree.size());
      assertEquals('c', (char) tree.minimum());
      assertEquals('e', (char) tree.maximum());
   }

   @Test
   public void test_Character3() {
      BST<Character> tree = new BST<>();
      tree.insert('e');
      tree.insert('g');
      tree.insert('b');
      assertTrue(tree.contains('e'));
      assertTrue(tree.contains('g'));
      assertTrue(tree.contains('b'));
      assertFalse(tree.contains('a'));
      assertEquals(3, tree.size());
      assertEquals('b', (char) tree.minimum());
      assertEquals('g', (char) tree.maximum());
   }
   
   @Test
   public void test_Character4() {
      BST<Character> tree = new BST<>();
      Character[] aList = new Character[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
      for (int i = 0; i < 10; i++) {
         tree.insert(aList[i]);
      }
      for (int i = 0; i < 10; i++) {
         assertTrue(tree.contains(aList[i]));
      }
      assertEquals('a', (char) tree.minimum());
      assertEquals('j', (char) tree.maximum());
      assertEquals(10, tree.size());
   }

   @Test
   public void test_Character5() {
      BST<Character> tree = new BST<>();
      Character[] aList = new Character[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
      for (int i = 10; i > 0; i--) {
         tree.insert(aList[i - 1]);
      }
      for (int i = 10; i > 0; i--) {
         assertTrue(tree.contains(aList[i - 1]));
      }
      assertEquals('a', (char) tree.minimum());
      assertEquals('j', (char) tree.maximum());
      assertEquals(10, tree.size());
   }

   @Test
   public void test_Character6() {
      BST<Character> tree = new BST<>();
      tree.insert('e');
      tree.insert('c');
      tree.insert('d');
      tree.insert('Z');
      tree.insert('b');
      tree.insert('a');
      tree.insert('j');
      tree.insert('h');
      tree.insert('g');
      tree.insert('i');
      tree.insert('f');
      assertEquals(11, tree.size());
      tree.insert('j');
      tree.insert('h');
      tree.insert('g');
      tree.insert('i');
      tree.insert('f');
      assertEquals(11, tree.size());
      assertEquals('Z', (char) tree.minimum());
      assertEquals('j', (char) tree.maximum());
   }

   @Test
   public void test_Character7() { 
      BST<Character> tree = new BST<>();
      tree.insert('e');
      tree.insert('c');
      tree.insert('d');
      tree.insert('Z');
      tree.insert('b');
      tree.insert('a');
      tree.insert('j');
      tree.insert('h');
      tree.insert('g');
      tree.insert('i');
      tree.insert('f');
      assertEquals(11, tree.size());
      assertEquals('Z', (char) tree.minimum());
      assertEquals('j', (char) tree.maximum());
      ArrayList<Character> arr = new ArrayList<>();
      tree.toSortedList(arr);
      assertTrue(listEquals(new Character[] {'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'}, arr));
   }


   @Test
   public void test_String1() {
      BST<String> tree = new BST<>();
      tree.insert("a");
      assertTrue(tree.contains("a"));
      assertFalse(tree.contains("f"));
      assertEquals("a", tree.minimum());
      assertEquals("a", tree.maximum());
      assertEquals(1, tree.size());
   }

   @Test
   public void test_String2() {
      BST<String> tree = new BST<>();
      tree.insert("e");
      tree.insert("c");
      assertTrue(tree.contains("e"));
      assertTrue(tree.contains("c"));
      assertFalse(tree.contains("b"));
      assertEquals(2, tree.size());
      assertEquals("c", tree.minimum());
      assertEquals("e", tree.maximum());
   }

   @Test
   public void test_String3() {
      BST<String> tree = new BST<>();
      tree.insert("e");
      tree.insert("g");
      tree.insert("b");
      assertTrue(tree.contains("e"));
      assertTrue(tree.contains("g"));
      assertTrue(tree.contains("b"));
      assertFalse(tree.contains("a"));
      assertEquals(3, tree.size());
      assertEquals("b", tree.minimum());
      assertEquals("g", tree.maximum());
   }
   
   @Test
   public void test_String4() {
      BST<String> tree = new BST<>();
      String[] aList = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
      for (int i = 0; i < 10; i++) {
         tree.insert(aList[i]);
      }
      for (int i = 0; i < 10; i++) {
         assertTrue(tree.contains(aList[i]));
      }
      assertEquals("a", tree.minimum());
      assertEquals("j", tree.maximum());
      assertEquals(10, tree.size());
   }

   @Test
   public void test_String5() {
      BST<String> tree = new BST<>();
      String[] aList = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
      for (int i = 10; i > 0; i--) {
         tree.insert(aList[i - 1]);
      }
      for (int i = 10; i > 0; i--) {
         assertTrue(tree.contains(aList[i - 1]));
      }
      assertEquals("a", tree.minimum());
      assertEquals("j", tree.maximum());
      assertEquals(10, tree.size());
   }

   @Test
   public void test_String6() {
      BST<String> tree = new BST<>();
      tree.insert("e");
      tree.insert("c");
      tree.insert("d");
      tree.insert("Z");
      tree.insert("b");
      tree.insert("a");
      tree.insert("j");
      tree.insert("h");
      tree.insert("g");
      tree.insert("i");
      tree.insert("f");
      assertEquals(11, tree.size());
      tree.insert("j");
      tree.insert("h");
      tree.insert("g");
      tree.insert("i");
      tree.insert("f");
      assertEquals(11, tree.size());
      assertEquals("Z", tree.minimum());
      assertEquals("j", tree.maximum());
   }

   @Test
   public void test_String7() { 
      BST<String> tree = new BST<>();
      tree.insert("e");
      tree.insert("c");
      tree.insert("d");
      tree.insert("Z");
      tree.insert("b");
      tree.insert("a");
      tree.insert("j");
      tree.insert("h");
      tree.insert("g");
      tree.insert("i");
      tree.insert("f");
      assertEquals(11, tree.size());
      assertEquals("Z", tree.minimum());
      assertEquals("j", tree.maximum());
      ArrayList<String> arr = new ArrayList<>();
      tree.toSortedList(arr);
      assertTrue(listEquals(new String[] {"Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}, arr));
   }

   @Test
   public void testTreeHeight1_empty() {
      BST<Integer> tree = new BST<>();
      assertEquals(-1, tree.treeHeight());
   }
   
   @Test
   public void testTreeHeight2_justRoot() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      assertEquals(0, tree.treeHeight());
   }

   @Test
   public void testTreeHeight3_lopsidedRight() {
      BST<Integer> tree = new BST<>();
      for (int i = 0; i < 10; i++) {
         tree.insert(i);
      }
      assertEquals(9, tree.treeHeight());
   }

   @Test
   public void testTreeHeight4_lopsidedLeft() {
      BST<Integer> tree = new BST<>();
      for (int i = 10; i > 0; i--) {
         tree.insert(i);
      }
      assertEquals(9, tree.treeHeight());
   }

   @Test
   public void testTreeHeight5_Normalish() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(1);
      tree.insert(2);
      tree.insert(7);
      tree.insert(6);
      assertEquals(3, tree.treeHeight());
   }

   @Test (expected=NoSuchElementException.class)
   public void testRemove1_empty() {
      BST<Integer> tree = new BST<>();
      tree.remove(3);
   }

   @Test 
   public void testRemove2_justRoot() {
      BST<Integer> tree = new BST<>();
      tree.insert(3);
      assertEquals(1, tree.size());
      tree.remove(3);
      assertEquals(0, tree.size());
      assertEquals(-1, tree.treeHeight());
   }

   @Test
   public void testRemove3_lopsidedRight() {
      BST<Integer> tree = new BST<>();
      for (int i = 0; i < 10; i++) {
         tree.insert(i);
      }
      assertEquals(10, tree.size());
      for (int i = 0; i < 10; i++) {
         tree.remove(i);
      }
      assertEquals(0, tree.size());
   }

   @Test
   public void testRemove4_lopsidedLeft() {
      BST<Integer> tree = new BST<>();
      for (int i = 10; i > 0; i--) {
         tree.insert(i);
      }
      assertEquals(10, tree.size());
      for (int i = 10; i > 0; i--) {
         tree.remove(i);
      }
      assertEquals(0, tree.size());
   }

   @Test
   public void testRemove5_Normalish() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(1);
      tree.insert(2);
      tree.insert(7);
      tree.insert(6);
      assertEquals(6, tree.size());
      tree.remove(3);
      assertEquals(5, tree.size());
   }
   
   @Test (expected=NoSuchElementException.class)
   public void testRemove6_Normalish_noElement() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(1);
      tree.insert(2);
      tree.insert(7);
      tree.insert(6);
      tree.remove(9);
   }

   public void testRemove7_Normalish() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(1);
      tree.insert(2);
      tree.insert(7);
      tree.insert(6);
      tree.insert(8);
      tree.insert(0);
      assertEquals(8, tree.size());
      tree.remove(5);
      assertEquals(7, tree.size());
   }

   @Test
   public void testRemove8_Normalish() {
      BST<Integer> tree = new BST<>();
      tree.insert(100);
      tree.insert(50);
      tree.insert(20);
      tree.insert(40);
      tree.insert(30);
      tree.insert(25);
      tree.insert(45);
      tree.insert(75);
      tree.insert(80);
      tree.insert(200);
      tree.insert(150);
      tree.insert(175);
      tree.insert(300);
      tree.insert(400);
      assertEquals(14, tree.size());
      tree.remove(200);
      assertEquals(13, tree.size()); 
   }

   @Test
   public void testRemove9_Normalish() {
      BST<Integer> tree = new BST<>();
      tree.insert(100);
      tree.insert(50);
      tree.insert(20);
      tree.insert(40);
      tree.insert(30);
      tree.insert(25);
      tree.insert(45);
      tree.insert(75);
      tree.insert(80);
      tree.insert(200);
      tree.insert(150);
      tree.insert(175);
      tree.insert(300);
      tree.insert(400);
      assertEquals(14, tree.size());
      tree.remove(100);
      assertEquals(13, tree.size()); 
   }

   @Test
   public void testRemove10_Normalish() {
      BST<Integer> tree = new BST<>();
      tree.insert(100);
      tree.insert(50);
      tree.insert(20);
      tree.insert(40);
      tree.insert(30);
      tree.insert(25);
      tree.insert(45);
      tree.insert(75);
      tree.insert(80);
      tree.insert(200);
      tree.insert(150);
      tree.insert(175);
      tree.insert(300);
      tree.insert(400);
      assertEquals(14, tree.size());
      tree.remove(20);
      assertEquals(13, tree.size()); 
   }

   @Test
   public void testInternalPathLength1_empty() {
      BST<Integer> tree = new BST<>();
      assertEquals(-1, tree.internalPathLength());
   }

   @Test 
   public void testInternalPathLength2_justRoot() {
      BST<Integer> tree = new BST<>();
      tree.insert(3);
      assertEquals(0, tree.internalPathLength());
   }

   @Test
   public void testInternalPathLength3_lopsidedRight() {
      BST<Integer> tree = new BST<>();
      for (int i = 0; i < 10; i++) {
         tree.insert(i);
      }
      assertEquals(45, tree.internalPathLength());
   }

   @Test
   public void testInternalPathLength4_lopsidedLeft() {
      BST<Integer> tree = new BST<>();
      for (int i = 10; i > 0; i--) {
         tree.insert(i);
      }
      assertEquals(45, tree.internalPathLength());
   }

   @Test
   public void testInternalPathLength5_Normalish() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(1);
      tree.insert(2);
      tree.insert(7);
      tree.insert(6);
      assertEquals(9, tree.internalPathLength());
   }
   
   @Test
   public void testInternalPathLength6_Normalish() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(1);
      tree.insert(2);
      tree.insert(7);
      tree.insert(6);
      tree.insert(0);
      assertEquals(12, tree.internalPathLength());
   }

   @Test
   public void testInternalPathLength7_Normalish_withRemove() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(1);
      tree.insert(2);
      tree.insert(7);
      tree.insert(6);
      tree.insert(0);
      assertEquals(12, tree.internalPathLength());
      tree.remove(3);
      assertEquals(8, tree.internalPathLength());
   }

   @Test
   public void testInternalPathLength8_Normalish_withRemove() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(1);
      tree.insert(2);
      tree.insert(7);
      tree.insert(6);
      tree.insert(8);
      tree.insert(0);
      assertEquals(14, tree.internalPathLength());
      tree.remove(5);
      assertEquals(12, tree.internalPathLength());
   }

   @Test
   public void testInternalPathLength9_Normalish_withRemove() {
      BST<Integer> tree = new BST<>();
      tree.insert(100);
      tree.insert(50);
      tree.insert(20);
      tree.insert(40);
      tree.insert(30);
      tree.insert(25);
      tree.insert(45);
      tree.insert(75);
      tree.insert(80);
      tree.insert(200);
      tree.insert(150);
      tree.insert(175);
      tree.insert(300);
      tree.insert(400);
      assertEquals(35, tree.internalPathLength());
      tree.remove(40);
      assertEquals(31, tree.internalPathLength()); 
   }

   @Test
   public void testInternalPathLength10_Normalish_withRemove() {
      BST<Integer> tree = new BST<>();
      tree.insert(100);
      tree.insert(50);
      tree.insert(20);
      tree.insert(40);
      tree.insert(30);
      tree.insert(25);
      tree.insert(45);
      tree.insert(75);
      tree.insert(80);
      tree.insert(200);
      tree.insert(150);
      tree.insert(175);
      tree.insert(300);
      tree.insert(400);
      assertEquals(35, tree.internalPathLength());
      tree.remove(200);
      assertEquals(32, tree.internalPathLength()); 
   }
  
   @Test (expected=NoSuchElementException.class)
   public void testGet1_empty() {
      BST<Integer> tree = new BST<>();
      tree.get(4);
   }

   @Test 
   public void testGet2_justRoot() {
      BST<Integer> tree = new BST<>();
      tree.insert(3);
      assertEquals(3, (int) tree.get(3));
   }

   @Test
   public void testGet3_lopsidedRight() {
      BST<Integer> tree = new BST<>();
      for (int i = 0; i < 10; i++) {
         tree.insert(i);
      }
      for (int i = 0; i < 10; i++) {
         assertEquals(i, (int) tree.get(i));
      }
   }

   @Test
   public void testGet4_lopsidedLeft() {
      BST<Integer> tree = new BST<>();
      for (int i = 10; i > 0; i--) {
         tree.insert(i);
      }
      for (int i = 10; i > 0; i--) {
         assertEquals(i, (int) tree.get(i));
      }
   }

   @Test
   public void testGet5_Normalish() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(1);
      tree.insert(2);
      tree.insert(7);
      tree.insert(6);
      assertEquals(2, (int) tree.get(2));
   }
   
   @Test
   public void testGet6_Normalish() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(1);
      tree.insert(2);
      tree.insert(7);
      tree.insert(6);
      tree.insert(0);
      assertEquals(7, (int) tree.get(7));
   }

   @Test (expected=NoSuchElementException.class)
   public void testGet7_Normalish_withRemove() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(1);
      tree.insert(2);
      tree.insert(7);
      tree.insert(6);
      tree.insert(0);
      tree.remove(3);
      tree.get(3);
   }

   @Test (expected=NoSuchElementException.class)
   public void testGet8_Normalish_withRemove() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(1);
      tree.insert(2);
      tree.insert(7);
      tree.insert(6);
      tree.insert(8);
      tree.insert(0);
      tree.remove(8);
      tree.get(8);
   }

   @Test
   public void testGet9_Normalish() {
      BST<Integer> tree = new BST<>();
      tree.insert(100);
      tree.insert(50);
      tree.insert(20);
      tree.insert(40);
      tree.insert(30);
      tree.insert(25);
      tree.insert(45);
      tree.insert(75);
      tree.insert(80);
      tree.insert(200);
      tree.insert(150);
      tree.insert(175);
      tree.insert(300);
      tree.insert(400);
      assertEquals(400, (int) tree.get(400));
      assertEquals(150, (int) tree.get(150));
      assertEquals(75, (int) tree.get(75));
   }

   @Test
   public void testGet10_Normalish_withRemove() {
      BST<Integer> tree = new BST<>();
      tree.insert(100);
      tree.insert(50);
      tree.insert(20);
      tree.insert(40);
      tree.insert(30);
      tree.insert(25);
      tree.insert(45);
      tree.insert(75);
      tree.insert(80);
      tree.insert(200);
      tree.insert(150);
      tree.insert(175);
      tree.insert(300);
      tree.insert(400);
      tree.remove(200);
      tree.size(); 
   }

   @Test (expected=UnsupportedOperationException.class)
   public void testIterator1_Remove() {
      BST<Integer> tree = new BST<>();
      Iterator it = tree.iterator();
      it.remove();
   }
   
   @Test (expected=UnsupportedOperationException.class)
   public void testIterator2_Remove() {
      BST<Integer> tree = new BST<>();
      Iterator it = tree.iterator();
      tree.insert(50);
      it.remove();
   }
   
   @Test
   public void testIterator3_hasNext() {
      BST<Integer> tree = new BST<>();
      Iterator it = tree.iterator();
      assertFalse(it.hasNext());
   }
   
   @Test
   public void testIterator4_hasNext() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      Iterator it = tree.iterator();
      assertTrue(it.hasNext());
   }

   @Test
   public void testIterator5_hasNext() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      Iterator it = tree.iterator();
      assertTrue(it.hasNext());
      it.next();
      assertFalse(it.hasNext());
   }
   
   @Test (expected=NoSuchElementException.class)
   public void testIterator6_Next() {
      BST<Integer> tree = new BST<>();
      Iterator it = tree.iterator();
      it.next();
   }
   
   @Test 
   public void testIterator7_Next() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      Iterator it = tree.iterator();
      assertEquals(5, it.next());
   }
   
   @Test 
   public void testIterator8_Next() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(4);
      Iterator it = tree.iterator();
      assertEquals(3, it.next());
      assertEquals(4, it.next());
      assertEquals(5, it.next());
   }
   
   @Test
   public void testIterator9_Next_lopsidedRight() {
      BST<Integer> tree = new BST<>();
      for (int i = 0; i < 10; i++) {
         tree.insert(i);
      }
      Iterator it = tree.iterator();
      for (int i = 0; i < 10; i++) {
         assertEquals(i, it.next());
      }
   }

   @Test
   public void testIterator10_Next_lopsidedLeft() {
      BST<Integer> tree = new BST<>();
      for (int i = 10; i > 0; i--) {
         tree.insert(i);
      }
      Iterator it = tree.iterator();
      for (int i = 1; i < 11; i++) {
         assertEquals(i, it.next());
      }
   }

   @Test
   public void testIterator11_Next_Normalish() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(1);
      tree.insert(2);
      tree.insert(7);
      tree.insert(6);
      tree.insert(4);
      tree.insert(8);
      tree.insert(0);
      Iterator it = tree.iterator();
      for (int i = 0; i < 9; i++) {
         assertEquals(i, it.next());
      }
   }

   @Test
   public void testIterator12_Next_Normalish() {
      BST<Integer> tree = new BST<>();
      tree.insert(100);
      tree.insert(50);
      tree.insert(20);
      tree.insert(40);
      tree.insert(30);
      tree.insert(25);
      tree.insert(45);
      tree.insert(75);
      tree.insert(80);
      tree.insert(200);
      tree.insert(150);
      tree.insert(175);
      tree.insert(300);
      tree.insert(400);
      Iterator it = tree.iterator();
      assertEquals(20, it.next());
      assertEquals(25, it.next());
      assertEquals(30, it.next());
      assertEquals(40, it.next());
      assertEquals(45, it.next());
      assertEquals(50, it.next());
      assertEquals(75, it.next());
      assertEquals(80, it.next());
      assertEquals(100, it.next());
      assertEquals(150, it.next());
      assertEquals(175, it.next());
      assertEquals(200, it.next());
      assertEquals(300, it.next());
      assertEquals(400, it.next());
   }  

   @Test (expected=NoSuchElementException.class)
   public void testIterator13_Next_TooMany() {
      BST<Integer> tree = new BST<>();
      tree.insert(5);
      Iterator it = tree.iterator();
      it.next();
      assertFalse(it.hasNext());
      it.next();
   }

   @Test (expected=NoSuchElementException.class)
   public void testIterator14_Next_TooMany() {
      BST<Integer> tree = new BST<>();
      for (int i = 0; i < 10; i++) {
         tree.insert(i);
      }
      Iterator it = tree.iterator();
      for (int i = 0; i < 10; i++) {
         it.next();
      }
      assertFalse(it.hasNext());
      it.next();
   }

   @Test (expected=NoSuchElementException.class)
   public void testIterator15_Next_TooMany() {
      BST<Integer> tree = new BST<>();
      tree.insert(100);
      tree.insert(50);
      tree.insert(20);
      tree.insert(40);
      tree.insert(30);
      tree.insert(25);
      tree.insert(45);
      tree.insert(75);
      tree.insert(80);
      tree.insert(200);
      tree.insert(150);
      tree.insert(175);
      tree.insert(300);
      tree.insert(400);
      Iterator it = tree.iterator();
      for (int i = 0; i < 14; i++) {
         it.next();
      }
      assertFalse(it.hasNext());
      it.next();
   }  

   // Private helper method
   private static <T> boolean listEquals(T[] arr, ArrayList<T> arr2) {
      if (arr.length != arr2.size()) {
         return false;
      }
      for (int i = 0; i < arr.length; i++) {
         if (!arr[i].equals(arr2.get(i))) {
            return false;
         }
      }
      return true;
   }
}
