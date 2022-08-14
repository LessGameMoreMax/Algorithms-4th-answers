package myCharpter3_3;

import edu.princeton.cs.algs4.StdDraw;

public class DrawRedBlackBST <Key extends Comparable<Key>,Value>{
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
		
		private double x;
		private double y;
		public Node(Key key,Value val,int N,boolean color,double x,double y)
		{ this.key = key; this.val = val; this.N = N; this.color = color; this.x = x; this.y = y;}
	}
	
	private boolean isRed(Node x) {
		if(x==null) return false;
		return x.color==RED;
	}
	
	private Node rotateLeft(Node h,double len) {
		Node x = h.right;
		
		x.x = h.x;
		x.y = h.y;
		h.x = h.x - len;
		h.y = h.y - len;
		h.left.x = h.left.x - len;
		h.left.y = h.left.y - len;
		x.left.x -= len;
		x.right.x -= len;
		x.right.y += len;
		
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1+size(h.left)+size(h.right);
		return x;
	}
	
	private Node rotateRight(Node h,double len) {
		Node x = h.left;
		
		x.x = h.x;
		x.y = h.y;
		h.x += len;
		h.y += len;
		h.right.x += len;
		h.right.y -= len;
		x.right.x += len;
		x.left.x -= len;
		x.left.y += len;
		
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
	
	public void put(Key key,Value val)
	{ 	
		root = put(root,key,val,0,0,4);
		root.color = BLACK;
	}
	
	private Node put(Node x,Key key,Value val,double X,double Y,double len) {
		if(x==null) return new Node(key,val,1,RED,X,Y);
		int cmp = key.compareTo(x.key);
		if(cmp<0) x.left = put(x.left,key,val,X-len,Y-len,len/2);
		else if(cmp>0) x.right = put(x.right,key,val,X+len,Y-len,len/2);
		else x.val = val;
		if(isRed(x.right)&&!isRed(x.left)) x = rotateLeft(x,len);
		if(isRed(x.left)&&isRed(x.left.left)) x = rotateRight(x,len);
		if(isRed(x.left)&&isRed(x.right)) flipColors(x);
		x.N = size(x.left)+size(x.right)+1;
		return x;
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
	
	public void draw() {
		StdDraw.setXscale(-10, 10);
		StdDraw.setYscale(-10, 1);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(.03);
		drawPoint(root);
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.setPenRadius(.01);
		drawLine(root);
	}
	
	private void drawPoint(Node x) {
		if(x==null) return;
		StdDraw.point(x.x, x.y);
		if(x.left!=null) drawPoint(x.left);
		if(x.right!=null) drawPoint(x.right);
	}
	
	private void drawLine(Node x) {
		if(x==null) return;
		if(x.left!=null) {
			if(x.left.color) StdDraw.setPenColor(StdDraw.RED);
			StdDraw.line(x.x, x.y, x.left.x, x.left.y);
			StdDraw.setPenColor(StdDraw.GRAY);
			drawLine(x.left);
		}
		if(x.right!=null) {
			StdDraw.line(x.x, x.y, x.right.x, x.right.y);
			drawLine(x.right);
		}
	}
}
