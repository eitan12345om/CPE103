import java.util.Scanner;

/**
 * An RPN and infix evaluator.
 *
 * @author Eitan Simler
 * @version Project2
 */

public class RPN {

   public static double evaluateRPN(String expression) {
      Scanner scan = new Scanner(expression);
      SimpleLinkedStack<Double> stack = new SimpleLinkedStack<>();
      char operator;
      double value1, value2;

      while (scan.hasNext()) {
      
         // Check if next token int, double, or operator
         if (scan.hasNextInt()) {
            stack.push((double) scan.nextInt());      
         }
         else if (scan.hasNextDouble()) {
            stack.push(scan.nextDouble());
         }
         
         // If token is an operator
         else {
            operator = scan.next().charAt(0);
            value2 = stack.pop();
            value1 = stack.pop();

            // Evaluate and push the expressions
            switch (operator) {
               case '+':
                  stack.push(value1 + value2);
                  break;
               case '-':
                  stack.push(value1 - value2);
                  break;
               case '*':
                  stack.push(value1 * value2);
                  break;
               case '/':
                  stack.push(value1 / value2);
                  break;
            }

         }
      }
      return stack.pop();
   }

   public static String toRPN(String infix) {
      Scanner scan = new Scanner(infix);
      SimpleLinkedStack<Character> stack = new SimpleLinkedStack<>();
      String expression = "";
      char operator;

      while (scan.hasNext()) {
         
         // Check if next token int, double, or operator       
         if (scan.hasNextInt()) {
            expression += scan.nextInt() + " ";
         }
         else if (scan.hasNextDouble()) {
            expression += scan.nextDouble() + " ";
         }
         else {
            operator = scan.next().charAt(0);

            // Whenever a open parenthese sign, push to stack
            if (operator == '(') {
               stack.push(operator);
            }
            else if (operator == ')') {
               // Pop from stack until open parentheses
               while (stack.peek() != '(') {
                  expression += stack.pop() + " ";
               }

               // Remove opening parentheses
               stack.pop();
            }
            else {
               // Add to stack after popping everything of equal or greater precedence
               while (stack.size() > 0 && stack.peek() != '(' && !isGreaterPrec(operator, stack.peek())) {
                  expression += stack.pop() + " ";
               }
            
               stack.push(operator);
            }
         }
      }

      // Add remaining operators to expression
      while (stack.size() > 0) {
         expression += stack.pop() + " ";
      }
      
      // Remove white space on ends and return
      return expression.trim();
   }
   
   public static double evaluateInfix(String infix) {
      // Evaluate infix expression using toRPN and evaluateRPN
      return evaluateRPN(toRPN(infix));  
   }

   private static boolean isGreaterPrec(char opExpr, char opStack) {
      // opExpr --- operator from expression
      // opStack --- operator from stack
      if (opExpr == '+' || opExpr == '-') {
         return false;
      }
      else {
         if (opStack == '*' || opStack == '/') {
            return false;
         }
      }
      return true;
   }

}
