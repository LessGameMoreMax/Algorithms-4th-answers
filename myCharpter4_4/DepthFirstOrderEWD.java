package myCharpter4_4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstOrderEWD {
	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	
	public DepthFirstOrderEWD(MyEdgeWeightedDigraph G) {
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];
		
		for(int v = 0;v < G.V();v++)
			if(!marked[v]) dfs(G,v);
	}
	
	private void dfs(MyEdgeWeightedDigraph G,int v) {
		pre.enqueue(v);
		
		marked[v] = true;
		for(MyDirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(!marked[w]) dfs(G,w);
		}
		
		post.enqueue(v);
		reversePost.push(v);
	}
	
	public Iterable<Integer> pre()
	{ return pre;}
	
	public Iterable<Integer> post()
	{ return post;}
	
	public Iterable<Integer> reversePost()
	{ return reversePost;}
}
