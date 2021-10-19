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
		assertEquals(0, singlyLinkedList1.size());

		singlyLinkedList1.addFirst("A");
		assertFalse(singlyLinkedList1.isEmpty());
		assertEquals(1, singlyLinkedList1.size());

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
		assertEquals(4, singlyLinkedList.size());
	}

	@Test
	public void testRemoveFirst() {
		SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
		singlyLinkedList.add("A");
		singlyLinkedList.add("B");
		singlyLinkedList.add("C");
//		singlyLinkedList.addFirst("D");

		singlyLinkedList.removeFirst();

		System.out.println("testRemoveFirst : " + singlyLinkedList.toString());
		assertEquals("BC", singlyLinkedList.toString());
		assertEquals(2, singlyLinkedList.size());
	}

	@Test
	public void testClear() {
		SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

		singlyLinkedList.add("A");
		singlyLinkedList.add("B");
		singlyLinkedList.add("C");

		assertEquals(3, singlyLinkedList.size());

		singlyLinkedList.clear();

		assertEquals(0, singlyLinkedList.size());

	}

	@Test
	public void testRemoveLast() {
		SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
		assertEquals(0, singlyLinkedList.size());
		singlyLinkedList.add("A");
		assertEquals(1, singlyLinkedList.size());
		singlyLinkedList.add("B");
		assertEquals(2, singlyLinkedList.size());
		singlyLinkedList.add("C");
		assertEquals(3, singlyLinkedList.size());

		singlyLinkedList.removeLast();

		System.out.println("testRemoveLast : " + singlyLinkedList.toString());
		assertEquals("AB", singlyLinkedList.toString());
		assertEquals(2, singlyLinkedList.size());
	}

	@Test
	public void testAddInSpecificPosition() {
		SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
		singlyLinkedList.add("A");
		singlyLinkedList.add(0, "B");

		System.out.println("testAddInSpecificPosition : " + singlyLinkedList.toString());
		assertEquals(2, singlyLinkedList.size());
		assertEquals("BA", singlyLinkedList.toString());

		// insert middle node
		singlyLinkedList.clear();
		
		singlyLinkedList.add("A");
		singlyLinkedList.add("B");
		singlyLinkedList.add(1,"C");
		assertEquals(3, singlyLinkedList.size());
		assertEquals("ACB", singlyLinkedList.toString());
		System.out.println("testAddInSpecificPosition : " + singlyLinkedList.toString());
		
		// index out Of bounds
		singlyLinkedList.clear();
		singlyLinkedList.add("A");
		singlyLinkedList.add("B");
		
		singlyLinkedList.add(2,"C");
		assertEquals(3, singlyLinkedList.size());
		assertEquals("ABC", singlyLinkedList.toString());
		System.out.println("testAddInSpecificPosition : " + singlyLinkedList.toString());
		
		// inserting index out Of bounds
		singlyLinkedList.clear();
		singlyLinkedList.add("A");
		singlyLinkedList.add("B");
		
		singlyLinkedList.add(3,"C");
		System.out.println("testAddInSpecificPosition : " + singlyLinkedList.toString());
		assertEquals(4, singlyLinkedList.size());
		
	}

}
