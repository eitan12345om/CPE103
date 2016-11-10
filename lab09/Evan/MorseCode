/**
 * A class that represents Morse Code/Character pairs - provided to save you
 * from having to type them all - see how nice I am!
 *
 * @author Hatalsky/Jones
 * @version 11/1/2016 CPE 103 Program 4
 */
public class MorseCode {
   private Character character;
   private String code;

   private static final MorseCode[] codes = new MorseCode[] {
      new MorseCode('A', ".-"),
      new MorseCode('B', "-..."),
      new MorseCode('C', "-.-."),
      new MorseCode('D', "-.."),
      new MorseCode('E', "."),
      new MorseCode('F', "..-."),
      new MorseCode('G', "--."),
      new MorseCode('H', "...."),
      new MorseCode('I', ".."),
      new MorseCode('J', ".---"),
      new MorseCode('K', "-.-"),
      new MorseCode('L', ".-.."),
      new MorseCode('M', "--"),
      new MorseCode('N', "-."),
      new MorseCode('O', "---"),
      new MorseCode('P', ".--."),
      new MorseCode('Q', "--.-"),
      new MorseCode('R', ".-."),
      new MorseCode('S', "..."),
      new MorseCode('T', "-"),
      new MorseCode('U', "..-"),
      new MorseCode('V', "...-"),
      new MorseCode('W', ".--"),
      new MorseCode('X', "-..-"),
      new MorseCode('Y', "-.--"),
      new MorseCode('Z', "--.."),
      new MorseCode('0', "-----"),
      new MorseCode('1', ".----"),
      new MorseCode('2', "..---"),
      new MorseCode('3', "...--"),
      new MorseCode('4', "....-"),
      new MorseCode('5', "....."),
      new MorseCode('6', "-...."),
      new MorseCode('7', "--..."),
      new MorseCode('8', "---.."),
      new MorseCode('9', "----."),
      new MorseCode('.', ".-.-.-"),
      new MorseCode(',', "--..--"),
      new MorseCode('?', "..--.."),
      new MorseCode('\'', ".----."),
      new MorseCode('!', "-.-.--"),
      new MorseCode('/', "-..-."),
      new MorseCode('(', "-.--."),
      new MorseCode(')', "-.--.-"),
      new MorseCode('&', ".-..."),
      new MorseCode(':', "---..."),
      new MorseCode(';', "-.-.-."),
      new MorseCode('=', "-...-"),
      new MorseCode('+', ".-.-."),
      new MorseCode('-', "-....-"),
      new MorseCode('_', "..--.-"),
      new MorseCode('"', ".-..-."),
      new MorseCode('$', "...-..-"),
      new MorseCode('@', "-..-.-"),
   };
  
   /**
    * Provided to support subclass constructors; it is protected so that only
    * subclasses can call it!
    *
    * @param other the MorseCode to copy (shallow)
    */
   protected MorseCode(MorseCode other) {
      this.character = other.character;
      this.code = other.code;
   }
   
   /**
    * Provided to support sub-class constructors; it is protected so that only
    * subclasses can call it!
    *
    * @param character the character associated with this paring (shallow)
    * @param code the Morse Code associated with this pairing (shallow)
    */
   protected MorseCode(Character character, String code) {
      this.character = character;
      this.code = code;
   }
   
   /**
    * Returns the character corresponding to this Morse Code/Character pair.
    *
    * @return the character corresponding to this Morse Code/Character pair
    */
   public Character getCharacter() {
      return character;
   }

   /**
    * Returns the Morse Code string corresponding to this Morse Code/Character
    * pair.
    *
    * @return the Morse Code string corresponding to this Morse Code/Character
    * pair
    */
   public String getCode() {
      return code;
   }

   /**
    * Returns the number of Morse Code/Character pairs.
    *
    * @return the number of Morse Code/Character pairs
    */
   public static int size() {
      return codes.length;
   }

   /**
    * Returns the Morse Code/Characer pair at the specified index.
    * <strong>IMPORTANT:</strong> Do not assume that the pairs are in any
    * particular order.
    *
    * @param index the index of the Morse Code/Character pair to return
    *
    * @return the Morse Code/Character pair at the specified index
    */
   public static MorseCode get(int index) {
      return codes[index];
   }
}