package stack;

import linkedlist.DoublyLinkedListUsingSentinels;
import linkedlist.ListDemo;

public class StackLinkedlist<E> implements StackDemo<E>{
	
	ListDemo<E> list;
	
	public StackLinkedlist() {
		list = new DoublyLinkedListUsingSentinels<>();
	}

	@Override
	public void put(E element) {
		list.add(element);
	}

	@Override
	public E pop() {
		return list.removeLast();
	}

	@Override
	public String toString() {
		return list.toString();
	}

	@Override
	public int size() {
		return list.size();
	}

}
