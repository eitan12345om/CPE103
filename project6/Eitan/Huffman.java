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
   private HashMap<Integer, String> map = new HashMap<>();

   // Constructor
   public Huffman(String fileName) throws FileNotFoundException, IOException {
      // File reader
      BufferedReader in = new BufferedReader(new FileReader(fileName));
   
      // Extract to HashMap then fill PriorityQueue
      extractToHashMap(in);
      in.close();

      // Create PriorityQueue with tree
      makeTree();

      // Generate codes for compress
      makeCodes(pq.peek(), ""); 
   }

   // Methods
   public void compress(String infileName, String outfileName) throws
      FileNotFoundException, IOException {
      BufferedReader in = new BufferedReader(new FileReader(infileName));
      BufferedWriter out = new BufferedWriter(new FileWriter(outfileName));

      int c;
      String value;
      // Go through file one character at a time
      while ((c = in.read()) != -1) {
         // Get object at value
         value = map.get(c);
         out.write(value, 0, value.length());
      }

      in.close();
      out.close();
   }

   public void decompress(String infileName, String outfileName) throws
      FileNotFoundException, IOException {
      BufferedReader in = new BufferedReader(new FileReader(infileName));
      BufferedWriter out = new BufferedWriter(new FileWriter(outfileName));

      int c;
      Node node = pq.peek();
      // Go through file one character at a time
      while ((c = in.read()) != -1) {
         // Check if go left or right
         if ((char) c == '0') {
            node = node.left;
         }
         else {
            node = node.right;
         }

         // Check if at leaf node
         if (node.value != null) {
            out.write((int) node.value);
            // reset node
            node = pq.peek(); 
         }
      }

      in.close();
      out.close();
   }

   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("|");
      toString(pq.peek(), sb);
      sb.append("|");     
      return sb.toString();
   }

   private void extractToHashMap(BufferedReader in) throws IOException {
      HashMap<Character, Node> hMap = new HashMap<>();
        
      int c;
      Node node;
      Character ch;
      // Go through file one character at a time
      while ((c = in.read()) != -1) {
         ch = (char) c;
         
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

   private void makeCodes(Node node, String code) {
      if (node.value != null) {
         map.put((int) node.value, code.toString());
      }
      else {
         makeCodes(node.left, new String(code + "0"));
         makeCodes(node.right, new String(code + "1"));
      }
   }

   private void toString(Node node, StringBuilder sb) {
      // Recursive method to to print pre-order of tree
      if (node.value == null) {
         toString(node.left, sb);
         toString(node.right, sb); 
      }
      else {
         sb.append(node.value);
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
