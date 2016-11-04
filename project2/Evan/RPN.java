/**
 *RPN class
 *
 *
 *
 *@author Evan Jameson
 *@version Project 02
 */

import java.util.*;

public class RPN
{
   //Evaluates the given infix expression
   public static double evaluateInfix(String infix)
   {
      return evaluateRPN(toRPN(infix));
   }
   
   //Evaluates th given RPN expression
   public static double evaluateRPN(String expression)
   {
      SimpleLinkedStack<Double> stack = new SimpleLinkedStack<>();
      Scanner s = new Scanner(expression);
      char operator;
      double op1;
      double op2;
      while(s.hasNext())
      { 
         if(s.hasNextInt())
         {
            stack.push((double)s.nextInt());  
         }
         else if(s.hasNextDouble())
         {
            stack.push(s.nextDouble());
         }
         else
         {
            operator = s.next().charAt(0);
            op2 = stack.pop(); 
            op1 = stack.pop();
            switch(operator)
            {
               case '*':
                  stack.push(op1 * op2);
                  break;
               case '/':
                  stack.push(op1 / op2);
                  break;
               case '+':
                  stack.push(op1 + op2);
                  break;
               case '-':
                  stack.push(op1 - op2);
                  break;
            }
         }
      }
      s.close();
      return stack.pop();
   }
   //Converts the given infix expression to reverse polish notation 
   public static String toRPN(String infix)
   {
      SimpleLinkedStack<Character> stack = new SimpleLinkedStack<>();
      Scanner s = new Scanner(infix);
      String finalExp = "";
      char operator;
      while(s.hasNext())
      {
         if(s.hasNextInt())
         {
           finalExp += s.nextInt() + " ";       
         }
         else if(s.hasNextDouble())
         {
            finalExp += s.nextDouble() + " ";
         }
         else
         {
            operator = s.next().charAt(0);
            if(operator == '(')
            {
               stack.push(operator);
            }
            else if(operator == ')')
            {
               while(stack.peek() != '(')
               {
                  finalExp += stack.pop() + " ";
               }
               stack.pop();
            }
            else
            {
               while(stack.size() > 0 && stack.peek() != '(' && !checkPrec(operator,stack.peek()))
               {
                  finalExp += stack.pop() + " ";
               }
               stack.push(operator);
            }
         }
      }
      while(stack.size() > 0)
      {
         finalExp += stack.pop() + " ";
      }
      return finalExp.trim();
   }

   private static boolean checkPrec(char operator, char soperator)
   {
      if(operator == '+' || operator == '-')
      {
         return false;
      }
      else if(soperator == '*' || soperator == '/')
      {
         return false;
      }
      else
      {
         return true;
      }
   }
}
