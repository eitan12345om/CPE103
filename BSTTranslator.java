/**
 *BSTTranslaator interface
 *
 *
 *
 *@author Evan Jameson 
 *@version Project 4
 */

public interface BSTTranslator<T extends Comparable<? super T>>
{
   BST<T> getBST();
   String translate(String s);
}
