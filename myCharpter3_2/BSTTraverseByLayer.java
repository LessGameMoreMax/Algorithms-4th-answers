package myCharpter3_2;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.Queue;

public class BSTTraverseByLayer<Key extends Comparable<Key>,Value> {
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
		else		return x.N;
	}
	
	public Value get(Key key)
	{ return get(root,key);}
	
	private Value get(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return get(x.left,key);
		else if(cmp>0) return get(x.right,key);
		else return x.val;
	}
	
	public void put(Key key,Value val)
	{ root = put(root,key,val);}
	
	private Node put(Node x,Key key,Value val) {
		if(x==null) return new Node(key,val,1);
		int cmp = key.compareTo(x.key);
		if(cmp<0) x.left = put(x.left,key,val);
		else if(cmp>0) x.right = put(x.right,key,val);
		else x.val = val;
		x.N = size(x.left)+ size(x.right)+1;
		return x;
	}
	
	public void printLevel(){
		printLevel(root);	
	}
	
	
	private void printLevel(Node x) {
		if(x==null) return;
		Queue<Node> temp = new Queue<Node>();
		temp.enqueue(x);
		while(!temp.isEmpty()) {
			int N = temp.size();
			for(int i = 0;i<N;i++) {
				Node tempX = temp.dequeue();
				System.out.print(tempX.key);
				if(tempX.left!=null) temp.enqueue(tempX.left);
				if(tempX.right!=null) temp.enqueue(tempX.right);
			}
		}
	}
	
	public static void main(String[] args) {
		BSTTraverseByLayer<String,Integer> test = new BSTTraverseByLayer<String,Integer>();
		test.put("S", null);
		test.put("E", null);
		test.put("A", null);
		test.put("R", null);
		test.put("C", null);
		test.put("H", null);
		test.put("E", null);
		test.put("X", null);
		test.put("A", null);
		test.put("M", null);
		test.printLevel();
	}
}
