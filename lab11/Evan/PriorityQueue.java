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
         if(heap.size() == 1)
         {
            throw new NoSuchElementException();
         }
         
         boolean exit = false;
         int index = 1;
         T root = heap.get(1);        
         T last = heap.remove(heap.size() - 1);

         if(root.equals(last))
         {
            return root;
         }

         while(!exit)
         {
            if(index * 2 < heap.size()) //check for left child
            {
               if(index * 2 + 1 < heap.size()) //check for right child  
               {
                  if(pickAKid(heap.get(index * 2), heap.get(index * 2 + 1)))
                  {
                     if(pickAKid(last, heap.get(index * 2)))
                     {
                        exit = true;
                     }
                     else
                     {
                        heap.set(index, heap.get(index * 2));
                        index *= 2;
                     }
                  }
                  else
                  {
                     if(pickAKid(last, heap.get(index * 2 + 1)))
                     {
                        exit = true;
                     }
                     else
                     {
                        heap.set(index, heap.get(index * 2 + 1));
                        index = index * 2 + 1;
                     }
                  }
               }
               else
               {
                  if(pickAKid(last, heap.get(index * 2)))
                  {
                     exit = true;
                  }
                  else
                  {
                     heap.set(index, heap.get(index * 2));
                     index *= 2;
                     exit = true;
                  }
               }
            }
            else
            {
                  exit = true;
            }
         }   
         heap.set(index,last);
         return root;
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
                  exit = true; //break;
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
                  exit = true; //break;
               }
            }
            
         }
         heap.set(index, element);
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
         boolean max = false;

         if(k > size - k + 1)
         {
            k = size - k + 1;
            max = true;
         }

         PriorityQueue<E> queue = new PriorityQueue<>(arr, k, max);

         if(max)
         {
            for(int i = k; i < size; i++)
            {
               if(arr[i].compareTo(queue.peek()) < 0)
               {
                  queue.dequeue();
                  queue.enqueue(arr[i]);
               }
            }
         }
         else
         {
            for (int i = k; i < size; i++)
            {
               if(arr[i].compareTo(queue.peek()) > 0)
               {
                  queue.dequeue();
                  queue.enqueue(arr[i]);
               }
            }
         }
         return queue.peek();
      }

      public static <E extends Comparable<? super E>> void sort(E[] arr, int size)
      {
         PriorityQueue<E> queue = new PriorityQueue<>(arr, size);
         for(int i = 0; i < size; i++)
         {
            arr[i] = queue.dequeue();
         }
      } 

      private boolean pickAKid(T left, T right)
      {
         if(isMax)
         {
            return left.compareTo(right) >= 0;
         }
         return left.compareTo(right) <= 0;
      }
}
