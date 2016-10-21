/**
 *Priority Queue class
 *
 *
 *
 *@author Evan Jameson
 *@version Project 03
 */

import java.util.*;

public class PriorityQueue<T extends Comparable<? super T>> implements SimpleQueue<T>
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
         
      }

      public void enqueue(T element)
      {
         if(isMax)
         {
            if(heap.size() == 1)//1 with the null element
            {
               heap.add(element);              
            }
            else
            {
               
            }
         }
         else
         {

         }
      }

      public static <E extends Comparable<? super E>> E kth(E[] arr, int size, int k)//With E being generic
      {

      }

      public T peek()
      {

      }

      public int size()
      {

      }

      public static <E extends Comparable<? super E>> E kth(E[] arr, int size)
      {

      }  
}
