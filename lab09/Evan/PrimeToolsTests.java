/**
 *JUnit tests for Prime Tools class
 *
 *
 *
 *@author Evan Jameson
 *@version Lab09
 */

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PrimeToolsTests
{
   PrimeTools pt = new PrimeTools();

   @Test
   public void test1_isPrime()
   {
      assertTrue(pt.isPrime(3));
      assertTrue(pt.isPrime(5));
      assertTrue(pt.isPrime(7));
      assertTrue(pt.isPrime(199));
      assertFalse(pt.isPrime(0));
      assertFalse(pt.isPrime(10));
      assertFalse(pt.isPrime(35));
      assertFalse(pt.isPrime(194));
   }

   @Test
   public void test2_nextPrime()
   {
      assertEquals(7, pt.nextPrime(5));
      assertEquals(11, pt.nextPrime(7));
      assertEquals(31, pt.nextPrime(29));
      assertEquals(179, pt.nextPrime(173));
   }

   @Test(expected = NoSuchElementException.class)
   public void test3_nextPrimeNoSuch()
   {
      assertEquals(12, pt.nextPrime(Integer.MAX_VALUE - 1));
   }

   @Test(expected = IllegalArgumentException.class)
   public void test4_nextPrimeIll()
   {
      assertEquals(1, pt.nextPrime(0));
      assertEquals(1, pt.nextPrime(-1));
   }
}
