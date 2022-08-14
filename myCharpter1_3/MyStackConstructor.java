package myCharpter1_3;

import java.util.Iterator;

public class MyStackConstructor<Item> implements Iterable<Item> 
{
	private Node first;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	
	public MyStackConstructor() {
		
	}
	
    public MyStackConstructor(MyStackConstructor ori) {
    	MyStackConstructor<Item> temp = new MyStackConstructor<Item>();
    	while(!ori.isEmpty())
    		temp.push(ori.pop());
    	for(Item s:temp) {
    		this.push(s);
    		ori.push(s);
    	}
	}

	public boolean isEmpty() { return first == null; }
	public int size()		 { return N; }
	public void push(Object object) {
		Node oldfirst = first;
		first = new Node();
		first.item = (Item) object;
		first.next = oldfirst;
		N++;
	}
	public Item pop() {
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