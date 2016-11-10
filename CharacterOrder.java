/**
 *Character order class
 *
 *
 *
 *@author Evan Jameson
 *@version Project 4
 */

public class CharacterOrder extends MorseCode implements Comparable<CharacterOrder>
{
   public CharacterOrder(MorseCode other)
   {
      super(other);
   }

   public CharacterOrder(Character character, String code)
   {
      super(character, code);
   }

   public int compareTo(CharacterOrder other)
   {
      return this.getCharacter().compareTo(other.getCharacter());
   }
}
