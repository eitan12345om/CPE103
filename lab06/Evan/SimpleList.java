public interface SimpleList<T>
{
	void add(int index, T element);
	void add(T element);
	T get(int index);
	T remove(int index);
	int size();
}
