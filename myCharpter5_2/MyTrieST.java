package myCharpter5_2;

import edu.princeton.cs.algs4.Queue;

public class MyTrieST<Value> {
	public static int R = 256;
	private Node root;
	
	private static class Node{
		private int N;
		private Object val;
		private Node[] next = new Node[R];
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
		return get(x.next[c],key,d+1);
	}
	
	public void put(String key,Value val)
	{ 	if(contains(key)) get(root,key,0).val = val;
		else root = put(root,key,val,0);
	}
	
	private Node put(Node x,String key,Value val,int d) {
		if(x==null) x = new Node();
		x.N++;
		if(d==key.length()) { x.val = val; return x;}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c],key,val,d+1);
		return x;
	}
	
	public int lazySize()
	{ return lazySize(root);}
	
	private int lazySize(Node x) {
		if(x==null) return 0;
		int cnt = 0;
		if(x.val!=null) cnt++;
		for(char c = 0;c<R;c++)
			cnt += lazySize(x.next[c]);
		return cnt;
	}
	
	public int moreImmediatelySize() 
	{ if(root==null) return 0; else return root.N;}
	
	public Iterable<String> keys()
	{ return keyWithPrefix("");}
	
	public Iterable<String> keyWithPrefix(String pre){
		Queue<String> q = new Queue<String>();
		collect(get(root,pre,0),pre,q);
		return q;
	}
	
	private void collect(Node x,String pre,Queue<String> q) {
		if(x==null) return;
		if(x.val!=null) q.enqueue(pre);
		for(char c = 0;c<R;c++)
			collect(x.next[c],pre + c,q);
	}
	
	public Iterable<String> keysThatMatch(String pat){
		Queue<String> q = new Queue<String>();
		collect(root,"",pat,q);
		return q;
	}
	
	public void collect(Node x,String pre,String pat,Queue<String> q) {
		int d = pre.length();
		if(x==null) return;
		if(d==pat.length()&&x.val!=null) q.enqueue(pre);
		if(d==pat.length()) return;
		
		char next = pat.charAt(d);
		for(char c = 0;c<R;c++)
			if(next=='.'||next==c)
				collect(x.next[c],pre+c,pat,q);
	}
	
	public String longestPrefixOf(String s) {
		int length = search(root,s,0,0);
		return s.substring(0,length);
	}
	
	private int search(Node x,String s,int d,int length) {
		if(x==null) return length;
		if(x.val!=null) length = d; 
		if(d==s.length()) return length;
		char c = s.charAt(d);
		return search(x.next[c],s,d+1,length);
	}
	
	public void delete(String key)
	{
		if(!contains(key)) return;
		root = delete(root,key,0);
	}
	
	private Node delete(Node x,String key,int d) {
		if(x==null) return null;
		if(d==key.length()) x.val = null;
		else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c],key,d+1);
		}
		x.N--;
		if(x.val!=null) return x;
		for(char c = 0;c<R;c++)
			if(x.next[c]!=null) return x;
		return null;
	}
	
//	private String maxPartString(Node x) {
//		String s = "";
//		if(x==null) return s;
//		Node temp = x;
//		while(true) {
//			char c = 0;
//			for( c = (char) (this.R-1);c>0;c--)
//				if(temp.next[c]!=null) break;
//			temp = temp.next[c];
//			if(temp!=null) s += c;
//			else 		   break;
//		}
//		return s;
//	}
	
	
	public String select(int k) {
		if(k<=0||k>this.moreImmediatelySize()) return "";
		Queue<Character> q = new Queue<Character>();
		select(root,k,q);
		String s = "";
		for(char c : q) s += c;
		return s;
	}
	
	private void select(Node x,int k,Queue<Character> q) {
		if(x==null) return;
		if(x.val!=null) {
			k--;
			if(k==0) return;
		}
		int num = 0;
		for(char c = 0;c<R;c++) 
			if(x.next[c]!=null) {
				if(num + x.next[c].N >= k) {
					q.enqueue(c);
					select(x.next[c],k-num,q);
					break;
				}else num += x.next[c].N;
			}
	}

	
	private Character minChildChar(Node x) {
		if(x==null) return null;
		char c = 0;
		while(c<R) {
			if(x.next[c]!=null) return c;
			c++;
		}
		return null;
	}
	
	private Character maxChildChar(Node x) {
		if(x==null) return null;
		char c = (char) (R-1);
		while(c>0) {
			if(x.next[c]!=null) return c;
			c--;
		}
		return null;
	}

	
	public int rank(String key)
	{ return rank(root,key,0);}
	
	private int rank(Node x,String key,int d) {
		if(x==null) return 0;
		if(x.val==null&&d==key.length()) return 1;
		else if(x.val!=null&&d==key.length()) return 0;
		char c = key.charAt(d);
		if(maxChildChar(x)==null||minChildChar(x)==null) return x.N;
		if(c>maxChildChar(x)) return lessNumber(x,c)+1;
		if(c<minChildChar(x)) return 1;
		if(x.next[c]==null) return lessNumber(x,c)+1;
		if(x.next[c]!=null) {
			if(x.next[c].val!=null) 	return lessNumber(x,c) + rank(x.next[c],key,d+1) + 1;
			else		   				return lessNumber(x,c) + rank(x.next[c],key,d+1);
		}
		return 0;
	}
	
	public boolean contains(String key)
	{ return get(key)!=null;}
	
	private int lessNumber(Node x,char c) {
		int num = 0;
		for(int i = 0;i<c;i++) 
			if(x.next[i]!=null) num += x.next[i].N;
//		System.out.println(num);
		return num;
	}
	
	public String floor(String key) {
		if(contains(key)) return key;
		int r = rank(key);
		if(r==1) return "";
		return select(r-1);
 	}
	
	public String ceiling(String key) {
		if(contains(key)) return key;
		int r = rank(key);
		if(r>moreImmediatelySize()) return "";
		return select(r);
	}
	
	public static void main(String[] args) {
		MyTrieST<Integer> T = new MyTrieST<Integer>();
		T.put("by", 4);
		T.put("sea", 2);
		T.put("sells", 1);
		T.put("she", 0);
		T.put("shells", 3);
		T.put("shells", 3);
		T.put("shells", 3);
		T.put("shells", 3);
		T.put("the", 5);
		T.put("sh", 5);
		T.put("sh", 5);
		T.put("sh", 5);
		T.put("sh", 5);
		T.put("shea", 5);
//		System.out.println(T.rank("she"));
//		T.get("shea");
//		T.get("shells");
		T.put("the", 1);
		T.put("the", 5);
		System.out.println(T.get("the"));
		System.out.println(T.moreImmediatelySize());
	}
}
