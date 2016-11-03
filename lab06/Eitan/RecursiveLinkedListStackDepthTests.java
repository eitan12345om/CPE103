/**
 * JUnit tests to verify the expected stack depths of the recursion.
 *
 * NOTE: These tests assume all methods work and only checks the stack depth.
 *       YOU ARE EXPECTED TO DEVELOP YOU OWN TESTS FOR THE OTHER BEHAVIORS!
 *
 * @author Paul Hatalsky
 * @version 1/27/2016 Developed for CPE 103 Lab 6 
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import java.util.NoSuchElementException;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.lang.annotation.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RecursiveLinkedListStackDepthTests {
   private final PrintWriter console = System.console().writer();

   @Retention(RetentionPolicy.RUNTIME)
   @Target({ ElementType.TYPE, ElementType.METHOD})
   @Documented
   public @interface TestDescription {
       public String desc();
   }
   @Rule
   public TestRule watcher = new TestWatcher() {
      protected void starting(Description description) {
         console.printf("\b\bStarting: %-48s", description.getMethodName());
      }
   };
   @Rule
   public Stopwatch sw = new Stopwatch() {
      String s;
      protected void finished(long nanos, Description description) {
         console.println(s);
      }
      protected void succeeded(long nanos, Description description) {
         s = "Passed" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
      }
      protected void failed(long nanos, Throwable e, Description description) {
         s = "FAILED" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
         TestDescription t = description.getAnnotation(TestDescription.class);
         if (t != null)
            s += "\nFailed test description:\n" + t.desc();
      }
   };

   @Test
   public void test01_stackDepthAtConstruction() {
      int startDepth, depth;
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      startDepth = (new Throwable()).getStackTrace().length;

      list.size();
      depth = list.stackTrace().getStackTrace().length;

      assertEquals(startDepth + 2, depth);
   }
   
   @Test
   public void test02_addEndStackDepth() {
      int startDepth, depth;
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      startDepth = (new Throwable()).getStackTrace().length;

      list.add(1);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 2, depth);

      list.add(2);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 3, depth);

      list.add(3);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 4, depth);
   }

   @Test
   public void test03_addEndSizeStackDepth() {
      int startDepth, depth;
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      startDepth = (new Throwable()).getStackTrace().length;

      list.add(1);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 2, depth);

      list.size();
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 3, depth);

      list.add(2);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 3, depth);

      list.size();
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 4, depth);

      list.add(3);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 4, depth);
      
      list.size();
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 5, depth);
   }

   @Test
   public void test04_addIndexStackDepth() {
      int startDepth, depth;
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      startDepth = (new Throwable()).getStackTrace().length;

      list.add(0, 1);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 2, depth);

      list.add(0, 2);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 2, depth);

      list.add(1, 3);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 3, depth);
      
      list.add(2, 3);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 4, depth);
      
      list.add(4, 3);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 6, depth);
      
      list.add(2, 3);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 4, depth);
   }

   @Test
   public void test05_getStackDepth() {
      int startDepth, depth;
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      startDepth = (new Throwable()).getStackTrace().length;

      list.add(1);
      list.add(2);
      list.add(3);

      list.get(0);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 2, depth);

      list.get(1);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 3, depth);

      list.get(2);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 4, depth);
   }

   @Test
   public void test06_removeStackDepth() {
      int startDepth, depth;
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      startDepth = (new Throwable()).getStackTrace().length;

      list.add(1);
      list.add(2);
      list.add(3);

      list.remove(2);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 4, depth);

      list.remove(1);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 3, depth);

      list.remove(0);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 2, depth);
   }
}


