import java.util.ArrayList;

/**
 * A class for converting Morse Code into text.
 *
 * @author Eitan Simler
 * @version Project4
 */

public class TextToMorse implements BSTTranslator<CharacterOrder> {

   // Instance variables
   private BST<CharacterOrder> tree;
   private ArrayList<CharacterOrder> arr;

   // Constructor
   public TextToMorse() {
      tree = new BST<>();
      arr = new ArrayList<>(MorseCode.size());
      preSorting();
      tree.toSortedList(arr);
      constructBST(0, MorseCode.size() / 2, MorseCode.size() - 1);
   }

   // Methods
   public BST<CharacterOrder> getBST() {
      return tree;
   }

   public String translate(String s) {
      // TODO: Add method body
      return "";
   }



   // Private helper methods
   private void preSorting() {
      for (int i = 0; i < MorseCode.size(); i++) {
         tree.insert(new CharacterOrder(MorseCode.get(i)));
      }
   }
   
   private void constructBST(int low, int mid, int high) {
      // Recursive binary search like thing
      tree.insert(arr.get(mid));
      if (low < mid) {
         constructBST(low, (low + mid) / 2, mid - 1);
      }
      if (high > mid) {
         constructBST(mid + 1, (high + mid + 1) / 2, high);
      }
   }
}   
