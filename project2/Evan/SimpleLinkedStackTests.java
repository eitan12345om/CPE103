/**
 * Simple Linked Stack tests.
 *
 * @author Evan Jameson
 * @version Project 02
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

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
      stack.push("Howdy");
      assertEquals(stack.size(), 1);
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
      stack.push("Howdy");
      stack.push("Sup");
      stack.push("ey");
      assertTrue(stack.peek().equals("ey"));
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
      stack.push("Howdy");
      stack.push("Sup");
      stack.push("ey");
      stack.pop();
      assertEquals(stack.size(), 2);
   }
 
   @Test 
   public void testPop() {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      stack.push("Howdy");
      assertTrue(stack.pop().equals("Howdy"));
      assertTrue(stack.size() == 0);
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

}
