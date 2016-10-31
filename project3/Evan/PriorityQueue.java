/**
 *Priority Queue class
 *
 *
 *
 *@author Evan Jameson
 *@version Project 03
 */

import java.util.*;

public class PriorityQueue<T extends Comparable<? super T>> //implements SimpleQueue<T>
{

      //"..must have exactly two private fields!"
      private ArrayList<T> heap = new ArrayList<>();//-or- ArrayList<T>();
      private boolean isMax; //keeps track of whether queue is a min or max queue
                          //[min = min value at top of heap] & [max = max value at top of heap]

      public PriorityQueue()
      {
         this.heap.add(null); //to put a null at the 0th index
         this.isMax = false;
      }
      public PriorityQueue(boolean isMax)
      {
         this.heap.add(null);
         this.isMax = isMax;  
      }
      public PriorityQueue(T[] arr, int size)
      {
         this.heap.add(null);
         this.isMax = false;
         for(int i = 0; i < size; i++)
         {
            this.enqueue(arr[i]);
         }
      }
      public PriorityQueue(T[] arr, int size, boolean isMax)
      {
         this.heap.add(null);
         this.isMax = isMax;
         for(int i = 0; i < size; i++)
         {
            this.enqueue(arr[i]);  
         }
      }

      public T dequeue()
      {
         
         return heap.get(heap.size()-1);
      }

      public void enqueue(T element)
      {
      int index = heap.size();
      heap.add(null);
      boolean exit = false;
         if(isMax)
         {
            while(!exit && index != 1)
            {
               if(element.compareTo(heap.get(index / 2)) > 0)
               {
                  heap.set(index, heap.get(index / 2));
                  index /= 2;
               }
               else
               {
                  exit = true;
               }
            }
         }
         else
         {
            while(!exit && index != 1)
            {
               if(element.compareTo(heap.get(index/2)) < 0)
               {
                  heap.set(index, heap.get(index / 2));
                  index /= 2;
               }
               else
               {
                  exit = true;
               }
            }
            
         }
         heap.add(index, element);
      }

      public T peek()
      {
         if(heap.size() == 1)
         {
            throw new NoSuchElementException();
         }
         return heap.get(1);
      }

      public int size()
      {
         return heap.size() - 1;
      }

      public static <E extends Comparable<? super E>> E kth(E[] arr, int size, int k)//With E being generic
      {
         return arr[arr.length-1];
      }

      public static <E extends Comparable<? super E>> void sort(E[] arr, int size)
      {
      
      }  
}
