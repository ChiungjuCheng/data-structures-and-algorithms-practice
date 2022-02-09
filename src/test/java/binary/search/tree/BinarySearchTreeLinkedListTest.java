package binary.search.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import binary.search.tree.BinarySearchTreeLinkedList.Node;

public class BinarySearchTreeLinkedListTest {

	@BeforeEach
	void printLine() {
		System.out.println("=================================");
	}

	@Test
	void testInsert() {
		BinarySearchTreeLinkedList binarySearchTree = new BinarySearchTreeLinkedList();
		binarySearchTree.insert(10);
		binarySearchTree.insert(5);
		binarySearchTree.insert(15);
		binarySearchTree.insert(4);
		binarySearchTree.insert(6);
		binarySearchTree.insert(14);
		binarySearchTree.insert(16);

		Node root = binarySearchTree.getRootNode();

		// L0
		assertEquals(10, root.getData());
		// L1
		assertEquals(5, root.getLeft().getData());
		assertEquals(15, root.getRight().getData());
		// L2
		assertEquals(4, root.getLeft().getLeft().getData());
		assertEquals(6, root.getLeft().getRight().getData());
		
		assertEquals(14, root.getRight().getLeft().getData());
		assertEquals(16, root.getRight().getRight().getData());

	}
}
