/**
 *JUnit tests for the SimpleArrayStack class
 *
 *
 *
 *@author Evan Jameson
 *@version Lab 03
 */

import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

public class SimpleArrayStackTests
{
   
   @Test
   public void testSizeCapacity_atConstruction()
   {
      SimpleArrayStack<Character> stack = new SimpleArrayStack<Character>();
      assertEquals(0, stack.size());
      assertEquals(10, stack.capacity());
   }

   @Test (expected = NoSuchElementException.class)
   public void testPeek_atConstruction()
   {
      SimpleArrayStack<Character> stack = new SimpleArrayStack<Character>();
      stack.peek();
   }

   @Test (expected = NoSuchElementException.class)
   public void testPop_atConstruction()
   {
      SimpleArrayStack<Character> stack = new SimpleArrayStack<Character>();
      stack.pop();
   }

   @Test
   public void testPush_characters()
   {
      SimpleArrayStack<Character> stack = new SimpleArrayStack<Character>();
      stack.push('a');
      stack.push('b');
      stack.push('c');
      assertTrue(stackEquals(stack, new Character[] {'a','b','c'}));
   }

   @Test
   public void testPop_characters()
   {
      SimpleArrayStack<Character> stack = new SimpleArrayStack<Character>();
      stack.push('a');
      stack.push('b');
      stack.push('c');
      stack.push('d');
      stack.push('e');
      stack.pop();
      assertTrue(stackEquals(stack, new Character[] {'a','b','c','d'}));
   }

   //test push to expand, pop after expand, size after expansion, capacity after expansion, and contents
   @Test
   public void testPush_expansion()
   {
      SimpleArrayStack<Character> stack = new SimpleArrayStack<Character>();
      stack.push('a');
      stack.push('b');
      stack.push('c');
      stack.push('d');
      stack.push('e');
      stack.push('f');
      stack.push('g');
      stack.push('h');
      stack.push('i');
      stack.push('j');
      stack.push('k');
      stack.push('l');
      stack.pop();
      assertEquals(11, stack.size());
      assertEquals(20, stack.capacity());
      assertTrue(stackEquals(stack, new Character[] {'a','b','c','d','e','f','g','h','i','j','k'}));
   }

  /*@Test
   public void testPushPop_null()
   {
      SimpleArrayStack<Character> 
   }
   */

   //This method wont let me keep it generic for some reason ?
   private static <Character> boolean stackEquals(SimpleArrayStack<Character> stack, Character[] a)
   {
      if(stack.size()!= a.length)
      {
         return false;
      }

      //reverse indexing since its a stack
      for(int i = a.length - 1; i > -1; i--)
      {
         if(stack.peek() == null || a[i] == null)
         {
            if(stack.pop() != a[i])
            {
               return false;
            }
         }
         else
         {
            if(stack.pop() != a[i])
            {
               return false;
            }
         }
      }
      return true;
   }
}
