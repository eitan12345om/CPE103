/**
 *Simple Array Stack class is a generic implementation of the simple stack interface
 *
 *
 *
 *@author Evan Jameson
 *@version Lab03
 */

import java.util.*;

public class SimpleArrayStack<T> implements SimpleStack<T>
{
   private T arr[];
   private int size;
   
   @SuppressWarnings("unchecked")
   public SimpleArrayStack()
   {
      arr = (T[]) new Object[10];
      this.size = 0;
   }

   //Returns the element from the top of the stack without removing it
   public T peek()
   {
      if(size == 0)
      {
         throw new NoSuchElementException();
      }
      return arr[size-1];
   }

   //Removes and returns the top element from the stack
   public T pop()
   {
      if(size == 0)
      {
         throw new NoSuchElementException();
      }
      T theElement = arr[size-1];
      arr[size-1] = null;
      size--;
      return theElement;
   }

   //Adds an element to the top of the stack
   @SuppressWarnings("unchecked")
   public void push(T element)
   {
      //Case if the array is full and an element is about to be added to the top
      if(size == arr.length)
      {
         T[] newArray = (T[])new Object[arr.length*2];
         for(int i = 0; i < arr.length; i++)
         {
            newArray[i] = arr[i];
         }
         arr = newArray;
      }
      arr[size] = element;
      size++;
   }

   //returns the total size of the array, whether or not its full
   public int capacity()
   {
      return arr.length;
   }

   public int size()
   {
      return size;
   }
}
