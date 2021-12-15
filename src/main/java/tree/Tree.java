package tree;

public interface Tree<E> extends Iterable<E> {

	E root();

	E parent(Position<E> p);

	boolean hasLeftChild(Position<E> p);

	boolean hasRightChild(Position<E> p);

	int size();

	boolean isEmpty();
}
