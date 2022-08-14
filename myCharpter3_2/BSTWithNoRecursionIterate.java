package myCharpter3_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BSTWithNoRecursionIterate <Key extends Comparable<Key>,Value>{
	private Node root;
	private class Node{
		private Key key;
		private Value val;
		private Node left;
		private Node right;
		private int N;
		public Node(Key key,Value val,int N)
		{ this.key = key; this.val = val; this.N = N;}
	}
	
	public int size()
	{ return size(root);}
	
	private int size(Node x) {
		if(x==null) return 0;
		else 		return x.N;
	}
	
	public Value get(Key key) 
	{ return get(root,key);}
	
	private Value get(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return get(x.left,key);
		else if(cmp>0) return get(x.right,key);
		else		return x.val;
	}
	
	public void put(Key key,Value val)
	{ root = put(root,key,val);}
	
	private Node put(Node x,Key key,Value val) {
		if(x==null) return new Node(key,val,1);
		int cmp = key.compareTo(x.key);
		if(cmp<0) x.left = put(x.left,key,val);
		else if(cmp>0) x.right = put(x.right,key,val);
		else x.val = val;
		x.N = size(x.left)+size(x.right)+1;
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
		Node x = root;
		Stack<Node> stack = new Stack<Node>();
		while(queue.size()<size()) {
			while(x.left!=null) {
				stack.push(x);
				x = x.left;
			}
			queue.enqueue(x.key);
			if(queue.size()>=size()) break;
			while(true) {
				if(x.right!=null) {
					x = x.right;
					break;
				}else {
					x = stack.pop();
					queue.enqueue(x.key);
					if(queue.size()>=size()) break;
				}
			}
		}
		return queue;
	}
	
	public static void main(String[] args) {
		BSTWithNoRecursionIterate<String,Integer> test = new BSTWithNoRecursionIterate<String,Integer>();
		test.put("S", null);
		test.put("E", null);
		test.put("A", null);
		test.put("R", null);
		test.put("C", null);
		test.put("H", null);
		test.put("E", null);
		test.put("X", null);
		test.put("A", null);
		test.put("O", null);
		test.put("P", null);
		test.put("T", null);
		test.put("W", null);
		test.put("Q", null);
		test.put("Z", null);
		test.put("Y", null);
		test.put("I", null);
		test.put("L", null);
		for(String s : test.keys())
		System.out.println(s);
	}
}
