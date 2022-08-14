package myCharpter3_2;

public class TreeCheck<Key extends Comparable<Key>,Value> {
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
	
	public Value get(Key key)
	{ return get(root,key);}
	
	private Value get(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return get(x.left,key);
		else if(cmp>0) return get(x.right,key);
		else	return x.val;
	}
	
	public void put(Key key,Value val)
	{ root = put(root,key,val);}
	
	private Node put(Node x,Key key,Value val) {
		if(x==null) return new Node(key,val,1);
		int cmp = key.compareTo(x.key);
		if(cmp<0) x.left = put(x.left,key,val);
		else if(cmp>0) x.right = put(x.right,key,val);
		else	x.val = val;
		x.N = size(x.left)+size(x.right)+1;
		return x;
	}
	
	public int size()
	{ return size(root);} 
	
	private int size(Node x) {
		if(x==null) return 0;
		else 		return x.N;
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
	
	public boolean isBinaryTree()
	{ return root.N==isBinaryTree(root);}
	
	private int isBinaryTree(Node x) {
		if(x==null) return 0;
		int N = 0;
		N += isBinaryTree(x.left);
		N += isBinaryTree(x.right);
		return ++N;
	}
	
	public boolean isOrdered()
	{ return isOrdered(root,min(root).key,max(root).key);}
	
	private boolean isOrdered(Node x,Key min,Key max) {
		if(x.key.compareTo(min)<0||x.key.compareTo(max)>0) return false;
		if(x.left!=null&&!isOrdered(x.left,min(x.left).key,max(x.left).key)) return false;
		if(x.right!=null&&!isOrdered(x.right,min(x.right).key,max(x.right).key)) return false;
		return true;
	}
	
	public boolean hasNoDuplicates()
	{ return hasNoDuplicates(root);}
	
	private boolean hasNoDuplicates(Node x) {
		if(x.left!=null&&x.key.equals(x.left.key)) return false;
		if(x.right!=null&&x.key.equals(x.right.key)) return false;
		if(x.left!=null&&!hasNoDuplicates(x.left)) return false; 
		if(x.right!=null&&!hasNoDuplicates(x.right)) return false;
		return true;
	}
	
	public boolean isBST(Node x) {
		if(x.N!=isBinaryTree(x)) return false;
		if(!isOrdered(x,min(x).key,max(x).key)) return false;
		if(!hasNoDuplicates(x)) return false;
		return true;
	}
	
	public Key select(int k)
	{ return select(root,k).key;}
	
	private Node select(Node x,int k) {
		if(x==null) return null;
		int t = size(x.left);
		if(t>k) return select(x.left,k);
		else if(t<k) return select(x.right,k-t-1);
		else	return x;
	}
	
	public int rank(Key key)
	{ return rank(key,root);}
	
	private int rank(Key key,Node x) {
		if(x==null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return rank(key,x.left);
		else if(cmp>0) return 1+size(x.left)+rank(key,x.right);
		else return size(x.left);
	}
	
	public boolean selectAndRankCheck(){
		for(int i = 0;i<size(root);i++)
			if(i!=rank(select(i))) return false;
		return selectAndRankCheck(root);
	}
	
	private boolean selectAndRankCheck(Node x) {
		if(x==null) return true;
		if(!x.key.equals(select(rank(x.key)))) return false;
		if(!selectAndRankCheck(x.left)) return false;
		if(!selectAndRankCheck(x.right)) return false;
		return true;
	}
}
