import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

/**
 * JUnit tests for Huffman.
 *
 * @author Eitan Simler
 * @version Project6
 */

public class HuffmanTests {

   @Test (expected = FileNotFoundException.class)
   public void test_FileNotFound() throws FileNotFoundException, IOException {
      Huffman huff = new Huffman("hello.txt");
   }

   @Test
   public void test_toString() throws FileNotFoundException, IOException {
      Huffman huff = new Huffman("textfile.txt");
      assertEquals("|acb|", huff.toString());
   }
   
   @Test
   public void test_toString2() throws FileNotFoundException, IOException {
      Huffman huff = new Huffman("textfile2.txt");
      assertEquals("| bdca|", huff.toString());
   }

   @Test
   public void test_decompress() throws FileNotFoundException, IOException {
      Huffman huff = new Huffman("textfile.txt");
      huff.decompress("compressed.txt", "decompressed.txt");
      
      Scanner scan1 = new Scanner(new File("decompressed.txt"));
      Scanner scan2 = new Scanner(new File("textfile.txt"));
      
      assertEquals(scan2.nextLine(), scan1.nextLine());
   }

   @Test
   public void test_decompress2() throws FileNotFoundException, IOException {
      Huffman huff = new Huffman("textfile2.txt");
      huff.decompress("compressed2.txt", "decompressed2.txt");
      
      Scanner scan1 = new Scanner(new File("decompressed2.txt"));
      Scanner scan2 = new Scanner(new File("textfile2.txt"));
      
      assertEquals(scan2.nextLine(), scan1.nextLine());
   }
   
   @Test
   public void test_compress() throws FileNotFoundException, IOException {
      Huffman huff = new Huffman("textfile.txt");
      huff.compress("textfile.txt", "textfile_compressed.txt");
      
      Scanner scan1 = new Scanner(new File("textfile_compressed.txt"));
      Scanner scan2 = new Scanner(new File("compressed.txt"));
      
      assertEquals(scan2.nextLine(), scan1.nextLine());
   }

   @Test
   public void test_compress2() throws FileNotFoundException, IOException {
      Huffman huff = new Huffman("textfile2.txt");
      huff.compress("textfile2.txt", "textfile_compressed2.txt");
      
      Scanner scan1 = new Scanner(new File("textfile_compressed2.txt"));
      Scanner scan2 = new Scanner(new File("compressed2.txt"));
      
      assertEquals(scan2.nextLine(), scan1.nextLine());
   }
}
