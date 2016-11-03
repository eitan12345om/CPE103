import org.junit.*;
import static org.junit.Assert.*;

/**
 * A Balanced Symbol Checker Tester.
 *
 * @author Eitan Simler
 * @version Lab03
 */

public class BSCTests {

   @Test
   public void testEmpty() {
      assertTrue(BSC.isBalanced(""));
   }

   @Test
   public void testOnlyParentheses() {
      assertTrue(BSC.isBalanced("()"));
   }

   @Test
   public void testOnlySquareBrackets() {
      assertTrue(BSC.isBalanced("[]"));
   }

   @Test
   public void testOnlyArrows() {
      assertTrue(BSC.isBalanced("<>"));
   }

   @Test
   public void testOnlySquigglyBrackets() {
      assertTrue(BSC.isBalanced("{}"));
   }

   @Test
   public void testOnlyParentheses_false() {
      assertFalse(BSC.isBalanced(")("));
   }

   @Test
   public void testOnlySquareBrackets_false() {
      assertFalse(BSC.isBalanced("]["));
   }

   @Test
   public void testOnlyArrows_false() {
      assertFalse(BSC.isBalanced("><"));
   }

   @Test
   public void testOnlySquigglyBrackets_false() {
      assertFalse(BSC.isBalanced("}{"));
   }

   @Test
   public void testParentheses_otherChars() {
      assertTrue(BSC.isBalanced("(Hello)"));
   }

   @Test
   public void testParentheses_otherCharsBefore() {
      assertTrue(BSC.isBalanced("Hello()"));
   }

   @Test
   public void testParentheses_otherCharsAfter() {
      assertTrue(BSC.isBalanced("()Hello"));
   }

   @Test
   public void testParentheses_otherCharsMixed() {
      assertTrue(BSC.isBalanced("He(l)lo"));
   }

   @Test
   public void testSquareBrackets_otherChars() {
      assertTrue(BSC.isBalanced("[Hello]"));
   }

   @Test
   public void testSquareBrackets_otherCharsBefore() {
      assertTrue(BSC.isBalanced("Hello[]"));
   }

   @Test
   public void testSquareBrackets_otherCharsAfter() {
      assertTrue(BSC.isBalanced("[]Hello"));
   }

   @Test
   public void testSquareBrackets_otherCharsMixed() {
      assertTrue(BSC.isBalanced("He[l]lo"));
   }

   @Test
   public void testArrows_otherChars() {
      assertTrue(BSC.isBalanced("<Hello>"));
   }

   @Test
   public void testArrows_otherCharsBefore() {
      assertTrue(BSC.isBalanced("Hello<>"));
   }

   @Test
   public void testArrows_otherCharsAfter() {
      assertTrue(BSC.isBalanced("<>Hello"));
   }

   @Test
   public void testArrows_otherCharsMixed() {
      assertTrue(BSC.isBalanced("He<l>lo"));
   }

   @Test
   public void testSquigglyBrackets_otherChars() {
      assertTrue(BSC.isBalanced("{Hello}"));
   }

   @Test
   public void testSquigglyBrackets_otherCharsBefore() {
      assertTrue(BSC.isBalanced("Hello{}"));
   }

   @Test
   public void testSquigglyBrackets_otherCharsAfter() {
      assertTrue(BSC.isBalanced("{}Hello"));
   }

   @Test
   public void testSquigglyBrackets_otherCharsMixed() {
      assertTrue(BSC.isBalanced("He{l}lo"));
   }
      
   @Test
   public void testParentheses_otherChars_false() {
      assertFalse(BSC.isBalanced(")Hello("));
   }

   @Test
   public void testParentheses_otherCharsBefore_false() {
      assertFalse(BSC.isBalanced("Hello)("));
   }

   @Test
   public void testParentheses_otherCharsAfter_false() {
      assertFalse(BSC.isBalanced(")(Hello"));
   }

   @Test
   public void testParentheses_otherCharsMixed_false() {
      assertFalse(BSC.isBalanced("He)l(lo"));
   }

   @Test
   public void testSquareBrackets_otherChars_false() {
      assertFalse(BSC.isBalanced("]Hello["));
   }

   @Test
   public void testSquareBrackets_otherCharsBefore_false() {
      assertFalse(BSC.isBalanced("Hello]["));
   }

   @Test
   public void testSquareBrackets_otherCharsAfter_false() {
      assertFalse(BSC.isBalanced("][Hello"));
   }

   @Test
   public void testSquareBrackets_otherCharsMixed_false() {
      assertFalse(BSC.isBalanced("He]l[lo"));
   }

   @Test
   public void testArrows_otherChars_false() {
      assertFalse(BSC.isBalanced(">Hello<"));
   }

   @Test
   public void testArrows_otherCharsBefore_false() {
      assertFalse(BSC.isBalanced("Hello><"));
   }

   @Test
   public void testArrows_otherCharsAfter_false() {
      assertFalse(BSC.isBalanced("><Hello"));
   }

   @Test
   public void testArrows_otherCharsMixed_false() {
      assertFalse(BSC.isBalanced("He>l<lo"));
   }

   @Test
   public void testSquigglyBrackets_otherChars_false() {
      assertFalse(BSC.isBalanced("}Hello{"));
   }

   @Test
   public void testSquigglyBrackets_otherCharsBefore_false() {
      assertFalse(BSC.isBalanced("Hello}{"));
   }

   @Test
   public void testSquigglyBrackets_otherCharsAfter_false() {
      assertFalse(BSC.isBalanced("}{Hello"));
   }

   @Test
   public void testSquigglyBrackets_otherCharsMixed_false() {
      assertFalse(BSC.isBalanced("He}l{lo"));
   }

   @Test
   public void testExample1() {
      assertTrue(BSC.isBalanced("(())"));
   }

   @Test
   public void testExample2() {
      assertTrue(BSC.isBalanced("[]{}"));
   } 

   @Test
   public void testExample3() {
      assertTrue(BSC.isBalanced("( [ { < ( ) <( ){}>> } ] )"));
   }

   @Test
   public void testWorking1() {
      assertTrue(BSC.isBalanced("[(Hel<lo>) {W}orld!]{              < () > }"));
   } 

   @Test
   public void testWorking2() {
      assertTrue(BSC.isBalanced("[<<<>>><<{{}}>>]{}"));
   } 

   @Test
   public void testWorking3() {
      assertTrue(BSC.isBalanced("{{hello}<(hello)>}e()()()<>d sd s    {}"));
   }

   @Test
   public void testWorking4() {
      assertTrue(BSC.isBalanced("[(<{[(<{[(<{}>)]}>)]}>)]"));
   } 

   @Test
   public void testNotWorking1() {
      assertFalse(BSC.isBalanced("[(Hel<lo>) {W}orld!]{         }     < () > }"));
   } 

   @Test
   public void testNotWorking2() {
      assertFalse(BSC.isBalanced("[<<<>>>><<{{}}>>]{}"));
   } 

   @Test
   public void testNotWorking3() {
      assertFalse(BSC.isBalanced("{{hello}<(hello)>}e({)()()<>d sd s    {}"));
   }

   @Test
   public void testNotWorking4() {
      assertFalse(BSC.isBalanced("[(<{[(<{[(<{}>)]}>)]}>)]["));
   } 

   @Test
   public void testNotWorking5() {
      assertFalse(BSC.isBalanced("[{]}"));
   } 
}
