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
      // Create hashmap
      HashMap<String, MyStats> hMap = new HashMap<>(267119);

      Scanner scan = new Scanner(new File(fileName));
      Scanner lineScanner;

      String word;
      MyStats value;
      int lineNumber = 1;

      while (scan.hasNext()) {

         lineScanner = new Scanner(scan.nextLine());
         lineScanner.useDelimiter("[^\\w-']+");

         while (lineScanner.hasNext()) {
            word = lineScanner.next();
            value = hMap.get(word);
            if (value != null) {
               value.getLineNumbers().add(lineNumber);
               hMap.put(word, new MyStats(value.getOccurrences() + 1,
                        value.getLineNumbers(), value.isWord()));
            }
            else {
               List<Integer> list = new ArrayList<>();
               list.add(lineNumber);
               hMap.put(word, new MyStats(1, list, isWord(word)));
            }
         }
         lineNumber++;
      }

      scan.close();

      return hMap;
   }

   // Inner Class
   public class MyStats {
  
      // Instance Variables
      private int occurrences;
      private List<Integer> lineNumbers;
      private boolean isWord;

      // Constructor
      public MyStats(int occurrences, List<Integer> lineNumbers, boolean isWord) {
         this.occurrences = occurrences;
         this.lineNumbers = lineNumbers;
         this.isWord = isWord;
      }

      // Methods
      public int getOccurrences() {
         return occurrences;
      }
      
      public List<Integer> getLineNumbers() {
         return lineNumbers;
      }
      
      public boolean isWord() {
         return isWord;
      }
   }
}
