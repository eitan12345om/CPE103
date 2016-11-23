/**
 * A class to do timing for ShellSorts.
 *
 * @author Eitan Simler
 * @version Lab11
 */

import java.util.Random;

public class SortTime {

   private static Random rand = new Random(100);

   public static void main(String[] args) {
      String operation = args[0];
      int order = Integer.valueOf(args[1]);

      if (operation.equals("shell")) {
         shell(order);  
      }
      else if (operation.equals("hib")) {
         hibbard(order);
      }
      else if (operation.equals("sedge")) {
         sedgewick(order);
      }
      else if (operation.equals("heap")) {
         heapSort(order);
      }
   }

   private static void shell(int order) {
      Integer[] arr = new Integer[order];
      for (int i = 0; i < order; i++) {
         arr[i] = rand.nextInt();
      }
      
      long tm = System.currentTimeMillis();
         
      ShellSorts.shell(arr);

      long total = System.currentTimeMillis() - tm;

      System.out.println("time: " + total);
   }
   
   private static void hibbard(int order) {
      Integer[] arr = new Integer[order];
      for (int i = 0; i < order; i++) {
         arr[i] = rand.nextInt();
      }
      
      long tm = System.currentTimeMillis();

      ShellSorts.hibbard(arr);

      long total = System.currentTimeMillis() - tm;

      System.out.println("time: " + total);
   }
   
   private static void sedgewick(int order) {
      Integer[] arr = new Integer[order];
      for (int i = 0; i < order; i++) {
         arr[i] = rand.nextInt();
      }
      
      long tm = System.currentTimeMillis();

      ShellSorts.sedgewick(arr);

      long total = System.currentTimeMillis() - tm;

      System.out.println("time: " + total);
   }
   
   private static void heapSort(int order) {
      Integer[] arr = new Integer[order];
      for (int i = 0; i < order; i++) {
         arr[i] = rand.nextInt();
      }
      
      long tm = System.currentTimeMillis();

      ShellSorts.heapSort(arr);

      long total = System.currentTimeMillis() - tm;

      System.out.println("time: " + total);
   }
}
