package myCharpter3_2;

public class ThreadST <Key extends Comparable<Key>,Value>{
	private Node root;
	private class Node{
		private Key key;
		private Value val;
		private Node left;
		private Node right;
		private Node pred;
		private Node succ;
		private int N;
		public Node(Key key,Value val,int N){
			this.key = key;
			this.val = val;
			this.N = N;
		}
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
	
	public Key next(Key key){
		Node t = next(root,key);
		if(t==null) return null;
		else 		return t.key;
	}
	
	private Node next(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return next(x.left,key);
		else if(cmp>0) return next(x.right,key);
		else return x.succ;
	}
	
	public Key prev(Key key){
		Node t = prev(root,key);
		if(t==null) return null;
		else		return t.key;
	}
	
	private Node prev(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return prev(x.left,key);
		else if(cmp>0) return prev(x.right,key);
		else return x.pred;
	}
	
	public void put(Key key,Value val)
	{ 
		root = put(root,key,val);
		putChange(root,key);
	}
	
	private Node put(Node x,Key key,Value val) {
		if(x==null) return new Node(key,val,1);
		int cmp = key.compareTo(x.key);
		if(cmp<0) x.left = put(x.left,key,val);
		else if(cmp>0) x.right = put(x.right,key,val);
		else x.val = val;
		x.N = size(x.left)+size(x.right)+1;
		return x;
	}
	
	private void putChange(Node x,Key key) {
		if(x==null) return;
		int cmp = key.compareTo(x.key);
		if(cmp<0) {
			int r = rank(x.key);
			if(r==0) {
				x.pred = null;
				x.succ = select(root,r+1);
			}else if(r==size()-1) {
				x.pred = select(root,r-1);
				x.succ = null;
			}else {
				x.pred = select(root,r-1);
				x.succ = select(root,r+1);	
			}
			putChange(x.left,key);
		}
		else if(cmp>0) {
			int r = rank(x.key);
			if(r==0) {
				x.pred = null;
				x.succ = select(root,r+1);
			}else if(r==size()-1) {
				x.pred = select(root,r-1);
				x.succ = null;
			}else {
				x.pred = select(root,r-1);
				x.succ = select(root,r+1);	
			}
			putChange(x.right,key);
		}
		else {
			int r = rank(x.key);
			if(r==0&&r==size()-1) {
				x.pred = null;
				x.succ = null;
			}
			else if(r==0&&r!=size()-1) {
				x.pred = null;
				x.succ = select(root,r+1);
			}else if(r!=0&&r==size()-1) {
				x.pred = select(root,r-1);
				x.succ = null;
			}else {
				x.pred = select(root,r-1);
				x.succ = select(root,r+1);	
			}
			return;
		}
	}
	
	public Key min()
	{ return min(root).key;}
	
	private Node min(Node x) {
		if(x.left==null) return x;
		return min(x.left);
	}
	
	public Key floor(Key key) {
		Node x = floor(root,key);
		if(x==null) return null;
		return x.key;
	}
	
	private Node floor(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp==0) return x;
		if(cmp<0) return floor(x.left,key);
		Node t = floor(x.right,key);
		if(t!=null) return t;
		else return x;
	}
	
	public Key select(int k)
	{ return select(root,k).key;}
	
	private Node select(Node x,int k) {
		if(x==null) return null;
		int t = size(x.left);
		if(t>k) return select(x.left,k);
		else if(t<k) return select(x.right,k-t-1);
		else return x;
	}
	
	public int rank(Key key)
	{ return rank(key,root);}
	
	private int rank(Key key,Node x) {
		if(x==null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return rank(key,x.left);
		else if(cmp>0) return 1+size(x.left)+rank(key,x.right);
		else	return size(x.left);
	}
	
	public void deleteMin()
	{ 
		root = deleteMin(root);
		deleteMinChange(root);
	}
	
	private Node deleteMin(Node x) {
		if(x.left==null) return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left)+size(x.right)+1;
		return x;
	}
	
	private void deleteMinChange(Node x) {
		if(x==null) return;
		int r = rank(x.key);
		if(r==0&&r==size()-1) {
			x.pred = null;
			x.succ = null;
		}
		else if(r==0&&r!=size()-1) {
			x.pred = null;
			x.succ = select(root,r+1);
		}else if(r!=0&&r==size()-1) {
			x.pred = select(root,r-1);
			x.succ = null;
		}else {
			x.pred = select(root,r-1);
			x.succ = select(root,r+1);	
		}
		deleteMinChange(x.left);
	}
	
	public void deleteMax()
	{ 
		root = deleteMax(root);
		deleteMaxChange(root);
	}
	
	private Node deleteMax(Node x) {
		if(x.right==null) return x.left;
		x.right = deleteMax(x.right);
		x.N = size(x.left)+size(x.right)+1;
		return x;
	}
	
	private void deleteMaxChange(Node x) {
		if(x==null) return;
		int r = rank(x.key);
		if(r==0&&r==size()-1) {
			x.pred = null;
			x.succ = null;
		}
		else if(r==0&&r!=size()-1) {
			x.pred = null;
			x.succ = select(root,r+1);
		}else if(r!=0&&r==size()-1) {
			x.pred = select(root,r-1);
			x.succ = null;
		}else {
			x.pred = select(root,r-1);
			x.succ = select(root,r+1);	
		}
		deleteMinChange(x.right);
	}
	
	public void delete(Key key)
	{
		int r = rank(key);
		root = delete(root,key);
		deleteChange(r);
	}
	
	private Node delete(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) x.left = delete(x.left,key);
		else if(cmp>0) x.right = delete(x.right,key);
		else {
			if(x.right == null) return x.left;
			if(x.left==null) return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left)+size(x.right)+1;
		return x;
	}
	
	private void deleteChange(int r) {
		if(r==0&&r==size()) return;
		if(r==0) {
			Node t = select(root,0);
			Node s = select(root,1);
			t.pred = null;
			t.succ = s;
		}else if(r==size()) {
			Node t = select(root,size()-1);
			Node s = select(root,size()-2);
			t.succ = null;
			t.pred = s;
		}else {
			Node t = select(root,r-1);
			Node s = select(root,r);
			t.succ = s;
			s.pred = t;
		}
	}
	
	public static void main(String[] args) {
		ThreadST<String,Integer> test = new ThreadST<String,Integer>();
		test.put("S", 0);
		test.put("E", 1);
		test.put("A", 2);
		test.put("R", 3);
		test.put("C", 4);
		test.put("H", 5);
		test.put("E", 6);
		test.put("X", 7);
		test.put("A", 8);
		test.put("M", 9);
//normal test:		
//		System.out.println(test.prev("A"));
//		System.out.println(test.prev("C"));
//		System.out.println(test.prev("E"));
//		System.out.println(test.prev("H"));
//		System.out.println(test.prev("S"));
//		System.out.println(test.prev("X"));
//		System.out.println();
//		System.out.println(test.next("A"));
//		System.out.println(test.next("C"));
//		System.out.println(test.next("E"));
//		System.out.println(test.next("H"));
//		System.out.println(test.next("S"));
//		System.out.println(test.next("X"));
		
//deleteMin test:
//		test.deleteMin();
//		System.out.println(test.prev("C"));
//		System.out.println(test.prev("E"));
//		System.out.println(test.next("C"));
//		System.out.println(test.next("E"));
//		test.deleteMin();
//		System.out.println(test.prev("E"));
//		System.out.println(test.prev("H"));
//		System.out.println(test.next("E"));
//		System.out.println(test.next("H"));
//		test.deleteMin();
//		System.out.println(test.prev("H"));
//		System.out.println(test.prev("R"));
//		System.out.println(test.next("H"));
//		System.out.println(test.next("R"));
		
//		deleteMax test:
//		test.deleteMax();
//		System.out.println(test.prev("S"));
//		System.out.println(test.prev("R"));
//		System.out.println(test.next("S"));
//		System.out.println(test.next("R"));
//		test.deleteMax();
//		System.out.println(test.prev("R"));
//		System.out.println(test.prev("H"));
//		System.out.println(test.next("R"));
//		System.out.println(test.next("H"));
//		test.deleteMax();
//		System.out.println(test.prev("H"));
//		System.out.println(test.prev("E"));
//		System.out.println(test.next("H"));
//		System.out.println(test.next("E"));
		
//		delete test:
//		test.delete("E");
//		System.out.println(test.prev("H"));
//		System.out.println(test.prev("M"));
//		System.out.println(test.next("C"));
//		System.out.println(test.next("H"));
//		test.delete("S");
//		System.out.println(test.prev("X"));
//		System.out.println(test.next("X"));
//		System.out.println(test.next("R"));
//		System.out.println(test.prev("R"));
//		test.delete("H");
//		System.out.println(test.prev("M"));
//		System.out.println(test.next("C"));
//		test.delete("R");
//		System.out.println(test.next("M"));
//		System.out.println(test.prev("X"));
//		test.delete("A");
//		test.delete("M");
//		test.delete("X");
//		System.out.println(test.prev("C"));
//		System.out.println(test.next("C"));
	}
	
}
