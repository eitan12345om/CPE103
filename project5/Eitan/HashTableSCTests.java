import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for HashTableSC.
 *
 * @author Eitan Simler
 * @version Project5
 */

public class HashTableSCTests {

   private final double DELTA = 1e-8;

   @Test (expected=IllegalArgumentException.class)
   public void test_illegalTableSize1() {
      HashTableSC<Integer> table = new HashTableSC<>(-5);
   }

   @Test (expected=IllegalArgumentException.class)
   public void test_illegalTableSize2() {
      HashTableSC<Integer> table = new HashTableSC<>(-100);
   }

   @Test
   public void test_tableSize3() {
      HashTableSC<Integer> table = new HashTableSC<>(0);
      assertEquals(2, table.tableSize());
   }
   
   @Test
   public void test_tableSize4() {
      HashTableSC<Integer> table = new HashTableSC<>(2);
      assertEquals(2, table.tableSize());
   }
   
   @Test
   public void test_tableSize5() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      assertEquals(101, table.tableSize());
   }
   
   @Test
   public void test_size1_atConstruction() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      assertEquals(0, table.size());
   }
   
   @Test
   public void test_size2_atConstruction() {
      HashTableSC<Integer> table = new HashTableSC<>(1);
      assertEquals(0, table.size());
   }

   @Test
   public void test_isEmpty1_atConstruction() {
      HashTableSC<Integer> table = new HashTableSC<>(1);
      assertTrue(table.isEmpty());
   }

   @Test
   public void test_isEmpty2_atConstruction() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      assertTrue(table.isEmpty());
   }
   
   @Test
   public void test_isEmpty3() {
      HashTableSC<Integer> table = new HashTableSC<>(1);
      table.add(13);
      assertFalse(table.isEmpty());
   }

   @Test
   public void test_isEmpty4() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      table.add(13);
      table.add(13);
      assertFalse(table.isEmpty());
      assertEquals(1, table.size());
   }

   @Test
   public void test_loadFactor1_atConstruction() {
      HashTableSC<Integer> table = new HashTableSC<>(1);
      assertEquals(0, table.loadFactor(), DELTA);
   }

   @Test
   public void test_loadFactor2_atConstruction() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      assertEquals(0, table.loadFactor(), DELTA);
   }

   @Test
   public void test_add1() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      table.add(50);
      assertEquals(1, table.size());
      assertEquals(1.0 / 101, table.loadFactor(), DELTA);
   }

   @Test
   public void test_add2() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      table.add(50);
      assertEquals(1, table.size());
      assertEquals(1.0 / 101, table.loadFactor(), DELTA);
      table.add(50);
      assertEquals(1, table.size());
      assertEquals(1.0 / 101, table.loadFactor(), DELTA);
   }
   
   @Test
   public void test_add3() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      table.add(50);
      assertEquals(1, table.size());
      assertEquals(1.0 / 101, table.loadFactor(), DELTA);
      table.add(60);
      assertEquals(2, table.size());
      assertEquals(2.0 / 101, table.loadFactor(), DELTA);
   }
   
   @Test
   public void test_add4() {
      HashTableSC<Integer> table = new HashTableSC<>(10);
      for (int i = 0; i < 10; i++) {
         table.add(i);
      }
      assertEquals(10, table.size());
      assertEquals(10.0 / 11, table.loadFactor(), DELTA);
   }
   
   @Test
   public void test_add5() {
      HashTableSC<String> table = new HashTableSC<>(10);
      table.add("hello");
      table.add("ehllo");
      assertEquals(2, table.size());
      assertEquals(2.0 / 11, table.loadFactor(), DELTA);
   }
   
   @Test
   public void test_add6() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      long tm = System.currentTimeMillis();
      for (int i = 0; i < 1000; i++) {
         table.add(i);
      }
      long total = System.currentTimeMillis() - tm;
      
      HashTableSC<Integer> table2 = new HashTableSC<>(100);
      long tm2 = System.currentTimeMillis();
      for (int i = 0; i < 10000; i++) {
         table2.add(i);
      }
      long total2 = System.currentTimeMillis() - tm2;

      assertTrue(total2 > total);
   }
   
   @Test
   public void test_contains1() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      table.add(50);
      assertTrue(table.contains(50));
   }

   @Test
   public void test_contains2() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      assertTrue(table.add(50));
      assertFalse(table.add(50));
      assertTrue(table.contains(50));
   }
   
   @Test
   public void test_contains3() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      assertTrue(table.add(50));
      assertTrue(table.add(60));
      assertTrue(table.contains(50));
      assertTrue(table.contains(60));
   }
   
   @Test
   public void test_contains4() {
      HashTableSC<Integer> table = new HashTableSC<>(10);
      for (int i = 0; i < 10; i++) {
         table.add(i);
      }
      for (int i = 0; i < 10; i++) {
         assertTrue(table.contains(i));
      }
      assertFalse(table.contains(10));
   }
   
   @Test
   public void test_contains5() {
      HashTableSC<String> table = new HashTableSC<>(10);
      table.add("hello");
      table.add("ehllo");
      assertTrue(table.contains("hello"));
      assertTrue(table.contains("ehllo"));
   }
   
   @Test
   public void test_remove1() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      table.add(50);
      assertTrue(table.remove(50));
      assertEquals(0, table.size());
   }

   @Test
   public void test_remove2() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      assertTrue(table.add(50));
      assertFalse(table.add(50));
      assertTrue(table.remove(50));
      assertEquals(0, table.size());
   }
   
   @Test
   public void test_remove3() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      assertTrue(table.add(50));
      assertTrue(table.add(60));
      assertTrue(table.remove(50));
      assertTrue(table.remove(60));
      assertEquals(0, table.size());
   }
   
   @Test
   public void test_remove4() {
      HashTableSC<Integer> table = new HashTableSC<>(10);
      for (int i = 0; i < 10; i++) {
         table.add(i);
      }
      for (int i = 0; i < 10; i++) {
         assertTrue(table.remove(i));
      }
      assertFalse(table.remove(10));
      assertEquals(0, table.size());
   }
   
   @Test
   public void test_remove5() {
      HashTableSC<String> table = new HashTableSC<>(10);
      table.add("hello");
      table.add("ehllo");
      assertTrue(table.remove("hello"));
      assertTrue(table.remove("ehllo"));
      assertEquals(0, table.size());
   }
   
   @Test
   public void test_collisions1() {
      HashTableSC<String> table = new HashTableSC<>(10);
      table.add("hello");
      assertEquals(0, table.collisions());
   }
   
   @Test
   public void test_collisions2() {
      HashTableSC<String> table = new HashTableSC<>(10);
      table.add("hello");
      table.add("hello");
      assertEquals(1, table.collisions());
   }
   
   @Test
   public void test_collisions3() {
      HashTableSC<String> table = new HashTableSC<>(2);
      table.add("hello");
      table.add("hello");
      table.add("ehlol");
      assertEquals(2, table.collisions());
   }
   
   @Test
   public void test_collisions4() {
      HashTableSC<String> table = new HashTableSC<>(2);
      table.add("hello");
      table.add("hello");
      table.add("ehlol");
      assertEquals(2, table.collisions());
   }
   
   @Test
   public void test_collisions5() {
      HashTableSC<String> table = new HashTableSC<>(2);
      table.add("hello");
      table.add("hello");
      table.add("heoll");
      table.add("ehlol");
      assertEquals(4, table.collisions());
   }
   
   @Test
   public void test_maxCollisions1() {
      HashTableSC<String> table = new HashTableSC<>(10);
      table.add("hello");
      assertEquals(0, table.maxCollisions());
   }
   
   @Test
   public void test_maxCollisions2() {
      HashTableSC<String> table = new HashTableSC<>(10);
      table.add("hello");
      table.add("hello");
      assertEquals(1, table.maxCollisions());
   }
   
   @Test
   public void test_maxCollisions3() {
      HashTableSC<String> table = new HashTableSC<>(2);
      table.add("hello");
      table.add("hello");
      table.add("ehlol");
      assertEquals(1, table.maxCollisions());
   }
   
   @Test
   public void test_maxCollisions4() {
      HashTableSC<String> table = new HashTableSC<>(2);
      table.add("hello");
      table.add("hello");
      table.add("ehlol");
      assertEquals(1, table.maxCollisions());
   }
   
   @Test
   public void test_maxCollisions5() {
      HashTableSC<String> table = new HashTableSC<>(2);
      table.add("hello");
      table.add("hello");
      table.add("heoll");
      table.add("ehlol");
      assertEquals(2, table.maxCollisions());
   }
   
   @Test
   public void test_maxCollisions6() {
      HashTableSC<String> table = new HashTableSC<>(10);
      table.add("a");
      table.add("b");
      table.add("c");
      table.add("d");
      assertEquals(0, table.maxCollisions());
   }
   
   @Test
   public void test_maxCollisions7() {
      HashTableSC<String> table = new HashTableSC<>(1);
      table.add("a");
      table.add("b");
      table.add("c");
      table.add("d");
      assertEquals(1, table.maxCollisions());
   }
}
