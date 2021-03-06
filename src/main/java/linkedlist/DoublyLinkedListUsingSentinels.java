package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 使用標兵(Sentinels) 參考資料結構與演算法 java 書籍
 * 
 * @author user
 * @param <E>
 */
public class DoublyLinkedListUsingSentinels<E> implements ListDemo<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public DoublyLinkedListUsingSentinels() {
		head = new Node(null, null, null);
		tail = new Node(null, null, null);
		head.next = tail;
		tail.pre = head;
	}

	/** add into tail */
	@Override
	public void add(E newElement) {
		addBetween(newElement, tail.pre, tail);
	}

	@Override
	public void addFirst(E newElement) {
		addBetween(newElement, head, head.next);
	}

	// O(n)
	@Override
	public void add(int index, E newElement) {
		Node<E> targetPositonNode = getNode(index);
		if (targetPositonNode == null) {
			return;
		}
		addBetween(newElement, targetPositonNode.pre, targetPositonNode);
	}

	// O(1)
	@Override
	public E removeLast() {
		if (isEmpty()) {
			return null;
		}
		return removeBetween(tail.pre.pre, tail).element;
	}

	// O(1)
	@Override
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		return removeBetween(head, head.next.next).element;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		head.next = tail;
		tail.pre = head;
		size = 0;
	}

	// O(N)
	@Override
	public E get(int index) {
		Node<E> targetNode = getNode(index);
		return targetNode != null ? targetNode.element : null;
	}

	// O(N)
	private Node<E> getNode(int index) {
		if (isEmpty() || index >= size()) {
			return null;
		}
		Node<E> targetNode = head;

		for (int i = 0; i <= index; i++) {
			targetNode = targetNode.next;
		}

		return targetNode;
	}

	// O(1)
	private void addBetween(E newElement, Node<E> pre, Node<E> next) {
		// the new Node point to old Nodes
		Node<E> newNode = new Node<>(newElement, pre, next);
		// old Nodes point to the new Node
		pre.next = newNode;
		next.pre = newNode;
		size++;
	}

	// O(1)
	private Node<E> removeBetween(Node<E> pre, Node<E> next) {
		Node<E> targetNode = pre.next;
		pre.next = next;
		next.pre = pre;
		size--;
		return targetNode;
	}

	// O(N)
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		Node<E> current = head.next;
		// tail.next == null
		while (current.next != null) {
			sb.append(current.toString());
			current = current.next;
		}

		return sb.toString();
	}

	private class Node<E> {
		E element;
		Node<E> pre;
		Node<E> next;

		Node() {
		}

		Node(E element, Node<E> pre, Node<E> next) {
			this.element = element;
			this.pre = pre;
			this.next = next;
		}

		public String toString() {
			return this.element != null ? this.element.toString() : "Null";
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new LstIterator();
	}

	private class LstIterator implements Iterator<E> {

		private int nextIndex;
		private Node<E> nextNode;

		private LstIterator() {
			this.nextIndex = 0;
			this.nextNode = head.next;
		}

		@Override
		public boolean hasNext() {

			return size > nextIndex;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			Node<E> currentNode = nextNode;
			nextNode = nextNode.next;
			nextIndex++;

			return currentNode.element;
		}

	}

}
