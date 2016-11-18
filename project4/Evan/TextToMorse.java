/**
 *Text to morse class
 *
 *
 *
 *@author Evan Jameson
 *@version Project 4
 */

import java.util.*;

public class TextToMorse implements BSTTranslator<CharacterOrder>
{
   private BST<CharacterOrder> tree;
   private ArrayList<CharacterOrder> arr;

   public TextToMorse()
   {
      tree = new BST<>();
      arr = new ArrayList<>(MorseCode.size());
      for(int i = 0; i < MorseCode.size(); i++)
      {
         tree.insert(new CharacterOrder(MorseCode.get(i)));
      }
      tree.toSortedList(arr);
      tree = new BST<>();
      //new external recursive methodman
      orderBST(MorseCode.size() - 1, MorseCode.size() / 2, 0);  
   }

   public BST<CharacterOrder> getBST()
   {
   	  return tree;
   }

   public String translate(String s)
   {
      StringBuilder res = new StringBuilder("");
      String newMorse;

      for(int i = 0; i < s.length(); i ++)
      {
         if(s.charAt(i) == ' ')
         {
            res.append(" ");
         }
         else
         {
            try
            {
               newMorse = tree.get(new CharacterOrder(s.charAt(i), "")).getCode();
               res.append(newMorse + " ");
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
