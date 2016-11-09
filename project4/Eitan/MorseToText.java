import java.util.*;

/**
 * A class for converting Morse Code into text.
 *
 * @author Eitan Simler
 * @version Project4
 */

public class MorseToText implements BSTTranslator<MorseOrder> {

   // Instance variables
   private BST<MorseOrder> tree;
   private ArrayList<MorseOrder> arr;
   
   // Constructor
   public MorseToText() {
      tree = new BST<>();
      arr = new ArrayList<>(MorseCode.size());
      preSorting();
      tree.toSortedList(arr);
      tree = new BST<>();
      constructBST(0, MorseCode.size() / 2, MorseCode.size() - 1);
   }

   // Methods
   public BST<MorseOrder> getBST() {
      return tree;
   }

   public String translate(String s) { 
      // Variables to help with storing
      String result = "";
      String newString;
      String scanString;
      Scanner scan = new Scanner(s);
      scan.useDelimiter(" ");

      // Loop through characters in String
      while (scan.hasNext()) {
         scanString = scan.next();
         
         if (scanString.equals("")) {
            result += " ";
         }
         else {
            try {
               newString = String.valueOf(tree.get(new MorseOrder(' ', scanString)).getCharacter());
               result += newString;
            }
            catch (NoSuchElementException e) {
            
            }
         }
      }

      return result.trim();
   }

   // Private helper methods
   private void preSorting() {
      for (int i = 0; i < MorseCode.size(); i++) {
         tree.insert(new MorseOrder(MorseCode.get(i)));
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
