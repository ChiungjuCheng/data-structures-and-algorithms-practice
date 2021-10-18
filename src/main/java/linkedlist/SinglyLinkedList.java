package linkedlist;

/**
 * No sentinels verison
 * 
 * @author user
 * @param <E>
 */
public class SinglyLinkedList<E> implements ListDemo<E> {

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
	}

	// O(1)
	@Override
	public E removeFirst() {
		Node<E> firstNode = head;

		// when size = 1
		if (size() != 1) {
			head = head.next;
		} else {
			// when size > 1
			head = null;
			tail = null;
		}

		size--;

		return firstNode.element;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * TODO adding element in specific index of list.
	 * 
	 * @return true when success
	 */
	public boolean add(int index, E newElement) {
		// when index is out of the range.

		// when index is in the range

		return true;
	}

	// O(1)
	/** insert to the last index */
	@Override
	public void add(E newElement) {

		// when empty add head
		if (isEmpty()) {
			addFirst(newElement);
		} else {
			// when not empty add tail
			Node<E> newTailNode = new Node<E>(newElement);
			Node<E> previousTailNode = tail;
			tail = newTailNode;
			previousTailNode.next = newTailNode;
			size++;
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// O(1)
	@Override
	public void addFirst(E newElement) {
		Node<E> newNode = new Node<E>(newElement);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		Node<E> current = head;

		while (current != null) {
			sb.append(current.toString());
			current = current.next;
		}

		return sb.toString();
	}

	private class Node<E> {
		E element;
		Node<E> next;

		Node(E element) {
			this.element = element;
		}

		void setNext(Node<E> nextNode) {
			this.next = nextNode;
		}

		public String toString() {
			return this.element.toString();
		}
	}

}
