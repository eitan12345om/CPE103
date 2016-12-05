import java.util.*;
import java.io.*;

/**
 * Performs encoding and decoding with the Huffman algorithm.
 *
 * @author Eitan Simler
 * @version Project6
 */

public class Huffman {

   // Constructor
   public Huffman(String fileName) throws FileNotFoundException, IOException {
   
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

   // Private class to represent node
   private class Node implements Comparable<Node> {
   
      // Instance variables
      private Character value;
      private int frequency;

      // Constructor
      public Node(Character value) {
         this.value = value;
      }

      // Compare the values of the nodes
      @Override
      public int compareTo(Node other) {
         return 
      }
   }
}
