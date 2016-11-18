import java.io.*;
import java.util.*;

/**
 * A spellschecker using custom hash table.
 *
 * @author Eitan Simler
 * @version Project5
 */

public class SpellChecker {

   // Instance variables
   private HashTableSC<String> table;

   // Constructors
   public SpellChecker() throws FileNotFoundException {
      Scanner scan;
      
      // Try to open dictionary.txt
      try {
         File file = new File("dictionary.txt");
         scan = new Scanner(file);
      }
      catch (FileNotFoundException e) {
         throw e;
      }

      table = new HashTableSC<>(267119);

      // Add words to hashmap
      while (scan.hasNext()) {
         table.add(scan.nextLine());   
      }

      scan.close();
   }

   public SpellChecker(String fileName) throws FileNotFoundException {
      Scanner scan;
      
      // Try to open dictionary.txt
      try {
         File file = new File(fileName);
         scan = new Scanner(file);
      }
      catch (FileNotFoundException e) {
         throw e;
      }
      
      table = new HashTableSC<>(267119);

      // Add words to hashmap
      while (scan.hasNext()) {
         table.add(scan.nextLine());   
      }
      
      scan.close();
   }

   // Methods
   public boolean isWord(String s) {
      return table.contains(s) || table.contains(s.toLowerCase());
   }

   public HashTableSC<String> getDictionary() {
      return table; 
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
