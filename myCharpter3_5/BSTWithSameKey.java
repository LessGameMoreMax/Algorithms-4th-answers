package myCharpter3_5;


import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

public class BSTWithSameKey <Key extends Comparable<Key>,Value>{
	private Node root;
	
	private class Node{
		private Key key;
		private Queue<Value> val;
		private Node left;
		private Node right;
		private int N;
		
		public Node(Key key,Queue<Value> val,int N)
		{this.key = key; this.val = val; this.N = N; }
	}
	
	public int size()
	{ return size(root);}
	
	private int size(Node x) {
		if(x==null) return 0;
		else		return x.N;
	}
	
	public Value get(Key key) 
	{ return get(root,key);}
	
	private Value get(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return get(x.left,key);
		else if(cmp>0) return get(x.right,key);
		else			return random(x.val);
	}
	
	private Value random(Queue q) {
		int N = StdRandom.uniform(q.size()) + 1;
		Iterator<Value> t = q.iterator();
		Value val = null;
		for(int i = 0;i<N;i++)
			val = t.next();
		return val;
	}
	
	public Iterator<Value> getAll(Key key)
	{ return getAll(root,key);}
	
	private Iterator<Value> getAll(Node x,Key key){
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return getAll(x.left,key);
		else if(cmp>0) return getAll(x.right,key);
		else 		return x.val.iterator();
	}
	
	public void put(Key key,Value val)
	{ root = put(root,key,val);}
	
	private Node put(Node x,Key key,Value val) {
		if(x==null) {
			Queue<Value> q = new Queue<Value>();
			q.enqueue(val);
			return new Node(key,q,1);
		}
		int cmp = key.compareTo(x.key);
		if(cmp<0) x.left = put(x.left,key,val);
		else if(cmp>0) x.right = put(x.right,key,val);
		else	x.val.enqueue(val);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Key select(int k)
	{ return select(root,k).key;}
	
	private Node select(Node x,int k) {
		if(x==null) return null;
		int t = size(x.left);
		if(t>k) return select(x.left,k);
		else if(t<k) return select(x.right,k-t-1);
		else		return x;
	}
	
	public int rank(Key key)
	{ return rank(key,root);}
	
	private int rank(Key key,Node x) {
		if(x==null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return rank(key,x.left);
		else if(cmp>0) return 1+size(x.left)+rank(key,x.right);
		else		return size(x.left);
	}
	
	public void deleteMin()
	{ root = deleteMin(root);}
	
	private Node deleteMin(Node x) {
		if(x.left==null) {
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void delete(Key key)
	{ root = delete(root,key);}
	
	private Node delete(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0)  x.left = delete(x.left,key);
		else if(cmp>0)  x.right = delete(x.right,key);
		else {
			if(x.right==null) return x.left;
			if(x.left==null) return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Key min()
	{ return min(root).key;}
	
	private Node min(Node x) {
		if(x.left==null) return x;
		return min(x.left);
	}
	
	public Key max()
	{ return max(root).key;}
	
	private Node max(Node x) {
		if(x.right==null) return x;
		return max(x.right);
	}
	
	public Iterable<Key> keys()
	{ return keys(min(),max());}
	
	public Iterable<Key> keys(Key lo,Key hi){
		Queue<Key> queue = new Queue<Key>();
		keys(root,queue,lo,hi);
		return queue; 
	}
	
	private void keys(Node x,Queue<Key> queue,Key lo,Key hi) {
		if(x==null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if(cmplo<0) keys(x.left,queue,lo,hi);
		if(cmplo<=0&&cmphi>=0) queue.enqueue(x.key);
		if(cmphi>0) keys(x.right,queue,lo,hi);
	}
}
