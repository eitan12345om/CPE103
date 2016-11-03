import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for RecursiveLinkedList.
 *
 * @author Eitan Simler
 * @version Lab03
 */

public class RecursiveLinkedListTests {

   @Test
   public void testSize_empty() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      assertTrue(list.size() == 0);
   }

   @Test
   public void testSize_notEmpty() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(1);
      list.add(1, 2);
      assertFalse(list.size() == 0);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testGet_atConstruction() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.get(0);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testGet_indexTooLow() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.get(-1); 
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testGet_indexTooHigh() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.get(3); 
   }
   
   @Test
   public void testGet_indexBeginning() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.get(0) == 1); 
   }

   @Test
   public void testGet_indexEnd() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.get(2) == 3); 
   }

   @Test
   public void testGet_indexMiddle() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.get(1) == 2); 
   }
   
   @Test (expected=IndexOutOfBoundsException.class)
   public void testAdd_atConstructionOutOfBounds() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(25, null);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testRemove_atConstruction() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.remove(0);
   }
  
   @Test (expected=IndexOutOfBoundsException.class)
   public void testRemove_indexTooLow() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.remove(-1);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testRemove_indexTooHigh() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.remove(3);
   }

   @Test ()
   public void testRemove_indexBeginning() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.remove(0) == 1);
      assertTrue(listEquals(list, new Integer[] {2, 3}));
      assertTrue(list.size() == 2);
   }

   @Test ()
   public void testRemove_indexEnd() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.remove(2) == 3);
      assertTrue(listEquals(list, new Integer[] {1, 2}));
      assertTrue(list.size() == 2);
   }

   @Test ()
   public void testRemove_indexMiddle() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.remove(1) == 2);
      assertTrue(listEquals(list, new Integer[] {1, 3}));
      assertTrue(list.size() == 2);
   }

   @Test
   public void testAddSize() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(5);
      list.add(10);
      list.add(15);
      list.add(20);
      assertTrue(listEquals(list, new Integer[] {5, 10, 15, 20}));
      assertTrue(list.size() == 4);
   }

   @Test
   public void testOtherAddSize() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(0, 5);
      list.add(0, 10);
      list.add(1, 15);
      list.add(0, 20);
      assertTrue(listEquals(list, new Integer[] {20, 10, 15, 5}));
      assertTrue(list.size() == 4);
   }

   @Test
   public void testAddNull() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(null);
      list.add(1);
      list.add(2);
      list.add(null);
      assertTrue(listEquals(list, new Integer[] {null, 1, 2, null}));
      assertTrue(list.size() == 4);
   }

   @Test
   public void testOtherAddNull() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(0, null);
      list.add(1, 1);
      list.add(0, null);
      list.add(3, 5);
      assertTrue(listEquals(list, new Integer[] {null, null, 1, 5}));
      assertTrue(list.size() == 4);
   }

   @Test
   public void testGetNull() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(null);
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.get(0) == null);
   }

   @Test
   public void testGetNull_withOtherAdd() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(0, null);
      list.add(1, 1);
      list.add(0, 3);
      list.add(0, 2);
      assertTrue(list.get(2) == null);
   }

   @Test
   public void testRemoveNull() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(null);
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.remove(0) == null);
   }

   @Test
   public void testRemoveNull_withOtherAdd() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(0, null);
      list.add(1, 1);
      list.add(0, 3);
      list.add(0, 2);
      assertTrue(list.remove(2) == null);
   }

   @Test
   public void testSizeNull() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(null);
      list.add(1);
      list.add(2);
      list.add(3);
      assertTrue(list.size() == 4);
   }

   @Test
   public void testSizeNull_withOtherAdd() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
      list.add(0, null);
      list.add(1, 1);
      list.add(0, 3);
      list.add(0, 2);
      assertTrue(list.size() == 4);
   }

   @Test
   public void testWithNonInteger() {
      RecursiveLinkedList<String> list = new RecursiveLinkedList<>();
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
   private static <T> boolean listEquals(RecursiveLinkedList<T> list, T[] a) {
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
