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
		binarySearchTree.insert(5);
		binarySearchTree.insert(4);
		binarySearchTree.insert(6);

		Node root = binarySearchTree.getRootNode();

		assertEquals(5, root.getData());
		assertEquals(4, root.getLeft().getData());
		assertEquals(6, root.getRight().getData());

	}
}
