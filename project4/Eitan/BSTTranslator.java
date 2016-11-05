/**
 * Interface for MorseToText and TextToMorse.
 *
 * @author Eitan Simler
 * @version Project4
 */

public interface BSTTranslator<T extends Comparable<? super T>> {

   public BST<T> getBST();
   public String translate(String s);
}
