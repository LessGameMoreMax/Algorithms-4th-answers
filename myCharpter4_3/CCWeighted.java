package myCharpter4_3;

import edu.princeton.cs.algs4.Graph;

public class CCWeighted {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public CCWeighted(MyEdgeWeightedGraph G) {
		Graph graph = new Graph(G.V());
		for(MyEdge e : G.edges()) {
			int w = e.either();
			int v = e.other(w);
			graph.addEdge(w,v);
		}
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for(int s = 0;s<G.V();s++)
			if(!marked[s]) {
				dfs(graph,s);
				count++;
			}
	}
	
	private void dfs(Graph G,int v) {
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G,w);
	}
	
	public boolean connected(int v,int w)
	{ return id[w]==id[v];}
	
	public int id(int v)
	{ return id[v];}
	
	public int count()
	{ return count;}
}
