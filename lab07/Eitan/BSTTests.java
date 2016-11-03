import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * JUnit tests for BST.
 *
 * @author Eitan Simler
 * @version Lab07
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
