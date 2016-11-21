/**
 *Spell checker class
 *
 *
 *
 *@author Evan Jameson
 *@version Project 5
 */

import java.io.*;
import java.util.*;

public class SpellChecker
{
   private HashTableSC<String> table;

   public SpellChecker() throws FileNotFoundException
   {
      Scanner s;
      try
      {
         File file = new File("dictionary.txt");
         s = new Scanner(file);
      }
      catch(FileNotFoundException e)
      {
         throw e;
      }

      table = new HashTableSC<>(267119);
      while(s.hasNext())
      {
         table.add(s.nextLine());
      }
      s.close();
   }

   public SpellChecker(String fileName) throws FileNotFoundException
   {
      Scanner s;

      try
      {
         File file = new File(fileName);
         s = new Scanner(file);
      }
      catch(FileNotFoundException e)
      {
         throw e;
      }

      table = new HashTableSC<>(267119);
      while(s.hasNext())
      {
         table.add(s.nextLine());
      }
      s.close();
   }

   public boolean isWord(String s)
   {
      return table.contains(s) || table.contains(s.toLowerCase());
   }

   public HashTableSC<String> getDictionary()
   {
      return table;
   }

   public HashMap<String, SpellChecker.MyStats> processFile(String fileName) throws FileNotFoundException
   {
      HashMap<String, MyStats> hashMap = new HashMap<>(267119);
      Scanner s = new Scanner(new File(fileName));
      Scanner lineScanner;
      String word;
      MyStats value;
      int lineNumber = 1;
      while(s.hasNext())
      {
         lineScanner = new Scanner(s.nextLine());
         lineScanner.useDelimiter("[^\\w-]+");
         while(lineScanner.hasNext())
         {
            word = lineScanner.next();
            value = hashMap.get(word);
            if(value != null)
            {
               value.getLineNumbers().add(lineNumber);
               hashMap.put(word, new MyStats(value.getOccurrences() + 1, value.getLineNumbers(), value.isWord()));
            }
            else
            {
               List<Integer> list = new ArrayList<>();
               list.add(lineNumber);
               hashMap.put(word, new MyStats(1, list, isWord(word)));
            }
         }
         lineNumber++;
      }
      s.close();
      return hashMap;
   }

   public class MyStats
   {
      private int occurrences;
      private List<Integer> lineNumbers;
      private boolean isWord;

      public MyStats(int occurrences, List<Integer> lineNumbers, boolean isWord)
      {
         this.occurrences = occurrences;
         this.lineNumbers = lineNumbers;
         this.isWord = isWord;
      }

      public int getOccurrences()
      {
         return occurrences;
      }
      
      public List<Integer> getLineNumbers()
      {
         return lineNumbers;
      }

      public boolean isWord()
      {
         return isWord;
      }
   }
}
