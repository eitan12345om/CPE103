/**
 * A simple stack interface.
 *
 * @author Eitan Simler
 * @version Project2
 */

public interface SimpleStack<T> {

   // Returns element on top of the stack
   T peek();

   // Removes and returns element on top of stack
   T pop();

   // Add specified element to stack
   void push(T element);

   // Return size of stack
   int size();
}
