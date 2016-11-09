import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for MorseToText.
 *
 * @author Eitan Simler
 * @version Project4
 */

public class MorseToTextTests {

   @Test
   public void test1_getBST_size() {
      MorseToText txt = new MorseToText();
      assertEquals(MorseCode.size(), txt.getBST().size());
   }
   
   @Test
   public void test2_getBST_minimum() {
      MorseToText txt = new MorseToText();
      assertEquals("-", txt.getBST().minimum().getCode());
   }
   
   @Test
   public void test3_getBST_maximum() {
      MorseToText txt = new MorseToText();
      assertEquals(".....", txt.getBST().maximum().getCode());
   }

   @Test
   public void test4_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(0))));
   }

   @Test
   public void test5_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(1))));
   }

   @Test
   public void test6_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(2))));
   }

   @Test
   public void test7_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(3))));
   }

   @Test
   public void test8_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(4))));
   }

   @Test
   public void test9_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(5))));
   }

   @Test
   public void test10_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(6))));
   }

   @Test
   public void test11_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(7))));
   }

   @Test
   public void test12_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(8))));
   }

   @Test
   public void test13_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(9))));
   }

   @Test
   public void test14_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(10))));
   }

   @Test
   public void test15_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(11))));
   }

   @Test
   public void test16_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(12))));
   }

   @Test
   public void test17_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(13))));
   }

   @Test
   public void test18_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(14))));
   }

   @Test
   public void test19_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(15))));
   }

   @Test
   public void test20_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(16))));
   }

   @Test
   public void test21_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(17))));
   }

   @Test
   public void test22_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(18))));
   }

   @Test
   public void test23_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(19))));
   }

   @Test
   public void test24_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(20))));
   }

   @Test
   public void test25_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(21))));
   }

   @Test
   public void test26_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(22))));
   }

   @Test
   public void test27_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(23))));
   }

   @Test
   public void test28_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(24))));
   }

   @Test
   public void test29_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(25))));
   }

   @Test
   public void test30_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(26))));
   }

   @Test
   public void test31_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(27))));
   }

   @Test
   public void test32_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(28))));
   }

   @Test
   public void test33_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(29))));
   }

   @Test
   public void test34_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(30))));
   }

   @Test
   public void test35_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(31))));
   }

   @Test
   public void test36_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(32))));
   }

   @Test
   public void test37_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(33))));
   }

   @Test
   public void test38_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(34))));
   }

   @Test
   public void test39_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(35))));
   }

   @Test
   public void test40_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(36))));
   }

   @Test
   public void test41_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(37))));
   }

   @Test
   public void test42_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(38))));
   }

   @Test
   public void test43_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(39))));
   }

   @Test
   public void test44_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(40))));
   }

   @Test
   public void test45_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(41))));
   }

   @Test
   public void test46_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(42))));
   }

   @Test
   public void test47_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(43))));
   }

   @Test
   public void test48_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(44))));
   }

   @Test
   public void test49_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(45))));
   }

   @Test
   public void test50_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(46))));
   }

   @Test
   public void test51_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(47))));
   }

   @Test
   public void test52_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(48))));
   }

   @Test
   public void test53_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(49))));
   }

   @Test
   public void test54_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(50))));
   }

   @Test
   public void test55_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(51))));
   }

   @Test
   public void test56_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(52))));
   }

   @Test
   public void test57_contains() {
      MorseToText txt = new MorseToText();
      assertTrue(txt.getBST().contains(new MorseOrder(MorseCode.get(53))));
   }

   @Test
   public void test58_internalPathLength() {
      MorseToText txt = new MorseToText();
      assertEquals(213, txt.getBST().internalPathLength());
   }

   @Test
   public void test59_treeHeight() {
      MorseToText txt = new MorseToText();
      assertEquals(5, txt.getBST().treeHeight());
   }

   @Test
   public void test60_translate() {
      MorseToText txt = new MorseToText();
      assertEquals("SOS", txt.translate("... --- ..."));
   }
   
   @Test
   public void test61_translate() {
      MorseToText txt = new MorseToText();
      assertEquals("HI ALLY", txt.translate(".... ..  .- .-.. .-.. -.--"));
   }
   
   @Test
   public void test62_translate() {
      MorseToText txt = new MorseToText();
      assertEquals("HI JAKE@", txt.translate(".... ..  .------. .--- .- -.- . -..-.-"));
   }
   
   @Test
   public void test63_translate() {
      MorseToText txt = new MorseToText();
      assertEquals("", txt.translate(".----.-.-.-"));
   }
   
   @Test
   public void test64_translate() {
      MorseToText txt = new MorseToText();
      assertEquals("HI ALLY!", txt.translate(".... -.--....-. ..  ...---.- .- .-.. " +
         "-.---.-.-. .-.. -.-- ............ -.-.--"));
   }
   
   @Test
   public void test65_translate() {
      MorseToText txt = new MorseToText();
      assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", txt.translate(".- -... -.-. -.. . ..-. " + 
         "--. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.."));
   }
   
   @Test
   public void test66_translate() {
      MorseToText txt = new MorseToText();
      assertEquals("0123456789", txt.translate("----- .---- ..--- ...-- ....- ..... -.... " +
         "--... ---.. ----."));
   }
   
   @Test
   public void test67_translate() {
      MorseToText txt = new MorseToText();
      assertEquals(".,?'!/()&:;=+-_\"$@", txt.translate(".-.-.- --..-- ..--.. .----. -.-.-- " + 
         "-..-. -.--. -.--.- .-... ---... -.-.-. -...- .-.-. -....- ..--.- .-..-. ...-..- -..-.-"));
   }


}
