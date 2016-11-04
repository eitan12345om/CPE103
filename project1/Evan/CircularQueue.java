/**
 *CircularQueue is a generic implementation of SimpleQueue
 *and contains the nested static class MyException
 *
 *@author Evan Jameson
 *@version Project 1
 */

import java.util.*;
import java.util.NoSuchElementException;


public class CircularQueue<T> implements SimpleQueue<T>
{
	private T[] arr;
	private int back = -1;
	private int front = 0;	
	public static final int INITIAL_LENGTH = 10;
	private int size;

	@SuppressWarnings("unchecked")
	public CircularQueue()
	{
		arr = (T[]) new Object[INITIAL_LENGTH];
	}

	@SuppressWarnings("unchecked")
	public CircularQueue(int initialCapacity)
	{
		if(initialCapacity < 1)
		{
			throw new MyException();
		}
		arr = (T[]) new Object[initialCapacity];
		
	}

	public T dequeue()
	{
		//If the list is empty and an attempt to dequeue is made, this exception is thrown
		if(size == 0)
		{
			throw new NoSuchElementException();
		}
		T theElement = arr[front];
		
		//Case where the front is in the last spot in the array and must be moved to index 0
		if(front == arr.length - 1)
		{
			front = 0;
		}
		else
		{
			front++;
		}
		size--;
		return theElement;
	}

	@SuppressWarnings("unchecked")
	public void enqueue(T element)
	{
		//Case to create a new array double the size of the original array if it was full
		if(size == arr.length)
		{
			T[] newArray = (T[])new Object[2*arr.length];
			for(int i = 0; i < arr.length; i++)
			{
				newArray[i] = arr[(front + i) % arr.length];
			}
			arr = newArray;
			front = 0;
			back = size -1;
		}
		back = (back + 1) % arr.length;
		arr[back] = element;
		size++;
	}

	public T peek()
	{
		if(size == 0)
		{
			throw new NoSuchElementException();
		}
		return arr[front];
	}

	public int size()
	{
		return size;
	}

	public Object[] unusualMethodForTestingPurposesOnly()
	{
		return arr;
	}
	
	/**
 	* Private and static class nested within the CircularQueue class
 	* that is thrown when there is an exception in the second constructor
 	*/
	 public static class MyException extends RuntimeException //or is it CircularQueue.MyException (?)
	 {
	 	public MyException()
	 	{
	 		//Constructs a MyException with no detail message
	 	}
		
	 	public MyException(String s)
	 	{
	 		//Constructs a MyException with the specified detail message
	 		super(s);
	 	}
	 }
}

/** notes and questions for the time being
 *--------------------------------------------------------------------------------------------------------
 *Implementation for the MyException inner class?
 *
 */
