/**
 *ShellSorts class
 *
 *
 *
 *@author Evan Jameson
 *@version Lab11
 */

import java.util.*;

public class ShellSorts
{
   public static <T extends Comparable<? super T>> void shell(T[] arr)
   {
      int [] gaps = new int[] {128, 64, 32, 16, 8, 4, 2, 1}; 
      T temp;
      int j;

      for(int gap : gaps)
      {
         for(int i = gap; i < arr.length; i++)
         {
            temp = arr[i];
            for(j = i; j >= gap && temp.compareTo(arr[j - gap]) < 0; j -= gap)
            {
               arr[j] = arr[j - gap];
            }
            arr[j] = temp;
         }
      }
   }

   public static <T extends Comparable<? super T>> void hibbard(T[] arr)
   {
      int [] gaps = new int[] {255, 127, 63, 31, 15, 7, 3, 1}; 
      T temp;
      int j;

      for(int gap : gaps)
      {
         for(int i = gap; i < arr.length; i++)
         {
            temp = arr[i];
            for(j = i; j >= gap && temp.compareTo(arr[j - gap]) < 0; j -= gap)
            {
               arr[j] = arr[j - gap];
            }
            arr[j] = temp; 
         }
      }
   }
   public static <T extends Comparable<? super T>> void sedgewick(T[] arr)
   {
      int [] gaps = new int[] {16766, 4286, 1118, 281, 77, 23, 8, 1}; 
      T temp;
      int j;

      for(int gap : gaps)
      {
         for(int i = gap; i < arr.length; i++)
         {
            temp = arr[i];
            for(j = i; j >= gap && temp.compareTo(arr[j - gap]) < 0; j -= gap)
            {
               arr[j] = arr[j - gap];
            }
            arr[j] = temp; 
         }
      }
   }
   public static <T extends Comparable<? super T>> void heapSort(T[] arr)
   {
      PriorityQueue pq = new PriorityQueue();
      pq.sort(arr, arr.length);
   }
}
