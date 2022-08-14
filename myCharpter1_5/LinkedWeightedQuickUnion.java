package myCharpter1_5;

import edu.princeton.cs.algs4.StdIn;

public class LinkedWeightedQuickUnion {
	private int count;
	private int nodeCount;
	private Node head = null;
	private Node tail = null;
	private class Node{
		Node arrNext;
		Node root;
		int sz = 1;
	}
	
	public LinkedWeightedQuickUnion() {
		head = new Node();
		tail = head;
		head.root = head; 
		count = 1;
		nodeCount = 1;
	}
	
	public int count()
	{ return count;}
	
	public boolean connect(int p,int q) {
		if(p<0||p>=this.nodeCount||q<0||q>=this.nodeCount) throw new RuntimeException("Sorry,it's too much!");		
		return find(p).equals(find(q));
	}
	
	public Node find(int p) {
		Node temp = head;
		for(int i = 0;i<p;i++)
			temp = temp.arrNext;
		while(!temp.root.equals(temp))
			temp = temp.root;
		return temp;
	}
	
	public int newSite()
	{ return nodeCount;}
	
	public void union(int p,int q) {
		if(p<0||q<0) throw new RuntimeException("Sorry,it can not be smaller than zero!");
		if(p>=this.nodeCount||q>=this.nodeCount) {
			for(int i = this.nodeCount;i<=Math.max(q, p);i++) {
				tail.arrNext = new Node();
				tail = tail.arrNext;
				tail.root = tail;
				this.count++;
				this.nodeCount++;
			}
		}
		
		Node qRoot = find(q);
		Node pRoot = find(p);
		
		if(pRoot.equals(qRoot)) return;
		
		if(qRoot.sz>pRoot.sz) {pRoot.root = qRoot;qRoot.sz+=pRoot.sz;} 
		else  				  {qRoot.root = pRoot;pRoot.sz+=qRoot.sz;} 
		count--;
		return;
	}
	
	public static void main(String[] args) {
		LinkedWeightedQuickUnion test = new LinkedWeightedQuickUnion();
		for(int i = 0;i<3;i++) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			test.union(p, q);
		}
		int i = StdIn.readInt();
		int j = StdIn.readInt();
		System.out.println(test.connect(i, j));
		System.out.println(test.newSite());
	}
}
