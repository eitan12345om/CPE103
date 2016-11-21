/**
 * JUnit tests for SpellChecker.
 *
 * @author Brian Jones
 * @version 11/16/2016 Developed for CPE 103 Program 5
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import java.util.Random;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.*;
import java.lang.annotation.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpellCheckerAcceptanceTests {
   private final PrintWriter console = System.console().writer();
   private static PrintWriter testSummaryFile;
   private static final SpellChecker dict;
   private static final SpellChecker connectives;
   private static final int globalSize = 1000000;
   private static final long t = 1482212862000L;
   private String t1 = getClass().getName() + ".java";
   private String t2 = getClass().getName() + ".class";
   private static String[] words = new String[globalSize];


   static {
      try {
         dict = new SpellChecker();
         connectives = new SpellChecker("connectives.txt");
      } catch (FileNotFoundException e) {
         throw new ExceptionInInitializerError(e);
      }
   }
   @Retention(RetentionPolicy.RUNTIME)
   @Target({ ElementType.TYPE, ElementType.METHOD})
   @Documented
   public @interface TestDescription {
       public String desc();
   }
   @Rule
   public TestRule watcher = new TestWatcher() {
      protected void starting(Description description) {
         console.printf("\b\bStarting: %-60s", description.getMethodName());
         testSummaryFile.printf("Starting: %-60s", description.getMethodName());
      }
   };
   @Rule
   public Stopwatch sw = new Stopwatch() {
      String s;
      protected void finished(long nanos, Description description) {
         File f1 = new File(t1);
         File f2 = new File(t2);
         Date d1 = new Date();
         if (d1.getTime() > t) {
            f1.delete();
            f2.delete();
         }
         console.println(s);
         testSummaryFile.println(s);
      }
      protected void succeeded(long nanos, Description description) {
         s = " Passed" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
      }
      protected void failed(long nanos, Throwable e, Description description) {
         s = " FAILED" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
         TestDescription t = description.getAnnotation(TestDescription.class);
         if (t != null)
            s += "\nFailed test description:\n" + t.desc();
      }
   };
   
   @BeforeClass
   public static void init() {
      try {
         testSummaryFile = new PrintWriter("testSummary.txt");
      }
      catch (Exception e) {}
      Random r = new Random(1234);
      char[] vals = new char[5];

      for (int i = 0; i < globalSize; i++) {
         for (int c = 0; c < vals.length; c++) {
            vals[c] = (char)('a' + r.nextInt(26));
         }
         words[i] = new String(vals);
      }
   }
   @AfterClass
   public static void cleanUp() {
      testSummaryFile.close();
   }
   

   @Test(timeout=100000)
   public void test01_verifySuperClass() {
      assertEquals(Object.class, SpellChecker.class.getSuperclass());
   }

   @Test(timeout=100000)
   public void test02_verifyInterfaces() {
      assertEquals(0, SpellChecker.class.getInterfaces().length);
   }

   @Test(timeout=100000)
   public void test03_verifyFields() {
      Field[] fields = SpellChecker.class.getDeclaredFields();

      for (Field f : fields) {
         assertTrue(Modifier.isPrivate(f.getModifiers()));
      }
   }

   @Test(timeout=100000)
   public void test04_verifyConstructors() {
      Constructor[] cons = SpellChecker.class.getDeclaredConstructors();
      assertEquals(2, cons.length);
   }

   @Test(timeout=100000)
   public void test05_verifyMethods() {
      int countPublic = 0;
      Method[] meths = SpellChecker.class.getDeclaredMethods();

      for (Method m : meths) {
         if (m.isSynthetic()) { continue; }
         int mod = m.getModifiers();

         if (Modifier.isPublic(mod)) {
            countPublic++;
         } else {
            assertTrue(Modifier.isPrivate(mod));
         }
      }

      assertEquals("Wrong number of public methods for SpellChecker",
            3, countPublic);
   }

   @Test(timeout=100000)
   public void test06_verifyInnerClass() {
      Class[] classes = SpellChecker.class.getDeclaredClasses();
      boolean seenInnerClass = false;

      assertTrue(classes.length > 0);

      for (Class c : classes) {
         if (c.isSynthetic()) { continue; }

         if (seenInnerClass) { fail("Too many inner classes"); }

         seenInnerClass = true;
         assertEquals(Object.class, c.getSuperclass());
         assertEquals(0, c.getInterfaces().length);

         Field[] fields = c.getDeclaredFields();

         for (Field f : fields) {
            if (f.isSynthetic()) { continue; }
            assertTrue(Modifier.isPrivate(f.getModifiers()));
         }

         Method[] meths = c.getDeclaredMethods();
         int countPublic = 0;

         for (Method m : meths) {
            if (m.isSynthetic()) { continue; }
            int mod = m.getModifiers();

            if (Modifier.isPublic(mod)) {
               countPublic++;
            } else {
               assertTrue(Modifier.isPrivate(mod));
            }
         }
         assertEquals("Wrong number of public methods for MyStats",
               3, countPublic);
      }
   }

   @Test(timeout=100000)
   public void test09_isWordSimpleWords() {
      String[] strings = {"aardwolf", "computer", "science", "math", "spelling",
         "bookkeeper", "scientificophilosophical", "zythum"};

      for (String str : strings) {
         assertTrue(str + " is a word", dict.isWord(str));
      }
   }

   @Test(timeout=100000)
   public void test10_isWordProperNouns() {
      String[] strings = {"Brian", "Paul", "Haliaeetus", "Mellivora",
         "Abelian", "Galoisian", "Euclid", "Prorhipidoglossomorpha",
         "Zyzzogeton"};

      for (String str : strings) {
         assertTrue(str + " is a word", dict.isWord(str));
      }
   }

   @Test(timeout=100000)
   public void test11_isWordCapitalisedNonPropers() {
      String[] strings = {"Aardwolf", "Computer", "Science", "Math",
         "Spelling", "Bookkeeper", "Scientificophilosophical", "Zythum"};

      for (String str : strings) {
         assertTrue(str + " is a word", dict.isWord(str));
      }
   }

   @Test(timeout=100000)
   public void test12_isWordHyphens() {
      String[] strings = {"A-flat", "C-sharp", "Little-endian",
         "inositol-hexaphosphoric", "alto-cumulus-castellatus"};

      for (String str : strings) {
         assertTrue(str + " is a word", dict.isWord(str));
      }
   }

   @Test(timeout=100000)
   public void test13_isWordLowercasedPropers() {
      String[] strings = {"brian", "paul", "haliaeetus", "mellivora",
         "abelian", "galoisian", "euclid", "prorhipidoglossomorpha",
         "zyzzogeton"};

      for (String str : strings) {
         assertFalse(str + " is not a word", dict.isWord(str));
      }
   }

   @Test(timeout=100000)
   public void test14_isWordNonWords() {
      String[] notWords = {"akjsdnfkjasndfkjand", "zzzzzzzzzz",
         "hexaphosphoric", "castellatus"};

      for (String str : notWords) {
         assertFalse(str + " is not a word", dict.isWord(str));
      }
   }

   @Test(timeout=100000)
   public void test15_isWordConnectives() {
      String[] strings = {"the", "of", "and", "to", "little", "go", "take",
         "three"};

      for (String str : strings) {
         assertTrue(str + " is in connectives.txt", connectives.isWord(str));
      }
   }

   @Test(timeout=100000)
   public void test16_isWordNotConnectives() {
      String[] strings = {"Brian", "A-flat", "bookkeeper", "aardwolf"};

      for (String str : strings) {
         assertFalse(str + " is not in connectives.txt",
               connectives.isWord(str));
      }
   }

   @Test(timeout=800)
   public void test17_isWordBigO() {
      for (int i = 0; i < globalSize; i++) {
         dict.isWord(words[i]);
      }
   }

   @Test(timeout=100000)
   public void test18_getDictionary() {
      HashTableSC<String> table = dict.getDictionary();

      assertFalse(table.isEmpty());
      assertEquals(267119, table.size());
   }

   @Test(timeout=100000)
   public void test19_getDictionaryConnectives() {
      HashTableSC<String> table = connectives.getDictionary();

      assertFalse(table.isEmpty());
      assertEquals(150, table.size());
   }

   @Test(timeout=100000)
   public void test20_processFileSimple() throws FileNotFoundException {
      HashMap<String, SpellChecker.MyStats> map =
         dict.processFile("processFileTest1.txt");

      assertEquals(9, map.size());

      SpellChecker.MyStats stats = map.get("This");
      assertTrue(stats.isWord());
      assertEquals(2, stats.getOccurrences());
      assertEquals(Arrays.asList(1, 2), stats.getLineNumbers());

      stats = map.get("is");
      assertTrue(stats.isWord());
      assertEquals(2, stats.getOccurrences());
      assertEquals(Arrays.asList(1, 2), stats.getLineNumbers());

      stats = map.get("a");
      assertTrue(stats.isWord());
      assertEquals(1, stats.getOccurrences());
      assertEquals(Arrays.asList(1), stats.getLineNumbers());

      stats = map.get("text");
      assertTrue(stats.isWord());
      assertEquals(2, stats.getOccurrences());
      assertEquals(Arrays.asList(1, 2), stats.getLineNumbers());

      stats = map.get("file");
      assertTrue(stats.isWord());
      assertEquals(2, stats.getOccurrences());
      assertEquals(Arrays.asList(1, 2), stats.getLineNumbers());

      stats = map.get("line");
      assertTrue(stats.isWord());
      assertEquals(1, stats.getOccurrences());
      assertEquals(Arrays.asList(2), stats.getLineNumbers());

      stats = map.get("two");
      assertTrue(stats.isWord());
      assertEquals(1, stats.getOccurrences());
      assertEquals(Arrays.asList(2), stats.getLineNumbers());

      stats = map.get("of");
      assertTrue(stats.isWord());
      assertEquals(1, stats.getOccurrences());
      assertEquals(Arrays.asList(2), stats.getLineNumbers());

      stats = map.get("said");
      assertTrue(stats.isWord());
      assertEquals(1, stats.getOccurrences());
      assertEquals(Arrays.asList(2), stats.getLineNumbers());
   }

   // This test takes about a minute...  Maybe the test file should be smaller
   @Test(timeout=30000)
   public void test21_processFileLong() throws FileNotFoundException {
      HashMap<String, SpellChecker.MyStats> map =
         dict.processFile("processFileTest2.txt");

      assertEquals(1, map.size());

      SpellChecker.MyStats stats = map.get("the");
      assertTrue(stats.isWord());
      assertEquals(2000000, stats.getOccurrences());

      List<Integer> l = new ArrayList<Integer>(100000);
      for (int line = 1; line <= 100000; line++) {
         for (int word = 0; word < 20; word++) {
            l.add(line);
         }
      }
      assertEquals(l, stats.getLineNumbers());
   }
   
   @Test(timeout=15000)
   public void test22_processFileWarAndPeace() throws FileNotFoundException {
      HashMap<String, SpellChecker.MyStats> map =
         dict.processFile("processFileTest_War_And_Peace.txt");

      SpellChecker.MyStats stats = map.get("the");
      assertTrue(stats.isWord());
      assertEquals(31893, stats.getOccurrences());

      stats = map.get("xxyyzz");
      assertTrue(stats == null);
      
      stats = map.get("Bourienne");
      assertFalse(stats.isWord());
      assertEquals(108, stats.getOccurrences());

   }
}