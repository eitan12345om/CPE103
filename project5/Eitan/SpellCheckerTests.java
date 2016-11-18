import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

/**
 * JUnit tests for SpellChecker.
 *
 * @author Eitan Simler
 * @version Project5
 */

public class SpellCheckerTests {

   private SpellChecker sp;

   @Test
   public void test_Constructor() throws FileNotFoundException {
      sp = new SpellChecker();
      assertEquals(267119, sp.getDictionary().size());
   }
   
   @Test (expected=FileNotFoundException.class)
   public void test_Constructor_noFile() throws FileNotFoundException {
      sp = new SpellChecker("hello.txt");
   }

   @Test
   public void test_Constructor_customFile() throws FileNotFoundException {
      sp = new SpellChecker("hi.txt");
      assertEquals(1, sp.getDictionary().size());
   }
   
   @Test
   public void test_isWord() throws FileNotFoundException {
      sp = new SpellChecker();

      assertTrue(sp.isWord("Hello"));
      assertTrue(sp.isWord("Hell"));
      assertTrue(sp.isWord("Hair"));
      assertFalse(sp.isWord("UDUSD"));
      assertFalse(sp.isWord("ASDA"));
      assertFalse(sp.isWord("hAAA"));
   }
   
   @Test
   public void test_processFile() throws FileNotFoundException {
      sp = new SpellChecker();
      HashMap<String, SpellChecker.MyStats> prFile = sp.processFile("lyrics.txt");
      assertEquals(5, prFile.get("wonder").getOccurrences());
      assertTrue(listEquals(new Integer[] {16, 17, 26, 27, 41},
               prFile.get("wonder").getLineNumbers()));
      assertTrue(prFile.get("wonder").isWord());
   }

   // Helper method
   private boolean listEquals(Integer[] arr, List<Integer> list) {
      if (arr.length != list.size()) {
         return false;
      }

      for (int i = 0; i < arr.length; i++) {
         if (arr[i] != list.get(i)) {
            return false;
         }
      }

      return true;
   }
}
