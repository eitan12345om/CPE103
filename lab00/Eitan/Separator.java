import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class will separate input.
 *
 * @author Eitan Simler
 * @version Lab00
 */

public class Separator {
   public static final int N = 6;
   
   // Main method
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      ArrayList<Integer> intList = new ArrayList<>();
      ArrayList<Float> floatList = new ArrayList<>();
      boolean keepGoing = true;

      while (keepGoing) {
         // Integer input
         if (scan.hasNextInt()) {
            if (intList.size() < N) {
               intList.add(scan.nextInt());
            }
            else {
               keepGoing = false;
            }
         }
         // Non-integer number input
         else if (scan.hasNextFloat()) {
            if (floatList.size() < N) {
               floatList.add(scan.nextFloat());
            }
            else {
               keepGoing = false;
            }
         }
         // Non-number input
         else {
            keepGoing = false;
         }
      }

      scan.close();   // Close scanner for memory
      
      // Print integer and float lists to screen 
      System.out.print("\nIntegers:");
      print(intList);
      System.out.print("\nFloats:");
      print(floatList);
      System.out.println();
   }

   // Helper function
   public static <T> void print(ArrayList<T> arr) {
      for (T element : arr) {
         System.out.print(" " + element);
      }
   }

}
