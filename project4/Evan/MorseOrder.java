/**
 *MorseOrder class
 *
 *
 * 
 *@author Evan Jameson
 *@version Project 4
 */

public class MorseOrder extends MorseCode implements Comparable<MorseOrder>
{
   public MorseOrder(MorseCode other)
   {
      super(other);
   }

   public MorseOrder(Character character, String code)
   {
      super(character, code);
   }

   public int compareTo(MorseOrder other)
   {
      return this.getCode().compareTo(other.getCode());     
   }
}
