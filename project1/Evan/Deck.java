/**
 *Deck class
 *
 *
 *
 *@author Evan Jameson
 *@version Project 1
 */
import java.util.*;
import java.util.NoSuchElementException;


public class Deck extends CircularQueue<Card>
{
   public Deck(boolean shuffle)
   {  
      //create a normal correctly ordered deck
      for(int i = 1; i < 5; i++)
      {
          for(int j = 1; j < 14; j++)
          {
             super.enqueue(new Card(j,i));
          }
      }
      
      //Shuffle the deck that has been made fam
      if(shuffle)
      {
         shuffle();
      }
   }

   public void shuffle()
   {
      //do the shuffle fam
      ArrayList<Card> oldDeck = new ArrayList<Card>();
      Random rand = new Random(); 
      int deckSize = super.size(); 
      //Emptying the deck queue and putting them into an arraylist
      for(int i = 0; i < deckSize; i++)
      {
         oldDeck.add(super.dequeue());
      }
      
      //1000 shuffles
      for(int j = 0; j < 100000; j++)
      {
         int spot1 = rand.nextInt(deckSize);
         Card card1 = oldDeck.get(spot1);
         oldDeck.remove(spot1);
         oldDeck.add(card1);
      }
      
      //Put the deck back into the queue
      for(int l = 0; l < oldDeck.size(); l++)
      {
         super.enqueue(oldDeck.get(l));
      }
   }

   public Card draw()
   {
      if(super.size() == 0)//if deck is empty
      {
         throw new NoSuchElementException();
      }
      else
      {
         return super.dequeue();         
      }
   }
}
