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

   @Test
   public void testSize_third_atConstruction() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {}, 0);
      assertEquals(0, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null}));
   }

   @Test
   public void testSize_fourth_atConstruction() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {}, 0, true);
      assertEquals(0, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null}));
   }

   @Test
   public void testSize_fourth_atConstruction2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {}, 0, false);
      assertEquals(0, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null}));
   }

   // Enqueue Tests
   @Test
   public void testEnqueueSize_first() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>();
      myQueue.enqueue(1);
      assertEquals(1, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 1}));
   }
   
   @Test
   public void testEnqueueSize_first_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>();
      myQueue.enqueue(1);
      myQueue.enqueue(3);
      myQueue.enqueue(2);
      myQueue.enqueue(3);
      assertEquals(4, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 1, 2, 3, 3}));
   }
   
   @Test
   public void testEnqueueSize_first_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>();
      myQueue.enqueue(2);
      myQueue.enqueue(3);
      myQueue.enqueue(4);
      myQueue.enqueue(4);
      myQueue.enqueue(4);
      myQueue.enqueue(5);
      myQueue.enqueue(1);
      assertEquals(7, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 1, 2, 3, 4, 4, 4, 5}));
   }

   @Test
   public void testEnqueueSize_second() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(true);
      myQueue.enqueue(1);
      assertEquals(1, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 1}));
   }

   @Test
   public void testEnqueueSize_second_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(true);
      myQueue.enqueue(1);
      myQueue.enqueue(3);
      myQueue.enqueue(2);
      myQueue.enqueue(3);
      assertEquals(4, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 3, 3, 2, 1}));
   }
   
   @Test
   public void testEnqueueSize_second_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(true);
      myQueue.enqueue(2);
      myQueue.enqueue(3);
      myQueue.enqueue(4);
      myQueue.enqueue(4);
      myQueue.enqueue(4);
      myQueue.enqueue(5);
      myQueue.enqueue(1);
      assertEquals(7, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 5, 4, 4, 4, 3, 2, 1}));
   }

   @Test
   public void testEnqueueSize_second2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(false);
      myQueue.enqueue(1);
      assertEquals(1, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 1}));
   }

   @Test
   public void testEnqueueSize_second2_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(false);
      myQueue.enqueue(1);
      myQueue.enqueue(3);
      myQueue.enqueue(2);
      myQueue.enqueue(3);
      assertEquals(4, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 1, 2, 3, 3}));
   }
   
   @Test
   public void testEnqueueSize_second2_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(false);
      myQueue.enqueue(2);
      myQueue.enqueue(3);
      myQueue.enqueue(4);
      myQueue.enqueue(4);
      myQueue.enqueue(4);
      myQueue.enqueue(5);
      myQueue.enqueue(1);
      assertEquals(7, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 1, 2, 3, 4, 4, 4, 5}));
   }

   @Test
   public void testEnqueueSize_third() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {4}, 1);
      assertEquals(1, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 4}));
   }

   @Test
   public void testEnqueueSize_third2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {4, 6, 2, 6, 8, 4, 23}, 1);
      assertEquals(1, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 4}));
   }

   @Test
   public void testEnqueueSize_third3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {4, 6, 2, 6, 8, 4, 23}, 0);
      assertEquals(0, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null}));
   }

   @Test
   public void testEnqueueSize_third4() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {4, 6, 2, 6, 8, 4, 23}, 7);
      assertEquals(7, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 2, 4, 4, 6, 6, 8, 23}));
   }

   @Test
   public void testEnqueueSize_fourth() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {4}, 1, true);
      assertEquals(1, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 4}));
   }

   @Test
   public void testEnqueueSize_fourth_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {4, 6, 2, 6, 8, 4, 23}, 1, true);
      assertEquals(1, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 4}));
   }

   @Test
   public void testEnqueueSize_fourth_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {4, 6, 2, 6, 8, 4, 23}, 0, true);
      assertEquals(0, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null}));
   }

   @Test
   public void testEnqueueSize_fourth_4() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {4, 6, 2, 6, 8, 4, 23}, 7, true);
      assertEquals(7, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 23, 8, 6, 6, 4, 4, 2}));
   }

   @Test
   public void testEnqueueSize_fourth2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {4}, 1, false);
      assertEquals(1, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 4}));
   }

   @Test
   public void testEnqueueSize_fourth2_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {4, 6, 2, 6, 8, 4, 23}, 1, false);
      assertEquals(1, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 4}));
   }

   @Test
   public void testEnqueueSize_fourth2_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {4, 6, 2, 6, 8, 4, 23}, 0, false);
      assertEquals(0, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null}));
   }

   @Test
   public void testEnqueueSize_fourth2_4() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(
            new Integer[] {4, 6, 2, 6, 8, 4, 23}, 7, false);
      assertEquals(7, myQueue.size());
      assertTrue(listEquals(myQueue, new Integer[] {null, 2, 4, 4, 6, 6, 8, 23}));
   }

   // Dequeue Tests
   @Test (expected=NoSuchElementException.class)
   public void testDequeue_first_noElements() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>();
      myQueue.dequeue(); 
   }

   @Test (expected=NoSuchElementException.class)
   public void testDequeue_second_noElements() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(true);
      myQueue.dequeue(); 
   }

   @Test (expected=NoSuchElementException.class)
   public void testDequeue_second_noElements2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(false);
      myQueue.dequeue(); 
   }

   @Test (expected=NoSuchElementException.class)
   public void testDequeue_third_noElements() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {}, 0);
      myQueue.dequeue();
   }

   @Test (expected=NoSuchElementException.class)
   public void testDequeue_third_noElements_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {4, 5, 1, 2}, 0);
      myQueue.dequeue();
   }

   @Test (expected=NoSuchElementException.class)
   public void testDequeue_fourth_noElements() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {}, 0, true);
      myQueue.dequeue();
   }

   @Test (expected=NoSuchElementException.class)
   public void testDequeue_fourth_noElements_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {4, 5, 1, 2}, 0, true);
      myQueue.dequeue();
   }
   
   @Test (expected=NoSuchElementException.class)
   public void testDequeue_fourth_noElements2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {}, 0, false);
      myQueue.dequeue();
   }

   @Test (expected=NoSuchElementException.class)
   public void testDequeue_fourth_noElements2_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {4, 5, 1, 2}, 0, false);
      myQueue.dequeue();
   }
   
   @Test
   public void testDequeue_first() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>();
      myQueue.enqueue(5);
      assertEquals(5, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null}));
   }

   @Test
   public void testDequeue_first_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>();
      myQueue.enqueue(5);
      myQueue.enqueue(1);
      assertEquals(1, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 5}));
   }

   @Test
   public void testDequeue_first_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>();
      myQueue.enqueue(5);
      myQueue.enqueue(1);
      for (int i = 2; i < 10; i++) {
         myQueue.enqueue(i);
      }
      assertEquals(1, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 2, 3, 4, 5, 5, 6, 7, 8, 9}));
   }

   @Test
   public void testDequeue_second() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(true);
      myQueue.enqueue(5);
      assertEquals(5, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null}));
   }
   
   @Test
   public void testDequeue_second_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(true);
      myQueue.enqueue(1);
      myQueue.enqueue(5);
      assertEquals(5, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 1}));
   }

   @Test
   public void testDequeue_second_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(true);
      for (int i = 3; i > -5; i--) {
         myQueue.enqueue(i);
      }
      assertEquals(3, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 2, 1, 0, -1, -2, -3, -4}));
   }

   @Test
   public void testDequeue_second2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(false);
      myQueue.enqueue(4);
      assertEquals(4, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null}));
   }
   
   @Test
   public void testDequeue_second2_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(false);
      myQueue.enqueue(5);
      myQueue.enqueue(1);
      assertEquals(1, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 5}));
   }

   @Test
   public void testDequeue_second2_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(false);
      myQueue.enqueue(5);
      myQueue.enqueue(1);
      for (int i = 2; i < 10; i++) {
         myQueue.enqueue(i);
      }
      assertEquals(1, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 2, 3, 4, 5, 5, 6, 7, 8, 9}));
   }
   
   @Test
   public void testDequeue_third2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {5, 5, 5, 5, 6}, 5);
      assertEquals(5, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 5, 5, 5, 6}));
   }
   
   @Test
   public void testDequeue_third2_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {3, 5, 7, 2, 1}, 5);
      assertEquals(1, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 2, 3, 5, 7}));
   }

   @Test
   public void testDequeue_third2_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {3, -4, 7, 2, 1}, 5);
      assertEquals(-4, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 1, 2, 3, 7}));
   }

   @Test
   public void testDequeue_fourth() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {3, 5, 7, 2, 1}, 5, true);
      assertEquals(7, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 5, 3, 2, 1}));
   }
   
   @Test
   public void testDequeue_fourth_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {1, 5, 1, 1, 1}, 5, true);
      assertEquals(5, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 1, 1, 1, 1}));
   }

   @Test
   public void testDequeue_fourth_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {5, 5, 5, 5, 6}, 5, true);
      assertEquals(6, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 5, 5, 5, 5}));
   }

   @Test
   public void testDequeue_fourth2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {5, 5, 5, 5, 6}, 5, false);
      assertEquals(5, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 5, 5, 5, 6}));
   }
   
   @Test
   public void testDequeue_fourth2_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {3, 5, 7, 2, 1}, 5, false);
      assertEquals(1, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 2, 3, 5, 7}));
   }

   @Test
   public void testDequeue_fourth2_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {3, -4, 7, 2, 1}, 5, false);
      assertEquals(-4, (int) myQueue.dequeue());
      assertTrue(listEquals(myQueue, new Integer[] {null, 1, 2, 3, 7}));
   }

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

   @Test (expected=NoSuchElementException.class)
   public void testPeek_third_noElements() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {}, 0);
      myQueue.peek();
   }

   @Test (expected=NoSuchElementException.class)
   public void testPeek_third_noElements_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {4, 5, 1, 2}, 0);
      myQueue.peek();
   }

   @Test (expected=NoSuchElementException.class)
   public void testPeek_fourth_noElements() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {}, 0, true);
      myQueue.peek();
   }

   @Test (expected=NoSuchElementException.class)
   public void testPeek_fourth_noElements_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {4, 5, 1, 2}, 0, true);
      myQueue.peek();
   }
   
   @Test (expected=NoSuchElementException.class)
   public void testPeek_fourth_noElements2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {}, 0, false);
      myQueue.peek();
   }

   @Test (expected=NoSuchElementException.class)
   public void testPeek_fourth_noElements2_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {4, 5, 1, 2}, 0, false);
      myQueue.peek();
   }

   @Test
   public void testPeek_first() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>();
      myQueue.enqueue(5);
      assertEquals(5, (int) myQueue.peek());
   }

   @Test
   public void testPeek_first_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>();
      myQueue.enqueue(5);
      myQueue.enqueue(1);
      assertEquals(1, (int) myQueue.peek());
   }

   @Test
   public void testPeek_first_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>();
      myQueue.enqueue(5);
      myQueue.enqueue(1);
      for (int i = 2; i < 10; i++) {
         myQueue.enqueue(i);
      }
      assertEquals(1, (int) myQueue.peek());
   }

   @Test
   public void testPeek_second() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(true);
      myQueue.enqueue(5);
      assertEquals(5, (int) myQueue.peek());
   }
   
   @Test
   public void testPeek_second_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(true);
      myQueue.enqueue(1);
      myQueue.enqueue(5);
      assertEquals(5, (int) myQueue.peek());
   }

   @Test
   public void testPeek_second_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(true);
      myQueue.enqueue(1);
      myQueue.enqueue(5);
      for (int i = 2; i < -5; i--) {
         myQueue.enqueue(i);
      }
      assertEquals(5, (int) myQueue.peek());
   }

   @Test
   public void testPeek_second2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(false);
      myQueue.enqueue(4);
      assertEquals(4, (int) myQueue.peek());
   }
   
   @Test
   public void testPeek_second2_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(false);
      myQueue.enqueue(5);
      myQueue.enqueue(1);
      assertEquals(1, (int) myQueue.peek());
   }

   @Test
   public void testPeek_second2_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(false);
      myQueue.enqueue(5);
      myQueue.enqueue(1);
      for (int i = 2; i < 10; i++) {
         myQueue.enqueue(i);
      }
      assertEquals(1, (int) myQueue.peek());
   }
   
   @Test
   public void testPeek_third2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {5, 5, 5, 5, 6}, 5);
      assertEquals(5, (int) myQueue.peek());
   }
   
   @Test
   public void testPeek_third2_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {3, 5, 7, 2, 1}, 5);
      assertEquals(1, (int) myQueue.peek());
   }

   @Test
   public void testPeek_third2_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {3, -4, 7, 2, 1}, 5);
      assertEquals(-4, (int) myQueue.peek());
   }

   @Test
   public void testPeek_fourth() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {3, 5, 7, 2, 1}, 5, true);
      assertEquals(7, (int) myQueue.peek());
   }
   
   @Test
   public void testPeek_fourth_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {1, 5, 1, 1, 1}, 5, true);
      assertEquals(5, (int) myQueue.peek());
   }

   @Test
   public void testPeek_fourth_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {5, 5, 5, 5, 6}, 5, true);
      assertEquals(6, (int) myQueue.peek());
   }

   @Test
   public void testPeek_fourth2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {5, 5, 5, 5, 6}, 5, false);
      assertEquals(5, (int) myQueue.peek());
   }
   
   @Test
   public void testPeek_fourth2_2() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {3, 5, 7, 2, 1}, 5, false);
      assertEquals(1, (int) myQueue.peek());
   }

   @Test
   public void testPeek_fourth2_3() {
      PriorityQueue<Integer> myQueue = new PriorityQueue<>(new Integer[] {3, -4, 7, 2, 1}, 5, false);
      assertEquals(-4, (int) myQueue.peek());
   }

   // Sort Tests
   @Test
   public void testSort0() {
      Integer[] arr = new Integer[] {5, 4, 3, 2, 1};
      PriorityQueue.sort(arr, 0);
      assertTrue(arrEquals(new Integer[] {5, 4, 3, 2, 1}, arr));
   }

   @Test
   public void testSort1() {
      Integer[] arr = new Integer[] {5, 4, 3, 2, 1};
      PriorityQueue.sort(arr, 1);
      assertTrue(arrEquals(new Integer[] {5, 4, 3, 2, 1}, arr));
   }

   @Test
   public void testSort2() {
      Integer[] arr = new Integer[] {5, 4, 3, 2, 1};
      PriorityQueue.sort(arr, 2);
      assertTrue(arrEquals(new Integer[] {4, 5, 3, 2, 1}, arr));
   }

   @Test
   public void testSort3() {
      Integer[] arr = new Integer[] {5, 4, 3, 2, 1};
      PriorityQueue.sort(arr, 3);
      assertTrue(arrEquals(new Integer[] {3, 4, 5, 2, 1}, arr));
   }

   @Test
   public void testSort4() {
      Integer[] arr = new Integer[] {5, 4, 3, 2, 1};
      PriorityQueue.sort(arr, 4);
      assertTrue(arrEquals(new Integer[] {2, 3, 4, 5, 1}, arr));
   }

   @Test
   public void testSort5() {
      Integer[] arr = new Integer[] {5, 4, 3, 2, 1};
      PriorityQueue.sort(arr, 5);
      assertTrue(arrEquals(new Integer[] {1, 2, 3, 4, 5}, arr));
   }

   @Test
   public void testSort0_Character() {
      Character[] arr = new Character[] {'e', 'd', 'c', 'b', 'a'};
      PriorityQueue.sort(arr, 0);
      assertTrue(arrEquals(new Character[] {'e', 'd', 'c', 'b', 'a'}, arr));
   }
   
   @Test
   public void testSort1_Character() {
      Character[] arr = new Character[] {'e', 'd', 'c', 'b', 'a'};
      PriorityQueue.sort(arr, 1);
      assertTrue(arrEquals(new Character[] {'e', 'd', 'c', 'b', 'a'}, arr));
   }
   
   @Test
   public void testSort2_Character() {
      Character[] arr = new Character[] {'e', 'd', 'c', 'b', 'a'};
      PriorityQueue.sort(arr, 2);
      assertTrue(arrEquals(new Character[] {'d', 'e', 'c', 'b', 'a'}, arr));
   }
   
   @Test
   public void testSort3_Character() {
      Character[] arr = new Character[] {'e', 'd', 'c', 'b', 'a'};
      PriorityQueue.sort(arr, 3);
      assertTrue(arrEquals(new Character[] {'c', 'd', 'e', 'b', 'a'}, arr));
   }
 
   @Test
   public void testSort4_Character() {
      Character[] arr = new Character[] {'e', 'd', 'c', 'b', 'a'};
      PriorityQueue.sort(arr, 4);
      assertTrue(arrEquals(new Character[] {'b', 'c', 'd', 'e', 'a'}, arr));
   }
   
   @Test
   public void testSort5_Character() {
      Character[] arr = new Character[] {'e', 'd', 'c', 'b', 'a'};
      PriorityQueue.sort(arr, 5);
      assertTrue(arrEquals(new Character[] {'a', 'b', 'c', 'd', 'e'}, arr));
   }
   
   @Test
   public void testSort0_String() {
      String[] arr = new String[] {"e", "d", "c", "b", "a"};
      PriorityQueue.sort(arr, 0);
      assertTrue(arrEquals(new String[] {"e", "d", "c", "b", "a"}, arr));
   }
   
   @Test
   public void testSort1_String() {
      String[] arr = new String[] {"e", "d", "c", "b", "a"};
      PriorityQueue.sort(arr, 1);
      assertTrue(arrEquals(new String[] {"e", "d", "c", "b", "a"}, arr));
   }
   
   @Test
   public void testSort2_String() {
      String[] arr = new String[] {"e", "d", "c", "b", "a"};
      PriorityQueue.sort(arr, 2);
      assertTrue(arrEquals(new String[] {"d", "e", "c", "b", "a"}, arr));
   }
   
   @Test
   public void testSort3_String() {
      String[] arr = new String[] {"e", "d", "c", "b", "a"};
      PriorityQueue.sort(arr, 3);
      assertTrue(arrEquals(new String[] {"c", "d", "e", "b", "a"}, arr));
   }
 
   @Test
   public void testSort4_String() {
      String[] arr = new String[] {"e", "d", "c", "b", "a"};
      PriorityQueue.sort(arr, 4);
      assertTrue(arrEquals(new String[] {"b", "c", "d", "e", "a"}, arr));
   }
   
   @Test
   public void testSort5_String() {
      String[] arr = new String[] {"e", "d", "c", "b", "a"};
      PriorityQueue.sort(arr, 5);
      assertTrue(arrEquals(new String[] {"a", "b", "c", "d", "e"}, arr));
   }
   
   // Kth Tests
   @Test
   public void testKth1() {
      Integer[] arr = new Integer[] {1, 2, 3, 4, 5};
      assertEquals(1, (int) PriorityQueue.kth(arr, 1, 1));
   }

   @Test
   public void testKth2() {
      Integer[] arr = new Integer[] {1, 2, 3, 4, 5};
      assertEquals(2, (int) PriorityQueue.kth(arr, 2, 1));
   }

   @Test
   public void testKth3() {
      Integer[] arr = new Integer[] {1, 2, 3, 4, 5};
      assertEquals(3, (int) PriorityQueue.kth(arr, 3, 1));
   }

   @Test
   public void testKth4() {
      Integer[] arr = new Integer[] {1, 2, 3, 4, 5};
      assertEquals(4, (int) PriorityQueue.kth(arr, 4, 1));
   }

   @Test
   public void testKth5() {
      Integer[] arr = new Integer[] {1, 2, 3, 4, 5};
      assertEquals(5, (int) PriorityQueue.kth(arr, 5, 1));
   }

   @Test
   public void testKth_Misc1() {
      Integer[] arr = new Integer[] {4, 6, 2, 4, 5};
      assertEquals(4, (int) PriorityQueue.kth(arr, 3, 2));
   }

   @Test
   public void testKth_Misc2() {
      Integer[] arr = new Integer[] {11, 4, 3, 2, 5};
      assertEquals(2, (int) PriorityQueue.kth(arr, 4, 4));
   }

   @Test
   public void testKth_Misc3() {
      Integer[] arr = new Integer[] {11, 4, 3, 2, 5};
      assertEquals(4, (int) PriorityQueue.kth(arr, 5, 3));
   }

   // Helper methods
   private static <T extends Comparable<? super T>> boolean listEquals(
         PriorityQueue<T> myQueue, T[] arr) { 
      if (myQueue.size() != arr.length - 1) {
         return false;
      }

      for (int i = 1; i < arr.length; i++) {
         if (!myQueue.dequeue().equals(arr[i])) {
            return false;
         }
      }
      return true;
   }

   private static <T extends Comparable<? super T>> boolean arrEquals(
         T[] arr1, T[] arr2) {
      if (arr1.length != arr2.length) {
         return false;
      }
      for (int i = 0; i < arr1.length; i++) {
         if (!arr1[i].equals(arr2[i])) {
            return false;
         }
      }
      return true;
   }
}
