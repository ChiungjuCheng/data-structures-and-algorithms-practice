package binary.search.tree;

import java.util.Optional;

public class BinarySearchTreeLinkedList {

	private Node root;

	public void insert(int newData) {
		if (isEmpty()) {
			root = new Node(newData, null, null);
			return;
		}

//		insertByRecursion(root, newData);
		insertByLoop(newData);
	}

	private Node insertByRecursion(Node root, int newData) {

		if (root == null) {
			return new Node(newData, null, null);
		}

		if (newData > root.getData()) {
			root.setRight(insertByRecursion(root.getRight(), newData));
		} else {
			root.setLeft(insertByRecursion(root.getLeft(), newData));
		}

		return root;
	}

	private void insertByLoop(int newData) {

		Node root = this.root;

		while (true) {
			if (newData > root.getData()) {
				if (root.getRight() == null) {
					root.setRight(new Node(newData, null, null));
					break;
				}
				root = root.getRight();
			} else {
				if (root.getLeft() == null) {
					root.setLeft(new Node(newData, null, null));
					break;
				}
				root = root.getLeft();
			}
		}
	}

	public Node removeRec(Node root, int targetData) {

		if (root == null) {
			return root;
		}

		if (targetData > root.getData()) {
			root.setRight(removeRec(root.getRight(), targetData));
		} else if (targetData < root.getData()) {
			root.setLeft(removeRec(root.getLeft(), targetData));
		} else {
			// leaf and one child
			if (root.getLeft() == null && root.getRight() == null) {
				return null;
			} else if (root.getRight() == null) {
				return root.getLeft();
			} else if (root.getLeft() == null) {
				return root.getRight();
			} else {
				// two child
				Node minNode = findMin(root.getLeft(), targetData);
				root.data = minNode.getData();
				root.setLeft(removeRec(root.getLeft(), root.data));

			}

		}

		return root;

	}

	private Node findMin(Node root, int targetData) {

		Node minNode = root;
		while (minNode != null && minNode.getLeft() != null) {
			minNode = minNode.getLeft();
		}

		return minNode;

	}

	public Optional<Node> find(int targetData) {
		Node root = this.root;

		while (root != null) {
			if (targetData == root.getData()) {
				return Optional.of(root);
			}

			if (targetData > root.getData()) {
				root = root.getRight();
			} else {
				root = root.getLeft();
			}
		}

		return Optional.empty();
	}

	public void clear() {
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
