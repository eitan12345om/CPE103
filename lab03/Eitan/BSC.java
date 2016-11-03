/**
 * A Balanced Symbol Checker.
 *
 * @author Eitan Simler
 * @version Lab03
 */

public class BSC {
  
   private static Character[] openers = new Character[] {'[', '<', '{', '('};
   private static Character[] closers = new Character[] {']', '>', '}', ')'};

   public static boolean isBalanced(String aString) {
      SimpleArrayStack<Character> stack = new SimpleArrayStack<>();
         
      // Determine if balanced
      for (int i = 0; i < aString.length(); i++) {
         // Retrieve character at specified index 
         char c = aString.charAt(i);

         if (contains(openers, c)) {
            stack.push(c);
         }
         else if (contains(closers, c)) {
            // Check if size is 0
            if (stack.size() == 0) {
               return false;
            }
            
            // Check if closing symbol matches opening on top of stack
            int index = 0;

            switch (stack.peek()) {
               case '[':
                  index = 0;
                  break;
               case '<':
                  index = 1;
                  break;
               case '{':
                  index = 2;
                  break;
               case '(':
                  index = 3;
                  break;
            }



            if (closers[index].equals(c)) {
               stack.pop();  
            }
            else {
               return false;
            }
         }

      }

      // Check if stack empty
      if (stack.size() == 0) {
         return true;
      }
      
      // Otherwise return false
      return false;
   }

   private static <T> boolean contains(T[] arr, T target) {
      for (T elem : arr) {
         if (elem == null || target == null) {
            if (target == elem) {
               return true;
            }
         }
         else {
            if (target.equals(elem)) {
               return true;
            }
         }
      }
      return false;
   }
}
