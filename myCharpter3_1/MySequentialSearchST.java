package myCharpter3_1;

import edu.princeton.cs.algs4.Queue;

public class MySequentialSearchST<Key,Value> {
	private Node first;
	private class Node{
		Key key;
		Value val;
		Node next;
		public Node(Key key,Value val,Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	private int N = 0;
	
	public Value get(Key key) {
		for(Node x = first;x!=null;x=x.next)
			if(key.equals(x.key))
				return x.val;
		return null;
	}
	
	public void put(Key key,Value val) {
		N++;
		first = new Node(key,val,first);
	}
	
	public int size()
	{ return N;}
	
	public boolean isEmpty()
	{ return N==0;}
	
	public void delete(Key key) {
		if(this.isEmpty()) return;
		if(key.equals(first.key)) {
			first = first.next;
			N--;
			return;
		}
		if(this.size()==1) return;
		Node nodeFirst = first.next;
		Node nodeSecond = first;
		while(nodeFirst!=null) {
			if(key.equals(nodeFirst.key)) {
				nodeSecond.next = nodeFirst.next;
				N--;
				return;
			}
			nodeFirst = nodeFirst.next;
			nodeSecond = nodeSecond.next;
		}
	}

	public Iterable<Key> keys(){
		Queue<Key> q = new Queue<Key>();
		for(Node x = first;x!=null;x=x.next)
			q.enqueue(x.key);
		return q;
	}
	
}
