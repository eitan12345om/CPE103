/**
 * A partial implementation of a directed graph class to explore
 * Dijkstra's shortest-path algorithm.
 *
 * @author Hatalsky/Jones - Provided partial solution
 * @author Evan Jameson - Completed by
 * @version CPE 103 Lab 13
 */

import java.io.*;
import java.util.*;

public class DiGraph {
   /* Provided/Required */
   private TreeMap<String, Vertex> vertices = new TreeMap<String, Vertex>();

   /* Provided/Required - should not need to modify
    * The edge class is used such that we may store the weights easily. */
   private static class Edge {
      private Vertex dest;
      private double weight;

      public Edge(Vertex dest, double weight) {
         this.dest = dest;
         this.weight = weight;
      }
   }

   //===================================================================================================

   /* Provided/Required - should not need to modify */
   private static class Vertex implements Comparable<Vertex> {
      private String name;
      private TreeMap<String, Edge> edges = new TreeMap<String, Edge>();
      private boolean known;
      private double distance = Double.POSITIVE_INFINITY;
      private Vertex prior;

      public Vertex(String name) {
         this.name = name;
      }

      public void addEdge(Vertex adj, double weight) {
         // TreeMap put() returns null when no matching element in tree 
         if (edges.put(adj.name, new Edge(adj, weight)) != null) {
            throw new IllegalArgumentException("Duplicate edge");
         }
      }

      // Used by priority queue used in Dikstra's shortest path algorithm.
      public int compareTo(Vertex that) {
         return ((Double)this.distance).compareTo(that.distance);
      }

      public String toString() {
         return this.name;
      }

      // For debugging purposes if and as necessary...
      public String debugToString() {
         StringBuilder sb = new StringBuilder()
            .append("Vertex name: ").append(name)
            .append("\nKnown: ").append(known)
            .append("\nPrior: ").append(prior)
            .append("\nDistance: ").append(distance)
            .append("\nAdjacencies:");

         for (String name : edges.keySet()) {
            sb.append(' ').append(name);
         }

         return sb.toString();
      }
   } // End class Vertex

   //===================================================================================================

   /**
    * Constructs a directed graph from a file containing the weighted
    * edges.  A weighted edge is specified as three values, separated
    * by whitespace, in the following order: the from-vertex as a
    * String, the to-vertex as a String, and the weight as a double.
    *
    * @param fileName the name of a file containing the weighted
    * edges (see the method's detailed description for the file's
    * format).
    *
    * @throws FileNotFoundException if the file is not found
    * @throws IllegalArgumentException if:
    * <ul>
    *   <li>the file is empty</li>
    *   <li>the input is mal-formed</li>
    *   <li>the graph contains a negative edge</li>
    * </ul>
    */

	StringBuilder input = new StringBuilder();
	String edges;
   public DiGraph(String fileName) throws FileNotFoundException {
      // TODO: Complete the constructor
      Scanner scanner = new Scanner(new File(fileName));
      while(scanner.hasNext())
      {
         String token = scanner.next();
      	 if(Integer.parseInt(token) < 0)
	 {
	    throw new IllegalArgumentException("the graph contains a negative edge");
	 }
         input.append(token + " ");
      }
      if(input.length() == 0) //not sure if correct method, check javadocs
      {
	  throw new IllegalArgumentException("the file is empty");
      }
      edges = input.toString();
      if(oddVert(edges))
      {
         throw new IllegalArgumentException("the input is malformed");
      }
      scanner.close();
   }

   /**
    * Applies Dijkstra's shortest path algorithm to the graph using
    * the specified vertex as the starting vertex. 
    *
    * @param from The name of the starting vertex.
    *
    * @throws IllegalArgumentException if the specified vertex is not
    * in the graph
    */
   public void setStart(String from) 
   {
      // TODO: Complete setStart

      //Step 1: build Adjacency List
   	

      //Step 2: Initialise the vertecies in the adjacenc list to stuff

      //Step 3: Set the starting vertex's distance to 0 and add it to a minimum priority queue (what does the minimum mean?)

      //Step 4: Algorithm Shit
   }

   /**
    * Provided: Returns a shortest path to the specified vertex from
    * the current start-vertex. 
    *
    * @param to the to-vertex whose path you want
    * @return the path from the current start-vertex to the specified
    * to-vertex
    */
   public String getPathTo(String to) {
      StringBuilder path = new StringBuilder();
      getPathTo(vertices.get(to), path);

      return path.toString();
   }
   
   /*
    * Provided: Recursive helper method for public getPathTo().
    */
   private void getPathTo(Vertex v, StringBuilder path) {
      if (v.prior != null) {
         getPathTo(v.prior, path);
         path.append(' ');
      }

      path.append(v.name);
   }

   /**
    * Provided: Returns the distance of the shortest path to the
    * specified vertex to the current start-vertex. 
    *
    * @param to the to-vertex whose distance you want
    * @return the distance from the current start-vertex to the
    * specified to-vertex
    */
   public double getDistanceTo(String to) {
      return vertices.get(to).distance;
   }

   //====================================================================================================

   private void buildAdj(Vertex vert1, Vertex vert2)
   {
   	for(Edge vert: Collection.toArray(vert2.edges.values()))// edges))
	{
	   if(vert1.name.equals(vert.name))
	   {
	      throw new IllegalArgumentException("input contains a loop");
	   }
	}
	vert1.edges.add(vert2);//<--how the hell do i add to a treemap...
	//Don't think we are working with indegree in this lab
   }

   private boolean oddVert(String edges)
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

}
