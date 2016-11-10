/**
 *MorseToText class
 *
 *
 *
 *@author Evan Jameson
 *@version Project 4
 */

import java.util.*;

public class MorseToText implements BSTTranslator<MorseOrder>
{
   //This tree should only hold morse code
   private BST<MorseOrder> tree;
   private ArrayList<MorseOrder> arr;

   public MorseToText() //no arguments
   {
      tree = new BST<>();
      arr = new ArrayList<>(MorseCode.size());
      for(int i = 0; i < MorseCode.size(); i++)
      {
         tree.insert(new MorseOrder(MorseCode.get(i)));
      }
      tree.toSortedList(arr);
      tree = new BST<>();
      //new external recursive methodman
      orderBST(MorseCode.size() - 1, MorseCode.size() / 2, 0);
   }

   public BST<MorseOrder> getBST()
   {
      //Method needs to be O(1) so just return the tree that was already made foo
      return tree;
   }

   public String translate(String s)
   {
      StringBuilder res = new StringBuilder("");
      String newString;
      String scanString;
      Scanner scan = new Scanner(s);
      scan.useDelimiter(" ");

      while(scan.hasNext())
      {
         scanString = scan.next();
         if(scanString.equals(""))
         {
            res.append(" ");
         }
         else
         {
            try
            {
               newString = String.valueOf(tree.get(new MorseOrder(' ', scanString)).getCharacter());
               res.append(newString);
            }
            catch(NoSuchElementException e)
            {

            }
         }
      }
      String last = res.toString();
      return last.trim();
   }

   private void orderBST(int high, int mid, int low)
   {
      tree.insert(arr.get(mid));
      if(low < mid)
      {
         orderBST(mid - 1, (low + mid)/ 2, low);
      }
      if(high > mid)
      {
         orderBST(high, (high + mid + 1) / 2, mid + 1);
      }
   }
}
