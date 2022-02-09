package tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TreeTest {

	@Test
	public void testAdd() {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
		tree.add(10);
		tree.add(5);
		tree.add(15);
		tree.add(4);
		tree.add(6);
		tree.add(14);
		tree.add(16);
		
		assertEquals(7, tree.size);
	}
}
