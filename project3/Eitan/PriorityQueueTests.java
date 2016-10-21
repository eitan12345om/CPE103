import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

/**
 * Priority queue tests.
 *
 * @author Eitan Simler
 * @version Project3
 */

public class PriorityQueueTests {

   // Size Tests
   @Test
   public void testSize_first_atConstruction() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>();
      assertEquals(0, myQueue.size());     
   }

   @Test
   public void testSize_second_atConstruction() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(true);
      assertEquals(0, myQueue.size());   
   }

   @Test
   public void testSize_second_atConstruction2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(false);
      assertEquals(0, myQueue.size());   
   }



   // Enqueue Tests
   @Test
   public void testEnqueueSize_first() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>();
      myQueue.enqueue(1);
      assertEquals(1, myQueue.size());
   }

   @Test
   public void testEnqueueSize_second() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(true);
      myQueue.enqueue(1);
      assertEquals(1, myQueue.size());
   }

   @Test
   public void testEnqueueSize_second2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(false);
      myQueue.enqueue(1);
      assertEquals(1, myQueue.size());
   }


   // Dequeue Tests
   // TODO: Add Tests  

   // Peek Tests
   @Test (expected=NoSuchElementException.class)
   public void testPeek_first_noElements() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>();
      myQueue.peek(); 
   }

   @Test (expected=NoSuchElementException.class)
   public void testPeek_second_noElements() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(true);
      myQueue.peek(); 
   }

   @Test (expected=NoSuchElementException.class)
   public void testPeek_second_noElements2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(false);
      myQueue.peek(); 
   }

   @Test
   public void testPeek_first() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>();
      myQueue.enqueue(5);
      assertEquals(5, (int) myQueue.peek());
   }

   @Test
   public void testPeekSize_second() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(true);
      myQueue.enqueue(5);
      assertEquals(5, (int) myQueue.peek());
   }

   @Test
   public void testPeekSize_second2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(false);
      myQueue.enqueue(4);
      assertEquals(4, (int) myQueue.peek());
   }
   // TODO: Add Tests

   // Sort Tests
   // TODO: Add Tests

   // Kth Tests
   // TODO: Add Tests
}
