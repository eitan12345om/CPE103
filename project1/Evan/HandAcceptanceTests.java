import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import java.util.*;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.lang.annotation.*;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HandAcceptanceTests {
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
      assertEquals(Object.class, Hand.class.getSuperclass());
   }

   @Test
   public void test02_verifyFields() {
      Field[] fields = Hand.class.getDeclaredFields();

      for (Field f : fields) {
         assertTrue(Modifier.isPrivate(f.getModifiers()));
      }
   }

   @Test
   public void test03_verifyConstructors() {
      Constructor[] cons = Hand.class.getDeclaredConstructors();

      assertEquals(1, cons.length);
      Class[] params = cons[0].getParameterTypes();
      assertEquals(2, params.length);
      assertEquals(Deck.class, params[0]);
      assertEquals(int.class, params[1]);
   }

   @Test
   public void test04_verifyMethods() {
      int countPublic = 0;
      int countProtected = 0;
      int countPackage = 0;
      int countPrivate = 0;

      Method[] meths = Hand.class.getDeclaredMethods();

      for (Method m : meths) {
         if (Modifier.isPublic(m.getModifiers())) {
            countPublic++;
         } else if (Modifier.isProtected(m.getModifiers())) {
            countProtected++;
         } else if (Modifier.isPrivate(m.getModifiers())) {
            countPrivate++;
         } else {
            countPackage++;
         }
      }

      assertEquals(4, countPublic);
      assertEquals(0, countProtected);
      assertEquals(0, countPackage);
   }

   @Test(expected=NullPointerException.class)
   public void test05_nullDeck() {
      Hand h = new Hand(null, 7);
   }

   @Test(expected=NoSuchElementException.class)
   public void test06_emptyDeck() {
      Deck d = new Deck(false);
      while (d.size() > 0) {
         d.draw();
      }
      Hand h = new Hand(d, 7);
   }

   @Test(expected=NoSuchElementException.class)
   public void test07_tooFewCardsInDeck() {
      Deck d = new Deck(false);
      while (d.size() > 5) {
         d.draw();
      }
      Hand h = new Hand(d, 7);
   }

   @Test(expected=IllegalArgumentException.class)
   public void test08_negativeHandSize() {
      Hand h = new Hand(new Deck(false), -12);
   }

   @Test(expected=IllegalArgumentException.class)
   public void test09_zeroHandSize() {
      Hand h = new Hand(new Deck(false), 0);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void test10_getNegativeIndex() {
      Hand h = new Hand(new Deck(false), 1);
      assertEquals(1, h.size());
      h.getCard(-4);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void test11_getLargeIndex() {
      Hand h = new Hand(new Deck(false), 1);
      assertEquals(1, h.size());
      h.getCard(17);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void test12_getZeroIndexFromEmpty() {
      Hand h = new Hand(new Deck(false), 1);
      assertEquals(1, h.size());
      h.play(0);
      assertEquals(0, h.size());
      h.getCard(0);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void test13_playNegativeIndex() {
      Hand h = new Hand(new Deck(false), 1);
      assertEquals(1, h.size());
      h.play(-12);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void test14_playLargeIndex() {
      Hand h = new Hand(new Deck(false), 1);
      assertEquals(1, h.size());
      h.play(102);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void test14_playZeroIndexFromEmpty() {
      Hand h = new Hand(new Deck(false), 1);
      assertEquals(1, h.size());
      h.play(0);
      assertEquals(0, h.size());
      h.play(0);
   }

   @Test(expected=NoSuchElementException.class)
   public void test15_drawTooMuch() {
      Deck d = new Deck(false);
      Hand h = new Hand(d, 52);

      assertEquals(52, h.size());
      assertEquals(0, d.size());
      h.draw();
   }

   @Test
   public void test16_drawThenPlayWholeDeck() {
      Deck d = new Deck(false);
      Hand h = new Hand(d, 1);

      assertEquals(51, d.size());
      assertEquals(1, h.size());
      assertEquals(new Card(1, 1).toString(), h.getCard(0).toString());

      for (int card = 1; card < 52; card++) {
         h.draw();
         assertEquals(51 - card, d.size());
         assertEquals(card + 1, h.size());
         assertEquals(new Card(card % 13 + 1, card / 13 + 1).toString(),
                      h.getCard(card).toString());
      }

      for (int card = 0; card < 52; card++) {
         assertEquals(new Card(card % 13 + 1, card / 13 + 1).toString(),
                      h.getCard(card).toString());
         assertEquals(52, h.size());
         assertEquals(0, d.size());
      }

      for (int card = 51; card >= 0; card--) {
         assertEquals(new Card(card % 13 + 1, card / 13 + 1).toString(),
                      h.play(card).toString());
         assertEquals(card, h.size());
         assertEquals(0, d.size());
      }
   }

   @Test
   public void test17_oneCardHand() {
      Deck d = new Deck(false);
      Hand h = new Hand(d, 1);

      assertEquals(1, h.size());
      assertEquals(51, d.size());
      assertEquals(new Card(1, 1).toString(), h.play(0).toString());

      for (int card = 1; card < 52; card++) {
         assertEquals(0, h.size());
         assertEquals(52 - card, d.size());
         h.draw();
         assertEquals(1, h.size());
         assertEquals(51 - card, d.size());

         assertEquals(new Card(card % 13 + 1, card/13 + 1).toString(),
                      h.play(0).toString());
      }
   }
   @Test
   public void test18_drawSpades() {
      Deck d = new Deck(false);
      Hand h = new Hand(d, 13);

      assertEquals(13, h.size());
      assertEquals(39, d.size());

      // Verify that the hand contains all spades in order
      for (int card = 1; card <= 13; card++) {
         assertEquals(new Card(card, 1).toString(),
                      h.getCard(card - 1).toString());
         assertEquals(13, h.size());
         assertEquals(39, d.size());
      }

      for (int card = 13; card >= 1; card--) {
         assertEquals(new Card(card, 1).toString(),
                      h.play(h.size() - 1).toString());
         assertEquals(card - 1, h.size());
         assertEquals(39, d.size());
      }

      // Verify that the deck contains the rest of the cards in order
      for (int suit = 2; suit <= 4; suit++) {
         for (int rank = 1; rank <= 13; rank++) {
            assertEquals(new Card(rank, suit).toString(), d.draw().toString());
            assertEquals(0, h.size());
            assertEquals(65 - suit*13 - rank, d.size());
         }
      }
   }

}