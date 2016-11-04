import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import org.junit.rules.*;
import org.junit.runners.MethodSorters;
import org.junit.runner.Description;
import java.util.concurrent.TimeUnit;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class L0Tests {
   private final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
   private final ByteArrayOutputStream myErr = new ByteArrayOutputStream();
   private final PrintWriter console = System.console().writer();
   // Init ==>
   
   @Rule
   public TestRule watcher = new TestWatcher() {
      protected void starting(Description description) {
         console.printf("Starting: %-55s", description.getMethodName());
      }
   };
   @Rule
   public Stopwatch sw = new Stopwatch() {
      protected void finished(long nanos, Description description) {
         console.println(" (" + runtime(TimeUnit.MILLISECONDS) + " ms)");
      }
      protected void succeeded(long nanos, Description description) {
         console.print("Passed");
      }
      protected void failed(long nanos, Throwable e, Description description) {
         console.print("FAILED");
      }
   };

   @Before
   public void setUpStreams() {
      System.setOut(new PrintStream(myOut));
      System.setErr(new PrintStream(myErr));
   }

   @After
   public void cleanUpStreams() {
      System.setOut(null);
      System.setErr(null);
   }
   // <==
   // ListWork Tests ==>
   @Test
   public void test01_Search_emptyIntegerArray() {
      Integer[] ints = {};

      assertFalse(ListWork.search(ints, 6));
      assertEquals(myOut.toString(), "");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test02_Search_firstElementInt() {
      Integer[] ints = {1, 2, 3, 4};

      assertTrue(ListWork.search(ints, 1));
      assertEquals(myOut.toString(), "");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test03_Search_midElementInt() {
      Integer[] ints = {1, 2, 3, 4};

      assertTrue(ListWork.search(ints, 3));
      assertEquals(myOut.toString(), "");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test04_Search_midElementInteger() {
      Integer[] ints = {new Integer(1), new Integer(2), new Integer(3),
         new Integer(4)};

      assertTrue(ListWork.search(ints, new Integer(3)));
      assertEquals(myOut.toString(), "");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test05_Search_doesNotContainInteger() {
      Integer[] ints = {new Integer(1), new Integer(2), new Integer(3),
         new Integer(4)};

      assertFalse(ListWork.search(ints, new Integer(5)));
      assertEquals(myOut.toString(), "");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test06_Search_arrayContainsNulls() {
      Object[] os = {null, null, null};

      assertFalse(ListWork.search(os, new Integer(5)));
      assertEquals(myOut.toString(), "");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test07_Search_searchForNull() {
      Double[] ds = {new Double(1), new Double(2)};

      assertFalse(ListWork.search(ds, null));
      assertEquals(myOut.toString(), "");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test08_Search_searchForNullInArrayOfNull() {
      Object[] os = {null, null};

      assertTrue(ListWork.search(os, null));
      assertEquals(myOut.toString(), "");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test09_Print_emptyArray() {
      Integer[] ints = {};

      ListWork.print(ints);
      assertEquals(myOut.toString(), "");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test10_Print_oneElementIntegerArray() {
      Integer[] ints = {new Integer(1)};

      ListWork.print(ints);
      assertEquals(myOut.toString(), "1\n");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test11_Print_tenElementIntegerArray() {
      Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

      ListWork.print(ints);
      assertEquals(myOut.toString(), "1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test12_Print_fourElementStringArray() {
      String[] words = {"these", "are", "some", "words"};

      ListWork.print(words);
      assertEquals(myOut.toString(), "these\nare\nsome\nwords\n");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test13_Print_arrayWithNulls() {
      Boolean[] bools = {true, false, null, false, null};

      ListWork.print(bools);
      assertEquals(myOut.toString(), "true\nfalse\nnull\nfalse\nnull\n");
      assertEquals(myErr.toString(), "");
   }
   // <==
   // Separator Tests ==>
   @Test
   public void test14_Separator_moreThanNIntegers() {
      System.setIn(new ByteArrayInputStream("1 2 3\n4 5 6\n7 8 9\n10 11 12\n".getBytes()));

      Separator.main(new String[] {});
      assertEquals(myOut.toString().replaceAll("\\s*\n","\n").trim(),
            "Integers: 1 2 3 4 5 6\nFloats:");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test15_Separator_exactlyNIntegers() {
      System.setIn(new ByteArrayInputStream("1 2 3\n4 5\n6\n".getBytes()));

      Separator.main(new String[] {});
      assertEquals(myOut.toString().replaceAll("\\s*\n","\n").trim(),
            "Integers: 1 2 3 4 5 6\nFloats:");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test16_Separator_fewerThanNIntegers() {
      System.setIn(new ByteArrayInputStream("1 2 3\n4\n".getBytes()));

      Separator.main(new String[] {});
      assertEquals(myOut.toString().replaceAll("\\s*\n","\n").trim(),
            "Integers: 1 2 3 4\nFloats:");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test17_Separator_moreThanNFloats() {
      System.setIn(new ByteArrayInputStream("1.2 2.3 3.4\n4.5 5.6 6.7\n7.8 8.9".getBytes()));

      Separator.main(new String[] {});
      assertEquals(myOut.toString().replaceAll("\\s*\n","\n").trim(),
            "Integers:\nFloats: 1.2 2.3 3.4 4.5 5.6 6.7");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test18_Separator_exactlyNFloats() {
      System.setIn(new ByteArrayInputStream("1.2 2.3 3.4 4.5 5.6 6.7".getBytes()));

      Separator.main(new String[] {});
      assertEquals(myOut.toString().replaceAll("\\s*\n","\n").trim(),
            "Integers:\nFloats: 1.2 2.3 3.4 4.5 5.6 6.7");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test19_Separator_fewerThanNFloats() {
      System.setIn(new ByteArrayInputStream("1.2 2.3 3.4".getBytes()));

      Separator.main(new String[] {});
      assertEquals(myOut.toString().replaceAll("\\s*\n","\n").trim(),
            "Integers:\nFloats: 1.2 2.3 3.4");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test20_Separator_moreThanNIntegers_fewerThanNFloats() {
      System.setIn(new ByteArrayInputStream("1 2 3 4 5\n1.2 2.3 3.4\n6 7\n4.5\n".getBytes()));

      Separator.main(new String[] {});
      assertEquals(myOut.toString().replaceAll("\\s*\n","\n").trim(),
            "Integers: 1 2 3 4 5 6\nFloats: 1.2 2.3 3.4");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test21_Separator_fewerThanNIntegers_moreThanNFloats() {
      System.setIn(new ByteArrayInputStream("1 2 3 4\n1.2 2.3 3.4\n4.5 5.6 6.7 7.8\n5 6\n".getBytes()));

      Separator.main(new String[] {});
      assertEquals(myOut.toString().replaceAll("\\s*\n","\n").trim(),
            "Integers: 1 2 3 4\nFloats: 1.2 2.3 3.4 4.5 5.6 6.7");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test22_Separator_exactlyNIntegers_exactlyNFloats() {
      System.setIn(new ByteArrayInputStream("1 2 3 4\n1.2 2.3 3.4\n4.5 5.6 6.7\n5 6\n".getBytes()));

      Separator.main(new String[] {});
      assertEquals(myOut.toString().replaceAll("\\s*\n","\n").trim(),
            "Integers: 1 2 3 4 5 6\nFloats: 1.2 2.3 3.4 4.5 5.6 6.7");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test23_Separator_fewerThanNIntegers_fewerThanNFloats() {
      System.setIn(new ByteArrayInputStream("1 2 3 4\n1.2 2.3 3.4\n5\n".getBytes()));

      Separator.main(new String[] {});
      assertEquals(myOut.toString().replaceAll("\\s*\n","\n").trim(),
            "Integers: 1 2 3 4 5\nFloats: 1.2 2.3 3.4");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test24_Separator_someValidThenInvalid() {
      System.setIn(new ByteArrayInputStream("1 2\n3 4\n1.2 2.3\nhello these are words 5 6".getBytes()));

      Separator.main(new String[] {});
      assertEquals(myOut.toString().replaceAll("\\s*\n","\n").trim(),
            "Integers: 1 2 3 4\nFloats: 1.2 2.3");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test25_Separator_onlyInvalidInput() {
      System.setIn(new ByteArrayInputStream("hello these are words".getBytes()));

      Separator.main(new String[] {});
      assertEquals(myOut.toString().replaceAll("\\s*\n","\n").trim(),
            "Integers:\nFloats:");
      assertEquals(myErr.toString(), "");
   }

   @Test
   public void test26_Separator_noInput() {
      System.setIn(new ByteArrayInputStream("".getBytes()));

      Separator.main(new String[] {});
      assertEquals(myOut.toString().replaceAll("\\s*\n","\n").trim(),
            "Integers:\nFloats:");
      assertEquals(myErr.toString(), "");
   }
   // <==
}