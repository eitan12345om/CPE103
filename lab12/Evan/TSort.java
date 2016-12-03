/**
 * Provided starting point for Java-based tsort.
 *
 * @author Hatalsky/Jones - Starting point.
 * @author Evan Jameson - Completed by.
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



   //-----------------------------------------------------------------------------
   public static String tsort(String edges) 
   {
      Scanner s = new Scanner(edges);
      if(!s.hasNext())
      {
         throw new IllegalArgumentException("input contains no edges");
      }
      else if(oddVert(edges))
      {
         throw new IllegalArgumentException("input contains an odd number of tokens");
      }
      else
      {
         ArrayList<Vertex> vertecies = new ArrayList<>();
        // Scanner s = new Scanner(edges);
         while(s.hasNext())
         {
            String check = s.next();
            if(vertecies.size() != 0)
            {
               boolean fudge = true;
               while(fudge)
               {

                  for(Vertex vert: vertecies)
                  {
                     if(check.equals(vert.name))
                     {
                        fudge = false; 
                     }
                  }
                  if(fudge)
                  {
                     Vertex v = new Vertex(check);//only gets here if not yet seen
                     vertecies.add(v);
                  }
                  fudge = false;
               }
            }
            if(vertecies.size() == 0)
            {
               Vertex v = new Vertex(check);
               vertecies.add(v);
            }
         }
         s.close();

         //now we have a list of the unique verticies
         for(Vertex vert: vertecies)
         {
            //System.out.print(vert.name + " " );  
         }

         Scanner last= new Scanner(edges);
         while(last.hasNext())
         {
            String check1 = last.next();
            String check2 = last.next();
            int i = 0;
            int j = 0;
            for(Vertex vert: vertecies)
            {
               if(check1.equals(vert.name))
               {
                  i = vertecies.indexOf(vert);
               }
               if(check2.equals(vert.name))
               {
                  j = vertecies.indexOf(vert);
               }
            }
            buildAdj(vertecies.get(i), vertecies.get(j));
         }
         last.close();

         //now we have list of unique vertex objects and they all contain their aadjacencies
         
         Stack<Vertex> stack = new Stack<>();
         StringBuilder output = new StringBuilder();
         for(Vertex vert: vertecies)
         {
            if(vert.inDegree == 0)
            {
               stack.push(vert);
            }
         }
         while(!stack.empty())
         {
            Vertex v = stack.pop();
            output.append(v.name + "\n");
            for(Vertex vert: v.adj)
            {
               vert.inDegree -= 1 ;
               if(vert.inDegree == 0)
               {
                  stack.push(vert);
               }
            }
         }


      return output.toString();
      }
   }
   //use a hash map to store stuff but also keep an arraylist of the verticies to keep them in order
   //-----------------------------------------------------------------------------
   
   


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
   //-----------------------------------------------------------------------------
   //private helper methods
 
   //returns true if the edges has an odd number of vertecies
   private static boolean oddVert(String edges)
   {
      int num = 0;
      Scanner scan = new Scanner(edges);
      while(scan.hasNext())
      {
         num += 1;
         scan.next();
      }
      scan.close();
      if(num%2 == 1)
      {
         return true;
      }
      return false;
   }

   //
   private static void buildAdj(Vertex vert1,Vertex vert2)
   {
      
      for(Vertex vert: vert2.adj)
      {
         if(vert1.name.equals(vert.name))
         {
           throw new IllegalArgumentException("input contains a loop");
         }

      }
      vert1.adj.add(vert2);
      vert2.inDegree += 1;
      
   }

   //-----------------------------------------------------------------------------
   private static class Vertex
   {
      ArrayList<Vertex> adj = new ArrayList<>(); //list of adjacent vertecies
      int inDegree = 0;     //in degree #
      String name;

      public Vertex(String name) 
      {
         this.name = name;
      }
   }
}
