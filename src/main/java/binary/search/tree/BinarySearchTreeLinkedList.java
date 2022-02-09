package binary.search.tree;

public class BinarySearchTreeLinkedList {

	private Node root;

	public void insert(int newData) {
		if (isEmpty()) {
			root = new Node(newData, null, null);
			return;
		}

		insertByRecursion2(root, newData);
	}

	private void insertByRecursion(Node root, int newData) {

		if (newData > root.getData()) {
			if (root.getRight() == null) {
				root.setRight(new Node(newData, null, null));
				return;
			}
			insertByRecursion(root.getRight(), newData);
		} else {
			if (root.getLeft() == null) {
				root.setLeft(new Node(newData, null, null));
				return;
			}
			insertByRecursion(root.getLeft(), newData);
		}

	}

	private Node insertByRecursion2(Node root, int newData) {

		if (root == null) {
			return new Node(newData, null, null);
		}

		if (newData > root.getData()) {
			root.setRight(insertByRecursion2(root.getRight(), newData));
		} else {
			root.setLeft(insertByRecursion2(root.getLeft(), newData));
		}

		return root;

	}

	private void clear() {
		this.root = null;
	}

	private boolean isEmpty() {
		return root == null;
	}

	public Node getRootNode() {
		return this.root;
	}

	/** === Node class === */
	class Node {

		private int data;

		private Node left, right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		Node getLeft() {
			return left;
		}

		Node getRight() {
			return right;
		}

		void setLeft(Node left) {
			this.left = left;
		}

		void setRight(Node right) {
			this.right = right;
		}

		int getData() {
			return data;
		}
	}
}
