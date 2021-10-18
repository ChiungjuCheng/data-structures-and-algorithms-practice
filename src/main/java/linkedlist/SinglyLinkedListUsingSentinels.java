package linkedlist;

/**
 * 使用標兵(Sentinels) 參考資料結構與演算法 java 書籍
 * todo test
 * @author user
 *
 * @param <E>
 */
public class SinglyLinkedListUsingSentinels<E> implements ListDemo<E> {

	private Node<E> head = null;
	private Node<E> tail = null;

	public SinglyLinkedListUsingSentinels() {
		head = new Node(null);
		tail = new Node(null);
		head.setNext(tail);
	}

	@Override
	public void addFirst(E newElement) {
		Node newNode = new Node(newElement);
		addBetween(newNode,head,head.next);
	}

	private void addBetween(Node newNode, Node predecessor, Node suiccessor) {
		newNode.setNext(suiccessor);
		predecessor.setNext(newNode);
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

}
