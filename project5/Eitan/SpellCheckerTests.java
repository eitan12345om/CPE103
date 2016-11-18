import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;

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
      
      try {
         sp = new SpellChecker();
      }
      catch (FileNotFoundException e) {
         throw e;
      }  
      assertEquals(267119, sp.getDictionary().size());
   }
   
   @Test (expected=FileNotFoundException.class)
   public void test_Constructor_noFile() throws FileNotFoundException {
      try {
         sp = new SpellChecker("hello.txt");
      }
      catch (FileNotFoundException e) {
         throw new FileNotFoundException();
      }  
   }

   @Test
   public void test_Constructor_customFile() throws FileNotFoundException {
      try {
         sp = new SpellChecker("hi.txt");
      }
      catch (FileNotFoundException e) {
         throw new FileNotFoundException();
      }  
      assertEquals(1, sp.getDictionary().size());
   }
}
