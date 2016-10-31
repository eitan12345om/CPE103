/**
 *JUnit tests for recursive lined list class
 *
 *
 *
 *@author Evan Jameson
 *@version lab06
 */

import org.junit.*;
import static org.junit.Assert.*;

public class RecursiveLinkedListTests
{
   
/*================================|get tests|==================================*/
   @Test
   public void test1_get()
   {
      RecursiveLinkedList<String> list = new RecursiveLinkedList<>();
      list.add("Hey");
      assertEquals("Hey", list.get(0));
   }


   @Test
   public void test2_get()
   {
      RecursiveLinkedList<String> list = new RecursiveLinkedList<>();
      list.add(0,"Hi");
      list.add(1,"soup");
      list.add(2,"cookie");
      list.add(3,"up");
      list.add(4,"down");
      assertEquals("Hi",list.get(0));
      assertEquals("soup", list.get(1));
      assertEquals("cookie",list.get(2));
      assertEquals("up",list.get(3));
      assertEquals("down",list.get(4));
   }

/*================================|add tests|===========================================*/

   @Test
   public void test3_add()
   {
      RecursiveLinkedList<String> list = new RecursiveLinkedList<>();
      list.add(0,"Hi");
      list.add(1,"soup");
      list.add(2,"cookie");
      list.add(3,"up");
      list.add(4,"down");
      assertTrue(listEquals(list,new String[] {"Hi","soup","cookie","up","down"}));
   }

   @Test
   public void test4_add()
   {
      RecursiveLinkedList<String> list = new RecursiveLinkedList<>();
      list.add(0,"Hi");
      list.add(1,"soup");
      list.add(1,"cookie");
      list.add(3,"up");
      list.add(4,"down");
      assertTrue(listEquals(list,new String[] {"Hi","cookie","soup","up","down"}));
   }

/*================================|remove tests|===========================================*/
   
   @Test
   public void test_remove()
   {
      RecursiveLinkedList<String> list = new RecursiveLinkedList<>();
      list.add(0,"Hi");
      list.add(1,"soup");
      list.add(2,"cookie");
      list.add(3,"up");
      list.add(4,"down");
      list.remove(4);
      list.remove(3);

      assertTrue(listEquals(list,new String[] {"Hi","soup","cookie"}));
   }

   @Test
   public void test2_remove()
   {
      RecursiveLinkedList<String> list = new RecursiveLinkedList<>();
      list.add(0,"Hi");
      list.add(1,"soup");
      list.add(2,"cookie");
      list.add(3,"up");
      list.add(4,"down");
      list.remove(2);
      list.remove(3);
      assertTrue(listEquals(list,new String[] {"Hi","soup","up"}));
   }

private static <T> boolean listEquals(RecursiveLinkedList<T> list, T[] a) 
{
      if (list.size() != a.length) 
      {
         return false;
      }

      for (int i = 0; i < a.length; i++) 
      {
         if (list.get(i) == null || a[i] == null) 
         {
            if (list.get(i) != a[i]) 
            {
               return false;
            }
         }
         else 
         {
            if (!list.get(i).equals(a[i])) 
            {
               return false;
            }
         }
      }

      return true;
   }
}
