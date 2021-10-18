package linkedlist;

/**
 * No sentinels verison
 * @author user
 *
 * @param <E>
 */
public class SinglyLinkedList<E> implements ListDemo<E>{

	private Node<E> head = null;
	private Node<E> tail = null;

	public SinglyLinkedList() {}
	
	@Override
	public void addFirst(E newElement) {
		Node<E> newNode = new Node<E>(newElement);
		
		if (head == null) {
			head = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Node<E> current = head;
		
		while(current != null) {
			sb.append(current.toString());
			current = current.next;
		}
		
		return sb.toString();
	}

	private class Node<E> {
		E element;
		Node<E> next;
		
		Node(){}

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
