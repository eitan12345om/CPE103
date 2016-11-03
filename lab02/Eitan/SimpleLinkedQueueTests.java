import java.util.NoSuchElementException;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for SimpleLinkedQueue.
 *
 * @author Eitan Simler
 * @version Lab02
 */

public class SimpleLinkedQueueTests {

   @Test
   public void testSize_empty() {
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<>();
      assertTrue(list.size() == 0);
   }

   @Test
   public void testSize_notEmpty() {
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<>();
      list.enqueue(1);
      assertTrue(list.size() == 1);
   }

   @Test
   public void testEnqueueSize() {
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<>();
      for (int i = 0; i < 10; i++) {
         list.enqueue(i);
      }
      assertTrue(list.size() == 10);
   }

   @Test
   public void testEnqueueOrder() {
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<>();
      for (int i = 0; i < 10; i++) {
         list.enqueue(i);
      }
      assertTrue(listEquals(list, new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
   }

   @Test (expected=NoSuchElementException.class)
   public void testDequeue_atConstruction() {
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<>();
      list.dequeue();
   }

   @Test (expected=NoSuchElementException.class)
   public void testDequeue_addingThenRemovingUntilNone() {
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<>();
      for (int i = 0; i < 3; i++) {
         list.enqueue(1);
      }
      for (int i = 0; i < 4; i++) {
         list.dequeue();
      }
   }

   @Test
   public void testDequeueSize() {
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<>();
      list.enqueue(5);
      list.dequeue();
      assertTrue(list.size() == 0);
   }

   @Test
   public void testDequeueReturnsElement() {
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<>();
      list.enqueue(5);
      assertTrue(list.dequeue() == 5);
   }

   @Test (expected=NoSuchElementException.class)
   public void testPeek_atConstruction() {
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<>();
      list.peek();
   }

   @Test
   public void testPeek_oneElement() {
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<>();
      list.enqueue(5);
      assertTrue(list.peek() == 5);
   }

   @Test
   public void testPeek_moreElements() {
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<>();
      list.enqueue(5);
      list.enqueue(6);
      list.enqueue(7);
      assertTrue(list.peek() == 5);
   }

   @Test
   public void testNonIntegerPeek() {
      SimpleLinkedQueue<String> list = new SimpleLinkedQueue<>();
      list.enqueue("Hello");
      list.enqueue("Hi");
      list.enqueue("When");
      assertTrue(list.peek().equals("Hello"));
   }

   @Test
   public void testNonIntegerPeekNull() {
      SimpleLinkedQueue<String> list = new SimpleLinkedQueue<>();
      list.enqueue(null);
      list.enqueue("Hi");
      list.enqueue("When");
      assertTrue(list.peek() == null);
   }

   @Test
   public void testNonIntegerDequeue() {
      SimpleLinkedQueue<String> list = new SimpleLinkedQueue<>();
      list.enqueue("Hello");
      list.enqueue("Hi");
      list.enqueue("When");
      assertTrue(list.dequeue().equals("Hello"));
      assertTrue(list.size() == 2);
   }

   @Test
   public void testNonIntegerDequeueNull() {
      SimpleLinkedQueue<String> list = new SimpleLinkedQueue<>();
      list.enqueue(null);
      list.enqueue("Hi");
      list.enqueue("When");
      assertTrue(list.dequeue() == null);
      assertTrue(list.size() == 2);
   }

   @Test
   public void testNonIntegerEnqueueSize() {
      SimpleLinkedQueue<String> list = new SimpleLinkedQueue<>();
      list.enqueue("Hello");
      list.enqueue("Hi");
      list.enqueue("When");
      assertTrue(list.size() == 3);
   }

   @Test
   public void testNonIntegerEnqueueSizeNull() {
      SimpleLinkedQueue<String> list = new SimpleLinkedQueue<>();
      list.enqueue(null);
      list.enqueue(null);
      list.enqueue(null);
      assertTrue(list.size() == 3);
   }

   @Test
   public void testNonIntegerSize_atConstruction() {
      SimpleLinkedQueue<String> list = new SimpleLinkedQueue<>();
      assertTrue(list.size() == 0);
   }

   // Private helper function to equate lists
   private static <T> boolean listEquals(SimpleLinkedQueue<T> list, T[] a) {
      if (list.size() != a.length) {         
         return false;
      }

      for (int i = 0; i < a.length; i++) {
         if (list.peek() == null || a[i] == null) {
            if (list.dequeue() != a[i]) {
               return false;
            }
         }
         else {
            if (!list.dequeue().equals(a[i])) {
               return false;
            }
         }
      }

      return true;
   }
}
