package myCharpter4_2;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstPathsDigraph {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public BreadthFirstPathsDigraph(Digraph G,int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G,s);
	}
	private void bfs(Digraph G,int s) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		queue.enqueue(s);
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			for(int w : G.adj(v))
				if(!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					queue.enqueue(w);
				}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v;x!=s;x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
	
	public void pathPrint(int v) {
		if(hasPathTo(v))
			for(int x : this.pathTo(v))
				if(s==x) StdOut.print(x);
				else StdOut.print("-"+x);
	}
	
}
