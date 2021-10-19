package linkedlist;

/**
 * List interface
 * 
 * @author user
 * @param <E>
 */
public interface ListDemo<E> {
	void add(E newElement);
	
	void add(int index, E newElement);

	void addFirst(E newElement);
	
	E removeLast();
	
	E removeFirst();

	int size();

	boolean isEmpty();
	
	void clear();
}
