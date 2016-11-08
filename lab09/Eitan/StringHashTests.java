import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for StringHash.
 *
 * @author Eitan Simler
 * @version Lab09
 */

public class StringHashTests {

   // Reference for tests
   private StringHash hasher = new StringHash();

   @Test
   public void test1_hello() {
      assertEquals(99162322, hasher.hash("hello"));
   } 
   
   @Test
   public void test2_Hello() {
      assertEquals(69609650, hasher.hash("Hello"));
   } 
   
   @Test
   public void test3_HellO() {
      assertEquals(69609618, hasher.hash("HellO"));
   } 
   
   @Test
   public void test4_h() {
      assertEquals(104, hasher.hash("h"));
   } 
   
   @Test
   public void test5_H() {
      assertEquals(72, hasher.hash("H"));
   } 
   
   @Test
   public void test6_Hh() {
      assertEquals(2336, hasher.hash("Hh"));
   } 
   
   @Test
   public void test7_hH() {
      assertEquals(3296, hasher.hash("hH"));
   } 
}
