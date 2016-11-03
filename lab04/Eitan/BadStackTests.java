import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

/**
 * JUnit tests for BadStackTests.
 *
 * @author Eitan Simler
 * @version Lab04
 */

public class BadStackTests {

   @Test
   public void testSize_atConstruction() {
      BadStack<String> stack = new BadStack<>();
      assertEquals(stack.size(), 0);
   }

   @Test
   public void testCapacity_atConstruction() {
      BadStack<String> stack = new BadStack<>();
      assertEquals(stack.capacity(), 10);
   }

   @Test (expected=NoSuchElementException.class)
   public void testPeek_atConstruction() {
      BadStack<String> stack = new BadStack<>();
      stack.peek();
   }

   @Test (expected=NoSuchElementException.class)
   public void testPop_atConstruction() {
      BadStack<String> stack = new BadStack<>();
      stack.pop();
   }

   @Test 
   public void testPushSizeCapacity() {
      BadStack<String> stack = new BadStack<>();
      stack.push("Hello");
      assertEquals(stack.size(), 1);
      assertEquals(stack.capacity(), 10);
   }

   @Test 
   public void testPushSizeCapacity_push10() {
      BadStack<String> stack = new BadStack<>();
      for (int i = 0; i < 10; i++) {
         stack.push("Hello");   
      }
      assertEquals(stack.size(), 10);
      assertEquals(stack.capacity(), 10);
   }

   @Test 
   public void testPushSizeCapacity_pushDouble() {
      BadStack<String> stack = new BadStack<>();
      for (int i = 0; i < 15; i++) {
         stack.push("Hello");   
      }
      assertEquals(stack.size(), 15);
      assertEquals(stack.capacity(), 20);
   }

   @Test 
   public void testPeek() {
      BadStack<String> stack = new BadStack<>();
      stack.push("1");
      stack.push("2");
      stack.push("3");
      assertTrue(stack.peek().equals("3"));
   }

   @Test 
   public void testPopSizeCapacity() {
      BadStack<String> stack = new BadStack<>();
      stack.push("1");
      stack.push("2");
      stack.push("3");
      stack.pop();
      assertEquals(stack.size(), 2);
      assertEquals(stack.capacity(), 10);
   }

   @Test 
   public void testPopReturn() {
      BadStack<String> stack = new BadStack<>();
      stack.push("1");
      stack.push("2");
      stack.push("3");
      assertTrue(stack.pop().equals("3"));
   }

   @Test 
   public void testPopSizeCapacity_doubleCapacity() {
      BadStack<Integer> stack = new BadStack<>();
      for (int i = 0; i < 15; i++) {
         stack.push(i);
      }
      stack.pop();
      assertEquals(stack.size(), 14);
      assertEquals(stack.capacity(), 20);
   }

   @Test 
   public void testPopSizeCapacity_doubleCapacity2() {
      BadStack<Integer> stack = new BadStack<>();
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
      BadStack<Integer> stack = new BadStack<>();
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
      BadStack<Integer> stack = new BadStack<>();
      for (int i = 0; i < 15; i++) {
         stack.push(i);
      }
      assertTrue(stack.pop() == 14);
      stack.push(15);
      assertTrue(stack.pop() == 15);
   }
}
