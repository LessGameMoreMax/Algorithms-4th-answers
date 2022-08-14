package myCharpter3_2;

import edu.princeton.cs.algs4.StdDraw;

public class BSTVisionDraw <Key extends Comparable <Key>,Value>{
	private Node root;
	private class Node{
		private Key key;
		private Value val;
		private Node left;
		private Node right;
		private int N;
		private double x;
		private double y;
		public Node(Key key,Value val,int N,double x,double y)
		{ this.key = key; this.val = val; this.N = N; this.x = x; this.y = y;}
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
		else	return x.val;
	}
	
	public void put(Key key,Value val)
	{ root = put(root,key,val,0,0,4);}
	
	private Node put(Node x,Key key,Value val,double X,double Y,double len) {
		if(x==null) return new Node(key,val,1,X,Y);
		int cmp = key.compareTo(x.key);
		if(cmp<0) x.left = put(x.left,key,val,X-len,Y-len,len/2);
		else if(cmp>0) x.right = put(x.right,key,val,X+len,Y-len,len/2);
		else x.val = val;
		x.N = size(x.left)+size(x.right)+1;
		return x;
	}
	
	public void draw() {
		StdDraw.setXscale(-10, 10);
		StdDraw.setYscale(-10, 1);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(.03);
		drawPoint(root);
		StdDraw.setPenColor(StdDraw.GREEN);
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
			StdDraw.line(x.x, x.y, x.left.x, x.left.y);
			drawLine(x.left);
		}
		if(x.right!=null) {
			StdDraw.line(x.x, x.y, x.right.x, x.right.y);
			drawLine(x.right);
		}
	}
	
	public static void main(String[] args) {
		BSTVisionDraw<String,Integer> test = new BSTVisionDraw<String,Integer>();
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
		test.draw();
	}
}
