package myCharpter4_3;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class CyclePathGraph {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public CyclePathGraph(Graph G,int s) {
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		Integer u = bfs(G,s);
		if(u!=null) printPathTo(u);
	}
	
	private Integer bfs(Graph G,int s) {
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
				}else if(w==s) return v;
		}
		return null;
	}
	
	private void printPathTo(int u) {
		if(u==s) {
			System.out.print(s);
			return;
		}
		printPathTo(edgeTo[u]);
		System.out.print("-"+u);
	}
}
