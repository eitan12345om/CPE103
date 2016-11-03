import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

/**
 * JUnit tests for SimpleArrayStack.
 *
 * @author Eitan Simler
 * @version Lab04
 */

public class SimpleArrayStackTests {

   @Test
   public void testSize_atConstruction() {
      SimpleArrayStack<String> stack = new SimpleArrayStack<>();
      assertEquals(stack.size(), 0);
   }

   @Test
   public void testCapacity_atConstruction() {
      SimpleArrayStack<String> stack = new SimpleArrayStack<>();
      assertEquals(stack.capacity(), 10);
   }

   @Test (expected=NoSuchElementException.class)
   public void testPeek_atConstruction() {
      SimpleArrayStack<String> stack = new SimpleArrayStack<>();
      stack.peek();
   }

   @Test (expected=NoSuchElementException.class)
   public void testPop_atConstruction() {
      SimpleArrayStack<String> stack = new SimpleArrayStack<>();
      stack.pop();
   }

   @Test 
   public void testPushSizeCapacity() {
      SimpleArrayStack<String> stack = new SimpleArrayStack<>();
      stack.push("Hello");
      assertEquals(stack.size(), 1);
      assertEquals(stack.capacity(), 10);
   }

   @Test 
   public void testPushSizeCapacity_push10() {
      SimpleArrayStack<String> stack = new SimpleArrayStack<>();
      for (int i = 0; i < 10; i++) {
         stack.push("Hello");   
      }
      assertEquals(stack.size(), 10);
      assertEquals(stack.capacity(), 10);
   }

   @Test 
   public void testPushSizeCapacity_pushDouble() {
      SimpleArrayStack<String> stack = new SimpleArrayStack<>();
      for (int i = 0; i < 15; i++) {
         stack.push("Hello");   
      }
      assertEquals(stack.size(), 15);
      assertEquals(stack.capacity(), 20);
   }

   @Test 
   public void testPeek() {
      SimpleArrayStack<String> stack = new SimpleArrayStack<>();
      stack.push("1");
      stack.push("2");
      stack.push("3");
      assertTrue(stack.peek().equals("3"));
   }

   @Test 
   public void testPopSizeCapacity() {
      SimpleArrayStack<String> stack = new SimpleArrayStack<>();
      stack.push("1");
      stack.push("2");
      stack.push("3");
      stack.pop();
      assertEquals(stack.size(), 2);
      assertEquals(stack.capacity(), 10);
   }

   @Test 
   public void testPopReturn() {
      SimpleArrayStack<String> stack = new SimpleArrayStack<>();
      stack.push("1");
      stack.push("2");
      stack.push("3");
      assertTrue(stack.pop().equals("3"));
   }

   @Test 
   public void testPopSizeCapacity_doubleCapacity() {
      SimpleArrayStack<Integer> stack = new SimpleArrayStack<>();
      for (int i = 0; i < 15; i++) {
         stack.push(i);
      }
      stack.pop();
      assertEquals(stack.size(), 14);
      assertEquals(stack.capacity(), 20);
   }

   @Test 
   public void testPopSizeCapacity_doubleCapacity2() {
      SimpleArrayStack<Integer> stack = new SimpleArrayStack<>();
      for (int i = 0; i < 15; i++) {
         stack.push(i);
      }
      for (int i = 0; i < 10; i++) {
         stack.pop();
      }
      assertEquals(stack.size(), 5);
      assertEquals(stack.capacity(), 20);
   }

   @Test 
   public void testPushPeekPopNull() {
      SimpleArrayStack<Integer> stack = new SimpleArrayStack<>();
      for (int i = 0; i < 15; i++) {
         stack.push(i);
      }
      stack.push(null);
      assertEquals(stack.peek(), null);
      assertEquals(stack.pop(), null);
      assertEquals(stack.size(), 15);
      assertEquals(stack.capacity(), 20);
   }

   @Test 
   public void testPushPopTwice() {
      SimpleArrayStack<Integer> stack = new SimpleArrayStack<>();
      for (int i = 0; i < 15; i++) {
         stack.push(i);
      }
      assertTrue(stack.pop() == 14);
      stack.push(15);
      assertTrue(stack.pop() == 15);
   }
}
