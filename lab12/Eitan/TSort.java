/**
 * Provided starting point for Java-based tsort.
 *
 * @author Hatalsky/Jones - Starting point.
 * @author Eitan Simler
 *
 * @version Lab12
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
      Scanner scan = new Scanner(edges);
      ArrayList<Vertex> vertices = new ArrayList<>();
      
      // Check if edges is empty string
      if (!scan.hasNext()) {
         throw new IllegalArgumentException("input contains no edges");
      }

      // Add all vertices 
      String vertex;
      String adjacent;
      // Loop through files
      while (scan.hasNext()) {
         vertex = scan.next();
         
         // See if there is adjacent
         try {
            adjacent = scan.next();
         }
         // No adjacent means odd number for edges. Exception thrown
         catch (NoSuchElementException e) {
            throw new IllegalArgumentException("input contains an odd number of tokens");
         }
         
         // Puts vertex in list if not already there
         putVertexInList(vertex, vertices, adjacent);
      }

      scan.close();
      
      Stack<Vertex> stack = new Stack<>();

      // Push vertices with inDegree 0 to stack
      for (Vertex v : vertices) {
         if (v.inDegree == 0) {
            stack.push(v);
         }
      }

      StringBuilder theString = new StringBuilder();

      while (!stack.empty()) {
         Vertex v = stack.pop();
         vertices.remove(v);
         theString.append(v.name + "\n");

         // Reduce inDegree for each adjacent
         for (Vertex adj : v.adjacents) {
            adj.inDegree--;
            // Add vertices with inDegree of 0           
            if (adj.inDegree == 0) {
               stack.push(adj);
            }
         }
      }

      // Check if graph contains a cycle
      if (vertices.size() != 0) {
         throw new IllegalArgumentException("input contains a loop");
      }

      return theString.toString();
   }

   private static void putVertexInList(String v, ArrayList<Vertex> vertices, String adjacent) {
      // Loop through the vertices list
      for (Vertex vert : vertices) {
         // Check if vertex in vertices list
         if (v.equals(vert.name)) {
            // Create new adjacent if doesn't already exist
            vert.adjacents.add(adjacentInList(adjacent, vertices));
            return;
         }
      }
      // Vertex not in list
      Vertex newVert = new Vertex(v);
      newVert.adjacents.add(adjacentInList(adjacent, vertices));
      vertices.add(newVert);
   }

   private static Vertex adjacentInList(String adjacent, ArrayList<Vertex> vertices) {
      // Loop through vertices
      for (Vertex vert : vertices) {
         // Check if adjacent in vertices list
         if (adjacent.equals(vert.name)) {
            vert.inDegree++;
            return vert;
         }
      }
      // Create new vertex and increment indegree;
      Vertex newVert = new Vertex(adjacent);
      newVert.inDegree++;
      vertices.add(newVert);
      return newVert;
   }

   private static class Vertex {
   
      // Instance variables
      private int inDegree;
      private ArrayList<Vertex> adjacents = new ArrayList<>();
      private String name;

      // Constructor
      public Vertex(String name) {
         this.name = name;
      }
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
         System.out.print(tsort(input.toString()));
      } catch(IllegalArgumentException e) {
         System.out.println("TSort: " + e.getMessage());
         System.exit(1);
      }
   }
}
