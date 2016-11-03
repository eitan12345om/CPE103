/**
 * A partial implementation of a command-line program to compare running times
 * of a good O(1) stack implementation (SimpleArrayStack) versus a bad O(N)
 * stack implementation (BadStack) using System timer methods.
 *
 * The command-line processing is provided. You must complete the timing code.
 *
 * @author Brian Jones
 * @version 10/1/2016 - CPE 103 Lab 4
 */

public class StackTime {
   private static final String
      U1 = "Usage: java StackTime operation order N\n";

   private static final String
      U2 = "Where: operation is either \"push\" or \"pop\"\n";

   private static final String
      U3 = "Where: order is either \"1\" or \"N\"\n";

   private static final String
      U4 = "  And: N is the number of push/pops to perform";

   private static final String USAGE = U1 + U2 + U3 + U4;

   public static void main(String[] args) {
      verifyCommandLine(args);

      String operation = args[0];
      String order = args[1];
      int n = Integer.valueOf(args[2]);

      if (operation.equals("push")) {
         if (order.equals("1")) {
            runOrder1PushTest(n);
         } else {
            runOrderNPushTest(n);
         }
      } else {
         if (order.equals("1")) {
            runOrder1PopTest(n);
         } else {
            runOrderNPopTest(n);
         }
      }
   }
   
   private static void runOrder1PushTest(int n) {
      SimpleArrayStack<Integer> stack = new SimpleArrayStack<>();
      
      long tm = System.nanoTime();
      for (int i = 0; i < n; i++) {
         stack.push(i);
      }
      long total = System.nanoTime() - tm;
      long avg = total / (long) n; 
      System.out.println(avg + " ns"); 
   }
   
   private static void runOrder1PopTest(int n) {
      SimpleArrayStack<Integer> stack = new SimpleArrayStack<>();

      for (int i = 0; i < n; i++) {
         stack.push(i);
      }

      long tm = System.nanoTime();
      for (int i = 0; i < n; i++) {
         stack.pop();
      }
      long total = System.nanoTime() - tm;
      long avg = total / (long) n; 
      System.out.println(avg + " ns"); 
   }

   private static void runOrderNPushTest(int n) {
      BadStack<Integer> stack = new BadStack<>();
      
      long tm = System.nanoTime();
      for (int i = 0; i < n; i++) {
         stack.push(i);
      }
      long total = System.nanoTime() - tm;
      long avg = total / (long) n;
      System.out.println(avg + " ns"); 
   }
   
   private static void runOrderNPopTest(int n) {
      BadStack<Integer> stack = new BadStack<>();
      
      for (int i = 0; i < n; i++) {
         stack.push(i);
      }

      long tm = System.nanoTime();
      for (int i = 0; i < n; i++) {
         stack.pop();
      } 
      long total = System.nanoTime() - tm;
      long avg = total / (long) n;
      System.out.println(avg + " ns"); 
   }

   private static void verifyCommandLine(String[] args) {
      if (args.length != 3) {
         // Display USAGE and terminate the program...
         System.out.println(USAGE);
         System.exit(1);
      }
  
      if ( !(args[0].equals("push") || args[0].equals("pop")) ) {
         // Display USAGE and terminate the program...
         System.out.println(USAGE);
         System.exit(1);
      }

      if ( !(args[1].equals("1") || args[1].equals("N")) ) {
         // Display USAGE and terminate the program...
         System.out.println(USAGE);
         System.exit(1);
      }

      try {
         Integer.valueOf(args[2]);
      } catch(NumberFormatException e) {
         // Display USAGE and terminate the program...
         System.out.println(USAGE);
         System.exit(1);
      }

      // If we get here we have a good invocation of the program!
   }
}
