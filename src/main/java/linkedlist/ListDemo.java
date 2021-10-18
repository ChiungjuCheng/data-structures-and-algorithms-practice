package linkedlist;

/**
 * List interface
 * 
 * @author user
 * @param <E>
 */
public interface ListDemo<E> {
	void add(E newElement);

	void addFirst(E newElement);

	int size();

	boolean isEmpty();
}
