import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for HashTableSC.
 *
 * @author Eitan Simler
 * @version Project5
 */

public class HashTableSCTests {

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
   // TODO: add more size tests

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
   // TODO: add more isEmpty tests

   @Test
   public void test_loadFactor1_atConstruction() {
      HashTableSC<Integer> table = new HashTableSC<>(1);
      assertEquals(0, table.loadFactor());
   }

   @Test
   public void test_loadFactor2_atConstruction() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      assertEquals(0, table.loadFactor());
   }
   // TODO: add more loadFactor tests

}
