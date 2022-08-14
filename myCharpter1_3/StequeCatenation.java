package myCharpter1_3;

import java.util.Iterator;

public class StequeCatenation<Item> implements Iterable<Item>
{
	private int N;
	private Node head;
	private Node tail;
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty()
	{ return N == 0; }
	public int size()
	{ return N; }
	
	public void push(Item item) {
		Node temp = new Node();
		temp.item = item;
		if(N==0) {
			head = temp;
			tail = temp;
		}else {
			temp.next = head;
			head = temp;
		}
		N++;
		return;
	}
	
	public Item pop() {
		if(N==0) throw new RuntimeException("Sorry,the steque is empty!"); //注意先判断，否则出现空指针异常；
		Item temp = head.item;      
		if(N==1) {
			head = null;
			tail = null;
		}else {
			head = head.next;
		}
		N--;
		return temp;
	}
	
	public void enqueue(Item item) {
		Node temp = new Node();
		temp.item = item;
		if(N==0) {
			head = temp;
			tail = temp;
		}else {
			temp.next = null;
			tail.next = temp;
			tail = temp;
		}
		N++;
		return;
	}
	
	public void catenation(StequeCatenation<Item> input) {
		if(input.size()==0)
			return;
		if(this.size()==0) {
			this.head = input.head;
			this.tail = input.tail;
			return;
		}
		this.tail.next = input.head;
		this.tail = input.tail;
		input.head = null;
		input.tail = null;
		return;
	}
	
	public Iterator<Item> iterator()
	{ return new ListIterator();}
	private class ListIterator implements Iterator<Item>{
		private Node current = head;
		public boolean hasNext()
		{ return current != null;}
		public void remove() {}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
}
