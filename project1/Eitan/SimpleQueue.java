/**
 * A simple queue interface.
 *
 * @author Eitan Simler
 * @version Project1
 */

public interface SimpleQueue<T> {

   // Removes and returns the element at the front of this queue.
   T dequeue();

   // Adds the specified element to the end of this queue.
   void enqueue(T element);

   // Returns the element at the front of this queue.
   T peek();

   // Returns the number of elements in this queue.
   int size();
}
