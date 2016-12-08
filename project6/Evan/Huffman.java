/**
 *Huffman class
 *
 *
 *
 *@author Evan Jameson
 *@version Project 6
 */

import java.io.*;
import java.util.*;

public class Huffman 
{
   private PriorityQueue<Node> que = new PriorityQueue<>();
   private HashMap<Integer, String> map = new HashMap<>();

   public Huffman(String fileName) throws FileNotFoundException, IOException
   {
      BufferedReader in  = new BufferedReader(new FileReader(fileName));
      extractMap(in);
      in.close();
      createTree();
      createCodes(que.peek(), "");
   }

//=======================================================================================================

   private void extractMap(BufferedReader in) throws IOException
   {
      HashMap<Character, Node> hash = new HashMap<>();
      int num;
      Node node;
      Character chr;

      while((num = in.read()) != -1)
      {
         chr = (char) num;
         node = hash.get(chr);

         if(node == null)
         {
            hash.put(chr, new Node(chr));
         }
         else
         {
            node.frequency++;
         }
      }
      fillQueue(hash);
   }
   private void fillQueue(HashMap<Character, Node> hMap)
   { 
      for(Node node: hMap.values())
      {
         que.add(node);
      }
   }

   private void createTree()
   {
      Node node1;
      Node node2;

      while(que.size() > 1)
      {
         node1 = que.peek();
         que.remove(node1);
         node2 = que.peek();
         que.remove(node2);
         que.add(new Node(node1.frequency + node2.frequency, node1, node2));
      }
   }

   private void createCodes(Node node, String code)
   {
      if(node.value != null)
      {
         map.put((int) node.value, code.toString());
      }
      else
      {
         createCodes(node.left, new String(code + "0"));
         createCodes(node.right, new String(code + "1"));
      }
   }

   private void toString(Node node, StringBuilder build)
   {
      if(node.value == null)
      {
         toString(node.left, build);
         toString(node.right, build);
      }
      else
      {
         build.append(node.value);
      }
   }

//=======================================================================================================

   public void compress(String infileName, String outfileName) throws FileNotFoundException, IOException
   {
         BufferedReader in = new BufferedReader(new FileReader(infileName));
         BufferedWriter out = new BufferedWriter(new FileWriter(outfileName));

         int num;
         String val;

         while((num = in.read()) != -1)
         {
	    //System.out.println(num);
            val = map.get(num);
	    //System.out.println(val);
            out.write(val, 0, val.length());
         }
         in.close();
         out.close();
   }

   public void decompress(String infileName, String outfileName) throws FileNotFoundException, IOException
   {
      BufferedReader in = new BufferedReader(new FileReader(infileName));
      BufferedWriter out = new BufferedWriter(new FileWriter(outfileName));

      int num;
      Node node = que.peek();

      while((num = in.read()) != -1)
      {
         if((char) num == '0')
         {
            node = node.left;
         }
         else
         {
            node = node.right;
         }
         if(node.value != null)
         {
            out.write((int) node.value);
            node = que.peek();
         }
      }
      in.close();
      out.close();
   }

//=======================================================================================================

   public String toString()
   {
      StringBuilder build = new StringBuilder();
      build.append("|");
      toString(que.peek(), build);
      build.append("|");
      return build.toString();
   }



   private class Node implements Comparable<Node>
   {
      private Character value;
      private int frequency;
      private Node right, left;
      private Character minChar;

      public Node(Character value)
      {
         this.value = value;
         this.minChar = value;
         this.frequency = 1;
      }

      public Node(int frequency, Node left, Node right)
      {
         this.left = left;
         this.right = right;
         this.frequency = frequency;
         this.minChar = left.minChar.compareTo(right.minChar) < 0 ? left.minChar 
            : right.minChar;
      }
      
      @Override
      public int compareTo(Node other)
      {
         int result = frequency - other.frequency;

         if(result == 0)
         {
            return minChar.compareTo(other.minChar);
         }
         return result;
      }
   }
}
