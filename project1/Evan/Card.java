/**
 *Card Class
 *
 *
 *@author Evan Jameson
 *@version Project 1
 */

import java.util.*;


public class Card
{
   private int rank;
   private int suit;

   public Card(int rank, int suit)
   {
      if(0 < rank && rank < 14 && 0 < suit && suit < 5)
      {
         this.rank = rank;
         this.suit = suit;
      }
      else
      {
         throw new IllegalArgumentException();
      }
   }

   public String getRank()
   {
      if(rank == 1)
      {
         return "Ace";
      }
      else if(rank == 11)
      {
         return "Jack";
      }
      else if(rank == 12)
      {
         return "Queen";
      }
      else if(rank == 13)
      {
         return "King";
      }
      else
      {
      return Integer.toString(rank); 
      }
   }

   public String getSuit()
   {
      if(suit == 1)
      {
         return "Spades";
      }
      else if (suit == 2)
      {
         return "Hearts";
      }
      else if (suit == 3)
      {
         return "Diamonds";
      }
      else
      {
         return "Clubs";
      }
   }

   public String toString()
   {
      return (getRank() + " of " + getSuit());
   }

}
