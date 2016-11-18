/**
 *Public class QuadraticSorts
 *
 *
 *
 *@author Evan Jameson
 *@version Lab10
 */

import java.util.*;

public class QuadraticSorts
{
   public static <T extends Comparable<? super T>> void bubbleSort1(T[] array)
   {
      T obj;
      boolean swapped = true;
      while(swapped)
      {
         swapped = false;
         for(int i = 0; i < array.length - 1; i++)
         {
            if(array[i].compareTo(array[i + 1]) > 0)
            {
               obj = array[i];
               array[i] = array[i + 1];
               array[i + 1] = obj;
               swapped = true;
            }
         }
      }
   }

   public static <T extends Comparable<? super T>> void bubbleSort2(T[] array)
   {
      T obj;
      int newn;
      int n = array.length;


      while(n > 0)
      {
         newn = 0;
         for(int i = 1; i < n; i++)
         {
            if(array[i - 1].compareTo(array[i]) > 0)
            {
               obj = array[i];
               array[i] = array[i - 1];
               array[i - 1] = obj;
               newn = i;
            }
         }
         n = newn;
      }
   }

   public static <T extends Comparable<? super T>> void selectionSort(T[] array)
   {
      T obj;
      int iMin;

      for(int i = 0; i < array.length - 1; i++)
      {
         iMin = i;
         for(int j = i + 1; j < array.length; j++)
         {
            if(array[iMin].compareTo(array[j]) > 0)
            {
               iMin = j;
            }
         }
         obj = array[iMin];
         array[iMin] = array[i];
         array[i] = obj;
      }
   }

   public static <T extends Comparable<? super T>> void insertionSort(T[] array)
   {
      T obj;
      int j;

      for(int i = 1; i < array.length; i++)
      {
         obj = array[i];
         j = i - 1;
         while(j >= 0 && array[j].compareTo(obj) > 0)
         {
            array[j + 1] = array [j];
            j = j - 1;
         }
         array[j + 1] = obj;
      }
   }
}
