import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit tests for Card.
 *
 * @author Eitan Simler
 * @version Project1
 */

public class CardTests {

   @Test(expected=IllegalArgumentException.class)
   public void testIllegalRank_tooLow() {
      Card card = new Card(0, 2);
   }

   @Test(expected=IllegalArgumentException.class)
   public void testIllegalRank_tooHigh() {
      Card card = new Card(14, 2);
   } 

   @Test(expected=IllegalArgumentException.class)
   public void testIllegalSuit_tooLow() {
      Card card = new Card(4, 0);
   }

   @Test(expected=IllegalArgumentException.class)
   public void testIllegalSuit_tooHigh() {
      Card card = new Card(4, 15);
   }

   @Test
   public void testAceOfSpades() {
      Card card = new Card(1, 1);
      assertEquals(card.getRank(), "Ace");
      assertEquals(card.getSuit(), "Spades");
      assertEquals(card.toString(), "Ace of Spades");
   }

   @Test
   public void test2OfSpades() {
      Card card = new Card(2, 1);
      assertEquals(card.getRank(), "2");
      assertEquals(card.getSuit(), "Spades");
      assertEquals(card.toString(), "2 of Spades");
   }

   @Test
   public void test3OfSpades() {
      Card card = new Card(3, 1);
      assertEquals(card.getRank(), "3");
      assertEquals(card.getSuit(), "Spades");
      assertEquals(card.toString(), "3 of Spades");
   }

   @Test
   public void test4OfSpades() {
      Card card = new Card(4, 1);
      assertEquals(card.getRank(), "4");
      assertEquals(card.getSuit(), "Spades");
      assertEquals(card.toString(), "4 of Spades");
   }

   @Test
   public void test5OfSpades() {
      Card card = new Card(5, 1);
      assertEquals(card.getRank(), "5");
      assertEquals(card.getSuit(), "Spades");
      assertEquals(card.toString(), "5 of Spades");
   }

   @Test
   public void test6OfSpades() {
      Card card = new Card(6, 1);
      assertEquals(card.getRank(), "6");
      assertEquals(card.getSuit(), "Spades");
      assertEquals(card.toString(), "6 of Spades");
   }

   @Test
   public void test7OfSpades() {
      Card card = new Card(7, 1);
      assertEquals(card.getRank(), "7");
      assertEquals(card.getSuit(), "Spades");
      assertEquals(card.toString(), "7 of Spades");
   }

   @Test
   public void test8OfSpades() {
      Card card = new Card(8, 1);
      assertEquals(card.getRank(), "8");
      assertEquals(card.getSuit(), "Spades");
      assertEquals(card.toString(), "8 of Spades");
   }

   @Test
   public void test9OfSpades() {
      Card card = new Card(9, 1);
      assertEquals(card.getRank(), "9");
      assertEquals(card.getSuit(), "Spades");
      assertEquals(card.toString(), "9 of Spades");
   }

   @Test
   public void test10OfSpades() {
      Card card = new Card(10, 1);
      assertEquals(card.getRank(), "10");
      assertEquals(card.getSuit(), "Spades");
      assertEquals(card.toString(), "10 of Spades");
   }

   @Test
   public void testJackOfSpades() {
      Card card = new Card(11, 1);
      assertEquals(card.getRank(), "Jack");
      assertEquals(card.getSuit(), "Spades");
      assertEquals(card.toString(), "Jack of Spades");
   }

   @Test
   public void testQueenOfSpades() {
      Card card = new Card(12, 1);
      assertEquals(card.getRank(), "Queen");
      assertEquals(card.getSuit(), "Spades");
      assertEquals(card.toString(), "Queen of Spades");
   }

   @Test
   public void testKingOfSpades() {
      Card card = new Card(13, 1);
      assertEquals(card.getRank(), "King");
      assertEquals(card.getSuit(), "Spades");
      assertEquals(card.toString(), "King of Spades");
   }

   @Test
   public void testAceOfHearts() {
      Card card = new Card(1, 2);
      assertEquals(card.getRank(), "Ace");
      assertEquals(card.getSuit(), "Hearts");
      assertEquals(card.toString(), "Ace of Hearts");
   }

   @Test
   public void test2OfHearts() {
      Card card = new Card(2, 2);
      assertEquals(card.getRank(), "2");
      assertEquals(card.getSuit(), "Hearts");
      assertEquals(card.toString(), "2 of Hearts");
   }

   @Test
   public void test3OfHearts() {
      Card card = new Card(3, 2);
      assertEquals(card.getRank(), "3");
      assertEquals(card.getSuit(), "Hearts");
      assertEquals(card.toString(), "3 of Hearts");
   }

   @Test
   public void test4OfHearts() {
      Card card = new Card(4, 2);
      assertEquals(card.getRank(), "4");
      assertEquals(card.getSuit(), "Hearts");
      assertEquals(card.toString(), "4 of Hearts");
   }

   @Test
   public void test5OfHearts() {
      Card card = new Card(5, 2);
      assertEquals(card.getRank(), "5");
      assertEquals(card.getSuit(), "Hearts");
      assertEquals(card.toString(), "5 of Hearts");
   }

   @Test
   public void test6OfHearts() {
      Card card = new Card(6, 2);
      assertEquals(card.getRank(), "6");
      assertEquals(card.getSuit(), "Hearts");
      assertEquals(card.toString(), "6 of Hearts");
   }

   @Test
   public void test7OfHearts() {
      Card card = new Card(7, 2);
      assertEquals(card.getRank(), "7");
      assertEquals(card.getSuit(), "Hearts");
      assertEquals(card.toString(), "7 of Hearts");
   }

   @Test
   public void test8OfHearts() {
      Card card = new Card(8, 2);
      assertEquals(card.getRank(), "8");
      assertEquals(card.getSuit(), "Hearts");
      assertEquals(card.toString(), "8 of Hearts");
   }

   @Test
   public void test9OfHearts() {
      Card card = new Card(9, 2);
      assertEquals(card.getRank(), "9");
      assertEquals(card.getSuit(), "Hearts");
      assertEquals(card.toString(), "9 of Hearts");
   }

   @Test
   public void test10OfHearts() {
      Card card = new Card(10, 2);
      assertEquals(card.getRank(), "10");
      assertEquals(card.getSuit(), "Hearts");
      assertEquals(card.toString(), "10 of Hearts");
   }

   @Test
   public void testJackOfHearts() {
      Card card = new Card(11, 2);
      assertEquals(card.getRank(), "Jack");
      assertEquals(card.getSuit(), "Hearts");
      assertEquals(card.toString(), "Jack of Hearts");
   }

   @Test
   public void testQueenOfHearts() {
      Card card = new Card(12, 2);
      assertEquals(card.getRank(), "Queen");
      assertEquals(card.getSuit(), "Hearts");
      assertEquals(card.toString(), "Queen of Hearts");
   }

   @Test
   public void testKingOfHearts() {
      Card card = new Card(13, 2);
      assertEquals(card.getRank(), "King");
      assertEquals(card.getSuit(), "Hearts");
      assertEquals(card.toString(), "King of Hearts");
   }

   @Test
   public void testAceOfDiamonds() {
      Card card = new Card(1, 3);
      assertEquals(card.getRank(), "Ace");
      assertEquals(card.getSuit(), "Diamonds");
      assertEquals(card.toString(), "Ace of Diamonds");
   }

   @Test
   public void test2OfDiamonds() {
      Card card = new Card(2, 3);
      assertEquals(card.getRank(), "2");
      assertEquals(card.getSuit(), "Diamonds");
      assertEquals(card.toString(), "2 of Diamonds");
   }

   @Test
   public void test3OfDiamonds() {
      Card card = new Card(3, 3);
      assertEquals(card.getRank(), "3");
      assertEquals(card.getSuit(), "Diamonds");
      assertEquals(card.toString(), "3 of Diamonds");
   }

   @Test
   public void test4OfDiamonds() {
      Card card = new Card(4, 3);
      assertEquals(card.getRank(), "4");
      assertEquals(card.getSuit(), "Diamonds");
      assertEquals(card.toString(), "4 of Diamonds");
   }

   @Test
   public void test5OfDiamonds() {
      Card card = new Card(5, 3);
      assertEquals(card.getRank(), "5");
      assertEquals(card.getSuit(), "Diamonds");
      assertEquals(card.toString(), "5 of Diamonds");
   }

   @Test
   public void test6OfDiamonds() {
      Card card = new Card(6, 3);
      assertEquals(card.getRank(), "6");
      assertEquals(card.getSuit(), "Diamonds");
      assertEquals(card.toString(), "6 of Diamonds");
   }

   @Test
   public void test7OfDiamonds() {
      Card card = new Card(7, 3);
      assertEquals(card.getRank(), "7");
      assertEquals(card.getSuit(), "Diamonds");
      assertEquals(card.toString(), "7 of Diamonds");
   }

   @Test
   public void test8OfDiamonds() {
      Card card = new Card(8, 3);
      assertEquals(card.getRank(), "8");
      assertEquals(card.getSuit(), "Diamonds");
      assertEquals(card.toString(), "8 of Diamonds");
   }

   @Test
   public void test9OfDiamonds() {
      Card card = new Card(9, 3);
      assertEquals(card.getRank(), "9");
      assertEquals(card.getSuit(), "Diamonds");
      assertEquals(card.toString(), "9 of Diamonds");
   }

   @Test
   public void test10OfDiamonds() {
      Card card = new Card(10, 3);
      assertEquals(card.getRank(), "10");
      assertEquals(card.getSuit(), "Diamonds");
      assertEquals(card.toString(), "10 of Diamonds");
   }

   @Test
   public void testJackOfDiamonds() {
      Card card = new Card(11, 3);
      assertEquals(card.getRank(), "Jack");
      assertEquals(card.getSuit(), "Diamonds");
      assertEquals(card.toString(), "Jack of Diamonds");
   }

   @Test
   public void testQueenOfDiamonds() {
      Card card = new Card(12, 3);
      assertEquals(card.getRank(), "Queen");
      assertEquals(card.getSuit(), "Diamonds");
      assertEquals(card.toString(), "Queen of Diamonds");
   }

   @Test
   public void testKingOfDiamonds() {
      Card card = new Card(13, 3);
      assertEquals(card.getRank(), "King");
      assertEquals(card.getSuit(), "Diamonds");
      assertEquals(card.toString(), "King of Diamonds");
   }

   @Test
   public void testAceOfClubs() {
      Card card = new Card(1, 4);
      assertEquals(card.getRank(), "Ace");
      assertEquals(card.getSuit(), "Clubs");
      assertEquals(card.toString(), "Ace of Clubs");
   }

   @Test
   public void test2OfClubs() {
      Card card = new Card(2, 4);
      assertEquals(card.getRank(), "2");
      assertEquals(card.getSuit(), "Clubs");
      assertEquals(card.toString(), "2 of Clubs");
   }

   @Test
   public void test3OfClubs() {
      Card card = new Card(3, 4);
      assertEquals(card.getRank(), "3");
      assertEquals(card.getSuit(), "Clubs");
      assertEquals(card.toString(), "3 of Clubs");
   }

   @Test
   public void test4OfClubs() {
      Card card = new Card(4, 4);
      assertEquals(card.getRank(), "4");
      assertEquals(card.getSuit(), "Clubs");
      assertEquals(card.toString(), "4 of Clubs");
   }

   @Test
   public void test5OfClubs() {
      Card card = new Card(5, 4);
      assertEquals(card.getRank(), "5");
      assertEquals(card.getSuit(), "Clubs");
      assertEquals(card.toString(), "5 of Clubs");
   }

   @Test
   public void test6OfClubs() {
      Card card = new Card(6, 4);
      assertEquals(card.getRank(), "6");
      assertEquals(card.getSuit(), "Clubs");
      assertEquals(card.toString(), "6 of Clubs");
   }

   @Test
   public void test7OfClubs() {
      Card card = new Card(7, 4);
      assertEquals(card.getRank(), "7");
      assertEquals(card.getSuit(), "Clubs");
      assertEquals(card.toString(), "7 of Clubs");
   }

   @Test
   public void test8OfClubs() {
      Card card = new Card(8, 4);
      assertEquals(card.getRank(), "8");
      assertEquals(card.getSuit(), "Clubs");
      assertEquals(card.toString(), "8 of Clubs");
   }

   @Test
   public void test9OfClubs() {
      Card card = new Card(9, 4);
      assertEquals(card.getRank(), "9");
      assertEquals(card.getSuit(), "Clubs");
      assertEquals(card.toString(), "9 of Clubs");
   }

   @Test
   public void test10OfClubs() {
      Card card = new Card(10, 4);
      assertEquals(card.getRank(), "10");
      assertEquals(card.getSuit(), "Clubs");
      assertEquals(card.toString(), "10 of Clubs");
   }

   @Test
   public void testJackOfClubs() {
      Card card = new Card(11, 4);
      assertEquals(card.getRank(), "Jack");
      assertEquals(card.getSuit(), "Clubs");
      assertEquals(card.toString(), "Jack of Clubs");
   }

   @Test
   public void testQueenOfClubs() {
      Card card = new Card(12, 4);
      assertEquals(card.getRank(), "Queen");
      assertEquals(card.getSuit(), "Clubs");
      assertEquals(card.toString(), "Queen of Clubs");
   }

   @Test
   public void testKingOfClubs() {
      Card card = new Card(13, 4);
      assertEquals(card.getRank(), "King");
      assertEquals(card.getSuit(), "Clubs");
      assertEquals(card.toString(), "King of Clubs");
   }
}
