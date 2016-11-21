/**
 * JUnit tests for HashTableSC.
 *
 *
 *
 * @author Evan Jameson
 * @version Project5
 */

import org.junit.*;
import static org.junit.Assert.*;

public class HashTableSCTests {

   private final double DELTA = 1e-8;

   @Test (expected=IllegalArgumentException.class)
   public void test1() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(-5);
   }

   @Test (expected=IllegalArgumentException.class)
   public void test2() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(-100);
   }

   @Test
   public void test3() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(0);
      assertEquals(2, table.tableSize());
   }
   
   @Test
   public void test4() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(2);
      assertEquals(2, table.tableSize());
   }
   
   @Test
   public void test5() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      assertEquals(101, table.tableSize());
   }
   
   @Test
   public void test6() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      assertEquals(0, table.size());
   }
   
   @Test
   public void test7() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(1);
      assertEquals(0, table.size());
   }

   @Test
   public void test8() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(1);
      assertTrue(table.isEmpty());
   }

   @Test
   public void test9() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      assertTrue(table.isEmpty());
   }
   
   @Test
   public void test10() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(1);
      table.add(13);
      assertFalse(table.isEmpty());
   }

   @Test
   public void test11() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      table.add(13);
      table.add(13);
      assertFalse(table.isEmpty());
      assertEquals(1, table.size());
   }

   @Test
   public void test12() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(1);
      assertEquals(0, table.loadFactor(), DELTA);
   }

   @Test
   public void test13() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      assertEquals(0, table.loadFactor(), DELTA);
   }

   @Test
   public void test14() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      table.add(50);
      assertEquals(1, table.size());
      assertEquals(1.0 / 101, table.loadFactor(), DELTA);
   }

   @Test
   public void test15() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      table.add(50);
      assertEquals(1, table.size());
      assertEquals(1.0 / 101, table.loadFactor(), DELTA);
      table.add(50);
      assertEquals(1, table.size());
      assertEquals(1.0 / 101, table.loadFactor(), DELTA);
   }
   
   @Test
   public void test16() 
   {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      table.add(50);
      assertEquals(1, table.size());
      assertEquals(1.0 / 101, table.loadFactor(), DELTA);
      table.add(60);
      assertEquals(2, table.size());
      assertEquals(2.0 / 101, table.loadFactor(), DELTA);
   }
}
