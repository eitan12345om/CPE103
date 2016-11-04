import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for the SimpleLinkedList class
 *
 * @author Evan Jameson
 * @version Lab01
 */

public class SimpleLinkedListTests {

   @Test
   public void testSize_empty() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      assertTrue(list.size() == 0);
   }

   @Test
   public void testSize_notEmpty() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(1);
      list.add(1, 2);
      assertFalse(list.size() == 0);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testGet_atConstructionBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.get(0);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testGet_indexBelowBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.get(-1); 
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testGet_indexAboveBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.get(3); 
   }
   
   @Test
   public void testGet_indexStart() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.get(0) == 1); 
   }

   @Test
   public void testGet_indexEnd() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.get(2) == 3); 
   }

   @Test
   public void testGet_indexMiddle() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.get(1) == 2); 
   }
   
   @Test (expected=IndexOutOfBoundsException.class)
   public void testAdd_atConstructionBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(25, null);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testRemove_atConstructionBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.remove(0);
   }
  
   @Test (expected=IndexOutOfBoundsException.class)
   public void testRemove_indexBelowBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.remove(-1);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testRemove_indexAboveBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.remove(3);
   }

   @Test ()
   public void testRemove_indexStart() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(3);
      list.add(2);
      list.add(1);
      assertTrue(list.remove(0) == 3);
      assertTrue(listEquals(list, new Integer[] {2, 1}));
      assertTrue(list.size() == 2);
   }

   @Test ()
   public void testRemove_indexEnd() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.remove(2) == 3);
      assertTrue(listEquals(list, new Integer[] {1, 2}));
      assertTrue(list.size() == 2);
   }

   @Test ()
   public void testRemove_indexMiddle() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(3);
      list.add(2);
      list.add(1);
      assertTrue(list.remove(1) == 2);
      assertTrue(listEquals(list, new Integer[] {3, 1}));
      assertTrue(list.size() == 2);
   }

   @Test
   public void testAddSize() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(10);
      list.add(20);
      list.add(30);
      list.add(100);
      assertTrue(listEquals(list, new Integer[] {10, 20, 30, 100}));
      assertTrue(list.size() == 4);
   }

   @Test
   public void testOtherAddSize() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(0, 10);
      list.add(0, 20);
      list.add(1, 30);
      list.add(0, 100);
      assertTrue(listEquals(list, new Integer[] {100, 20, 30, 10}));
      assertTrue(list.size() == 4);
   }

   @Test
   public void testAddNull() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(null);
      list.add(4);
      list.add(3);
      list.add(null);
      assertTrue(listEquals(list, new Integer[] {null, 4, 3, null}));
      assertTrue(list.size() == 4);
   }

   @Test
   public void testOtherAddNull() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(0, null);
      list.add(1, 1);
      list.add(0, null);
      list.add(3, 5);
      assertTrue(listEquals(list, new Integer[] {null, null, 1, 5}));
      assertTrue(list.size() == 4);
   }

   @Test
   public void testGetNull() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(null);
      list.add(1);
      list.add(2);
      list.add(9);
      assertTrue(list.get(0) == null);
   }

   @Test
   public void testGetNull_otherAdd() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(0, null);
      list.add(1, 1);
      list.add(0, 1);
      list.add(0, 6);
      assertTrue(list.get(2) == null);
   }

   @Test
   public void testRemoveNull() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(null);
      list.add(2);
      list.add(4);
      list.add(6);
      assertTrue(list.remove(0) == null);
   }

   @Test
   public void testRemoveNull_otherAdd() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(0, null);
      list.add(1, 1);
      list.add(0, 3);
      list.add(0, 5);
      assertTrue(list.remove(2) == null);
   }

   @Test
   public void testSizeNull() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(null);
      list.add(1);
      list.add(2);
      list.add(1);
      assertTrue(list.size() == 4);
   }

   @Test
   public void testSizeNull_otherAdd() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(0, null);
      list.add(1, 3);
      list.add(0, 9);
      list.add(0, 4);
      list.add(3, 7);
      assertTrue(list.size() == 5);
   }

   @Test
   public void testNonInteger() {
      SimpleLinkedList<String> list = new SimpleLinkedList<>();
      list.add("Yoo");
      list.add(0, "Sup fam");
      list.add("How are you?");
      list.add(0, null);
      assertTrue(list.get(2).equals("Yoo"));
      assertTrue(list.get(0) == null);
      assertTrue(list.size() == 4);
      assertTrue(list.remove(1).equals("Sup fam"));
      assertTrue(list.size() == 3);
      assertTrue(list.get(2).equals("How are you?"));
   }

   // Private helper function to test lists
   private static <T> boolean listEquals(SimpleLinkedList<T> list, T[] a) {
      if (list.size() != a.length) {
         return false;
      }

      for (int i = 0; i < a.length; i++) {
         if (list.get(i) == null || a[i] == null) {
            if (list.get(i) != a[i]) {
               return false;
            }
         }
         else {
            if (!list.get(i).equals(a[i])) {
               return false;
            }
         }
      }

      return true;
   }
}
