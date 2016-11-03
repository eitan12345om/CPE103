import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

/**
 * Simple singly linked stack tests.
 *
 * @author Eitan Simler
 * @version Project2
 */

public class SimpleLinkedStackTests {

   @Test
   public void testSize_atConstruction() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      assertEquals(stack.size(), 0);
   }

   @Test (expected=NoSuchElementException.class)
   public void testPeek_atConstruction() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.peek();
   }
   
   @Test (expected=NoSuchElementException.class)
   public void testPop_atConstruction() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.pop();
   }

   @Test 
   public void testPushSize() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push("Hello");
      assertEquals(stack.size(), 1);
   }

   @Test 
   public void testPushSize2() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push("Hello");
      stack.push("Hi");
      stack.push("Hey");
      assertEquals(stack.size(), 3);
   }

   @Test 
   public void testPushSize3() {
      SimpleLinkedStack<Integer> stack = new SimpleLinkedStack<>();
      for (int i = 0; i < 100; i++) {
         stack.push(i);
      }
      assertEquals(stack.size(), 100);
   }

   @Test 
   public void testPushSize_Null() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push(null);
      assertEquals(stack.size(), 1);
   }

   @Test 
   public void testPeek() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push("Hello");
      assertTrue(stack.peek().equals("Hello"));
   }

   @Test 
   public void testPeek2() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push("Hello");
      stack.push("Hey");
      stack.push("Hi");
      assertTrue(stack.peek().equals("Hi"));
   }

   @Test 
   public void testPeekNull() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push(null);
      assertEquals(stack.peek(), null);
   }

   @Test 
   public void testPeekInteger() {
      SimpleLinkedStack<Integer> stack = new SimpleLinkedStack<>();
      stack.push(1);
      assertTrue(stack.peek() == 1);
   }

   @Test 
   public void testPopSize() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push("Hello");
      stack.pop();
      assertEquals(stack.size(), 0);
   }

   @Test 
   public void testPopSize2() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push("Hello");
      stack.push("Hi");
      stack.push("Hey");
      stack.pop();
      assertEquals(stack.size(), 2);
   }

   @Test 
   public void testPopSize3() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push("Hello");
      stack.push("Hi");
      stack.push("Hey");
      stack.pop();
      stack.pop();
      stack.pop();
      assertEquals(stack.size(), 0);
   }
 
   @Test 
   public void testPop() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push("Hello");
      assertTrue(stack.pop().equals("Hello"));
   }

   @Test 
   public void testPop2() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push("Hello");
      stack.push("Hey");
      stack.push("Hi");
      assertTrue(stack.pop().equals("Hi"));
   }

   @Test 
   public void testPopNull() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push(null);
      assertEquals(stack.pop(), null);
   }

   @Test 
   public void testPopInteger() {
      SimpleLinkedStack<Integer> stack = new SimpleLinkedStack<>();
      stack.push(1);
      assertTrue(stack.pop() == 1);
   }

   @Test
   public void testAll() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push("Hi");
      assertEquals(stack.size(), 1);
      assertTrue(stack.peek().equals("Hi"));
      assertTrue(stack.pop().equals("Hi"));
      assertEquals(stack.size(), 0);
   }
   
   @Test
   public void testAllNull() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push(null);
      assertEquals(stack.size(), 1);
      assertEquals(stack.peek(), null);
      assertEquals(stack.pop(), null);
      assertEquals(stack.size(), 0);
   }
}
