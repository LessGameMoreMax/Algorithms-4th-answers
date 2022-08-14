package myCharpter3_2;

public class BSTWithTemp <Key extends Comparable<Key>,Value>{
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
	private Node cache;
	
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
		if(x==cache) return cache.val;
		else		cache = x;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return get(x.left,key);
		else if(cmp>0) return get(x.right,key);
		else	return x.val;
	}
	
	public void put(Key key,Value val)
	{ root = put(root,key,val);}
	
	private Node put(Node x,Key key,Value val) {
		if(x==cache) cache.val = val;
		if(x==null) {cache = new Node(key,val,1); return x;}
		int cmp = key.compareTo(x.key);
		if(cmp<0) x.left = put(x.left,key,val);
		else if(cmp>0) x.right = put(x.right,key,val);
		else 		{cache = x; x.val = val;}
		x.N = size(x.left)+size(x.right)+1;
		return x;
	}
}
