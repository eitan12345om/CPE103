import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for BetterHash.
 *
 * @author Eitan Simler
 * @version Lab09
 */

public class BetterHashTests {

   // Reference for tests
   private BetterHash hasher = new BetterHash();

   @Test
   public void test1_hello() {
      assertEquals(710317364, hasher.hash("hello"));
   } 
   
   @Test
   public void test2_Hello() {
      assertEquals(-2122619628, hasher.hash("Hello"));
   } 
   
   @Test
   public void test3_HellO() {
      assertEquals(-2122619660, hasher.hash("HellO"));
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
      assertEquals(7088, hasher.hash("Hh"));
   } 
   
   @Test
   public void test7_hH() {
      assertEquals(10160, hasher.hash("hH"));
   } 
}
