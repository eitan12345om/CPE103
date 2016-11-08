import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

/**
 * JUnit tests for PrimeTools.
 *
 * @author Eitan Simler
 * @version Lab09
 */

public class PrimeToolsTests {

   @Test
   public void test1_isPrime_0() {
      assertFalse(PrimeTools.isPrime(0));
   } 
   
   @Test
   public void test2_isPrime_1() {
      assertFalse(PrimeTools.isPrime(1));
   } 
   
   @Test
   public void test3_isPrime_2() {
      assertTrue(PrimeTools.isPrime(2));
   } 
   
   @Test
   public void test4_isPrime_3() {
      assertTrue(PrimeTools.isPrime(3));
   } 
   
   @Test
   public void test5_isPrime_5() {
      assertTrue(PrimeTools.isPrime(5));
   } 
   
   @Test
   public void test6_isPrime_7() {
      assertTrue(PrimeTools.isPrime(7));
   } 
   
   @Test
   public void test7_isPrime_101() {
      assertTrue(PrimeTools.isPrime(101));
   } 
   
   @Test
   public void test8_isPrime_173() {
      assertTrue(PrimeTools.isPrime(173));
   } 
   
   @Test
   public void test9_isPrime_151() {
      assertTrue(PrimeTools.isPrime(151));
   } 
   
   @Test
   public void test10_isPrime_59() {
      assertTrue(PrimeTools.isPrime(59));
   }

   @Test (expected=IllegalArgumentException.class)
   public void test11_nextPrime_negative() {
      PrimeTools.nextPrime(-1);      
   }
   
   @Test (expected=IllegalArgumentException.class)
   public void test12_nextPrime_negative() {
      PrimeTools.nextPrime(-5);      
   }
   
   @Test
   public void test13_nextPrime_0() {
      assertEquals(2, PrimeTools.nextPrime(0));      
   }
   
   @Test
   public void test14_nextPrime_1() {
      assertEquals(2, PrimeTools.nextPrime(1));      
   }
   
   @Test
   public void test15_nextPrime_2() {
      assertEquals(2, PrimeTools.nextPrime(2));      
   }
   
   @Test
   public void test16_nextPrime_3() {
      assertEquals(3, PrimeTools.nextPrime(3));      
   }
   
   @Test
   public void test17_nextPrime_4() {
      assertEquals(5, PrimeTools.nextPrime(4));      
   }
   
   @Test
   public void test18_nextPrime_6() {
      assertEquals(7, PrimeTools.nextPrime(6));      
   }
   
   @Test
   public void test19_nextPrime_11() {
      assertEquals(11, PrimeTools.nextPrime(11));      
   }
  
   @Test 
   public void test20_nextPrime_maxInt() {
      assertEquals(Integer.MAX_VALUE, PrimeTools.nextPrime(Integer.MAX_VALUE - 1));      
   }  
}
