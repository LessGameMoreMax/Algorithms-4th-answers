package myCharpter3_3;

public class TwoThreeFourBSTNoRecursion <Key extends Comparable<Key>,Value>{
	private Node root;
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node{
		Key key;
		Value val;
		Node left;
		Node right;
		boolean color;
		
		Node(Key key,Value val,boolean color){
			this.key = key;
			this.val = val;
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
		return x;
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	
	private void flipColors(Node h) {
		h.color = !h.color;
		h.left.color = !h.left.color;
		h.right.color = !h.right.color;
	}
	
	public void put(Key key,Value val) {
		if(root==null) {
			root = new Node(key,val,RED);
			return;
		}
		Node h = root;
		while(true) {
			if(isRed(h.left)&&isRed(h.right)) flipColors(h);
			int cmp = key.compareTo(h.key);
			if(cmp<0) {
				if(h.left==null) {
					h.left = new Node(key,val,RED);
					break;
				}
				h = h.left;
				balance(h);
			}
			else if(cmp>0) {
				if(h.right==null) { 
					h.right = new Node(key,val,RED);
					break;
				}
				h = h.right;
				balance(h);
			}
			else {
				h.val = val;
				balance(h);
				break;
			}
		}
		root.color = BLACK;
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
	
    private void balance(Node h) {
        if (isRed(h.right)&&!isRed(h.left))      h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
    }
}


