package myCharpter3_5;

public class SETint{
	private Node root;
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node{
		int key;
		Node left;
		Node right;
		int N;
		boolean color;
		
		Node(int key,int N,boolean color){
			this.key = key;
			this.N = N;
			this.color = color;
		}
	}
	
	private boolean isRed(Node x) {
		if(x==null) return false;
		return x.color == RED;
	}
	
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left)+size(h.right);
		return x;
	}
	
	public int size()
	{ return size(root);}
	
	private int size(Node x) {
		if(x==null) return 0;
		return x.N;
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left)+size(h.right);
		return x;
	}
	
	private void flipColors(Node h) {
		h.color = !h.color;
		h.left.color = !h.left.color;
		h.right.color = !h.right.color;
	}
	
	public void put(int key) {
		root = put(root,key);
		root.color = BLACK;
	}
	
	private Node put(Node h,int key) {
		if(h==null) return new Node(key,1,RED);
		int cmp = key - h.key;
		if(cmp<0) h.left = put(h.left,key);
		else if(cmp>0) h.right = put(h.right,key);
		
		if(isRed(h.right)&&!isRed(h.left)) h = rotateLeft(h);
		if(isRed(h.left)&&isRed(h.left.left)) h = rotateRight(h);
		if(isRed(h.left)&&isRed(h.right)) flipColors(h);
		
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}
	
	public boolean contains(int key)
	{ return get(root,key);}
	
	private boolean get(Node x,int key) {
		if(x==null) return false;
		int cmp = key - x.key;
		if(cmp<0) return get(x.left,key);
		else if(cmp>0) return get(x.right,key);
		else 		return true;
	}
	
	private Node moveRedLeft(Node h) {
		flipColors(h);
		if(isRed(h.right.left)) {
			h.right = rotateRight(h.right);
			h = rotateLeft(h);
		}
		return h;
	}
	
	public void deleteMin() {
		if(!isRed(root.left)&&!isRed(root.right)) root.color = RED;
		root = deleteMin(root);
		if(!isEmpty()) root.color = BLACK;
	}
	
	private Node deleteMin(Node h) {
		if(h.left==null) return null;
		if(!isRed(h.left)&&!isRed(h.left.left)) h = moveRedLeft(h);
		h.left = deleteMin(h.left);
		return balance(h);
	}
	
	private Node balance(Node h) {
		if(isRed(h.right)) h = rotateLeft(h);
		if(isRed(h.right)&&!isRed(h.left)) h = rotateLeft(h);
		if(isRed(h.left)&&isRed(h.left.left)) h = rotateRight(h);
		if(isRed(h.left)&&isRed(h.right)) flipColors(h);
		
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}
	
	private Node moveRedRight(Node h) {
		flipColors(h);
		if(isRed(h.left.left)) h = rotateRight(h);
		return h;
	}
	
	public void deleteMax() {
		if(!isRed(root.left)&&!isRed(root.right))
			root.color = RED;
		root = deleteMax(root);
		if(!isEmpty()) root.color = BLACK;
	}
	
	private Node deleteMax(Node h) {
		if(isRed(h.left)) h = rotateRight(h);
		if(h.right==null) return null;
		if(!isRed(h.right)&&!isRed(h.right.left))
			h = moveRedRight(h);
		h.right = deleteMax(h.right);
		return balance(h);
	}
	
	public void delete(int key) {
		if(!isRed(root.left)&&!isRed(root.right))
			root.color = RED;
		root = delete(root,key);
		if(!isEmpty()) root.color = BLACK;
	}
	
	private Node delete(Node h,int key) {
		if(key<h.key) {
			if(!isRed(h.left)&&!isRed(h.left.left))
				h = moveRedLeft(h);
			h.left = delete(h.left,key);
		}else {
			if(isRed(h.left)) h = rotateRight(h);
			if(key==h.key&&(h.right==null))
				return null;
			if(!isRed(h.right)&&!isRed(h.right.left))
				h = moveRedRight(h);
			if(key==h.key) {
				h.key = min(h.right).key;
				h.right = deleteMin(h.right);
			}
			else h.right = delete(h.right,key);
		}
		return balance(h);
	}
	
	public int min()
	{ return min(root).key;}
	
	private Node min(Node x) {
		if(x.left==null) return x;
		return min(x.left);
	}
	
	public boolean isEmpty()
	{ return size()==0;}
	
}
