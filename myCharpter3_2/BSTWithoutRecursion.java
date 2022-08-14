package myCharpter3_2;

import edu.princeton.cs.algs4.Queue;

public class BSTWithoutRecursion <Key extends Comparable<Key>,Value>{
	private Node root;
	private class Node{
		private Key key;
		private Value val;
		private Node left;
		private Node right; 
		private int N;
		
		public Node(Key key,Value val,int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	
	public int size()
	{ return size(root);}
	
	private int size(Node x) {
		if(x==null) return 0;
		else 		return x.N;
	}
	
	public Value get(Key key) {
		Node x = root;
		while(x!=null) {
			int cmp = key.compareTo(x.key);
			if(cmp<0) x = x.left;
			else if(cmp>0) x = x.right;
			else return x.val;
		}
		return null;
	}
	
	public void put(Key key,Value val) {
		if(root==null) {
			root = new Node(key,val,1);
			return;
		}
		
		Node x = root;
		
		while(true) {
			int cmp = key.compareTo(x.key);
			if(cmp<0) {
				if(x.left==null) {
					x.left = new Node(key,val,1);
					break;
				}
				x = x.left;
			}else if(cmp>0) {
				if(x.right==null) {
					x.right = new Node(key,val,1);
					break;
				}
				x = x.right; 
			}else {
				x.val = val;
				return;
			}
		}
		
		addOne(x.key);
	}
	
	private void addOne(Key key) {
		Node x = root;
		while(true) {
			x.N++;
			int cmp = key.compareTo(x.key);
			if(cmp<0) x = x.left;
			else if(cmp>0) x = x.right;
			else    break;
		}
	}
	
	public Key min() {
		Node x = root;
		while(x.left!=null) x = x.left;
		return x.key;
	}
	
	private Node min(Node x) {
		while(x.left!=null) x = x.left;
		return x;
	}
	
	public Key max() {
		Node x = root;
		while(x.right!=null) x = x.right;
		return x.key;
	}
	
	public Key floor(Key key) {
		Node x = root;
		Node t = null;
		while(x!=null) {
			int cmp = key.compareTo(x.key);
			if(cmp<0) x = x.left;
			else if(cmp>0) {t = x; x = x.right;} 
			else	  return x.key;
		}
		if(t!=null) return t.key;
		else 		return null;
	}
	
	public Key ceiling(Key key) {
		Node x = root;
		Node t = null;
		while(x!=null) {
			int cmp = key.compareTo(x.key);
			if(cmp>0) x = x.right;
			else if(cmp<0) {t = x;x = x.left;}
			else return x.key;
		}
		if(t!=null) return t.key;
		else		return null;
	}
	
	public Key select(int k) {
		Node x = root;
		while(x!=null) {
			int t = size(x.left);
			if(t>k) x = x.left;
			else if(t<k) {x = x.right; k = k-t-1;}
			else		return x.key;
		}
		return null;
	}
	
	public int rank(Key key) {
		Node x = root;
		int num = 0;
		while(x!=null) {
			int cmp = key.compareTo(x.key);
			if(cmp<0) x = x.left;
			else if(cmp>0) {num += 1+size(x.left); x=x.right;}
			else			{num+=size(x.left); break;}
		}
		return num;
	}
	
	public void deleteMin()
	{ root = deleteMin(root);}
	
	private Node deleteMin(Node x) {
		if(x.left==null) return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left)+size(x.right)+1;
		return x;
	}
	
	public void deleteMax()
	{ root = deleteMax(root);}
	
	private Node deleteMax(Node x) {
		if(x.right==null) return x.left;
		x.right = deleteMax(x.right);
		x.N = size(x.left)+size(x.right)+1;
		return x;
	}
	
	public void delete(Key key)
	{ root = delete(root,key);}
	
	private Node delete(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) x.left = delete(x.left,key);
		else if(cmp>0) x.right = delete(x.right,key);
		else {
			if(x.right==null) return x.left;
			if(x.left ==null) return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left)+size(x.right)+1;
		return x;
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
