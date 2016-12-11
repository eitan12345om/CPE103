/**
 * A partial implementation of a directed graph class to explore
 * Dijkstra's shortest-path algorithm.
 *
 * @author Hatalsky/Jones - Provided partial solution
 * @author Eitan Simler - Completed by
 * @version Lab13
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
   public DiGraph(String fileName) throws FileNotFoundException {
      Scanner lineScan = new Scanner(new File(fileName));
 
      // Check if file is empty
      if (!lineScan.hasNext()) {
         throw new IllegalArgumentException();
      }
      
      Scanner edgeScan = new Scanner("");

      String from, to;
      double weight;
      Vertex vertex;
      
      // Loop through file
      while (lineScan.hasNext()) {
         edgeScan = new Scanner(lineScan.nextLine());
        
         // Check if there is malformed data
         try {
            from = edgeScan.next();
            to = edgeScan.next();
            weight = edgeScan.nextDouble();
         }
         catch (InputMismatchException e) {
            throw new IllegalArgumentException();
         }
         catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
         }

         // Check if weight is negative
         if (weight < 0) {
            throw new IllegalArgumentException();
         }

         // Check if vertex exists in TreeMap
         vertex = vertices.get(from);
         
         if (vertex == null) {
            vertex = new Vertex(from);
            // Add vertex to TreeMap
            vertices.put(vertex.toString(), vertex);
         }
         
         Vertex toVertex = vertices.get(to);
         // Check if toVertex already exists
         if (toVertex == null) {
            toVertex = new Vertex(to);
         }

         // Add edge to adjacents 
         vertex.addEdge(toVertex, weight);
      }

      lineScan.close();
      edgeScan.close();

      for (Vertex v : vertices.values()) {
         System.out.println(v.debugToString());
      }
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
   public void setStart(String from) {
      PriorityQueue<Vertex> pq = new PriorityQueue<>();
      
      // Get starting vertex
      Vertex start = vertices.get(from);
      
      // Check if vertex exists
      if (start == null) {
         throw new IllegalArgumentException();
      }

      start.distance = 0;
      pq.add(start);

      Vertex vertex;
      // While there are unknown vertices
      while (pq.size() != 0) {
         vertex = pq.poll();
         vertex.known = true;

         // For each adjacent
         for(Edge edge : vertex.edges.values()) {
            // If the vertex isn't already known, update distance and prior 
            if (!edge.dest.known) {
               // Check if current distance is more than distance from current vertex
               if (((Double) edge.dest.distance).compareTo(edge.weight + vertex.distance) > 0) {
                  pq.remove(edge.dest);
                  edge.dest.distance = edge.weight + vertex.distance;
                  pq.add(edge.dest);
                  edge.dest.prior = vertex;
               }
            }
         }         
      } 
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
}
