public interface SimpleQueue<T>
{
	T dequeue();
	void enqueue(T element);
	T peek();
	int size();	
}
