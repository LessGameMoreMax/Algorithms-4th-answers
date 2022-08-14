package myCharpter5_2;

import edu.princeton.cs.algs4.Queue;

public class MyTST<Value> {
	private Node root;
	private class Node{
		char c;
		Node left;
		Node mid;
		Node right;
		Value val;
	}
	private int N;
	
	public boolean contains(String key) 
	{ return get(key)!=null;}
	
	public int lessImmediatelySize()
	{ return N;}
	
	public Value get(String key) {
		Node x = get(root,key,0);
		if(x==null) return null;
		return x.val;
	}
	
	private Node get(Node x,String key,int d) {
		if(x==null) return null;
		char c = key.charAt(d);
		if(c<x.c) return get(x.left,key,d);
		else if(c>x.c) return get(x.right,key,d);
		else if(d<key.length()-1) return get(x.mid,key,d+1);
		else return x;
	}
	
	public void put(String key,Value val)
	{
		if(!contains(key)) N++;
		root = put(root,key,val,0);
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
	
	public Iterable<String> keys()
	{ return keysWithPrefix("");}
	
	public Iterable<String> keysWithPrefix(String pre){
		Queue<String> q = new Queue<String>();
		if(pre=="") collect(root,pre,q);
		else		collect(get(root,pre,0).mid,pre,q);
		return q;
	}
	
	private void collect(Node x,String pre,Queue<String> q) {
		if(x==null) return;
		if(x.val!=null) q.enqueue(pre+x.c);
		collect(x.left,pre,q);
		collect(x.mid,pre+x.c,q);
		collect(x.right,pre,q);
	}
	
	public Iterable<String> keysThatMatch(String pat){
		Queue<String> q = new Queue<String>();
		collect(root,"",pat,q);
		return q;
	}
	
	public void collect(Node x,String pre,String pat,Queue<String> q) {
		int d = pre.length();
		if(x==null) return;
		if(d==pat.length()-1&&x.val!=null) 
			if(pat.charAt(d)==x.c||pat.charAt(d)=='.')	
				q.enqueue(pre+x.c);
		if(d==pat.length()-1) return;
		
		char next = pat.charAt(d);
		if(next < x.c || next == '.') collect(x.left,pre,pat,q);  
		if(next == x.c || next == '.') collect(x.mid,pre + x.c,pat,q);  
		if(next > x.c || next == '.') collect(x.right,pre,pat,q);  
	}
	
	public String longestPrefixOf(String s) {
		int length = search(root,s,0,0);
		return s.substring(0,length);
	}
	
	private int search(Node x,String s,int d,int length) {
		if(x==null) return length;
		if(x.val!=null) length = d+1;
		if(d==s.length()-1) return length;
		char c = s.charAt(d);
		if(c < x.c) return search(x.left,s,d,length);  
		if(c == x.c) return search(x.mid,s,d+1,length);  
		return search(x.right,s,d,length); 
	}
	
	public static void main(String[] args) {
		MyTST<Integer> T = new MyTST<Integer>();
		T.put("are", 1);
		T.put("by", 1);
		T.put("sea", 1);
		T.put("sells", 1);
		T.put("she", 1);
		T.put("shells", 1);
		T.put("shore", 1);
		T.put("sur", 1);
		T.put("surely", 1);
		T.put("the", 1);
//		System.out.print(T.get(T.root,"sh",0).c);
//			System.out.println(T.longestPrefixOf("surelyz"));
		System.out.println(T.get("surly"));
	}
}
