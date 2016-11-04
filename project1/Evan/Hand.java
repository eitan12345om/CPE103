/**
 *Hand class
 *
 *
 *
 *@author Evan Jameson
 *@version Project 1
 */
import java.util.*;


public class Hand
{
   private Deck deck;
   private int handSize;
   private ArrayList<Card> hand = new ArrayList<Card>();
   public Hand(Deck deck, int handSize)
   {
      if(handSize < 1)
      {
         throw new IllegalArgumentException();
      }

      else if(deck.size() < handSize)
      {
         throw new NoSuchElementException();
      }
   
      else if(deck == null)
      {
         throw new NullPointerException();
      }
 
      else
      {
         this.deck = deck;
         this.handSize = handSize;
         //loop to draw cards to the specified size
         for(int i = 0; i < handSize; i++)
         {
            draw();
         }
      }
   }

   public void draw()
   {
      if(deck.size() == 0)
      {
         throw new NoSuchElementException();
      }
      //draw stuff here
      hand.add(deck.draw());
      //handSize++;
   }

   public Card getCard(int cardNumber)
   {
      if(0 > cardNumber || cardNumber == hand.size())
      {
         throw new IndexOutOfBoundsException();
      }
      return hand.get(cardNumber);
   }

   public Card play(int cardNumber)
   {
      if(0 > cardNumber || cardNumber == hand.size())
      {
         throw new IndexOutOfBoundsException();
      }
      //handSize--;
      return hand.remove(cardNumber);
   }

   public int size()
   {
      return hand.size();
   }
}
