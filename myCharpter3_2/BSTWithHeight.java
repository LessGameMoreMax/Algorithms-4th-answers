package myCharpter3_2;

public class BSTWithHeight <Key extends Comparable<Key>,Value>{
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
	
	private void heightTraverseSubOne(Node x) {
		if(x==null) return;
		x.height--;
		heightTraverseSubOne(x.left);
		heightTraverseSubOne(x.right);
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
		BSTWithHeight<String,Integer> test = new BSTWithHeight<String,Integer>();
		test.put("S", 0);
		test.put("E", 2);
		test.put("A", 3);
		test.put("R", 4);
		test.put("C", 5);
		test.put("H", 6);
		test.put("E", 7);
		test.put("X", 8);
		test.delete("E");
		test.delete("S");
		test.delete("C");
		test.delete("H");
		System.out.println(test.height("R"));
		System.out.println(test.avgCompares());
	}
}
