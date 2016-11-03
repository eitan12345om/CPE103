/**
 * This interface will be a standard for the rest of the classes.
 *
 * @author Eitan Simler
 * @version Lab01
 */

public interface SimpleList<T> {

   // Appends the element to the end of the list.
   void add(T element);
   
   // Inserts the element at the specified position.
   void add(int index, T element);

   // Returns the element at the specified index.
   T get(int index);

   // Removes the element at the specified index.
   T remove(int index);

   // Returns the number of elements in the list.
   int size();
}
