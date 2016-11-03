import java.util.Random;
import java.util.NoSuchElementException;

/**
 * A simple deck class which extends CircularQueue.
 *
 * @author Eitan Simler
 * @version Project1
 */

public class Deck extends CircularQueue<Card> {

   // Contstructor
   public Deck(boolean shuffle) {
      super(52);

      for (int i = 1; i < 5; i++) {
         for (int j = 1; j < 14; j++) {
            super.enqueue(new Card(j, i));
         }     
      }

      if (shuffle) {
         shuffle();
      }
   }

   // Methods
   public void shuffle() {
      int randNum = new Random().nextInt(10) + 5;
      Random rand = new Random();
      CircularQueue<Card> pile1 = new CircularQueue<>(52);
      CircularQueue<Card> pile2 = new CircularQueue<>(52);

      for (int i = 0; i < randNum; i++) {
         // Split deck into two piles
         while (super.size() > 0) {
            if (rand.nextBoolean()) {
               pile1.enqueue(super.dequeue());
            }
            else {
               pile2.enqueue(super.dequeue());
            }
         }

         // Add cards back to deck
         while (pile2.size() > 0) {   
            super.enqueue(pile2.dequeue());
         }

         while (pile1.size() > 0) {
            super.enqueue(pile1.dequeue());
         }
      } 
   }

   public Card draw() {
      // Check if deck empty
      if (super.size() < 1) {
         throw new NoSuchElementException();
      }

      return super.dequeue();
   }
}
