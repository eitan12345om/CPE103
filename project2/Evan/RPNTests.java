/**
 * RPN class Tests.
 *
 * @author Evan Jameson
 * @version Project 02
 */

import org.junit.*;
import static org.junit.Assert.*;

public class RPNTests {

   // For assertEquals(double, double, BETA)
   private final double BETA = 1e-8;

   @Test
   public void testtoRPN_empty() {
      String expression = "";
      assertEquals("", RPN.toRPN(expression));
   }

   @Test
   public void testtoRPN_Integer() {
      String expression = "5";
      assertEquals("5", RPN.toRPN(expression));
   }

   @Test
   public void testtoRPN_Double() {
      String expression = "5.3";
      assertEquals("5.3", RPN.toRPN(expression));
   }
 
   @Test
   public void testtoRPN_add() {
      String expression = "5 + 1";
      assertEquals("5 1 +", RPN.toRPN(expression));
   }

   @Test
   public void testtoRPN_subtract() {
      String expression = "5 - 1";
      assertEquals("5 1 -", RPN.toRPN(expression));
   }

   @Test
   public void testtoRPN_multiply() {
      String expression = "5 * 1";
      assertEquals("5 1 *", RPN.toRPN(expression));
   }

   @Test
   public void testtoRPN_divide() {
      String expression = "5 / 1";
      assertEquals("5 1 /", RPN.toRPN(expression));
   }

   @Test
   public void testtoRPN_addMultiply() {
      String expression = "5 + 1 * 3";
      assertEquals("5 1 3 * +", RPN.toRPN(expression));
   }

   @Test
   public void testEjemplo_toRPN() {
      String expression = "5 + ( 1 + 2 ) * 4 - 3";
      assertEquals("5 1 2 + 4 * + 3 -", RPN.toRPN(expression));
   }
   
   @Test
   public void testEjemplo2_toRPN() {
      String expression = "3 + 4 * ( 2 - 1 )";
      assertEquals("3 4 2 1 - * +", RPN.toRPN(expression));
   }
   
   @Test
   public void testOverEjemplo_toRPN() {
      String expression = "3 + 4 * 2 / ( 1 - 5 )";
      assertEquals("3 4 2 * 1 5 - / +", RPN.toRPN(expression));
   }

   @Test
   public void testAddDouble_toRPN() {
      String expression = "5.3 + 1";
      assertEquals("5.3 1 +", RPN.toRPN(expression));
   }

   @Test
   public void testMinusDouble_toRPN() {
      String expression = "5.3 - 1";
      assertEquals("5.3 1 -", RPN.toRPN(expression));
   }

   @Test
   public void testMultiplyDouble_toRPN() {
      String expression = "5.3001 * 1";
      assertEquals("5.3001 1 *", RPN.toRPN(expression));
   }

   @Test
   public void testDivideDouble_toRPN() {
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
   public void testEjemploDouble_toRPN() {
      String expression = "( ( 8.213 * ( 2.62 - 4.89 ) ) / 7.983 + ( 3.126 + 1.98 * ( 6.981 / 7.1093 ) ) ) / 9";
      assertEquals("8.213 2.62 4.89 - * 7.983 / 3.126 1.98 6.981 7.1093 / * + + 9 /", RPN.toRPN(expression));
   }
   
   @Test
   public void testOverEjemploDouble_toRPN() {
      String expression = "3.1 + 4.1 * 2.1 / ( 4 + 9 * ( 1.1 - 5.1 ) )";
      assertEquals("3.1 4.1 2.1 * 4 9 1.1 5.1 - * + / +", RPN.toRPN(expression));
   }

   @Test
   public void testInteger_evaluateRPN() {
      String expression = "5";
      assertEquals(5.0, RPN.evaluateRPN(expression), BETA);
   }

   @Test
   public void testDouble_evaluateRPN() {
      String expression = "5.3";
      assertEquals(5.3, RPN.evaluateRPN(expression), BETA);
   }
   
   @Test
   public void testAdd_evaluateRPN() {
      String expression = "5 3 +";
      assertEquals(8.0, RPN.evaluateRPN(expression), BETA);
   }
   
   @Test
   public void testMinus_evaluateRPN() {
      String expression = "5 3 -";
      assertEquals(2.0, RPN.evaluateRPN(expression), BETA);
   }
   
   @Test
   public void testMultiply_evaluateRPN() {
      String expression = "5.73821 3 *";
      assertEquals(17.21463, RPN.evaluateRPN(expression), BETA);
   }
   
   @Test
   public void testDivide_evaluateRPN() {
      String expression = "6 3 /";
      assertEquals(2.0, RPN.evaluateRPN(expression), BETA);
   }

   @Test
   public void testAddDouble_evaluateRPN() {
      String expression = "5.2 3.1 +";
      assertEquals(8.3, RPN.evaluateRPN(expression), BETA);
   }
   
   @Test
   public void testMinusDouble_evaluateRPN() {
      String expression = "5.2 3.1 -";
      assertEquals(2.1, RPN.evaluateRPN(expression), BETA);
   }
   
   @Test
   public void testMultiplyDouble_evaluateRPN() {
      String expression = "5.5 2 *";
      assertEquals(11.0, RPN.evaluateRPN(expression), BETA);
   }
   
   @Test
   public void testDivideDouble_evaluateRPN() {
      String expression = "4.5 3.0 /";
      assertEquals(1.5, RPN.evaluateRPN(expression), BETA);
   }

   @Test
   public void testEjemplo_evaluateRPN() {
      String expression = "5 1 2 + 4 * + 3 -";
      assertEquals(14.0, RPN.evaluateRPN(expression), BETA);
   }
   
   @Test
   public void testInteger_evaluateInfix() {
      String expression = "2";
      assertEquals(2.0, RPN.evaluateInfix(expression), BETA);
   }
   
   @Test
   public void testDouble_evaluateInfix() {
      String expression = "2.3";
      assertEquals(2.3, RPN.evaluateInfix(expression), BETA);
   }
   
   @Test
   public void testEjemplo1_evaluateInfix() {
      String expression = "2 + ( ( 3 * 4 ) - 5 ) * 3";
      assertEquals(23.0, RPN.evaluateInfix(expression), BETA);
   }
   
   @Test
   public void testEjemplo2_evaluateInfix() {
      String expression = "( 2 + ( 9 - ( 1 * ( 6 / 3 ) ) ) )";
      assertEquals(9.0, RPN.evaluateInfix(expression), BETA);
   }
   
   @Test
   public void testEjemplo3_evaluateInfix() {
      String expression = "( 2 * ( 9 - ( 1 * ( 6 / 3 ) ) ) )";
      assertEquals(14.0, RPN.evaluateInfix(expression), BETA);
   }
   
   @Test
   public void testEjemplo4_evaluateInfix() {
      String expression = "( ( ) ( ) ( ) 7 + 8 ( ) ( ) )";
      assertEquals(15.0, RPN.evaluateInfix(expression), BETA);
   }
   
   @Test
   public void testEjemplo5_evaluateInfix() {
      String expression = "( 7 *               ( ) ( ) ( ) 7 + 8 ( ) ( ) )";
      assertEquals(57.0, RPN.evaluateInfix(expression), BETA);
   }

   @Test
   public void testEjemplo6_evaluateInfix() {
      String expression = "2.3 + ( ( 3 * 1.5 ) - 5.5 ) * 3";
      assertEquals(-0.7, RPN.evaluateInfix(expression), BETA);
   }
}
