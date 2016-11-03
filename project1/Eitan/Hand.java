import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * A class to keep track of cards in hand.
 *
 * @author Eitan Simler
 * @version Project1
 */


public class Hand {

   // Instance Variables
   private Deck deck;
   private ArrayList<Card> myHand = new ArrayList<>();

   // Constructor
   public Hand(Deck deck, int handSize) {
      // Check if handSize non-positive
      if (handSize < 1) {
         throw new IllegalArgumentException();
      }

      // Check deck size
      if (deck.size() < handSize) {
         throw new NoSuchElementException();
      }

      // Check if deck is null
      if (deck == null) {
         throw new NullPointerException();
      }
      
      this.deck = deck;
      
      // Add cards to myHand from deck
      for (int i = 0; i < handSize; i++) {
         myHand.add(deck.dequeue());
      }
   }

   // Methods
   public void draw() {
      // Check if deck is empty
      if (deck.size() == 0) {
         throw new NoSuchElementException();
      }

      // Add to myHand from deck
      myHand.add(deck.dequeue());
   }

   public Card getCard(int cardNumber) {
      // Check if index valid
      if (cardNumber < 0 || cardNumber >= this.size()) {
         throw new IndexOutOfBoundsException();
      }

      // Return card at specified location
      return myHand.get(cardNumber);
   }

   public Card play(int cardNumber) {
      // Check if index valid
      if (cardNumber < 0 || cardNumber >= this.size()) {
         throw new IndexOutOfBoundsException();
      }

      // Remove and return card at specified location
      return myHand.remove(cardNumber);
   }

   public int size() {
      return myHand.size();
   }
}
