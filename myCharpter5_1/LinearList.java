package myCharpter5_1;

import edu.princeton.cs.algs4.Queue;

public class LinearList {
	private int N;
	private Node first;
	private class Node{
		String s;
		Node next;
		public Node(String s,Node next)
		{ this.s = s; this.next = next;}
	}
	public int size()
	{ return N;}
	public void add(String s) {
		N++;
		if(first==null) {
			first = new Node(s,null);
			return;
		}
		first = new Node(s,first);
	}
	
	public void change(String[] a) {
		Node temp = first;
		for(int i = 0;i<a.length;i++) {
			temp.s = a[i];
			temp = temp.next;
		}
	}
	
	public boolean hasString()
	{ return first!=null;}
	
	public Iterable<String> allString(){
		Queue<String> q = new Queue<String>();
		Node temp = first;
		while(temp!=null) {
			q.enqueue(temp.s);
			temp = temp.next;
		}
		return q;
	}
}
