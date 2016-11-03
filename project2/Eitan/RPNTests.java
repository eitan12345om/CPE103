import org.junit.*;
import static org.junit.Assert.*;

/**
 * RPN and infix evaluator Tests.
 *
 * @author Eitan Simler
 * @version Project2
 */

public class RPNTests {

   // For assertEquals(double, double, delta)
   private final double DELTA = 1e-8;

   @Test
   public void testEmpty_toRPN() {
      String expression = "";
      assertEquals("", RPN.toRPN(expression));
   }

   @Test
   public void testInteger_toRPN() {
      String expression = "5";
      assertEquals("5", RPN.toRPN(expression));
   }

   @Test
   public void testDouble_toRPN() {
      String expression = "5.3";
      assertEquals("5.3", RPN.toRPN(expression));
   }
 
   @Test
   public void testSimpleAdd_toRPN() {
      String expression = "5 + 1";
      assertEquals("5 1 +", RPN.toRPN(expression));
   }

   @Test
   public void testSimpleMinus_toRPN() {
      String expression = "5 - 1";
      assertEquals("5 1 -", RPN.toRPN(expression));
   }

   @Test
   public void testSimpleMultiply_toRPN() {
      String expression = "5 * 1";
      assertEquals("5 1 *", RPN.toRPN(expression));
   }

   @Test
   public void testSimpleDivide_toRPN() {
      String expression = "5 / 1";
      assertEquals("5 1 /", RPN.toRPN(expression));
   }

   @Test
   public void testAddMultiply_toRPN() {
      String expression = "5 + 1 * 3";
      assertEquals("5 1 3 * +", RPN.toRPN(expression));
   }

   @Test
   public void testAddDivide_toRPN() {
      String expression = "5 + 1 / 3";
      assertEquals("5 1 3 / +", RPN.toRPN(expression));
   }

   @Test
   public void testMinusMultiply_toRPN() {
      String expression = "5 - 1 * 3";
      assertEquals("5 1 3 * -", RPN.toRPN(expression));
   }

   @Test
   public void testMinusDivide_toRPN() {
      String expression = "5 - 1 / 3";
      assertEquals("5 1 3 / -", RPN.toRPN(expression));
   }

   @Test
   public void testExample_toRPN() {
      String expression = "5 + ( 1 + 2 ) * 4 - 3";
      assertEquals("5 1 2 + 4 * + 3 -", RPN.toRPN(expression));
   }
   
   @Test
   public void testWikiExample_toRPN() {
      String expression = "3 + 4 * ( 2 - 1 )";
      assertEquals("3 4 2 1 - * +", RPN.toRPN(expression));
   }

   @Test
   public void testOxfordExample_toRPN() {
      String expression = "2 * ( 3 + 1 * 5 ) + 4";
      assertEquals("2 3 1 5 * + * 4 +", RPN.toRPN(expression));
   }
   
   @Test
   public void testOverflowExample_toRPN() {
      String expression = "3 + 4 * 2 / ( 1 - 5 )";
      assertEquals("3 4 2 * 1 5 - / +", RPN.toRPN(expression));
   }

   @Test
   public void testSimpleAddDouble_toRPN() {
      String expression = "5.3 + 1";
      assertEquals("5.3 1 +", RPN.toRPN(expression));
   }

   @Test
   public void testSimpleMinusDouble_toRPN() {
      String expression = "5.3 - 1";
      assertEquals("5.3 1 -", RPN.toRPN(expression));
   }

   @Test
   public void testSimpleMultiplyDouble_toRPN() {
      String expression = "5.3 * 1";
      assertEquals("5.3 1 *", RPN.toRPN(expression));
   }

   @Test
   public void testSimpleDivideDouble_toRPN() {
      String expression = "5.3 / 1";
      assertEquals("5.3 1 /", RPN.toRPN(expression));
   }

   @Test
   public void testAddMultiplyDouble_toRPN() {
      String expression = "5.3 + 1 * 3.1";
      assertEquals("5.3 1 3.1 * +", RPN.toRPN(expression));
   }

   @Test
   public void testAddDivideDouble_toRPN() {
      String expression = "5.3 + 11 / 3.1";
      assertEquals("5.3 11 3.1 / +", RPN.toRPN(expression));
   }

   @Test
   public void testMinusMultiplyDouble_toRPN() {
      String expression = "5.3 - 1 * 3.1";
      assertEquals("5.3 1 3.1 * -", RPN.toRPN(expression));
   }

   @Test
   public void testMinusDivideDouble_toRPN() {
      String expression = "55 - 1.01 / 3";
      assertEquals("55 1.01 3 / -", RPN.toRPN(expression));
   }

   @Test
   public void testExampleDouble_toRPN() {
      String expression = "5.6 + ( 1.0 + 2 ) * 43 - 3";
      assertEquals("5.6 1.0 2 + 43 * + 3 -", RPN.toRPN(expression));
   }
   
   @Test
   public void testWikiExampleDouble_toRPN() {
      String expression = "3.3 + 4 * ( 222 - 1 )";
      assertEquals("3.3 4 222 1 - * +", RPN.toRPN(expression));
   }

   @Test
   public void testOxfordExampleDouble_toRPN() {
      String expression = "2.333 * ( 3 + 1.333 * 5.7 ) + 4";
      assertEquals("2.333 3 1.333 5.7 * + * 4 +", RPN.toRPN(expression));
   }
   
   @Test
   public void testOverflowExampleDouble_toRPN() {
      String expression = "3.1 + 4.1 * 2.1 / ( 1.1 - 5.1 )";
      assertEquals("3.1 4.1 2.1 * 1.1 5.1 - / +", RPN.toRPN(expression));
   }

   @Test
   public void testInteger_evaluateRPN() {
      String expression = "5";
      assertEquals(5.0, RPN.evaluateRPN(expression), DELTA);
   }

   @Test
   public void testDouble_evaluateRPN() {
      String expression = "5.3";
      assertEquals(5.3, RPN.evaluateRPN(expression), DELTA);
   }
   
   @Test
   public void testSimpleAdd_evaluateRPN() {
      String expression = "5 3 +";
      assertEquals(8.0, RPN.evaluateRPN(expression), DELTA);
   }
   
   @Test
   public void testSimpleMinus_evaluateRPN() {
      String expression = "5 3 -";
      assertEquals(2.0, RPN.evaluateRPN(expression), DELTA);
   }
   
   @Test
   public void testSimpleMultiply_evaluateRPN() {
      String expression = "5 3 *";
      assertEquals(15.0, RPN.evaluateRPN(expression), DELTA);
   }
   
   @Test
   public void testSimpleDivide_evaluateRPN() {
      String expression = "6 3 /";
      assertEquals(2.0, RPN.evaluateRPN(expression), DELTA);
   }

   @Test
   public void testSimpleAddDouble_evaluateRPN() {
      String expression = "5.2 3.1 +";
      assertEquals(8.3, RPN.evaluateRPN(expression), DELTA);
   }
   
   @Test
   public void testSimpleMinusDouble_evaluateRPN() {
      String expression = "5.2 3.1 -";
      assertEquals(2.1, RPN.evaluateRPN(expression), DELTA);
   }
   
   @Test
   public void testSimpleMultiplyDouble_evaluateRPN() {
      String expression = "5.5 2 *";
      assertEquals(11.0, RPN.evaluateRPN(expression), DELTA);
   }
   
   @Test
   public void testSimpleDivideDouble_evaluateRPN() {
      String expression = "4.5 3.0 /";
      assertEquals(1.5, RPN.evaluateRPN(expression), DELTA);
   }
   
   @Test
   public void testMetaExample1_evaluateRPN() {
      String expression = "5 3 2 * +";
      assertEquals(11.0, RPN.evaluateRPN(expression), DELTA);
   }
   
   @Test
   public void testMetaExample2_evaluateRPN() {
      String expression = "12 3 - 3 /";
      assertEquals(3.0, RPN.evaluateRPN(expression), DELTA);
   }
   
   @Test
   public void testMetaExample3_evaluateRPN() {
      String expression = "2 3 11 + 5 - *";
      assertEquals(18.0, RPN.evaluateRPN(expression), DELTA);
   }
   
   @Test
   public void testMetaExample4_evaluateRPN() {
      String expression = "2 1 12 3 / - +";
      assertEquals(-1.0, RPN.evaluateRPN(expression), DELTA);
   }

   @Test
   public void testWikiExample_evaluateRPN() {
      String expression = "5 1 2 + 4 * + 3 -";
      assertEquals(14.0, RPN.evaluateRPN(expression), DELTA);
   }
   
   @Test
   public void testGeorgiaTechExample1_evaluateRPN() {
      String expression = "4 2 5 * + 1 3 2 * + /";
      assertEquals(2.0, RPN.evaluateRPN(expression), DELTA);
   }

   @Test
   public void testGeorgiaTechExample2_evaluateRPN() {
      String expression = "2 5 * 4 + 3 2 * 1 + /";
      assertEquals(2.0, RPN.evaluateRPN(expression), DELTA);
   }
   
   @Test
   public void testInteger_evaluateInfix() {
      String expression = "2";
      assertEquals(2.0, RPN.evaluateInfix(expression), DELTA);
   }
   
   @Test
   public void testDouble_evaluateInfix() {
      String expression = "2.3";
      assertEquals(2.3, RPN.evaluateInfix(expression), DELTA);
   }
   
   @Test
   public void testExample1_evaluateInfix() {
      String expression = "2 + ( ( 3 * 4 ) - 5 ) * 3";
      assertEquals(23.0, RPN.evaluateInfix(expression), DELTA);
   }
   
   @Test
   public void testExample2_evaluateInfix() {
      String expression = "( 2 + ( 9 - ( 1 * ( 6 / 3 ) ) ) )";
      assertEquals(9.0, RPN.evaluateInfix(expression), DELTA);
   }
   
   @Test
   public void testExample3_evaluateInfix() {
      String expression = "( 2 * ( 9 - ( 1 * ( 6 / 3 ) ) ) )";
      assertEquals(14.0, RPN.evaluateInfix(expression), DELTA);
   }
   
   @Test
   public void testExample4_evaluateInfix() {
      String expression = "( ( ) ( ) ( ) 7 + 8 ( ) ( ) )";
      assertEquals(15.0, RPN.evaluateInfix(expression), DELTA);
   }
   
   @Test
   public void testExample5_evaluateInfix() {
      String expression = "( 7 *               ( ) ( ) ( ) 7 + 8 ( ) ( ) )";
      assertEquals(57.0, RPN.evaluateInfix(expression), DELTA);
   }

   @Test
   public void testExample6_evaluateInfix() {
      String expression = "2.3 + ( ( 3 * 1.5 ) - 5.5 ) * 3";
      assertEquals(-0.7, RPN.evaluateInfix(expression), DELTA);
   }
   
   @Test
   public void testExample7_evaluateInfix() {
      String expression = "( 2.5 + ( 9.5 - ( 1.5 * ( 6 / 1.5 + 3 ) ) ) )";
      assertEquals(1.5, RPN.evaluateInfix(expression), DELTA);
   }
   
   @Test
   public void testExample8_evaluateInfix() {
      String expression = "( 2 * ( 9 - ( 1 * ( 63.123 ) ) ) )";
      assertEquals(-108.246, RPN.evaluateInfix(expression), DELTA);
   }
   
   @Test
   public void testExample9_evaluateInfix() {
      String expression = "( ( ) ( ) ( ) 7.7 + 8.8 ( ) ( ) )";
      assertEquals(16.5, RPN.evaluateInfix(expression), DELTA);
   }
   
   @Test
   public void testExample10_evaluateInfix() {
      String expression = "( 7.5 *               ( ) ( ) ( ) 7 + 8 ( ) ( ) )";
      assertEquals(60.5, RPN.evaluateInfix(expression), DELTA);
   }
}
