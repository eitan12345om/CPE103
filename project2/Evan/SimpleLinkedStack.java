/**
 *Simple Linked Stack class
 *
 *
 *
 *@author Evan Jameson
 *@version Project 02
 */

import java.util.*;

public class SimpleLinkedStack<T> implements SimpleStack<T>
{
   private int size;
   private Node front;

   //Returns the element from the top of the stack without removing it
   public T peek()
   {
      if(size == 0)
      {
         throw new NoSuchElementException();
      }
      return front.element;
   }

   //Removes and returns the top element from the stack
   public T pop()
   {
      if(size == 0)
      {
         throw new NoSuchElementException();
      }
      T theElement = front.element;
      front = front.next;
      size--;
      return theElement;
   }

   //Adds an element to the top of the stack
   @SuppressWarnings("unchecked")
   public void push(T element)
   {
      Node newNode = new Node(element);
      //Case if list is empty back and front are set to same mode
      if(size == 0)
      {
         front = newNode;
      }
      //Case if list already has at least one node in it
      else
      {
         newNode.next = front;
         front = newNode;     //tenative solution
      } 
      size++;
   }

   public int size()
   {
      return size;
   }

   private class Node
   {
      public T element;
      public Node next;

      public Node(T element)
      {
         this.element = element;
         this.next = null;
      }
   }
}
