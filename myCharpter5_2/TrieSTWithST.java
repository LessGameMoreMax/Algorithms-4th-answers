package myCharpter5_2;

import edu.princeton.cs.algs4.ST;

public class TrieSTWithST<Value> {
	private Node root;
	private static class Node{
		private Object val;
		private ST<Character,Node> st = new ST<Character,Node>();
	}
	
	public Value get(String key) {
		Node x = get(root,key,0);
		if(x==null) return null;
		return (Value) x.val;
	}
	
	private Node get(Node x,String key,int d) {
		if(x==null) return null;
		if(d==key.length()) return x;
		char c = key.charAt(d);
		return get(x.st.get(c),key,d+1);
	}
	
	public void put(String key,Value val)
	{ root = put(root,key,val,0);}
	
	private Node put(Node x,String key,Value val,int d) {
		if(x==null) x = new Node();
		if(d==key.length()) { x.val = val; return x;}
		char c = key.charAt(d);
		x.st.put(c, put(x.st.get(c),key,val,d+1));
		return x;
	}
	
	public static void main(String[] args) {
		TrieSTWithST<Integer> T = new TrieSTWithST<Integer>();
		T.put("sea", 1);
		T.put("by", 2);
		T.put("sells", 3);
		T.put("sellt", 4);
		T.put("the", 5);
		T.put("yes", 6);
		System.out.println(T.get("sellt"));
	}
}
