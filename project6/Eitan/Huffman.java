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
   
      // Extract to HashMap then fill PriorityQueue
      extractToHashMap(in);
      in.close();

      // Create PriorityQueue with tree
      makeTree();
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

   private void extractToHashMap(BufferedReader in) throws IOException {
      HashMap<Character, Node> hMap = new HashMap<>();
        
      int c;
      Node node;
      // Go through file one character at a time
      while ((c = in.read()) != -1) {
         Character ch = (char) c;
         
         node = hMap.get(ch);
         
         if (node == null) {
            hMap.put(ch, new Node(ch));
         }
         else {
            node.frequency++;
         }
      }
     
      fillPriorityQueue(hMap);
   }

   private void fillPriorityQueue(HashMap<Character, Node> hMap) {
      for (Node node : hMap.values()) {
         pq.add(node);
      }
   }

   private void makeTree() {
      Node node1, node2;
      while (pq.size() > 1) {
         // Assign node1 and node2 and remove from pq
         node1 = pq.peek();
         pq.remove(node1);
         node2 = pq.peek();
         pq.remove(node2);

         // Create new internal node
         pq.add(new Node(node1.frequency + node2.frequency, node1, node2));
      } 
   }

   // Private class to represent node
   private class Node implements Comparable<Node> {
   
      // Instance variables
      private Character value;
      private int frequency;
      private Node right, left;
      private Character minChar;

      // Constructors
      public Node(Character value) {
         this.value = value;
         this.minChar = value;
         this.frequency = 1;
      }

      public Node(int frequency, Node left, Node right) {
         this.frequency = frequency;
         this.left = left;
         this.right = right;
         this.minChar = left.minChar.compareTo(right.minChar) < 0 ? left.minChar
            : right.minChar; 
      }

      // Compare the values of the nodes
      @Override
      public int compareTo(Node other) {
         int result = frequency - other.frequency;

         // Check if the frequencies are the same. Sort by ASCII.
         if (result == 0) {
            return minChar.compareTo(other.minChar);
         }
         
         return result;
      }
   }
}
