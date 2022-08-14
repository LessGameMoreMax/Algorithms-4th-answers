package myCharpter1_3;

import java.util.Iterator;

public class MyStackCatenation<Item> implements Iterable<Item> 
{
	private Node first;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty() { return first == null; }
	public int size()		 { return N; }
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public void catenation(MyStackCatenation<Item> behind) {
		Node current = first;
		if(current==null) {
			first = behind.first;
			return;
		}
		while(current.next!=null)
			current = current.next;
		current.next = behind.first;
		behind.first = null;
	}

	public Iterator<Item> iterator()
	{ return new ListIterator();}
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext() {
			return current != null;
		}
		public void remove() {}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}

