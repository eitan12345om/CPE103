import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for TextToMorse.
 *
 * @author Eitan Simler
 * @version Project4
 */

public class TextToMorseTests {

   @Test
   public void test1_getBST_size() {
      TextToMorse txt = new TextToMorse();
      assertEquals(MorseCode.size(), txt.getBST().size());
   }
   
   @Test
   public void test2_getBST_minimum() {
      TextToMorse txt = new TextToMorse();
      assertEquals('!', (char) txt.getBST().minimum().getCharacter());
   }
   
   @Test
   public void test3_getBST_maximum() {
      TextToMorse txt = new TextToMorse();
      assertEquals('_', (char) txt.getBST().maximum().getCharacter());
   }

   @Test
   public void test4_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(0))));
   }

   @Test
   public void test5_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(1))));
   }

   @Test
   public void test6_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(2))));
   }

   @Test
   public void test7_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(3))));
   }

   @Test
   public void test8_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(4))));
   }

   @Test
   public void test9_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(5))));
   }

   @Test
   public void test10_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(6))));
   }

   @Test
   public void test11_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(7))));
   }

   @Test
   public void test12_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(8))));
   }

   @Test
   public void test13_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(9))));
   }

   @Test
   public void test14_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(10))));
   }

   @Test
   public void test15_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(11))));
   }

   @Test
   public void test16_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(12))));
   }

   @Test
   public void test17_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(13))));
   }

   @Test
   public void test18_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(14))));
   }

   @Test
   public void test19_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(15))));
   }

   @Test
   public void test20_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(16))));
   }

   @Test
   public void test21_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(17))));
   }

   @Test
   public void test22_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(18))));
   }

   @Test
   public void test23_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(19))));
   }

   @Test
   public void test24_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(20))));
   }

   @Test
   public void test25_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(21))));
   }

   @Test
   public void test26_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(22))));
   }

   @Test
   public void test27_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(23))));
   }

   @Test
   public void test28_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(24))));
   }

   @Test
   public void test29_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(25))));
   }

   @Test
   public void test30_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(26))));
   }

   @Test
   public void test31_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(27))));
   }

   @Test
   public void test32_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(28))));
   }

   @Test
   public void test33_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(29))));
   }

   @Test
   public void test34_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(30))));
   }

   @Test
   public void test35_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(31))));
   }

   @Test
   public void test36_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(32))));
   }

   @Test
   public void test37_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(33))));
   }

   @Test
   public void test38_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(34))));
   }

   @Test
   public void test39_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(35))));
   }

   @Test
   public void test40_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(36))));
   }

   @Test
   public void test41_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(37))));
   }

   @Test
   public void test42_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(38))));
   }

   @Test
   public void test43_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(39))));
   }

   @Test
   public void test44_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(40))));
   }

   @Test
   public void test45_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(41))));
   }

   @Test
   public void test46_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(42))));
   }

   @Test
   public void test47_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(43))));
   }

   @Test
   public void test48_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(44))));
   }

   @Test
   public void test49_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(45))));
   }

   @Test
   public void test50_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(46))));
   }

   @Test
   public void test51_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(47))));
   }

   @Test
   public void test52_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(48))));
   }

   @Test
   public void test53_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(49))));
   }

   @Test
   public void test54_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(50))));
   }

   @Test
   public void test55_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(51))));
   }

   @Test
   public void test56_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(52))));
   }

   @Test
   public void test57_contains() {
      TextToMorse txt = new TextToMorse();
      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(53))));
   }

   @Test
   public void test58_internalPathLength() {
      TextToMorse txt = new TextToMorse();
      assertEquals(213, txt.getBST().internalPathLength());
   }

   @Test
   public void test59_treeHeight() {
      TextToMorse txt = new TextToMorse();
      assertEquals(5, txt.getBST().treeHeight());
   }

   @Test
   public void test60_translate() {
      TextToMorse txt = new TextToMorse();
      assertEquals("... --- ...", txt.translate("SOS"));
   }
   
   @Test
   public void test61_translate() {
      TextToMorse txt = new TextToMorse();
      assertEquals(".... ..  .- .-.. .-.. -.--", txt.translate("HI ALLY"));
   }
   
   @Test
   public void test62_translate() {
      TextToMorse txt = new TextToMorse();
      assertEquals(".... ..   .--- .- -.- . -..-.-", txt.translate("HI  JAKE@"));
   }
   
   @Test
   public void test63_translate() {
      TextToMorse txt = new TextToMorse();
      assertEquals("", txt.translate("%"));
   }
   
   @Test
   public void test64_translate() {
      TextToMorse txt = new TextToMorse();
      assertEquals(".... ..  .- .-.. .-.. -.-- -.-.--", txt.translate("%HI# A*LL^Y!"));
   }
   
   @Test
   public void test65_translate() {
      TextToMorse txt = new TextToMorse();
      assertEquals(".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- " +
         ".-. ... - ..- ...- .-- -..- -.-- --..", txt.translate("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
   }
   
   @Test
   public void test66_translate() {
      TextToMorse txt = new TextToMorse();
      assertEquals("----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.",
         txt.translate("0123456789"));
   }
   
   @Test
   public void test67_translate() {
      TextToMorse txt = new TextToMorse();
      assertEquals(".-.-.- --..-- ..--.. .----. -.-.-- -..-. -.--. -.--.- .-... ---... -.-.-. " +
         "-...- .-.-. -....- ..--.- .-..-. ...-..- -..-.-", txt.translate(".,?'!/()&:;=+-_\"$@"));
   }
}
