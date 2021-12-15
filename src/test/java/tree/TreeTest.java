package tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TreeTest {

	@Test
	public void testAdd() {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		
		assertEquals(4, tree.size);
	}
}
