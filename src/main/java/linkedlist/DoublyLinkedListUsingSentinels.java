package linkedlist;


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
		head = new Node(null,null,null);
		tail = new Node(null,null,null);
		head.next = tail;
		tail.pre = head;
	}

	/** add into tail*/
	@Override
	public void add(E newElement) {	
		addBetween(newElement,tail.pre , tail);
	}
	
	@Override
	public void addFirst(E newElement) {
		addBetween(newElement, head, head.next);
	}
	
	@Override
	public void add(int index, E newElement) {
		// TODO Auto-generated method stub
	}

	@Override
	public E removeLast() {
		if(isEmpty()) {
			return null;
		}
		
		// TODO check if node is null
		return removeBetween(tail.pre.pre,tail).element;
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	private void addBetween(E newElement, Node<E> pre, Node<E> next) {
		// the new Node point to old Nodes
		Node<E> newNode = new Node<>(newElement,pre,next);
		// old Nodes point to the new Node
		pre.next = newNode;
		next.pre = newNode;
		size++;
	}
	
	private Node<E> removeBetween(Node<E> pre, Node<E> next) {
		Node<E> targetNode = pre.next;
		pre.next = next;
		next.pre = pre;
		size--;
		
		return targetNode;
	}
	
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

		Node() {}

		Node(E element,Node<E> pre,Node<E> next) {
			this.element = element;
			this.pre = pre;
			this.next = next;			
		}

		public String toString() {
			return this.element != null ? this.element.toString() : "Null";
		}
	}

}
