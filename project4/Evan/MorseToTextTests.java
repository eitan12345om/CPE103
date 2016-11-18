/**
 * JUnit tests for MorseToText class
 *
 *
 *
 * @author Evan Jameson
 * @version Project4
 */

import org.junit.*;
import static org.junit.Assert.*;

public class MorseToTextTests 
{
   MorseToText text = new MorseToText();

   @Test
   public void test1() 
   {
      assertEquals(MorseCode.size(), text.getBST().size());
   }

   @Test
   public void test2() 
   {  
      assertEquals("-", text.getBST().minimum().getCode());
   }
   
   @Test
   public void test3() 
   {      
      assertEquals(".....", text.getBST().maximum().getCode());
   }

   @Test
   public void test4() 
   {      
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(0))));
   }

   @Test
   public void test5() 
   {     
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(1))));
   }

   @Test
   public void test6() 
   {     
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(2))));
   }

   @Test
   public void test7() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(3))));
   }

   @Test
   public void test8() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(4))));
   }

   @Test
   public void test9() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(5))));
   }

   @Test
   public void test10() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(6))));
   }

   @Test
   public void test11() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(7))));
   }

   @Test
   public void test12() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(8))));
   }

   @Test
   public void test13() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(9))));
   }

   @Test
   public void test14() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(10))));
   }

   @Test
   public void test15() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(11))));
   }

   @Test
   public void test16() 
   {  
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(12))));
   }

   @Test
   public void test17() 
   {
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(13))));
   }

   @Test
   public void test18() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(14))));
   }

   @Test
   public void test19() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(15))));
   }

   @Test
   public void test20() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(16))));
   }

   @Test
   public void test21() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(17))));
   }

   @Test
   public void test22()
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(18))));
   }

   @Test
   public void test23() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(19))));
   }

   @Test
   public void test24() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(20))));
   }

   @Test
   public void test25() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(21))));
   }

   @Test
   public void test26() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(22))));
   }

   @Test
   public void test27() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(23))));
   }

   @Test
   public void test28() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(24))));
   }

   @Test
   public void test29() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(25))));
   }

   @Test
   public void test30() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(26))));
   }

   @Test
   public void test31() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(27))));
   }

   @Test
   public void test32() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(28))));
   }

   @Test
   public void test33() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(29))));
   }

   @Test
   public void test34() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(30))));
   }

   @Test
   public void test35() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(31))));
   }

   @Test
   public void test36() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(32))));
   }

   @Test
   public void test37() 
   {
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(33))));
   }

   @Test
   public void test38() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(34))));
   }

   @Test
   public void test39() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(35))));
   }

   @Test
   public void test40() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(36))));
   }

   @Test
   public void test41() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(37))));
   }

   @Test
   public void test42() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(38))));
   }

   @Test
   public void test43() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(39))));
   }

   @Test
   public void test44() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(40))));
   }

   @Test
   public void test45() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(41))));
   }

   @Test
   public void test46() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(42))));
   }

   @Test
   public void test47() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(43))));
   }

   @Test
   public void test48() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(44))));
   }

   @Test
   public void test49() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(45))));
   }

   @Test
   public void test50() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(46))));
   }

   @Test
   public void test51() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(47))));
   }

   @Test
   public void test52() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(48))));
   }

   @Test
   public void test53() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(49))));
   }

   @Test
   public void test54() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(50))));
   }

   @Test
   public void test55() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(51))));
   }

   @Test
   public void test56() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(52))));
   }

   @Test
   public void test57() 
   {   
      assertTrue(text.getBST().contains(new MorseOrder(MorseCode.get(53))));
   }

   @Test
   public void test58() 
   {
      assertEquals("SOS", txt.translate("... --- ..."));
   }

   @Test
   public void test59() 
   {
      assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", txt.translate(".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.."));
   }
}
