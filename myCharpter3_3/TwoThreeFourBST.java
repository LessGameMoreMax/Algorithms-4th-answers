package myCharpter3_3;

public class TwoThreeFourBST <Key extends Comparable<Key>,Value>{
	private Node root;
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node{
		Key key;
		Value val;
		Node left;
		Node right;
		int N;
		boolean color;
		
		Node(Key key,Value val,int N,boolean color){
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}
	
	private boolean isRed(Node x) {
		if(x==null) return false;
		return x.color==RED;
	}
	
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1+size(h.left)+size(h.right);
		return x;
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1+size(h.left)+size(h.right);
		return x;
	}
	
	public int size()
	{ return size(root);}
	
	private int size(Node x) {
		if(x==null) return 0;
		return x.N;
	}
	
	private void flipColors(Node h) {
		h.color = !h.color;
		h.left.color = !h.left.color;
		h.right.color = !h.right.color;
	}
	
	public void put(Key key,Value val) {
		root = put(root,key,val);
		root.color = BLACK;
	}
	
	private Node put(Node h,Key key,Value val) {
		if(h==null) return new Node(key,val,1,RED);
		if(isRed(h.left)&&isRed(h.right)) flipColors(h);
		int cmp = key.compareTo(h.key);
		if(cmp<0) h.left = put(h.left,key,val);
		else if(cmp>0) h.right = put(h.right,key,val);
		else h.val = val;
		
		if(isRed(h.right)&&!isRed(h.left)) h = rotateLeft(h);
		if(isRed(h.left)&&isRed(h.left.left)) h = rotateRight(h);

		h.N = size(h.left)+size(h.right)+1;
		return h;
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
	
    private Node balance(Node h) {
        if (isRed(h.right))                      h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }
}

