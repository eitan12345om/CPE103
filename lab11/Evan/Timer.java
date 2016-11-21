/**
 * A class to do timing for ShellSorts.
 *
 * @author Evan Jameson
 * @version Lab11
 */

import java.util.Random;

public class Timer
{

   private static Random rand = new Random(100);

   public static void main(String[] args) 
   {
      String operation = args[0];
      int order = Integer.valueOf(args[1]);

      if (operation.equals("shell")) 
      {
         shell(order);  
      }
      else if (operation.equals("hibbard")) 
      {
         hibbard(order);
      }
      else if (operation.equals("sedgewick")) 
      {
         sedgewick(order);
      }
      else if (operation.equals("heap")) 
      {
         heap(order);
      }
   }

   private static void shell(int order) 
   {
      Integer[] arr = new Integer[order];
      for (int i = 0; i < order; i++) 
      {
         arr[i] = rand.nextInt();
      }
      
      long tm = System.currentTimeMillis();

      ShellSorts.shell(arr);

      long total = System.currentTimeMillis() - tm;

      System.out.println("time: " + total);
   }
   
   private static void hibbard(int order) 
   {
      Integer[] arr = new Integer[order];
      for (int i = 0; i < order; i++) 
      {
         arr[i] = rand.nextInt();
      }
      
      long tm = System.currentTimeMillis();

      ShellSorts.hibbard(arr);

      long total = System.currentTimeMillis() - tm;

      System.out.println("time: " + total);
   }
   
   private static void sedgewick(int order) 
   {
      Integer[] arr = new Integer[order];
      for (int i = 0; i < order; i++) 
      {
         arr[i] = rand.nextInt();
      }
      
      long tm = System.currentTimeMillis();

      ShellSorts.sedgewick(arr);

      long total = System.currentTimeMillis() - tm;

      System.out.println("time: " + total);
   }
   
   private static void heap(int order) 
   {
      Integer[] arr = new Integer[order];
      for (int i = 0; i < order; i++) 
      {
         arr[i] = rand.nextInt();
      }
      
      long tm = System.currentTimeMillis();

      ShellSorts.heapSort(arr);

      long total = System.currentTimeMillis() - tm;

      System.out.println("time: " + total);
   }
}
