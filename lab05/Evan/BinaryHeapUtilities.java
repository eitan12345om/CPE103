/**
 *Binary Heap Utilities class
 *
 *
 *
 *@author Evan Jameson
 *@version Lab 05
 */

import java.util.*;
import java.util.NoSuchElementException;

public class BinaryHeapUtilities
{
   public static int height(int size)
   {
      if(size < 1)
      {
         throw new IllegalArgumentException();
      }
      return (int) (Math.log(size) / Math.log(2));
   }
   
   public static <T extends Comparable<? super T>> boolean isHeap(T[] heap, int size)
   {
      //what to do with empty heap?
      //size must be positive [non-empty heaps size is its last valid index]
      if(size < 1)
      {
         //we can assume here the size is not zero since if that was the case it would haave returned true
         return false;
      }

      //Check for correct parent to child relations
      else
      {
         for(int i = 1; i * 2 + 1 <=  size; i++)
         {
            T parent = heap[i];
            T left = heap[i * 2];
            T right = heap [i * 2 + 1];
            if(parent.compareTo(left) > 0 || parent.compareTo(right) > 0)
            {
               return false;
            }
         }
      }
      return true;
   }

   public static <T extends Comparable<? super T>> T parentOf(int index, T[] heap, int size)
   {
      if(index <= 0 || index  > size)
      {
         throw new IndexOutOfBoundsException();
      }
      else if(index/2 == 0)
      {
         throw new NoSuchElementException();
      }
      else if(!isHeap(heap, size))
      {
         throw new IllegalArgumentException();
      }
      
      //implementation of method here
      return heap[index/2];
   }

   public static <T extends Comparable<? super T>> T leftChildOf(int index, T[] heap,int size)
   {
      if(index <= 0 || index  > size)
      {
         throw new IndexOutOfBoundsException();
      }
      else if(index * 2 > size)
      {
         throw new NoSuchElementException();
      }
      else if(!isHeap(heap, size))
      {
         throw new IllegalArgumentException();
      }
         
      //implementation of method here
      return heap[index * 2];
   }

   public static <T extends Comparable<? super T>> T rightChildOf(int index, T[] heap, int size)
   {
      if(index <= 0 || index  > size)
      {
         throw new IndexOutOfBoundsException();
      }
      else if(index * 2 + 1 > size)
      {
         throw new NoSuchElementException();
      }
      else if(!isHeap(heap, size))
      {
         throw new IllegalArgumentException();
      }

      //implementation of method here
      return heap[index * 2 + 1];
   }
}
