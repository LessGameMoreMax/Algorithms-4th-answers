package myCharpter3_4;

import edu.princeton.cs.algs4.Queue;

public class SequentialSearchSTPro<Key,Value> {
	private Node first;
	private int N;
	private class Node{
		Key key;
		Value val;
		Node next;
		
		int num;
		
		public Node(Key key,Value val,Node next,int num) {
			this.key = key;
			this.val = val;
			this.next = next;
			this.num = num;
		}
	}
	
	public Value get(Key key) {
		for(Node x = first;x!=null;x=x.next)
			if(key.equals(x.key))
				 return x.val;
		return null;
	}
	
	public void put(Key key,Value val,int num) {
		for(Node x = first;x!=null;x = x.next)
			if(key.equals(x.key))
			{ x.val = val; return;}
		first = new Node(key,val,first,num);
		N++;
	}
	
	public int checkNum(Key key) {
		for(Node x = first;x!=null;x=x.next)
			if(key.equals(x.key))
				 return x.num;
		return 0;
	}
	
	public boolean kIsEmpty(int k) {
		if(isEmpty()) return true;
		for(Node x = first;x!=null;x=x.next)
			if(x.num>k)
				 return true;
		return false;
	}
	
	public void checkDelete(int k) {
		if(this.isEmpty()) return;
		if(first.num>k) {
			first = first.next;
			N--;
			return;
		}
		if(this.size()==1) return;
		Node nodeFirst = first.next;
		Node nodeSecond = first;
		while(nodeFirst!=null) {
			if(nodeFirst.num>k) {
				nodeSecond.next = nodeFirst.next;
				N--;
				return;
			}
			nodeFirst = nodeFirst.next;
			nodeSecond = nodeSecond.next;
		}
	}
	
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
	
	public boolean isEmpty()
	{ return N==0;}
	
	public int size()
	{ return N;}
	
	public Iterable<Key> keys(){
		Queue<Key> q = new Queue<Key>();
		Node x = first;
		while(x!=null) {
			q.enqueue(x.key);
			x = x.next;
		}
		return q;
	}
}
