package myCharpter3_1;

import edu.princeton.cs.algs4.StdIn;

public class OrderedSequentialSearchST <Key extends Comparable<Key>,Value>{
	private Node first;
	private Node last;
	private class Node
	{
		Key key;
		Value val;
		Node next;
		
		public Node(Key key,Value val,Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public Value get(Key key) {
		for(Node x = first;x!=null;x = x.next)
			if(key.equals(x.key))
				return x.val;
		return null;
	}
	
	public void put(Key key,Value val) {
		if(first==null) {
			Node x = new Node(key,val,null);
			first = x;
			last = x;
			return;
		}
		
		if(last.key.compareTo(key)<0) {
			Node x = new Node(key,val,null);
			last.next = x;
			last = last.next;
			return;
		}
		if(first.key.compareTo(key)>0) {
			Node x = new Node(key,val,first);
			first = x;
			return;
		}
		for(Node x = first;x!=null;x = x.next)
			if(key.equals(x.key)) 
			{ x.val = val; return;}
		Node nodeFirst = first.next;
		Node nodeSecond = first;
		while(nodeFirst!=null) {
			if(key.compareTo(nodeFirst.key)<0) {
				Node x = new Node(key,val,nodeFirst);
				nodeSecond.next = x;
				return;
			}
			nodeFirst = nodeFirst.next;
			nodeSecond = nodeSecond.next;
		}
	}
	
	public boolean contains(Key key)
	{ return get(key)!=null;}
	
	public boolean isEmpty()
	{ return first==null;}
	
	public void delete(Key key) {
		if(isEmpty()) return;
		if(last==first)
			if(first.key.equals(key)) {first = null; last = null;}
			else 				return;
		if(key.equals(first.key)) {first = first.next; return;}
		Node nodeFirst = first.next;
		Node nodeSecond = first;
		while(nodeFirst!=null) {
			if(key.compareTo(nodeFirst.key)==0) {
				nodeSecond.next = nodeFirst.next;
				return;
			}
			nodeFirst = nodeFirst.next;
			nodeSecond = nodeSecond.next;
		}
	}
	
	public static void main(String[] args) {
	OrderedSequentialSearchST<String,Double> reportCard = new OrderedSequentialSearchST();
	reportCard.put("A+",4.33);
	reportCard.put("A", 4.00);
	reportCard.put("A-",3.67);
	reportCard.put("B+",3.33);
	reportCard.put("B",3.00);
	reportCard.put("B-", 2.67);
	reportCard.put("C+", 2.33);
	reportCard.put("C", 2.00);
	reportCard.put("C-", 1.67);
	reportCard.put("D", 1.00);
	reportCard.put("F", 0.00);
	System.out.println("How many grades would you like to input?");
	int N = StdIn.readInt();
	System.out.println("Please input:");
	double sum = 0;
	for(int i = 0;i<N;i++)
	 sum += reportCard.get(StdIn.readString());
	System.out.printf("Your GPA is:%.2f.",sum/(N*1.0));
	}
	
}
