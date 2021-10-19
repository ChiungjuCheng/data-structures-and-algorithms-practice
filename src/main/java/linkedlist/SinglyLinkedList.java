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
		if (isEmpty()) {
			return null;
		}
		Node<E> firstNode = head;

		if (size() == 1) {
			head = null;
			tail = null;
		} else {
			// when size > 1
			head = head.next;
		}
		size--;

		return firstNode.element;
	}

	// O(n)
	@Override
	public E removeLast() {

		if (isEmpty()) {
			return null;
		}

		Node<E> firstNode = tail;
		// when size = 1
		if (size() == 1) {
			head = null;
			tail = null;
		} else {
			// when size > 1
			Node<E> priorToLast = head;
			while (priorToLast.next != tail) {
				priorToLast = priorToLast.next;
			}
			tail = priorToLast;
			priorToLast.next = null;
		}
		size--;

		return firstNode.element;
	}

	/**
	 * TODO adding element in specific index of list.
	 * 
	 * @return true when success
	 */
	public void add(int index, E newElement) {

		if (index < 0) {
			return;
		}

		// insert to first
		if (index == 0) {
			addFirst(newElement);
			return;
		}

		// insert to last position
		if (size() == index) {
			add(newElement);
			return;
		}

		// insert to middle and over bound position
		Node<E> newNode = new Node<E>(newElement);
		if (isEmpty()) {
			head = new Node(null);
		}
		Node<E> previousTargetPositionNode = null;
		Node<E> targetPositionNode = head;
		boolean isIndexOutOfBounds = false;
		int newNodeNumber = 1;

		for (int i = 1; i <= index; i++) {

			if (targetPositionNode.next == null) {
				targetPositionNode.next = new Node(null);
				isIndexOutOfBounds = true;
				newNodeNumber++;
			}
			previousTargetPositionNode = targetPositionNode;
			targetPositionNode = targetPositionNode.next;
		}

		previousTargetPositionNode.next = newNode;

		if (isIndexOutOfBounds) {
			newNodeNumber--; // delete the last null value Node which is replace by new Node
		} else {
			newNode.next = targetPositionNode;
		}

		size += newNodeNumber;

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
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
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
			return this.element != null ? this.element.toString() : "Null";
		}
	}

}
