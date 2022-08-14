package myCharpter3_5;

import edu.princeton.cs.algs4.Queue;
public class SequentialSearchSET<Key extends Comparable<Key>> {
	private Node first;
	private class Node{
		Key key;
		Node next;
		public Node(Key key,Node next) {
			this.key = key;
			this.next = next;
		}
	}
	private int N = 0;
	
	public void put(Key key) {
		Node x = first;
		while(x!=null) {
			if(key.compareTo(x.key)==0)
				return;
			x = x.next;
		}
		N++;
		first = new Node(key,first);
	}
	
	public boolean contains(Key key) {
		Node x = first;
		while(x!=null) {
			if(x.key.equals(key)) return true;
			x = x.next;
		}
		return false;
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

