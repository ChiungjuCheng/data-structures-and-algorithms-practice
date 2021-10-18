package linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {
	
	@Test
	public void testAddFirst() {
		SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
		singlyLinkedList.addFirst("A");
		singlyLinkedList.addFirst("B");
		singlyLinkedList.addFirst("C");
		
		System.out.println("testAddFirst : "+singlyLinkedList.toString());
		assertEquals("CBA", singlyLinkedList.toString());
	}

}
