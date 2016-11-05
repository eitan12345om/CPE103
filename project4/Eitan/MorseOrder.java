/**
 * Subclass of MorseCode whose natural ordering will be based on the Morse Code
 * strings.
 *
 * @author Eitan Simler
 * @version Project4
 */

public class MorseOrder extends MorseCode implements Comparable<MorseOrder> {

   // Constructors
   public MorseOrder(MorseCode other) {
      super(other);
   }

   public MorseOrder(Character character, String code) {
      super(character, code);
   }

   // Method as required by the interface
   public int compareTo(MorseOrder other) {
      return this.getCode().compareTo(other.getCode());
   }
}
