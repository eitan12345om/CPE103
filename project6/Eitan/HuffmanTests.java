import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;

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
   public void test_ArrayList() throws FileNotFoundException, IOException {
      Huffman huff = new Huffman("textfile.txt");
   }
   
   @Test
   public void test_ArrayList2() throws FileNotFoundException, IOException {
      Huffman huff = new Huffman("textfile2.txt");
   }
}
