/**
 * Provided starting point for Java-based tsort.
 *
 * @author Hatalsky/Jones - Starting point.
 * @author ? - Completed by.
 *
 * @version CPE 103 Lab 12
 */
import java.io.*;
import java.util.*;

public class TSort {
   // Hides the constructor form javadoc utility and users.
   private TSort() {}

   /**
    * Performs a topological sort of the specified directed acyclic graph.  The
    * graph is given as a string containing pairs of vertices representing
    * edges separated by spaces.  The resulting string will be formatted
    * identically to the Unix utility {@code tsort}.  That is, one vertex per
    * line in topologically sorted order.
    *
    * @param edges the edges of the DAG specified as space separated
    * vertex-pairs
    *
    * @return a topological ordering for the specified DAG
    *
    * @throws IllegalArgumentException if:
    * <ul>
    *   <li>edges is emtpy with the message "input contains no edges"</li>
    *   <li>edges has an odd number of vertices (incomplete pair) with the
    *   message "input contains an odd number of tokens"</li>
    *   <li>the graph contains a cycle (isn't acyclic) with the message "input
    *   contains a loop"</li>
    * </ul>
    */
   public static String tsort(String edges) {
      return "TODO by you!";
   }

   /**
    * Entry point for the Java-based tsort utility allowing the user to specify
    * a file, redirect a file, or specify the input manually followed by
    * cntl-d to signal the end of input.
    */
   public static void main(String[] args) {
      Scanner scanner = null;

      if (args.length == 0) {
         scanner = new Scanner(System.in);
      } else if (args.length == 1) {
         try {
            scanner = new Scanner(new File(args[0]));
         } catch(FileNotFoundException e) {
            System.out.format("TSort: %s: No such file or directory\n", args[0]);
            System.exit(1);
         }
      } else {
         System.out.format("TSort: extra operand `%s'\n", args[1]);
         System.exit(1);
      }

      StringBuilder input = new StringBuilder();

      while(scanner.hasNext()) {
         input.append(scanner.next() + " ");
      }

      scanner.close();

      try {
         System.out.println(tsort(input.toString()));
      } catch(IllegalArgumentException e) {
         System.out.print("TSort: " + e.getMessage());
         System.exit(1);
      }
   }
}