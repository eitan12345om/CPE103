import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for SimpleLinkedList.
 *
 * @author Eitan Simler
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
   public void testGet_atConstruction() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.get(0);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testGet_indexTooLow() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.get(-1); 
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testGet_indexTooHigh() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.get(3); 
   }
   
   @Test
   public void testGet_indexBeginning() {
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
   public void testAdd_atConstructionOutOfBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(25, null);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testRemove_atConstruction() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.remove(0);
   }
  
   @Test (expected=IndexOutOfBoundsException.class)
   public void testRemove_indexTooLow() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.remove(-1);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testRemove_indexTooHigh() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.remove(3);
   }

   @Test ()
   public void testRemove_indexBeginning() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.remove(0) == 1);
      assertTrue(listEquals(list, new Integer[] {2, 3}));
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
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.remove(1) == 2);
      assertTrue(listEquals(list, new Integer[] {1, 3}));
      assertTrue(list.size() == 2);
   }

   @Test
   public void testAddSize() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(5);
      list.add(10);
      list.add(15);
      list.add(20);
      assertTrue(listEquals(list, new Integer[] {5, 10, 15, 20}));
      assertTrue(list.size() == 4);
   }

   @Test
   public void testOtherAddSize() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(0, 5);
      list.add(0, 10);
      list.add(1, 15);
      list.add(0, 20);
      assertTrue(listEquals(list, new Integer[] {20, 10, 15, 5}));
      assertTrue(list.size() == 4);
   }

   @Test
   public void testAddNull() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(null);
      list.add(1);
      list.add(2);
      list.add(null);
      assertTrue(listEquals(list, new Integer[] {null, 1, 2, null}));
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
      list.add(3);
      assertTrue(list.get(0) == null);
   }

   @Test
   public void testGetNull_withOtherAdd() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(0, null);
      list.add(1, 1);
      list.add(0, 3);
      list.add(0, 2);
      assertTrue(list.get(2) == null);
   }

   @Test
   public void testRemoveNull() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(null);
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.remove(0) == null);
   }

   @Test
   public void testRemoveNull_withOtherAdd() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(0, null);
      list.add(1, 1);
      list.add(0, 3);
      list.add(0, 2);
      assertTrue(list.remove(2) == null);
   }

   @Test
   public void testSizeNull() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(null);
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.size() == 4);
   }

   @Test
   public void testSizeNull_withOtherAdd() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
      list.add(0, null);
      list.add(1, 1);
      list.add(0, 3);
      list.add(0, 2);
      assertTrue(list.size() == 4);
   }

   @Test
   public void testWithNonInteger() {
      SimpleLinkedList<String> list = new SimpleLinkedList<>();
      list.add("Hello");
      list.add(0, "Hey");
      list.add("What's up");
      list.add(0, null);
      assertTrue(list.get(2).equals("Hello"));
      assertTrue(list.get(0) == null);
      assertTrue(list.size() == 4);
      assertTrue(list.remove(1).equals("Hey"));
      assertTrue(list.size() == 3);
      assertTrue(list.get(2).equals("What's up"));
   }

   // Private helper function to equate lists
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
