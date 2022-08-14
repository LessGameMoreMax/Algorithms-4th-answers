package myCharpter1_3;

import java.util.Iterator;

public class MyStackModificationException<Item> implements Iterable<Item> 
{
	private Node first;
	private boolean flag = false;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty() { return first == null; }
	public int size()		 { return N; }
	public void push(Item item) {
		if(flag) throw new RuntimeException("java.util.ConcurrentModificationException");
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop() {
		if(flag) throw new RuntimeException("java.util.ConcurrentModificationException");
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public Iterator<Item> iterator()
	{ return new ListIterator();}
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext() {
			flag = true;
			return current != null;
		}
		public void remove() {}
		public Item next() {
			flag = true;
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
