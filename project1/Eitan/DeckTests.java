public class DeckTests {

   public static void main(String[] args) {
      Deck deck = new Deck(false);

      for (int i = 0; i < 11; i++) {
         deck.draw();
      }

      deck.shuffle();

      System.out.println("deck size: " + deck.size());

      while (deck.size() > 0) {
         System.out.println(deck.draw());
      }
   }
}
