package myCharpter4_2;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstOrderTest {
	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	
	public DepthFirstOrderTest(Digraph G) {
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];
		
		for(int v = 0; v<G.V();v++)
			if(!marked[v]) dfs(G,v);
	}
	
	private void dfs(Digraph G,int v) {
		pre.enqueue(v);
		
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G,w);
		
		post.enqueue(v);
		reversePost.push(v);
	}
	
	public Iterable<Integer> pre()
	{ return pre;}
	
	public Iterable<Integer> post()
	{ return post;}
	
	public Iterable<Integer> reversePost()
	{ return reversePost;}
	
	public static void main(String[] args) {
		Digraph G = new Digraph(5);
		G.addEdge(4, 3);
		G.addEdge(0, 3);
		G.addEdge(0, 1);
		G.addEdge(1, 2);
		G.addEdge(2, 0);
		DepthFirstOrderTest D = new DepthFirstOrderTest(G.reverse());
		for(int i : D.post)
			System.out.println(i);
	}
}
