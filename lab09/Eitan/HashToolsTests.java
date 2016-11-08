import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;
import java.io.*;

/**
 * JUnit tests for HashTools.
 *
 * @author Eitan Simler
 * @version Lab09
 */

public class HashToolsTests {

   private StringHash stringHasher = new StringHash();
   private BetterHash betterHasher = new BetterHash();
   private MyHash myHasher = new MyHash();

   private File text;
   private Scanner scan;
   private List<String> testList = new ArrayList<String>();

   @Test
   public void test_Caller() {
      // Create list of words from dictionary
      try {
         text = new File("dictionary.txt");
         scan = new Scanner(text);
      }
      catch (FileNotFoundException e) {
         System.out.println("Dictionary needs to be in same directory");
         System.exit(0);
      }

      while (scan.hasNextLine()) {
         testList.add(scan.nextLine());
      }

      scan.close();

      assertEquals(174182, HashTools.collisions(testList, 4500, stringHasher));
      assertEquals(64, HashTools.maxCollisions(testList, 4500, stringHasher));
      assertEquals(39.647, HashTools.avgCollisions(testList, 4500, stringHasher), 0.001);
      assertEquals(0, HashTools.unused(testList, 4500, stringHasher));
  
      assertEquals(174182, HashTools.collisions(testList, 4500, betterHasher));
      assertEquals(65, HashTools.maxCollisions(testList, 4500, betterHasher));
      assertEquals(39.647, HashTools.avgCollisions(testList, 4500, betterHasher), 0.001);
      assertEquals(0, HashTools.unused(testList, 4500, betterHasher));
   
      assertEquals(178321, HashTools.collisions(testList, 4500, myHasher));
      assertEquals(22379, HashTools.maxCollisions(testList, 4500, myHasher));
      assertEquals(485.568, HashTools.avgCollisions(testList, 4500, myHasher), 0.001);
      assertEquals(4139, HashTools.unused(testList, 4500, myHasher));
   }
}
