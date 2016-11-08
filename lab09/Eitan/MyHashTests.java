import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for MyHash.
 *
 * @author Eitan Simler
 * @version Lab09
 */

public class MyHashTests {

   // Reference for tests
   private MyHash hasher = new MyHash();

   @Test
   public void test1_hello() {
      assertEquals(32562, hasher.hash("hello"));
   } 
   
   @Test
   public void test2_Hello() {
      assertEquals(32562, hasher.hash("Hello"));
   } 
   
   @Test
   public void test3_HellO() {
      assertEquals(32530, hasher.hash("HellO"));
   } 
   
   @Test
   public void test4_h() {
      assertEquals(43297, hasher.hash("h"));
   } 
   
   @Test
   public void test5_H() {
      assertEquals(43265, hasher.hash("H"));
   } 
   
   @Test
   public void test6_Hh() {
      assertEquals(31834, hasher.hash("Hh"));
   } 
   
   @Test
   public void test7_hH() {
      assertEquals(31892, hasher.hash("hH"));
   } 
}
