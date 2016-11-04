/**
 * JUnit tests for the CircularQueue class
 *
 * @author Evan Jameson
 * @version Project1
 */

import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

public class CircularQueueTests {

   @Test 
   public void testEnqueueSize() {
      CircularQueue<Integer> list = new CircularQueue<>();
      list.enqueue(1);
      list.enqueue(2);
      assertTrue(list.size() == 2);
   }

   @Test 
   public void testEnqueueSize_otherConstructor() {
      CircularQueue<Integer> list = new CircularQueue<>(5);
      list.enqueue(1);
      list.enqueue(2);
      assertTrue(list.size() == 2);
   }

   @Test 
   public void testEnqueuePeek() {
      CircularQueue<Integer> list = new CircularQueue<>();
      list.enqueue(1);
      list.enqueue(2);
      assertTrue(list.peek() == 1);
   }

   @Test 
   public void testEnqueuePeek_otherConstructor() {
      CircularQueue<Integer> list = new CircularQueue<>(5);
      list.enqueue(1);
      list.enqueue(2);
      assertTrue(list.peek() == 1);
   }

   @Test 
   public void testEnqueue_moreThanInitialLength() {
      CircularQueue<Integer> list = new CircularQueue<>();
      Integer[] temp = new Integer[100];
      for (int i = 0; i < 100; i++) {
         list.enqueue(i);
         temp[i] = i;
      }
      assertTrue(list.size() == 100);
      assertTrue(listEquals(list, temp));
   }

   @Test 
   public void testEnqueue_moreThanInitialLength_otherConstructor() {
      CircularQueue<Integer> list = new CircularQueue<>(1);
      Integer[] temp = new Integer[100];
      for (int i = 0; i < 100; i++) {
         list.enqueue(i);
         temp[i] = i;
      }
      assertTrue(list.size() == 100);
      assertTrue(listEquals(list, temp));
   }

      @Test (expected=CircularQueue.MyException.class)
   public void testSecondConstructor_initalOf0() {
      CircularQueue<Integer> list = new CircularQueue<>(0);
   }

   @Test (expected=NoSuchElementException.class)
   public void testPeek_atConstruction() {
      CircularQueue<Integer> list = new CircularQueue<>();
      list.peek();
   }

      @Test
   public void testSize_emptyAtConstruction() {
      CircularQueue<Integer> list = new CircularQueue<>();
      assertTrue(list.size() == 0);
   }

   @Test
   public void testSize_emptyAtConstruction_otherConstructor() {
      CircularQueue<Integer> list = new CircularQueue<>(5);
      assertTrue(list.size() == 0);
   }

   @Test (expected=NoSuchElementException.class)
   public void testPeek_atConstruction_otherConstructor() {
      CircularQueue<Integer> list = new CircularQueue<>(5);
      list.peek();
   }

   @Test (expected=NoSuchElementException.class)
   public void testDequeue_atConstruction() {
      CircularQueue<Integer> list = new CircularQueue<>();
      list.dequeue();
   }

   @Test (expected=NoSuchElementException.class)
   public void testDequeue_atConstruction_otherConstructor() {
      CircularQueue<Integer> list = new CircularQueue<>(5);
      list.dequeue();
   }

   @Test 
   public void testDequeue() {
      CircularQueue<Integer> list = new CircularQueue<>();
      for (int i = 0; i < 10; i++) {
         list.enqueue(i);
      }
      for (int i = 0; i < 5; i++) {
         list.dequeue();
      }
      assertTrue(list.size() == 5);
      assertTrue(listEquals(list, new Integer[] {5, 6, 7, 8, 9}));
   }

    @Test 
   public void testDequeueReturn() {
      CircularQueue<Integer> list = new CircularQueue<>();
      for (int i = 0; i < 10; i++) {
         list.enqueue(i);
      }
      assertTrue(list.dequeue() == 0);
   }

   @Test 
   public void testDequeue_otherConstructor() {
      CircularQueue<Integer> list = new CircularQueue<>(5);
      for (int i = 0; i < 10; i++) {
         list.enqueue(i);
      }
      for (int i = 0; i < 5; i++) {
         list.dequeue();
      }
      assertTrue(list.size() == 5);
      assertTrue(listEquals(list, new Integer[] {5, 6, 7, 8, 9}));
   }



   @Test 
   public void testDequeueReturn_otherConstructor() {
      CircularQueue<Integer> list = new CircularQueue<>(5);
      for (int i = 0; i < 10; i++) {
         list.enqueue(i);
      }

      assertTrue(list.dequeue() == 0);
   }

   @Test (expected=NoSuchElementException.class) 
   public void testDequeueTooMany() {
      CircularQueue<Integer> list = new CircularQueue<>();
      for (int i = 0; i < 10; i++) {
         list.enqueue(i);
      }
      for (int i = 0; i < 11; i++) {
         list.dequeue();
      }
   }

   @Test (expected=NoSuchElementException.class) 
   public void testDequeueTooMany_otherConstructor() {
      CircularQueue<Integer> list = new CircularQueue<>(5);
      for (int i = 0; i < 10; i++) {
         list.enqueue(i);
      }
      for (int i = 0; i < 11; i++) {
         list.dequeue();
      }
   }

   @Test 
   public void testPeek() {
      CircularQueue<Integer> list = new CircularQueue<>();
      for (int i = 0; i < 10; i++) {
         list.enqueue(i);
      }
      assertTrue(list.peek() == 0);
   }

   @Test 
   public void testPeek_otherConstructor() {
      CircularQueue<Integer> list = new CircularQueue<>(5);
      for (int i = 0; i < 10; i++) {
         list.enqueue(i);
      }
      assertTrue(list.peek() == 0);
   }

   @Test (expected=NoSuchElementException.class) 
   public void testPeekNoElements() {
      CircularQueue<Integer> list = new CircularQueue<>();
      for (int i = 0; i < 10; i++) {
         list.enqueue(i);
      }
      for (int i = 0; i < 10; i++) {
         list.dequeue();
      }
      list.peek();
   }

   @Test (expected=NoSuchElementException.class) 
   public void testPeekNoElements_otherConstructor() {
      CircularQueue<Integer> list = new CircularQueue<>(5);
      for (int i = 0; i < 10; i++) {
         list.enqueue(i);
      }
      for (int i = 0; i < 10; i++) {
         list.dequeue();
      }
      list.peek();
   }


   @Test (expected=CircularQueue.MyException.class)
   public void testSecondConstructor_initalOf0_String() {
      CircularQueue<String> list = new CircularQueue<>(0);
   }

   @Test (expected=NoSuchElementException.class)
   public void testPeek_atConstruction_String() {
      CircularQueue<String> list = new CircularQueue<>();
      list.peek();
   }

   @Test (expected=NoSuchElementException.class)
   public void testPeek_atConstruction_otherConstructor_String() {
      CircularQueue<String> list = new CircularQueue<>(5);
      list.peek();
   }

   @Test (expected=NoSuchElementException.class)
   public void testDequeue_atConstruction_String() {
      CircularQueue<String> list = new CircularQueue<>();
      list.dequeue();
   }

   @Test (expected=NoSuchElementException.class)
   public void testDequeue_atConstruction_otherConstructor_String() {
      CircularQueue<String> list = new CircularQueue<>(5);
      list.dequeue();
   }

   @Test 
   public void testEnqueueSize_String() {
      CircularQueue<String> list = new CircularQueue<>();
      list.enqueue("a");
      list.enqueue("b");
      assertTrue(list.size() == 2);
   }

   @Test 
   public void testEnqueueSize_otherConstructor_String() {
      CircularQueue<String> list = new CircularQueue<>(5);
      list.enqueue("a");
      list.enqueue("b");
      assertTrue(list.size() == 2);
   }

   @Test 
   public void testEnqueuePeek_String() {
      CircularQueue<String> list = new CircularQueue<>();
      list.enqueue("a");
      list.enqueue("b");
      assertTrue(list.peek().equals("a"));
   }

   @Test 
   public void testEnqueuePeek_otherConstructor_String() {
      CircularQueue<String> list = new CircularQueue<>(5);
      list.enqueue("a");
      list.enqueue("b");
      assertTrue(list.peek().equals("a"));
   }

   @Test 
   public void testDequeue_String() {
      CircularQueue<String> list = new CircularQueue<>();
      list.enqueue("a");
      list.enqueue("b");
      list.enqueue("c");
      list.enqueue("d");
      list.enqueue("e");
      list.dequeue();
      list.dequeue();
      assertTrue(list.size() == 3);
      assertTrue(listEquals(list, new String[] {"c", "d", "e"}));
   }

   @Test (expected=CircularQueue.MyException.class)
   public void testMyException() {
      throw new CircularQueue.MyException();
   }

   @Test (expected=CircularQueue.MyException.class)
   public void testMyException_withString() {
      throw new CircularQueue.MyException("A String!");
   }

   @Test
   public void testMyExceptionMessage() {
      assertTrue(new CircularQueue.MyException("A String!").getMessage().equals("A String!"));
   }

   // Private helper function to equate lists
   private static <T> boolean listEquals(CircularQueue<T> list, T[] a) {
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
