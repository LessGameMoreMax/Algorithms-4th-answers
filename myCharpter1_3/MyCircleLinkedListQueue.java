package myCharpter1_3;

//import java.util.Iterator;

public class MyCircleLinkedListQueue<Item>
//implements Iterable<Item>
{
	private Node last = null;
	private int N = 0;
	private class Node{
		Item item;
		Node next;
	}
	
	public int size() {return N;}
	public boolean isEmpty() {return N==0;}
	
	public void enqueue(Item item) {
		Node temp = new Node();
		temp.item = item;
		if(N==0) {
			last = temp;
			last.next = temp;
			N++;
			return;
		}
		Node oldlast = last;
		last = temp;
		last.next = oldlast.next;
		oldlast.next = last;
		N++;
		return;
	}
	
	public Item dequeue() {
		if(N==0) throw new RuntimeException("Sorry,queue is empty!");
		Item item = last.next.item;
		if(N==1) {
			last = null;
			N--;
			return item;
		}
		last.next = last.next.next;
		N--;
		return item;
	}
//	
//////	public Iterator<Item> iterator()
//////	{ return new ListIterator();}
//////	private class ListIterator implements Iterator<Item>{
//////		private Node current = last.next;
//////		public boolean hasNext()
//////		{return true;}
//////		public void remove() {}
//////		public Item next() {
//////			Item item = current.item;
//////			current = current.next;
//////			return item;
//////		}
//////	}
//	
	
}
