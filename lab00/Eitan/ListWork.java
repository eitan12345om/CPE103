import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class will do some work on lists.
 *
 * @author Eitan Simler
 * @version Lab00
 */

public final class ListWork {
   
   // Main method
   public static void main(String[] args) {
      Integer[] arr = new Integer[10];
      Scanner scan = new Scanner(System.in);
      int index = 0;
      String searchNumber = "Y";
      int target = 0;

      // Retrieving Integers for Array
      while (arr[9] == null) {
         System.out.print("Write your Integers here: "); 
         try {
            arr[index] = scan.nextInt();
         }
         // Catch non-integer inputs
         catch (InputMismatchException e) {
            // Removes non-integer from scanner
            scan.next();
            index -= 1;
         }
         index++;
      }

      // Ask user if they want to search
      while (searchNumber != null) {   
         
         scan.nextLine();   // Flush input from scanner

         try {
            System.out.print("Would you like to search (Y or N)? ");
            searchNumber = scan.next();
         }
         // Catch non-String inputs
         catch (InputMismatchException e) {
            System.out.println("Only 'Y' or 'N' please\n");
         }
         if (searchNumber.equals("Y")) {
            while (true) {
               
               scan.nextLine();   // Flush input from scanner
               
               try {
                  System.out.print("\nNumber to search for: ");
                  target = scan.nextInt();
                  System.out.println("Number in list? " + search(arr, target));
                  break;
               }
               catch (InputMismatchException e) {
                  System.out.println("Error: Not an Integer");
                  break;
               }
            }
         }
         else {
            searchNumber = null;;
         }
      }

      System.out.println("\n___The List___");
      print(arr);

      scan.close();
   }

   // Generic Methods
   public static <T> void print(T[] arr) {
      for (T element : arr) {
         System.out.println(element);
      }
   }

   public static <T> boolean search(T[] arr, T target) { 
      for (T element : arr) {
         if (target == null || element == null) {
            if (target == element) {
               return true;
            }
         }
         else {
            if (element.equals(target)) {
               return true;
            }
         }
      }
      return false;
   }
}
