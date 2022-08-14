package myCharpter1_3;

import java.util.Iterator;


public class MyQueueConstructor<Item> implements Iterable<Item> 
{
	private Node first = null;
	private Node last = null;
	private int N = 0;
	private class Node
	{
		Item item;
		Node next;
	}
	
	public MyQueueConstructor() {
		
	}
    public MyQueueConstructor(MyQueueConstructor ori) {
		while(!ori.isEmpty())
			this.enqueue(ori.dequeue());
		Node current = first;
		while(current!=null) {
			ori.enqueue(current.item);
			current = current.next;
		}
	}
	public boolean isEmpty() { return first == null; }
	public int size()        { return N;}
	public void enqueue(Object object) 
	{
		Node oldlast = last;
		last = new Node();
		last.item = (Item) object;
		last.next = null;
		if(isEmpty()) first = last;
		else          oldlast.next = last;
		N++;
	}
	
	public Item dequeue() 
	{
		Item item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		N--;
		return item;
	}
	
	public Iterator<Item> iterator()
	{ return new ListIterator(); }
	
	private class ListIterator implements Iterator<Item>
	{
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