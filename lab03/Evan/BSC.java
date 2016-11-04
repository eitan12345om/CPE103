/**
 *Class BSC
 *
 *
 *
 *@author Evan Jameson
 *@version Lab03
 */

import java.util.*;

public class BSC
{
   public static boolean isBalanced(String equation)
   {
      if(equation.equals(""))
      {
         return true;
      }
      else 
      {
         SimpleArrayStack<Character> checkem = new SimpleArrayStack<Character>();  
         boolean prevOpen =false;
         for(int i = 0; i < equation.length(); i++)
         {
            if(checkBracket(equation.charAt(i)) > -1)
            {
               char character = equation.charAt(i);
               //character is an opening bracket
               if(checkBracket(character) == 0)
               {
                  checkem.push(character);
                  prevOpen = true;
               }
               //character is a closing bracket
               else if(checkBracket(character) == 1)
               {
                  //first check if there are previous opening brackets
                  if(prevOpen == false) //or if checkem.size() == 0
                  {
                     return false;
                  }
                  else if (prevOpen)
                  {
                     //check if the brackets match
                     if(match(checkem.peek(),character))
                     {
                        checkem.pop();
                     }
                     //means brackets dont match but there is an open beforehand
                     else
                     {
                        return false;
                     }
                  }  
               }
            }
         }
         //A balanced string will leave the stak empty once the loop is finished
         if(checkem.size() == 0)
         {
            return true;
         }
         
         return false;   
      }
   }

   //auxillary method to check and store backets that we are looking for
   //returns -1 = not a opening or closing bracket
   //returns 0 = opening bracket
   //returns 1 = closing bracket
   private static int checkBracket(char character)
   {
      char[] brackets = new char[] {'[','<','{','(',')','}','>',']'};
      //Loop checks for opening bracket
      for(int i = 0; i < brackets.length/2; i++)
      {
         if(character == brackets[i])
         {
            return 0;
         }
      }
      //Loop checks for closing bracket
      for(int j = 4; j < brackets.length; j++)
      {
         if(character == brackets[j])
         {
            return 1;
         }
      } 
      //not a bracket
      return -1;
   }

   //Auxillary method to check for matching brackets
   private static boolean match(char openBracket, char closeBracket)
   {
      if(openBracket == '[')
      {
         return closeBracket == ']';
      }
      else if(openBracket == '<')
      {
         return closeBracket == '>';
      }
      else if(openBracket == '{')
      {
         return closeBracket == '}';
      }
      else if(openBracket == '(')
      {
         return closeBracket == ')';
      }
      return false;
   }


}

/**
 *NOTES
 *----------------------------------------------------------------------------------------------------
 *Does there need to be a constructor for this class?
 *
 *
 *
 *
 *
 *
 *
 */
