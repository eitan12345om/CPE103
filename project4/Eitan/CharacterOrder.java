/**
 * Subclass of MorseCode whose natural ordering will be based on the Character
 * values.
 *
 * @author Eitan Simler
 * @version Project4
 */

public class CharacterOrder extends MorseCode implements Comparable<CharacterOrder> {

   // Constructors
   public CharacterOrder(MorseCode other) {
      super(other);
   }

   public CharacterOrder(Character character, String code) {
      super(character, code);
   }

   // Method as required by the interface
   public int compareTo(CharacterOrder other) {
      return this.getCharacter().compareTo(other.getCharacter());
   }

}
