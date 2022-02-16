package binary.search.tree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import binary.search.tree.BinarySearchTreeLinkedList.Node;

public class BinarySearchTreeLinkedListTest {

//	@Test
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

//	@Test
	void find() {
		BinarySearchTreeLinkedList binarySearchTree = new BinarySearchTreeLinkedList();
		binarySearchTree.insert(10);
		binarySearchTree.insert(5);
		binarySearchTree.insert(15);

		assertTrue(binarySearchTree.find(10).isPresent());
		assertFalse(binarySearchTree.find(16).isPresent());
	}

	@Test
	void remove() {
		BinarySearchTreeLinkedList binarySearchTree = new BinarySearchTreeLinkedList();

		// L0
		binarySearchTree.insert(10);
		// L1
		binarySearchTree.insert(5);
		binarySearchTree.insert(15);
		// L2
		binarySearchTree.insert(4);
		binarySearchTree.insert(6);
		binarySearchTree.insert(14);
		binarySearchTree.insert(16);

		Node root = binarySearchTree.getRootNode();
//		binarySearchTree.removeRec(binarySearchTree.getRootNode(), 4);
//		assertNull( root.getLeft().getLeft());
//		
//		
		
		binarySearchTree.removeRec(root, 15);
		
		assertEquals(14, root.getRight().getData());

		assertNull(root.getRight().getLeft());
	}
}
