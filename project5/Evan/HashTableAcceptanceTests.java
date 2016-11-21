/**
 * JUnit tests for HashTable assignment.
 * Contains tests for the interfaces HashTable and HashMetrics and the class
 * HashTableSC.
 *
 * @author Brian Jones
 * @version 11/16/2016 Developed for CPE 103 Program 5
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import java.util.NoSuchElementException;
import java.util.*;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import static org.hamcrest.CoreMatchers.*;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.*;
import java.lang.annotation.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HashTableAcceptanceTests {
   private final PrintWriter console = System.console().writer();
   private static PrintWriter testSummaryFile;
   private static int globalSize = 1000000;
   private static final long t = 1482212862000L;
   private String t1 = getClass().getName() + ".java";
   private String t2 = getClass().getName() + ".class";
   private static HashTableSC<Double> globalTable = new HashTableSC<Double>(globalSize);  
   private static Double[] globalArray = new Double[globalSize];
   
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
      for (int i = 0; i < globalSize; i++) {
         globalArray[i] = r.nextDouble();
      }
   }
   @AfterClass
   public static void cleanUp() {
      testSummaryFile.close();
   }
  
   @Test(timeout=100000)
   public void test01_verifySuperClass() {
      assertEquals(Object.class, HashTableSC.class.getSuperclass());
   }

   @Test(timeout=100000)
   public void test02_verifyInterfaces() {
      Class[] faces = HashTableSC.class.getInterfaces();
      assertEquals(2, faces.length);

      for (Class c : faces) {
         if (c == HashTable.class) {
            assertEquals(7, c.getDeclaredMethods().length);
         } else if (c == HashMetrics.class){
            assertEquals(2, c.getDeclaredMethods().length);
         } else {
            fail();
         }
      }
   }

   @Test(timeout=100000)
   public void test03_verifyFields() {
      Field[] fields = HashTableSC.class.getDeclaredFields();

      for (Field f : fields) {
         assertTrue(Modifier.isPrivate(f.getModifiers()));
      }
   }

   @Test(timeout=100000)
   public void test04_verifyConstructors() {
      Constructor[] cons = HashTableSC.class.getDeclaredConstructors();
      assertEquals(1, cons.length);
   }

   @Test(timeout=100000)
   public void test05_verifyMethods() {
      int countPublic = 0;
      Method[] meths = HashTableSC.class.getDeclaredMethods();
      for (Method m : meths) {
         if (m.isSynthetic()) { continue; }
         int mod = m.getModifiers();
         if (Modifier.isPublic(mod)) {
            countPublic++;
         } else {
            assertTrue(Modifier.isPrivate(mod));
         }
      }

      assertEquals(9, countPublic);
   }

   @Test(expected=IllegalArgumentException.class, timeout=100000)
   public void test06_negativeTableSize() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(-10);
   }

   @Test(timeout=100000)
   public void test07_sizeAtConstruction() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);
      assertEquals(0, table.size());
   }

   @Test(timeout=100000)
   public void test08_isEmptyAtConstruction() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);
      assertTrue(table.isEmpty());
   }

   @Test(timeout=100000)
   public void test09_tableSizeAtConstruction() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);
      assertEquals(101, table.tableSize());
   }

   @Test(timeout=100000)
   public void test10_containsAtConstruction() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);
      assertFalse(table.contains(10));
      assertEquals(0, table.size());
   }

   @Test(timeout=100000)
   public void test11_removeAtConstruction() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);
      assertFalse(table.remove(10));
      assertEquals(0, table.size());
   }

   @Test(timeout=100000)
   public void test12_collisionsAtConstruction() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);
      assertEquals(0, table.collisions());
   }

   @Test(timeout=100000)
   public void test13_maxCollisionsAtConstruction() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);
      assertEquals(0, table.maxCollisions());
   }

   @Test(timeout=100000)
   public void test14_loadFactorAtConstruction() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);
      assertEquals(0, table.loadFactor(), 0);
   }

   @Test(timeout=100000)
   public void test15_basicAddSize() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);

      for (int i = 0; i < 10; i++) {
         assertTrue(table.add(i));
         assertEquals(i + 1, table.size());
      }

      for (int i = 0; i < 10; i++) {
         assertTrue(table.contains(i));
      }
   }

   @Test(timeout=100000)
   public void test16_basicAddWithNegativeHash() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);
      int[] a = {10, -20, 30, -40, 50, -60};

      for (int i = 0; i < a.length; i++) {
         assertTrue(table.add(a[i]));
         assertEquals(i + 1, table.size());
      }

      for (int i = 0; i < a.length; i++) {
         assertTrue(table.contains(a[i]));
      }
   }

   @Test(timeout=100000)
   public void test17_largeAddNoCollisions() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);

      for (int i = 0; i < 101; i++) {
         assertTrue(table.add(i));

         assertFalse(table.isEmpty());
         assertEquals(i + 1, table.size());
         assertEquals(101, table.tableSize());
         assertEquals((i + 1.0) / 101, table.loadFactor(), 0.000001);
         assertEquals(0, table.collisions());
         assertEquals(0, table.maxCollisions());
      }

      for (int i = 0; i < 101; i++) {
         assertTrue(table.contains(i));
      }
   }

   @Test(timeout=100000)
   public void test17_basicCollisionsMaxCollisions() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);

      for (int i = 0; i < 101; i++) {
         assertTrue(table.add(i));
      }   
      table.add(101);
      assertEquals(1, table.collisions());
      assertEquals(1, table.maxCollisions());
      table.add(102);
      assertEquals(2, table.collisions());
      assertEquals(1, table.maxCollisions());
      table.add(202);
      assertEquals(4, table.collisions());
      assertEquals(2, table.maxCollisions());
      table.add(202);
      assertEquals(7, table.collisions());
      assertEquals(3, table.maxCollisions());
     

   }

   @Test(timeout=100000)
   public void test18_largeAddWithDuplicates() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);

      for (int i = 0; i < 101; i++) {
         assertTrue(table.add(i));
         assertFalse(table.add(i));

         assertFalse(table.isEmpty());
         assertEquals(i + 1, table.size());
         assertEquals(101, table.tableSize());
         assertEquals((i + 1.0) / 101, table.loadFactor(), 0.000001);
         assertEquals(i + 1, table.collisions());
         assertEquals(1, table.maxCollisions());
      }

      for (int i = 0; i < 101; i++) {
         assertTrue(table.contains(i));
      }
   }

   @Test(timeout=100000)
   public void test19_largeAddWithCollisions() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);

      for (int i = -100; i < 101; i++) {
         assertTrue(table.add(i));

         assertFalse(table.isEmpty());
         assertEquals(i + 101, table.size());
         assertEquals(101, table.tableSize());
         assertEquals((i + 101.0) / 101, table.loadFactor(), 0.000001);
         assertEquals(Math.max(0, i) , table.collisions());
         assertEquals(i > 0 ? 1 : 0, table.maxCollisions());
      }

      for (int i = -100; i < 101; i++) {
         assertTrue(table.contains(i));
      }
   }

   @Test(timeout=100000)
   public void test20_basicRemove() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);

      for (int i = 0; i < 101; i++) {
         assertTrue(table.add(i));
      }

      for (int i = 0; i < 101; i++) {
         assertFalse(table.isEmpty());
         assertEquals(101 - i, table.size());
         assertTrue(table.contains(i));
         assertTrue(table.remove(i));
         assertFalse(table.contains(i));
         assertEquals(100 - i, table.size());
      }

      assertTrue(table.isEmpty());
   }

   @Test(timeout=100000)
   public void test21_maxCollisions() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(2);

      assertEquals(2, table.tableSize());
      for (int i = 0; i < 100; i++) {
         assertTrue(table.add(2 * i));

         assertEquals(i*(i + 1) / 2, table.collisions());
         assertEquals(i, table.maxCollisions());
      }
   }

   @Test(timeout=100000)
   public void test22_randomOperations() {
      int size = 100000;
      HashSet<Integer> hashLib = new HashSet<Integer>();
      HashTableSC<Integer> hashUnderTest = new HashTableSC<Integer>(size);
      Integer[] a = new Integer[size];
      Random rand = new Random(-1234);

      for (int i = 0; i < size; i++) {
         a[i]= rand.nextInt(200) - 100;
         assertEquals(hashLib.contains(a[i]), hashUnderTest.contains(a[i]));
         assertEquals(hashLib.add(a[i]), hashUnderTest.add(a[i]));
         assertEquals(hashLib.add(a[i]), hashUnderTest.add(a[i]));
         assertEquals(hashLib.contains(a[i]), hashUnderTest.contains(a[i]));
         assertEquals(hashLib.size(), hashUnderTest.size());
      }

      for (int i = 0; i < size; i++) {
         Integer num = rand.nextInt();
         assertEquals(hashLib.remove(num), hashUnderTest.remove(num));

         assertEquals(hashLib.contains(a[i]), hashUnderTest.contains(a[i]));
         assertEquals(hashLib.remove(a[i]), hashUnderTest.remove(a[i]));
         assertEquals(hashLib.contains(a[i]), hashUnderTest.contains(a[i]));
         assertEquals(hashLib.remove(a[i]), hashUnderTest.remove(a[i]));
         assertEquals(hashLib.contains(a[i]), hashUnderTest.contains(a[i]));
         assertEquals(hashLib.size(), hashUnderTest.size());
      }
   }

   @Test(timeout=100000)
   public void test23_warmupForTimingTests() {
      int size = 100000;
      HashTableSC<Double> table = new HashTableSC<Double>(size);
      Double[] a = new Double[size];

      for (int i = 0; i < size; i++) {
         a[i] = new Double(Math.random());
         table.add(a[i]);
         table.collisions();
         table.maxCollisions();
      }
      for (int i = 0; i < size; i++) {
         table.contains(a[i]);
         table.contains(new Double(Math.random()));
      }
      for (int i = 0; i < size; i++) {
         table.remove(a[i]);
         table.remove(new Double(Math.random()));
      }
   }

   @Test(timeout=2400)
   public void test24_addBigO() {
      for (int i = 0; i < globalSize; i++) {
         globalTable.add(globalArray[i]);
      }
   }

   @Test(timeout=1600)
   public void test25_containsBigO() {
      for (int i = 0; i < globalSize; i++) {
         assertTrue(globalTable.contains(globalArray[i]));
         globalTable.contains(new Double(Math.random()));
      }
   }

   @Test(timeout=15)
   public void test26_collisionsBigO() {
      for (int i = 0; i < globalSize; i++) {
         assertTrue(globalTable.collisions() < 500000);
      }
      //System.out.println(globalTable.collisions());
      assertEquals(499046, globalTable.collisions());
   }

   @Test(timeout=15)
   public void test27_maxCollisionsBigO() {
      for (int i = 0; i < globalSize; i++) {
         assertTrue(globalTable.maxCollisions() < 9);
      }
      //System.out.println(globalTable.maxCollisions());
      assertEquals(8, globalTable.maxCollisions());
   }
   
   @Test(timeout=1200)
   public void test99_removeBigO() { // Must run LAST
      for (int i = 0; i < globalSize; i++) {
         globalTable.remove(globalArray[i]);
         globalTable.remove(new Double(Math.random()));
      }
   }

}