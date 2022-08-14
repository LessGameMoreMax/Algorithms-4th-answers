package myCharpter5_2;

import edu.princeton.cs.algs4.ST;

public class MixTST<Value> {
	//key的长度必须大于2
	private static int R = 256;
	private class Node{
		char c;
		Node left;
		Node right;
		Node mid;
		Value val;
	}
	private ST<Character,ST<Character,Node>> st;
	
	public MixTST() {
		st = new ST<Character,ST<Character,Node>>();
	}
	
	public Value get(String key) {
		if(key.length()<=2) return null;
		ST<Character,Node> stTemp = st.get(key.charAt(0));
		if(stTemp==null) return null;
		Node x = stTemp.get(key.charAt(1));
		Node n = get(x,key,2);
		if(n==null) return null;
		return n.val;
	}
	
	private Node get(Node x,String key,int d) {
		if(x==null) return null;
		char c = key.charAt(d);
		if(c<x.c) return get(x.left,key,d);
		else if(c>x.c) return get(x.right,key,d);
		else if(d<key.length()-1) return get(x.mid,key,d+1);
		else return x;
	}
	
	public void put(String key,Value val) {
		if(key.length()<=2) return;
		if(st.get(key.charAt(0))==null) st.put(key.charAt(0),new ST<Character,Node>());
		ST<Character,Node> stTemp = st.get(key.charAt(0));
		if(stTemp.get(key.charAt(1))==null) stTemp.put(key.charAt(1),new Node());
		Node x = stTemp.get(key.charAt(1));
		x = put(x,key,val,2);
	}
	
	private Node put(Node x,String key,Value val,int d) {
		char c = key.charAt(d);
		if(x==null) { x = new Node(); x.c = c;}
		if(c<x.c) x.left = put(x.left,key,val,d);
		else if(c>x.c) x.right = put(x.right,key,val,d);
		else if(d<key.length()-1) x.mid = put(x.mid,key,val,d+1);
		else x.val = val;
		return x;
	}
	
	public static void main(String[] args) {
		MixTST<Integer> T = new MixTST<Integer>();
		T.put("are", 1);
		T.put("byz", 2);
		T.put("sea", 3);
		T.put("sells", 4);
		T.put("she", 5);
		T.put("shells", 6);
		T.put("shore", 7);
		T.put("sur", 8);
		T.put("surely", 9);
		T.put("the", 10);
		System.out.println(T.get("shurly"));
	}
}
