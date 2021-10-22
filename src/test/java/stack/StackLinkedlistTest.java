package stack;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StackLinkedlistTest {

	@Test
	public void testPut() {
		StackDemo<String> stack = new StackLinkedlist<>();
		stack.put("A");
		stack.put("B");
		stack.put("C");
		assertEquals("ABC", stack.toString());
	}

	@Test
	public void testPop() {
		StackDemo<String> stack = new StackLinkedlist<>();
		stack.put("A");
		stack.put("B");
		stack.put("C");

		assertEquals("C", stack.pop());
		assertEquals("B", stack.pop());
		assertEquals("A", stack.pop());
		assertNull(stack.pop());
	}

	@Test
	public void testSize() {
		StackDemo<String> stack = new StackLinkedlist<>();
		
		stack.put("A");
		stack.put("B");
		stack.put("C");
		assertEquals(3, stack.size());

		stack.pop();
		assertEquals(2, stack.size());
	}
}
