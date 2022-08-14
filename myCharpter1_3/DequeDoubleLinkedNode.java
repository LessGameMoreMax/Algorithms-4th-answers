package myCharpter1_3;

import java.util.Iterator;

public class DequeDoubleLinkedNode<Item> implements Iterable<Item>
{
	private int N;
	private Node head;
	private Node tail;
	private class Node{
		Item item;
		Node previous;
		Node next;
	}
	
	public boolean isempty() {
		return N==0;
	}
	public int size() {
		return N;
	}
	
	public void pushLeft(Item item) {
		Node temp = new Node();
		temp.item = item;
		if(N==0) {
			head = temp;
		    tail = temp;
		    temp.next = null;
		}else {
			temp.next = head;
			head.previous = temp;
		}
		temp.previous = null;
		head = temp;
		N++;
		return;
	}
	
	public void pushRight(Item item) {
		Node temp = new Node();
		temp.item = item;
		if(N==0) {
			head = temp;
		    tail = temp;
		    temp.previous = null;
		}else {
			temp.previous = tail;
			tail.next = temp;
		}
		temp.next = null;
		tail = temp;
		N++;
		return;
	}
	
	public Item popLeft() {
		if(N==0) throw new RuntimeException("Sorry,DequeDoubleLinkedNode is null!");
		Item temp = head.item;
		if(N==1) {
			head = null;
			tail = null;
		}else {
			head=head.next;
			head.previous.next =null;
			head.previous = null;
		}
		N--;
		return temp;
	}
	
	public Item popRight() {
		if(N==0) throw new RuntimeException("Sorry,DequeDoubleLinkedNode is null!");
		Item temp = tail.item;
		if(N==1) {
			head = null;
			tail = null;
		}else {
			tail=tail.previous;
			tail.next = null;
		}
		N--;
		return temp;
	}
	
	public Iterator<Item> iterator()
	{ return new ListIterator();}
	private class ListIterator implements Iterator<Item>
	{
		private Node current = head;
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
