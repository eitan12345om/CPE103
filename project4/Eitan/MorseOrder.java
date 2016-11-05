/**
 * Subclass of MorseCode whose natural ordering will be based on the Morse Code
 * strings.
 *
 * @author Eitan Simler
 * @version Project4
 */

public class MorseOrder extends MorseCode implements Comparable<MorseOrder> {

   // TODO: Add constructors!
   // Constructors
   

   // Method as required by the interface
   public int compareTo(MorseOrder other) {
      this.getCode().compareTo(other.getCode());
   }
}
