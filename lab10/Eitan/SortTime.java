/**
 * A class to do timing for QuadraticSorts.
 *
 * @author Eitan Simler
 * @version Lab10
 */

import java.util.Random;

public class SortTime {

   private static Random rand = new Random(100);

   public static void main(String[] args) {
      String operation = args[0];
      int order = Integer.valueOf(args[1]);

      if (operation.equals("insertion")) {
         insertion(order);  
      }
      else if (operation.equals("selection")) {
         selection(order);
      }
      else if (operation.equals("bubble1")) {
         bubble1(order);
      }
      else if (operation.equals("bubble2")) {
         bubble2(order);
      }
   }

   private static void insertion(int order) {
      Integer[] arr = new Integer[order];
      for (int i = 0; i < order; i++) {
         arr[i] = rand.nextInt();
      }
      
      long tm = System.currentTimeMillis();

      QuadraticSorts.insertionSort(arr);

      long total = System.currentTimeMillis() - tm;

      System.out.println("time: " + total);
   }
   
   private static void selection(int order) {
      Integer[] arr = new Integer[order];
      for (int i = 0; i < order; i++) {
         arr[i] = rand.nextInt();
      }
      
      long tm = System.currentTimeMillis();

      QuadraticSorts.selectionSort(arr);

      long total = System.currentTimeMillis() - tm;

      System.out.println("time: " + total);
   }
   
   private static void bubble1(int order) {
      Integer[] arr = new Integer[order];
      for (int i = 0; i < order; i++) {
         arr[i] = rand.nextInt();
      }
      
      long tm = System.currentTimeMillis();

      QuadraticSorts.bubbleSort1(arr);

      long total = System.currentTimeMillis() - tm;

      System.out.println("time: " + total);
   }
   
   private static void bubble2(int order) {
      Integer[] arr = new Integer[order];
      for (int i = 0; i < order; i++) {
         arr[i] = rand.nextInt();
      }
      
      long tm = System.currentTimeMillis();

      QuadraticSorts.bubbleSort2(arr);

      long total = System.currentTimeMillis() - tm;

      System.out.println("time: " + total);
   }
}
