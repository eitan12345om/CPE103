import java.io.*;
import java.util.HashMap;

/**
 * A spellschecker using custom hash table.
 *
 * @author Eitan Simler
 * @version Project5
 */

public class SpellChecker {

   // Constructors
   public SpellChecker() throws FileNotFoundException {
      // TODO: Add constuctor body   
   }

   public SpellChecker(String fileName) throws FileNotFoundException {
      // TODO: Add constuctor body   
   }

   // Methods
   public boolean isWord(String s) {
      // TODO: Add method body
      return false;
   }

   public HashTableSC<String> getDictionary() {
      // TODO: Add method body
      return null; 
   }
   
   public HashMap<String, SpellChecker.MyStats> processFile(String fileName)
      throws FileNotFoundException {
      // TODO: Add method body
      return null;
   }

   // Inner Class
   public class MyStats {
   
      // Methods
      public int getOccurrences() {
         // TODO: Add method body
         return 0;
      }
      
      public List<Integer> getLineNumbers() {
         // TODO: Add method body
         return null;
      }
      
      public boolean isWord() {
         // TODO: Add method body
         return false;
      }
   }
}
