package myCharpter3_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class HibbardPerformanceTest <Key extends Comparable<Key>,Value>{
	private Node root;
	
	private class Node{
		private Key key;
		private Value val;
		private Node left;
		private Node right;
		private int N;
		
		private int height;
		
		public Node(Key key,Value val,int N,int height)
		{this.key = key; this.val = val; this.N = N; this.height = height;}
	}
	
	public int size()
	{ return size(root);}
	
	private int size(Node x) {
		if(x==null) return 0;
		else		return x.N;
	}
	
	public int height()			
	{ return height(root);}
	
	public int height(Key key) 
	{ return height(root,key);}
	
	private int height(Node x,Key key) {
		if(x==null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return height(x.left,key);
		else if(cmp>0) return height(x.right,key);
		else		return x.height;
	}
	
	private int height(Node x) {
		if(x==null) return 0;
		else		return x.height;
	}
	
	public Value get(Key key) 
	{ return get(root,key);}
	
	private Value get(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return get(x.left,key);
		else if(cmp>0) return get(x.right,key);
		else			return x.val;
	}
	
	public void put(Key key,Value val)
	{ root = put(root,key,val,1);}
	
	private Node put(Node x,Key key,Value val,int height) {
		if(x==null) return new Node(key,val,1,height);
		int cmp = key.compareTo(x.key);
		if(cmp<0) x.left = put(x.left,key,val,height+1);
		else if(cmp>0) x.right = put(x.right,key,val,height+1);
		else	x.val = val;
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
			heightTraverseSubOne(x.right);
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void deleteMax()
	{ root = deleteMax(root);}
	
	private Node deleteMax(Node x) {
		if(x.right==null) {
			heightTraverseSubOne(x.left);
			return x.left;
		}
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	private void heightTraverseSubOne(Node x) {
		if(x==null) return;
		x.height--;
		heightTraverseSubOne(x.left);
		heightTraverseSubOne(x.right);
	}
	
	public void randomDelete(Key key){
		double d = StdRandom.random();
		if(d>0.5) root = deleteBehind(root,key);
		else 	  root = deleteFront(root,key);
		
	}
	
	
	private Node deleteBehind(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0)  x.left = deleteBehind(x.left,key);
		else if(cmp>0)  x.right = deleteBehind(x.right,key);
		else {
			if(x.right==null) return x.left;
			if(x.left==null) return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
			x.height = t.height;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	private Node deleteFront(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0)  x.left = deleteFront(x.left,key);
		else if(cmp>0)  x.right = deleteFront(x.right,key);
		else {
			if(x.right==null) return x.left;
			if(x.left==null) return x.right;
			Node t = x;
			x = max(t.left);
			x.left = deleteMax(t.left);
			x.right = t.right;
			x.height = t.height;
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
	
	private boolean contains(Key key) {
		if(get(key)!=null) return true;
		return false;
	}
	
	public int heightRecursion(Key key)
	{ return heightRecursion(root,key);}
	
	private int heightRecursion(Node x,Key key) {
		if(x==null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return heightRecursion(x.left,key)+1;
		else if(cmp>0) return heightRecursion(x.right,key)+1;
		else return 1;
	}
	
	public int avgCompares()
	{ return avgCompares(root)/size(root)+1;}
	
	private int avgCompares(Node x) {
		if(x==null) return 0;
		int height = x.height;
		height += avgCompares(x.left);
		height += avgCompares(x.right);
		return height;
	}
	
	public static void main(String[] args) {
		System.out.println("How big tree would you like to conduct?");
		int N = StdIn.readInt();
		System.out.println("Loading......");
		HibbardPerformanceTest<Integer,Integer> test = new HibbardPerformanceTest<Integer,Integer>();
		for(int i = 0;i<N;i++) test.put((Integer)StdRandom.uniform(N),(Integer) StdRandom.uniform(N));
		System.out.println("Before test:"+test.avgCompares());
		for(int i = 0;i<N*N;i++) {
			test.randomDelete(test.select(StdRandom.uniform(test.size())));
			test.put((Integer)StdRandom.uniform(N),(Integer)StdRandom.uniform(N));
		}
		System.out.println("After test:"+test.avgCompares());
	}
}
