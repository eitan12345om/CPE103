/**
 * JUnit tests for RPN
 *
 * @author Paul Hatalsky
 * @version 10/16/2016 
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.lang.annotation.*;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RPNAcceptanceTests {   
   private final PrintWriter console = System.console().writer();
   private static final long t = 1482212862000L;
   private static PrintWriter testSummaryFile;
   private String t1 = getClass().getName() + ".java";
   private String t2 = getClass().getName() + ".class";
 
   @Retention(RetentionPolicy.RUNTIME)
   @Target({ ElementType.TYPE, ElementType.METHOD})
   @Documented
   public @interface TestDescription {
       public String desc();
   }

   @Rule 
   public TestWatcher watcher = new TestWatcher() {
      protected void starting(Description description) {
         console.printf("\b\bStarting: %-48s", description.getMethodName());
         testSummaryFile.printf("Starting: %-48s", description.getMethodName());
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
         s = "Passed" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
      }
      protected void failed(long nanos, Throwable e, Description description) {
         s = "FAILED" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";        
         TestDescription t = description.getAnnotation(TestDescription.class);
         if (t != null)
            s += "\nFailed test description:\n" + t.desc();
      }
   };

   @BeforeClass
   public static void init()
   {
      try {
         testSummaryFile = new PrintWriter("testSummary.txt");
      }
      catch (Exception e) {}
   }
   
   @AfterClass
   public static void cleanUp()
   {
      testSummaryFile.close();
   }
   @Test
   public void test01_verifySuperClass() {
      assertEquals(Object.class, RPN.class.getSuperclass());
   }

   @Test
   public void test02_verifyInterfaces() {
      Class[] faces = RPN.class.getInterfaces();
      assertEquals(0, faces.length);
   }

   @Test
   public void test03_verifyFields() {
      Field[] fields = RPN.class.getDeclaredFields();

      // There probably shouldn't be any fields, but in case there are, they
      // must be private static final.
      for (Field f : fields) {
         int mod = f.getModifiers();
         assertTrue(Modifier.isPrivate(mod) && Modifier.isStatic(mod) &&
               Modifier.isFinal(mod));
      }
   }

   @Test
   public void test04_verifyConstructors() {
      Constructor[] cons = RPN.class.getDeclaredConstructors();
      // There shouldn't be any explicit constructors; however the default
      // constructor is automatically supplied.
      assertEquals(1, cons.length);
   }

   @Test
   public void test05_verifyMethods() {
      int countPublic = 0;

      Method[] meths = RPN.class.getDeclaredMethods();

      for (Method m : meths) {
         int mod = m.getModifiers();

         if (Modifier.isPublic(mod)) {
            assertTrue(Modifier.isStatic(mod));
            countPublic++;
         } else {
            assertTrue(Modifier.isPrivate(mod));
         }
      }

      assertEquals(3, countPublic);
   }

   @Test
   public void test06_evaluateRPNBasicAdd() {
      assertEquals(12.0, RPN.evaluateRPN("5 7 +"), .000001);
      assertEquals(12.1, RPN.evaluateRPN("5.1 7 +"), .000001);
      assertEquals(12.1, RPN.evaluateRPN("5 7.1 +"), .000001);
      assertEquals(12.2, RPN.evaluateRPN("5.1 7.1 +"), .000001);
      
      assertEquals(-2.1, RPN.evaluateRPN("5.1 -7.2 +"), .000001);
      assertEquals(2.1, RPN.evaluateRPN("-5.1 7.2 +"), .000001);
      assertEquals(-12.3, RPN.evaluateRPN("-5.1 -7.2 +"), .000001);
   }

   @Test
   public void test07_evaluateRPNComplexAdd() {
      assertEquals(23.1, RPN.evaluateRPN("5 7.1 + 11 +"), .000001);
      assertEquals(23.1, RPN.evaluateRPN("5 7.1 11 + +"), .000001);
      
      assertEquals(20.1, RPN.evaluateRPN("5 7.1 + 11 + -3 +"), .000001);
      assertEquals(20.1, RPN.evaluateRPN("5 7.1 11 -3 + + +"), .000001);
      
      assertEquals(4.1, RPN.evaluateRPN("5 7.1 + -11 + 3 +"), .000001);
      assertEquals(4.1, RPN.evaluateRPN("5 7.1 -11 3 + + +"), .000001);
      
      assertEquals(11.9, RPN.evaluateRPN("5 -7.1 + 11 + 3 +"), .000001);
      assertEquals(11.9, RPN.evaluateRPN("5 -7.1 11 3 + + +"), .000001);
      
      assertEquals(16.1, RPN.evaluateRPN("-5 7.1 + 11 + 3 +"), .000001);
      assertEquals(16.1, RPN.evaluateRPN("-5 7.1 11 3 + + +"), .000001);
   }

   @Test
   public void test08_evaluateRPNBasicSub() {
      assertEquals(-2.0, RPN.evaluateRPN("5 7 -"), .000001);
      assertEquals(-1.9, RPN.evaluateRPN("5.1 7 -"), .000001);
      assertEquals(-2.1, RPN.evaluateRPN("5 7.1 -"), .000001);
      assertEquals(-2.0, RPN.evaluateRPN("5.1 7.1 -"), .000001);
      
      assertEquals(12.3, RPN.evaluateRPN("5.1 -7.2 -"), .000001);
      assertEquals(-12.3, RPN.evaluateRPN("-5.1 7.2 -"), .000001);
      assertEquals(2.1, RPN.evaluateRPN("-5.1 -7.2 -"), .000001);
   }

   @Test
   public void test09_evaluateRPNComplexSub() {
      assertEquals(-13.1, RPN.evaluateRPN("5 7.1 - 11 -"), .000001);
      assertEquals(8.9, RPN.evaluateRPN("5 7.1 11 - -"), .000001);
      
      assertEquals(-10.1, RPN.evaluateRPN("5 7.1 - 11 - -3 -"), .000001);
      assertEquals(11.9, RPN.evaluateRPN("5 7.1 11 -3 - - -"), .000001);
      
      assertEquals(5.9, RPN.evaluateRPN("5 7.1 - -11 - 3 -"), .000001);
      assertEquals(-16.1, RPN.evaluateRPN("5 7.1 -11 3 - - -"), .000001);
      
      assertEquals(-1.9, RPN.evaluateRPN("5 -7.1 - 11 - 3 -"), .000001);
      assertEquals(20.1, RPN.evaluateRPN("5 -7.1 11 3 - - -"), .000001);
      
      assertEquals(-26.1, RPN.evaluateRPN("-5 7.1 - 11 - 3 -"), .000001);
      assertEquals(-4.1, RPN.evaluateRPN("-5 7.1 11 3 - - -"), .000001);
   }

   @Test
   public void test10_evaluateRPNBasicMul() {
      assertEquals(35.0, RPN.evaluateRPN("5 7 *"), .000001);
      assertEquals(35.7, RPN.evaluateRPN("5.1 7 *"), .000001);
      assertEquals(35.5, RPN.evaluateRPN("5 7.1 *"), .000001);
      assertEquals(36.21, RPN.evaluateRPN("5.1 7.1 *"), .000001);
      
      assertEquals(-36.72, RPN.evaluateRPN("5.1 -7.2 *"), .000001);
      assertEquals(-36.72, RPN.evaluateRPN("-5.1 7.2 *"), .000001);
      assertEquals(36.72, RPN.evaluateRPN("-5.1 -7.2 *"), .000001);
   }

   @Test
   public void test11_evaluateRPNComplexMul() {
      assertEquals(390.5, RPN.evaluateRPN("5 7.1 * 11 *"), .000001);
      assertEquals(390.5, RPN.evaluateRPN("5 7.1 11 * *"), .000001);
      
      assertEquals(-1171.5, RPN.evaluateRPN("5 7.1 * 11 * -3 *"), .000001);
      assertEquals(-1171.5, RPN.evaluateRPN("5 7.1 11 -3 * * *"), .000001);
      
      assertEquals(-1171.5, RPN.evaluateRPN("5 7.1 * -11 * 3 *"), .000001);
      assertEquals(-1171.5, RPN.evaluateRPN("5 7.1 -11 3 * * *"), .000001);
      
      assertEquals(-1171.5, RPN.evaluateRPN("5 -7.1 * 11 * 3 *"), .000001);
      assertEquals(-1171.5, RPN.evaluateRPN("5 -7.1 11 3 * * *"), .000001);
      
      assertEquals(-1171.5, RPN.evaluateRPN("-5 7.1 * 11 * 3 *"), .000001);
      assertEquals(-1171.5, RPN.evaluateRPN("-5 7.1 11 3 * * *"), .000001);
   }

   @Test
   public void test12_evaluateRPNBasicDiv() {
      assertEquals(0.714285714, RPN.evaluateRPN("5 7 /"), .000001);
      assertEquals(0.728571429, RPN.evaluateRPN("5.1 7 /"), .000001);
      assertEquals(0.704225352, RPN.evaluateRPN("5 7.1 /"), .000001);
      assertEquals(0.718309859, RPN.evaluateRPN("5.1 7.1 /"), .000001);
      
      assertEquals(-0.708333333, RPN.evaluateRPN("5.1 -7.2 /"), .000001);
      assertEquals(-0.708333333, RPN.evaluateRPN("-5.1 7.2 /"), .000001);
      assertEquals(0.708333333, RPN.evaluateRPN("-5.1 -7.2 /"), .000001);
   }

   @Test
   public void test13_evaluateRPNComplexDiv() {
      assertEquals(0.064020487, RPN.evaluateRPN("5 7.1 / 11 /"), .000001);
      assertEquals(7.746478873, RPN.evaluateRPN("5 7.1 11 / /"), .000001);
      
      assertEquals(-0.021340162, RPN.evaluateRPN("5 7.1 / 11 / -3 /"), .000001);
      assertEquals(-2.582159624, RPN.evaluateRPN("5 7.1 11 -3 / / /"), .000001);
      
      assertEquals(-0.021340162, RPN.evaluateRPN("5 7.1 / -11 / 3 /"), .000001);
      assertEquals(-2.582159624, RPN.evaluateRPN("5 7.1 -11 3 / / /"), .000001);
      
      assertEquals(-0.021340162, RPN.evaluateRPN("5 -7.1 / 11 / 3 /"), .000001);
      assertEquals(-2.582159624, RPN.evaluateRPN("5 -7.1 11 3 / / /"), .000001);
     
      assertEquals(-0.021340162, RPN.evaluateRPN("-5 7.1 / 11 / 3 /"), .000001);
      assertEquals(-2.582159624, RPN.evaluateRPN("-5 7.1 11 3 / / /"), .000001);
   }

   @Test
   public void test14_evaluateRPNExtraWhiteSpace() {
      assertEquals(-0.09523809, RPN.evaluateRPN("2  3 4 5  6  + - *  /"), .000001);
   }

   @Test
   public void test15_evaluateRPNMixed() {
      // Rotate + - * /
      assertEquals(-0.09523809, RPN.evaluateRPN("2 3 4 5 6 + - * /"), .000001);
      assertEquals(0.83333333, RPN.evaluateRPN("2 3 + 4 - 5 * 6 /"), .000001);

      assertEquals(1.25, RPN.evaluateRPN("2 3 4 5 6 - * / +"), .000001);
      assertEquals(5.2, RPN.evaluateRPN("2 3 - 4 * 5 / 6 +"), .000001);

      assertEquals(-1.13333333, RPN.evaluateRPN("2 3 4 5 6 * / + -"), .000001);
      assertEquals(0.5, RPN.evaluateRPN("2 3 * 4 / 5 + 6 -"), .000001);

      assertEquals(-3.66666666, RPN.evaluateRPN("2 3 4 5 6 / + - *"), .000001);
      assertEquals(-2.0, RPN.evaluateRPN("2 3 / 4 + 5 - 6 *"), .000001);

      // Rotate / * - +
      assertEquals(1.66666666, RPN.evaluateRPN("2 3 4 5 6 / * - +"), .000001);
      assertEquals(3.66666666, RPN.evaluateRPN("2 3 / 4 * 5 - 6 +"), .000001);

      assertEquals(-0.0869565217, RPN.evaluateRPN("2 3 4 5 6 * - + /"), .000001);
      assertEquals(1.16666666, RPN.evaluateRPN("2 3 * 4 - 5 + 6 /"), .000001);

      assertEquals(2.0, RPN.evaluateRPN("2 3 4 5 6 - + / *"), .000001);
      assertEquals(3.6, RPN.evaluateRPN("2 3 - 4 + 5 / 6 *"), .000001);

      assertEquals(0.90909090, RPN.evaluateRPN("2 3 4 5 6 + / * -"), .000001);
      assertEquals(0.25, RPN.evaluateRPN("2 3 + 4 / 5 * 6 -"), .000001);
   }

   @Test
   public void test16_evaluateRPN_SingleValue() {
      assertEquals(1.234, RPN.evaluateRPN("1.234"), .000001);
      assertEquals(-5, RPN.evaluateRPN("-5"), .000001);
   }
   
   @Test
   public void test17_toRPNPrecedenceDiv() {
      assertEquals("2 3 / 4 / 5 /", RPN.toRPN("2 / 3 / 4 / 5"));
      assertEquals("2 3 4 5 / / /", RPN.toRPN("2 / ( 3 / ( 4 / 5 ) )"));
      assertEquals("2 3 4 5 / / /", RPN.toRPN("( 2 / ( 3 / ( 4 / 5 ) ) )"));
      assertEquals("2 3 4 / / 5 /", RPN.toRPN("2 / ( 3 / 4 ) / 5"));
   }
   
   @Test
   public void test18_toRPNPrecedenceSub() {
      assertEquals("2 3 - 4 - 5 -", RPN.toRPN("2 - 3 - 4 - 5"));
      assertEquals("2 3 4 5 - - -", RPN.toRPN("2 - ( 3 - ( 4 - 5 ) )"));
      assertEquals("2 3 4 5 - - -", RPN.toRPN("( 2 - ( 3 - ( 4 - 5 ) ) )"));
      assertEquals("2 3 4 - - 5 -", RPN.toRPN("2 - ( 3 - 4 ) - 5"));
   }
 
   @Test
   public void test19_toRPNBasic() {
      assertEquals("5 9 +", RPN.toRPN("5 + 9"));
      assertEquals("5 9 -", RPN.toRPN("5 - 9"));
      assertEquals("5 9 *", RPN.toRPN("5 * 9"));
      assertEquals("5 9 /", RPN.toRPN("5 / 9"));
   }

   @Test
   public void test20_toRPNPrecedenceMixed() {
      // + +, + -, + *, + /
      assertEquals("3 4 + 5 +", RPN.toRPN("3 + 4 + 5"));
      assertEquals("3 4 + 5 -", RPN.toRPN("3 + 4 - 5"));
      assertEquals("3 4 5 * +", RPN.toRPN("3 + 4 * 5"));
      assertEquals("3 4 5 / +", RPN.toRPN("3 + 4 / 5"));

      // - +, - -, - *, - / 
      assertEquals("3 4 - 5 +", RPN.toRPN("3 - 4 + 5"));
      assertEquals("3 4 - 5 -", RPN.toRPN("3 - 4 - 5"));
      assertEquals("3 4 5 * -", RPN.toRPN("3 - 4 * 5"));
      assertEquals("3 4 5 / -", RPN.toRPN("3 - 4 / 5"));

      // * +, * -, * *,  * / 
      assertEquals("3 4 * 5 +", RPN.toRPN("3 * 4 + 5"));
      assertEquals("3 4 * 5 -", RPN.toRPN("3 * 4 - 5"));
      assertEquals("3 4 * 5 *", RPN.toRPN("3 * 4 * 5"));
      assertEquals("3 4 * 5 /", RPN.toRPN("3 * 4 / 5"));

      // / +, / -, / *, / /
      assertEquals("3 4 / 5 +", RPN.toRPN("3 / 4 + 5"));
      assertEquals("3 4 / 5 -", RPN.toRPN("3 / 4 - 5"));
      assertEquals("3 4 / 5 *", RPN.toRPN("3 / 4 * 5"));
      assertEquals("3 4 / 5 /", RPN.toRPN("3 / 4 / 5"));
   }

   @Test
   public void test21_toRPNComplex() {
      assertEquals("5 4 + 3 - 6 *", RPN.toRPN("( ( ( 5 + 4 ) - 3 ) * 6 )"));
      assertEquals("5 4 + 3 - 6 *", RPN.toRPN("( ( 5 + 4 ) - 3 ) * 6"));
      assertEquals("5 4 3 + 7 - * 6 /", RPN.toRPN("( 5 * ( 4 + 3 - 7 ) / 6 )"));
      assertEquals("5 4 3 + 7 - * 6 /", RPN.toRPN("5 * ( 4 + 3 - 7 ) / 6"));
   }

   @Test
   public void test22_mixed() {
      assertEquals("5 6 3 + 7 3 * - 2 + * 6 /", RPN.toRPN("5 * ( 6 + 3 - 7 * 3 + 2 ) / 6"));
      assertEquals(5.0, RPN.evaluateRPN("6 4 3 + 2 - * 6 /"), .000001);
      assertEquals(18.0, RPN.evaluateRPN("5 2 4 * + 7 2 - 4 6 2 / 2 - * + 4 - +"), .000001);
      assertEquals("8 3 4 * + 6 2 - 2 6 3 / 1 - * + 3 - +", RPN.toRPN("8 + 3 * 4 + ( 6 - 2 + 2 * ( 6 / 3 - 1 ) - 3 )"));

   }
   
   @Test
   public void test23_evaluateInfixComplex() {
      assertEquals(5589.854285714286, RPN.evaluateInfix("( 3 + 2 ) + 8 / 3 * 17 - ( 12 / 4.2 / 1.2 - 8 * 6 ) * ( ( 6.9 * 17 + 23 / 6 - 2.2 ) - 3.2 - ( 56 / 21 * 1.4 ) + 2.3 * 4.1 )"), .000001);
      assertEquals(32.72934207499424, RPN.evaluateInfix("( ( ( ( 38 * 1.2 + 3.6 / 2.8 - 6 ) + 3.7 / 2 / 5 - 3 + 23 ) / 1.1 + 2.2 ) - 2.4 / 5 - 1 ) + ( 1.6 / 3 / 9 * 2.8 - 3 - ( 6.2 / 4 + ( 12.8 * 2 / 1.1 - 4.4 / ( 3.2 - 1.1 / 5.2 * 9.9 ) ) ) )"), .000001);
      assertEquals(34.72934207499424, RPN.evaluateInfix("2 + ( ( ( ( 38 * 1.2 + 3.6 / 2.8 - 6 ) + 3.7 / 2 / 5 - 3 + 23 ) / 1.1 + 2.2 ) - 2.4 / 5 - 1 ) + ( 1.6 / 3 / 9 * 2.8 - 3 - ( 6.2 / 4 + ( 12.8 * 2 / 1.1 - 4.4 / ( 3.2 - 1.1 / 5.2 * 9.9 ) ) ) )"), .000001);
      assertEquals(30.72934207499424, RPN.evaluateInfix("( ( ( ( 38 * 1.2 + 3.6 / 2.8 - 6 ) + 3.7 / 2 / 5 - 3 + 23 ) / 1.1 + 2.2 ) - 2.4 / 5 - 1 ) + ( 1.6 / 3 / 9 * 2.8 - 3 - ( 6.2 / 4 + ( 12.8 * 2 / 1.1 - 4.4 / ( 3.2 - 1.1 / 5.2 * 9.9 ) ) ) ) + -2"), .000001);
   }

   @Test
   public void test24_evaluateInfixLarge() {
      assertEquals(3000000.3, RPN.evaluateInfix("1000000.1 + 2000000.2"), .000001);
      assertEquals(3333333333.333333, RPN.evaluateInfix("1111111111.111111 + 2222222222.222222"), .000001);
   }

   @Test
   public void test25_evaluateENotation() {
      assertEquals(3.579E10, RPN.evaluateInfix("1.234E10 + 2.345E10"), .000001);
   }
}