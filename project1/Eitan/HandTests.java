import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

/**
 * JUnit tests for Card.
 *
 * @author Eitan Simler
 * @version Project1
 */

public class HandTests {

   @Test (expected=NullPointerException.class)
   public void testDeckNull_atConstruction() {
      Deck deck = null;
      Hand hand = new Hand(deck, 10);  
   }

   @Test (expected=NoSuchElementException.class)
   public void testDeck_lessThanHandSize_atConstruction() {
      Deck deck = new Deck(false);
      Hand hand = new Hand(deck, 53);  
   }

   @Test (expected=NoSuchElementException.class)
   public void testDeck_lessThanHandSize2_atConstruction() {
      Deck deck = new Deck(false);
      for (int i = 0; i < 50; i++) {
         deck.draw();
      }
      Hand hand = new Hand(deck, 3);  
   }

   @Test (expected=IllegalArgumentException.class)
   public void testHandSizeTooSmall_atConstruction() {
      Deck deck = new Deck(false);
      Hand hand = new Hand(deck, 0);  
   }

   @Test
   public void testSize_atConstruction() {
      Hand hand = new Hand(new Deck(true), 10);
      assertEquals(hand.size(), 10);
   }

   @Test (expected=NoSuchElementException.class)
   public void testDeckShuffled_lessThanHandSize_atConstruction() {
      Hand hand = new Hand(new Deck(true), 53);  
   }

   @Test (expected=NoSuchElementException.class)
   public void testDeckShuffled_lessThanHandSize2_atConstruction() {
      Deck deck = new Deck(true);
      for (int i = 0; i < 50; i++) {
         deck.draw();
      }
      Hand hand = new Hand(deck, 3);  
   }

   @Test (expected=IllegalArgumentException.class)
   public void testHandSizeTooSmallShuffled_atConstruction() {
      Hand hand = new Hand(new Deck(true), 0);  
   }

   @Test
   public void testSizeShuffled_atConstruction() {
      Hand hand = new Hand(new Deck(true), 10);
      assertEquals(hand.size(), 10);
   }

   @Test
   public void testDraw_Size() {
      Hand hand = new Hand(new Deck(false), 10);
      hand.draw();
      assertEquals(hand.size(), 11);
   }

   @Test
   public void testDrawShuffled_Size() {
      Hand hand = new Hand(new Deck(true), 10);
      hand.draw();
      assertEquals(hand.size(), 11);
   }

   @Test
   public void testPlay_atConstruction() {
      Hand hand = new Hand(new Deck(false), 10);
      hand.play(1);
      assertEquals(hand.size(), 9);
   }

   @Test
   public void testPlayShuffled_atConstruction() {
      Hand hand = new Hand(new Deck(true), 10);
      hand.play(1);
      assertEquals(hand.size(), 9);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testPlay_tooHigh_atConstruction() {
      Hand hand = new Hand(new Deck(false), 10);
      hand.play(hand.size());
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testPlayShuffled_tooHigh_atConstruction() {
      Hand hand = new Hand(new Deck(true), 10);
      hand.play(hand.size());
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testPlay_tooLow_atConstruction() {
      Hand hand = new Hand(new Deck(false), 10);
      hand.play(-1);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testPlayShuffled_tooLow_atConstruction() {
      Hand hand = new Hand(new Deck(true), 10);
      hand.play(-1);
   }

   @Test 
   public void testPlayReturn_atConstruction() {
      Hand hand = new Hand(new Deck(false), 10);
      assertTrue(cardEquals(hand.play(0), new Card(1, 1)));
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testGetCard_tooLow_atConstruction() {
      Hand hand = new Hand(new Deck(false), 10);
      hand.getCard(-1);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testGetCardShuffled_tooLow_atConstruction() {
      Hand hand = new Hand(new Deck(true), 10);
      hand.getCard(-1);
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testGetCard_tooHigh_atConstruction() {
      Hand hand = new Hand(new Deck(false), 10);
      hand.getCard(hand.size());
   }

   @Test (expected=IndexOutOfBoundsException.class)
   public void testGetCardShuffled_tooHigh_atConstruction() {
      Hand hand = new Hand(new Deck(true), 10);
      hand.getCard(hand.size());
   }

   @Test 
   public void testGetCardReturn_atConstruction() {
      Hand hand = new Hand(new Deck(false), 10);
      assertTrue(cardEquals(hand.getCard(0), new Card(1,1)));
   }

   // private auxillary method
   private boolean cardEquals(Card c1, Card c2) {
      if (c1.toString().equals(c2.toString())) {
         return true;
      }
      return false;
   }
}
