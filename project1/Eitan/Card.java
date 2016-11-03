/**
 * A simple card class.
 *
 * @author Eitan Simler
 * @version Project1
 */

public class Card {

   // Instance Variables
   private int rank, suit;
   private static final String[] ranks = new String[] {"Ace", "2", "3",
      "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
   private static final String[] suits = new String[] {"Spades", "Hearts",
      "Diamonds", "Clubs"};

   // Constructor
   public Card(int rank, int suit) {
      // Check if rank is invalid
      if (rank < 1 || rank > 13) {
         throw new IllegalArgumentException();
      }
      
      // Check if suit is invalid
      if (suit < 1 || suit > 4) {
         throw new IllegalArgumentException();
      }

      this.rank = rank - 1;
      this.suit = suit - 1;
   }

   public String getRank() {
      return ranks[rank];
   }

   public String getSuit() {
      return suits[suit];
   }

   @Override
   public String toString() {
      return getRank() + " of " + getSuit();   
   }
}
