package linkedlist;

/**
 * List interface
 * 
 * @author user
 * @param <E>
 */
public interface ListDemo<E> extends Iterable<E>{
	void add(E newElement);
	
	void add(int index, E newElement);

	void addFirst(E newElement);
	
	E get(int index);
	
	E removeLast();
	
	E removeFirst();

	int size();

	boolean isEmpty();
	
	void clear();
}
