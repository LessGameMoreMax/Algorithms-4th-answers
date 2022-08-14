package myCharpter5_2;

import edu.princeton.cs.algs4.Queue;

public class StringSET {
	private static int R = 256;
	private Node root;
	private static class Node{
		private boolean isEnd;
		private Node[] next = new Node[R];
	}
	
	public void add(String key) {
		root = add(root,key,0);
	}
	
	private Node add(Node x,String key,int d) {
		if(x==null) x = new Node();
		if(d==key.length()) { x.isEnd = true; return x;}
		char c = key.charAt(d);
		x.next[c] = add(x.next[c],key,d+1);
		return x;
	}
	
	public void delete(String key)
	{ root = delete(root,key,0);}
	
	private Node delete(Node x,String key,int d) {
		if(x==null) return null;
		if(d==key.length()) x.isEnd = false;
		else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c],key,d+1);
		}
		if(!x.isEnd) return x;
		for(char c = 0;c < R;c++)
			if(x.next[c]!=null) return x;
		return null;
	}
	
	
	public boolean contains(String key) {
		Node x = contains(root,key,0);
		if(x==null) return false;
		return x.isEnd;
	}
	
	private Node contains(Node x,String key,int d) {
		if(x==null) return null;
		if(d==key.length()) return x;
		char c = key.charAt(d);
		return contains(x.next[c],key,d+1);
	}
	
	public boolean containsPrefix(String pre) {
		Node temp = root;
		for(int i = 0;i<pre.length();i++) {
			char c = pre.charAt(i);
			if(temp.next[c]==null) return false;
			else				   temp = temp.next[c];
		}
		return true;
	}
	
	public boolean isEmpty()
	{ return this.root==null;}
	
	public int size()
	{ return size(root);}
	
	private int size(Node x) {
		if(x==null) return 0;
		int cnt = 0;
		if(x.isEnd) cnt++;
		for(char c = 0;c<R;c++)
			cnt += size(x.next[c]);
		return cnt;
	}
	
	public String toString() {
		String str = "";
		for(String s : keys())
			str = str + s + "\n";
		return str;
	}
	
	private Iterable<String> keys(){
		Queue<String> q = new Queue<String>();
		collect(contains(root,"",0),"",q);
		return q;
	}
	
	private void collect(Node x,String pre,Queue<String> q) {
		if(x==null) return;
		if(x.isEnd) q.enqueue(pre);
		for(char c = 0;c<R;c++)
			collect(x.next[c],pre + c,q);
	}
	
	public static void main(String[] args) {
		StringSET set = new StringSET();
		set.add("by");
		set.add("sea");
		set.add("sells");
		set.add("she");
		set.add("shells");
		set.add("the");
		set.add("sea");
//		System.out.println(set.contains("by"));
//		System.out.print(set);
//		System.out.print(set.size());
//		set.delete("sea");
//		set.delete("she");
//		set.delete("the");
//		System.out.println(set.contains("sea"));
//		System.out.print(set);
//		System.out.print(set.size());
		
		System.out.print(set.containsPrefix("sa"));
	}
}
