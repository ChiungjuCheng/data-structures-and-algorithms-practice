package linkedlist;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListUsingSentinelsTest {
	
	@BeforeEach
	public void printLine() {
		System.out.println("=================================");
	}
	
	@Test
	public void testClear() {
		ListDemo<String> doublyLinkedList = new DoublyLinkedListUsingSentinels<>();
		doublyLinkedList.add("A");
		doublyLinkedList.clear();
		
		assertEquals(0,doublyLinkedList.size());
	}
	
	@Test
	public void testAdd() {
		ListDemo<String> doublyLinkedList = new DoublyLinkedListUsingSentinels<>();
		doublyLinkedList.add("A");
		doublyLinkedList.add("B");
		
		System.out.println("testAdd : "+doublyLinkedList.toString());
		
		assertEquals("AB",doublyLinkedList.toString());
		assertEquals(2, doublyLinkedList.size());
	}
	
	@Test
	public void testAddFirst() {
		ListDemo<String> doublyLinkedList = new DoublyLinkedListUsingSentinels<>();
		doublyLinkedList.addFirst("A");
		doublyLinkedList.addFirst("B");
		
		System.out.println("testAddFirst : "+doublyLinkedList.toString());
		
		assertEquals("BA",doublyLinkedList.toString());
		assertEquals(2, doublyLinkedList.size());
	}
	
	@Test
	public void testGetByIndex() {
		ListDemo<String> doublyLinkedList = new DoublyLinkedListUsingSentinels<>();
		doublyLinkedList.add("A");
		doublyLinkedList.add("B");
		doublyLinkedList.add("C");
		
		assertEquals("A", doublyLinkedList.get(0));
		assertEquals("B", doublyLinkedList.get(1));
		assertEquals("C", doublyLinkedList.get(2));
		assertNull(doublyLinkedList.get(3));
	}
	
	@Test
	public void testRemoveLast() {
		ListDemo<String> doublyLinkedList = new DoublyLinkedListUsingSentinels<>();
		assertNull(doublyLinkedList.removeLast());
		
		doublyLinkedList.add("A");
		
		System.out.println("testRemoveLast : "+doublyLinkedList.toString());
				
		assertEquals("A", doublyLinkedList.removeLast());
		
		doublyLinkedList.add("A");
		doublyLinkedList.add("B");
		doublyLinkedList.add("C");
		
		assertEquals("C", doublyLinkedList.removeLast());
		assertEquals("AB",doublyLinkedList.toString());
	}
	
	@Test
	public void testRemoveFirst() {
		ListDemo<String> doublyLinkedList = new DoublyLinkedListUsingSentinels<>();
		assertNull(doublyLinkedList.removeFirst());
		
		doublyLinkedList.add("A");
		doublyLinkedList.add("B");
		doublyLinkedList.add("C");
		assertEquals("A", doublyLinkedList.removeFirst());
		assertEquals("BC",doublyLinkedList.toString());
	}
	
	@Test
	public void addByIndex() {
		ListDemo<String> doublyLinkedList = new DoublyLinkedListUsingSentinels<>();
		doublyLinkedList.add("A");
		doublyLinkedList.add("B");
		doublyLinkedList.add("C");
		
		doublyLinkedList.add(1, "D");
		assertEquals(4, doublyLinkedList.size());
		assertEquals("ADBC",doublyLinkedList.toString());
	}
	
	@Test
	public void iterator() {
		ListDemo<String> doublyLinkedList = new DoublyLinkedListUsingSentinels<>();
		doublyLinkedList.add("A");
		doublyLinkedList.add("B");
		doublyLinkedList.add("C");
		
		for(String element : doublyLinkedList) {
			System.out.println(element);
		}
	}
}
