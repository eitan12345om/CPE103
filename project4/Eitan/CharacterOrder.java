/**
 * Subclass of MorseCode whose natural ordering will be based on the Character
 * values.
 *
 * @author Eitan Simler
 * @version Project4
 */

public class CharacterOrder extends MorseCode implements Comparable<CharacterOrder> {

   // TODO: Add constructors!
   // Constructors
   

   // Method as required by the interface
   public int compareTo(CharacterOrder other) {
      this.getCharacter().compareTo(other.getCharacter());
   }

}
