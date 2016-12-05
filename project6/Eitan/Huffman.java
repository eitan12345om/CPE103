import java.util.*;
import java.io.*;

/**
 * Performs encoding and decoding with the Huffman algorithm.
 *
 * @author Eitan Simler
 * @version Project6
 */

public class Huffman {

   // Instance variable
   private PriorityQueue<Node> pq = new PriorityQueue<>();

   // Constructor
   public Huffman(String fileName) throws FileNotFoundException, IOException {
      // File reader
      BufferedReader in = new BufferedReader(new FileReader(fileName));
   
      // Fill PriorityQueue
      extractToArrayList(in);

      in.close();
   }

   // Methods
   public void compress(String infileName, String outfileName) {
      // TODO: Add method body
   }

   public void decompress(String infileName, String outfileName) {
      // TODO: Add method body
   }

   public String toString() {
      // TODO: Add method body
      return "";
   }

   private void extractToArrayList(BufferedReader in) throws IOException {
      ArrayList<Node> list = new ArrayList<>();
      
      int c;
      // Go through file one character at a time
      while ((c = in.read()) != -1) {
         // Check if reached end of file
         if (c == -1) {
            break;
         }
         
         char ch = (char) c;
         
         int index = list.indexOf(new Node(ch));
         // Returns index at which Node is stored or -1 if not found
         if (index == -1) {
            list.add(new Node(ch));
         }
         else {
            list.get(index).frequency++;
         }
      }
     
      fillPriorityQueue(list);
   }

   private void fillPriorityQueue(ArrayList<Node> list) {
      for (Node node : list) {
         pq.add(node);
      }
   }

   // For testing
   public void printPQ() {
      System.out.println("\nPQ size: " + pq.size());
      Node node;
      while (pq.size() != 0) {
         node = pq.peek();
         System.out.println("Value: " + node.value + ", frequency: " + node.frequency);
         pq.remove(node);
      }
   }

   // Private class to represent node
   private class Node implements Comparable<Node> {
   
      // Instance variables
      private Character value;
      private int frequency;

      // Constructor
      public Node(Character value) {
         this.value = value;
         this.frequency = 1;
      }

      // Compare the values of the nodes
      @Override
      public int compareTo(Node other) {
         int result = frequency - other.frequency;

         // Check if the frequencies are the same. Sort by ASCII.
         if (result == 0) {
            return value.compareTo(other.value);
         }
         
         return result;
      }

      // Determine if two nodes are equal by value
      @Override
      public boolean equals(Object other) {
         if (other == null) {
            return false;
         }

         Node o = (Node) other;
         return value.equals(o.value);
      }
   }
}
