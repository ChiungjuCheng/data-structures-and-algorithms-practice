package tree;

import java.util.Iterator;

abstract public class AbstractBinaryTree<E> implements Tree<E> {

	abstract public Iterator<E> iterator();

	abstract public E remove(Position<E> p);

	/**
	 * (Left, Root, Right)
	 */
	abstract public void preorderTraveral();

}
