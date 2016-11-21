/**
 * JUnit tests for SpellChecker.
 *
 *
 *
 * @author Evan Jamesons
 * @version Project5
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class SpellCheckerTests {

   private SpellChecker s;

   @Test
   public void test_Constructor() throws FileNotFoundException
   {
      s = new SpellChecker();
      assertEquals(267119, s.getDictionary().size());
   }
   
   @Test (expected=FileNotFoundException.class)
   public void test_Constructor_noFile() throws FileNotFoundException 
   {
      s = new SpellChecker("hello.txt");
   }

   @Test
   public void test_Constructor_customFile() throws FileNotFoundException 
   {
      s = new SpellChecker("hi.txt");
      assertEquals(1, s.getDictionary().size());
   }
   
   @Test
   public void test_isWord() throws FileNotFoundException 
   {
      s = new SpellChecker();
      assertTrue(s.isWord("Hello"));
   }
   
   @Test
   public void test_processFile() throws FileNotFoundException 
   {
      s = new SpellChecker();
      HashMap<String, SpellChecker.MyStats> file = s.processFile("lyrics.txt");
      assertEquals(5, file.get("Let").getOccurrences());
      assertTrue(listEquals(new Integer[] {12, 17, 19, 27, 38},file.get("woo").getLineNumbers()));
      assertTrue(file.get("woo").isWord());
   }

   // Helper method
   private boolean listEquals(Integer[] arr, List<Integer> list) 
   {
      if (arr.length != list.size()) 
      {
         return false;
      }

      for (int i = 0; i < arr.length; i++) 
      {
         if (arr[i] != list.get(i)) 
         {
            return false;
         }
      }
      return true;
   }
}