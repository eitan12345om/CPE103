/**
 *JUnit tests for the BSC Class
 *
 *
 *
 *@author Evan Jameson
 *@version Lab 03
 */

import org.junit.*;
import static org.junit.Assert.*;

public class BSCTests
{

   @Test
   public void test1_parens()
   {
      String check = "()";
      assertTrue(BSC.isBalanced(check));
   }

   @Test
   public void test2_bracketsMultiple()
   {
      String check = "(){}<>[]";
      assertTrue(BSC.isBalanced(check));
   }

   @Test
   public void test3_nestedBrackets()
   {
      String check = "( [ { < ( ) <( ){}>> } ] )";
      assertTrue(BSC.isBalanced(check));
   }

   @Test
   public void test4_closeFail()
   {
      String check = "}";
      assertFalse(BSC.isBalanced(check));
   }

   @Test
   public void test5_nestedFail()
   {
      String check = "( { ) } <>";
      assertFalse(BSC.isBalanced(check));
   }

   @Test
   public void test6_otherCharacters()
   {
      String check = "[(Hello) {W}orld!]";
      assertTrue(BSC.isBalanced(check));
   }

   @Test 
   public void test7_otherCharactersFail()
   {
      String check = "23 ({4)} ";
      assertFalse(BSC.isBalanced(check));
   }

   @Test
   public void test8_otherCharactersOnly()
   {
      String check = "Hey hows it going fam";
      assertTrue(BSC.isBalanced(check));
   }

   @Test
   public void test9_empty()
   {
      String check = "               ";
      assertTrue(BSC.isBalanced(check));
   }

   @Test
   public void test10_finalBoss()
   {
      String check = "(<C>a{l Poly Mustangs Athle<<tic (a()nd) Acade>mic >excellence 123456789 !@#$^&*}:)";
      assertTrue(BSC.isBalanced(check));
   }
}
