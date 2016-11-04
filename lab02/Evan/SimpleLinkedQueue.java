/**
 *Class SimpleLinkedQueue is a generic implementation of the SimpleQueue interface
 *Items can only be added to the "back" and can only be taken from the front, much like a line for 
 *an event.
 *
 *@author Evan Jameson
 *@version Lab 02
 */

import java.util.NoSuchElementException;

public class SimpleLinkedQueue<T> implements SimpleQueue<T>
{
	private Node front;
	private Node back;
	private int size;	

	//No other variables are initialized since no dummy nodes and front and back Nodes need to begin null
	public SimpleLinkedQueue()
	{
		this.size = 0;
	}
 
	//Removes and returns the element at the front of the queue
	public T dequeue()
	{
		//Excpetion thrown when trying to remove from an empty queue
		if(size == 0)
		{
			throw new NoSuchElementException();
		}
		T theElement = front.element;
		front.prev = null;
		front = front.next;
		size--;
		return theElement;
	}

	//Adds the specified element to the end of the queue
	public void enqueue(T element)
	{
		Node newNode = new Node(element);		
		//Case if list is empty back and front are set to same node
		if(size == 0)
		{
			front = newNode;
			back = newNode;				
		}
		//Case if list already has at least one node in it
		else
		{
			back.next = newNode;
			newNode.prev = back;
			back = newNode;
		}
		size++;
	}
	
	//Returns the element at the front of this queue but does not remove it
	public T peek()
	{
		if(size == 0)
		{
			throw new NoSuchElementException();
		}
		return front.element;
	}

	public int size()
	{
		return size;
	}

	/**
 	*Private Node class
 	*/

	private class Node
	{
                public T element;
                public Node next;
                public Node prev;

                public Node(T element)
                {
                        this.element = element;
                        this.next = null;
                        this.prev = null;
                }
	
	}
}

