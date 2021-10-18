package linkedlist;

/**
 * 使用標兵(Sentinels) 參考資料結構與演算法 java 書籍 todo test
 * 
 * @author user
 * @param <E>
 */
public class SinglyLinkedListUsingSentinels<E> implements ListDemo<E> {

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;
	
	public SinglyLinkedListUsingSentinels() {
		head = new Node(null);
		tail = new Node(null);
		head.setNext(tail);
	}

	@Override
	public void add(E newElement) {
		

	}


	
	@Override
	public int size() {
		
		return size;
	}

	@Override
	public void addFirst(E newElement) {
		Node<E> newNode = new Node(newElement);
		addBetween(newNode, head, head.next);
	}

	private void addBetween(Node newNode, Node predecessor, Node suiccessor) {
		newNode.setNext(suiccessor);
		predecessor.setNext(newNode);
		size++;
	}

	private class Node<E> {
		E element;
		Node<E> next;

		Node() {
		}

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

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(int index, E newElement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}


}
