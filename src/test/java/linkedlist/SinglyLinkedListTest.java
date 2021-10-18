package linkedlist;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {
	
	@BeforeEach
	public void printLine() {
		System.out.println("===============================================================");
	}

	@Test
	public void testAddFirst() {
		SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
		singlyLinkedList.addFirst("A");
		singlyLinkedList.addFirst("B");
		singlyLinkedList.addFirst("C");

		System.out.println("testAddFirst : " + singlyLinkedList.toString());
		assertEquals("CBA", singlyLinkedList.toString());
	}

	@Test
	public void testSize() {
		SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
		singlyLinkedList.addFirst("A");
		singlyLinkedList.addFirst("B");
		singlyLinkedList.addFirst("C");

		System.out.println("testSize : " + singlyLinkedList.size());
		assertEquals(3, singlyLinkedList.size());
	}

	@Test
	public void testIsEmpty() {
		SinglyLinkedList<String> singlyLinkedList1 = new SinglyLinkedList<>();
		assertTrue(singlyLinkedList1.isEmpty());
		
		singlyLinkedList1.addFirst("A");
		assertFalse(singlyLinkedList1.isEmpty());

	}
	@Test
	public void testAddLast() {
		SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
		
		singlyLinkedList.add("A");
		singlyLinkedList.add("B");
		singlyLinkedList.add("C");
		singlyLinkedList.addFirst("D");

		System.out.println("testAdd : " + singlyLinkedList.toString());
		assertEquals("DABC", singlyLinkedList.toString());
	}

}
