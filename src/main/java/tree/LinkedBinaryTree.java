package tree;

import java.util.Iterator;

/**
 * 目前查到的add都會比較value，也許可以使用類似Breadth first search的方式找到空的? 
 * https://www.baeldung.com/java-binary-tree
 * 
 * @author user
 * @param <E>
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

	private Node<E> root;

	protected int size;

	public void add(E element) {

		// addByRecursive
		root = addByRecursive(root, element);

		// addByWhile

		size++;
	}

	/**
	 * TODO Test
	 * @param currentPosition
	 * @param element
	 * @return
	 */
	public Node<E> addByRecursive(Position<E> currentPosition, E element) {
		Node<E> currentNode = castToNode(currentPosition);
		if (currentNode == null) {
			return new Node<E>(null, null, null, element);
		}

		// TODO check if the element is comparable
		Comparable<E> k = (Comparable<E>) element;
		
		if(k.compareTo(currentNode.element) > 0) {
			currentNode.rightChild = addByRecursive(currentNode.rightChild, element);
		}else {
			currentNode.leftChild = addByRecursive(currentNode.leftChild, element);
		}

		return currentNode;
	}

	/**
	 * 參考put方法
	 * http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/util/TreeMap.java
	 */
	public void addByWhile(Position<E> currentPosition, E element) {
		Node<E> currentNode = castToNode(currentPosition);
		if (currentNode == null) {
			root = new Node<E>(null, null, null, element);
		}

	}

	@Override
	public E remove(Position<E> p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void preorderTraveral() {
		// TODO Auto-generated method stub
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E root() {
		return isEmpty() ? null : root.element;
	}

	@Override
	public E parent(Position<E> p) {
		Node<E> node = castToNode(p);
		if (node == null) {
			return null;
		}

		Node<E> parentNode = node.parent;

		if (parentNode == null) {
			return null;
		}

		return parentNode.element;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public boolean hasLeftChild(Position<E> p) {
		Node<E> node = castToNode(p);
		if (node == null) {
			return false;
		}
		return node.rightChild == null;
	}

	@Override
	public boolean hasRightChild(Position<E> p) {
		Node<E> node = castToNode(p);
		if (node == null) {
			return false;
		}
		return node.rightChild == null;

	}

	/**
	 * 將Position強轉型
	 * 
	 * @param p
	 * @return Node<E> or null
	 */
	public Node<E> castToNode(Position<E> p) {
		if (!(p instanceof LinkedBinaryTree.Node) || p == null) {
			return null;
		}

		return (Node<E>) p;
	}

	private class Node<E> implements Position<E> {
		public Node<E> parent;
		public Node<E> leftChild;
		public Node<E> rightChild;

		public E element;

		Node(Node parent, Node leftChild, Node rightChild, E element) {
			this.parent = parent;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.element = element;
		}

	}

}
