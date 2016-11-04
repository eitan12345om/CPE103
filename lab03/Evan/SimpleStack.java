/**
 * Simple Stack Interface
 *
 *
 * @author Evan Jameson
 * @version Lab03
 */

public interface SimpleStack<T>
{
   T peek();
   T pop();
   void push(T element);
   int size();
}
