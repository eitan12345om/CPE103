import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for HashTableSC.
 *
 * @author Eitan Simler
 * @version Project5
 */

public class HashTableSCTests {

   @Test
   public void test_tableSize1() {
      HashTableSC<Integer> table = new HashTableSC<>(0);
      assertEquals(2, table.tableSize());
   }
   
   @Test
   public void test_tableSize2() {
      HashTableSC<Integer> table = new HashTableSC<>(2);
      assertEquals(2, table.tableSize());
   }
   
   @Test
   public void test_tableSize3() {
      HashTableSC<Integer> table = new HashTableSC<>(100);
      assertEquals(101, table.tableSize());
   }
}
