/**
 *SimpleLinkedList is a doubly linked list class with dummy head and tail nodes
 *which exist outside of index bounds therefore there is no need for special case code
 *which simplifies the source code.
 *
 *@author Evan Jameson
 *@version lab01
 */

public class SimpleLinkedList<T> implements SimpleList<T>
{
	private Node head;
	private	Node tail;
	private int size;

	public SimpleLinkedList()
	{
		this.head = new Node(null);
		this.tail = new Node(null);
		this.head.next = tail;
		this.tail.prev = head;
		this.size = 0;
	}

	public void add(int index, T element)
	{
	        if (index < 0 || index > size)
       		{
               		throw new java.lang.IndexOutOfBoundsException();
	        }
		Node newNode = new Node(element);
		Node p = getNode(index);
		newNode.next = p;
		newNode.prev = p.prev;	
		p.prev.next = newNode;
		p.prev = newNode;
		size++;
	}

	public void add(T element)
	{
		Node newNode = new Node(element);
		Node p = tail.prev;
		p.next = newNode;
		newNode.prev = p;
		newNode.next = tail;
                tail.prev = newNode;
		size++;
	}

	public T remove(int index) 
	{
	        if (index < 0 || index >= size)
       		{
                	throw new java.lang.IndexOutOfBoundsException();
        	}
		Node oldNode = getNode(index);
		oldNode.prev.next = oldNode.next;
		oldNode.next.prev = oldNode.prev;
		size--;
		return oldNode.element;
	}

	public int size()
	{
		return size;
	}

	public T get (int index)
	{
       		if (index < 0 || index >= size)
      	  	{
        	        throw new java.lang.IndexOutOfBoundsException();
	        }
		Node theNode = getNode(index);
		return theNode.element;
	}

	//Extra method to make life a bit easier
	private Node getNode(int i)
	{
		Node p = head.next;
		int pos = 0;
		while (pos != i)
		{
			p = p.next;
			pos++;
		}
		return p;
	}


/**
 *Local Node class to be used by SimpleLinkedList
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
