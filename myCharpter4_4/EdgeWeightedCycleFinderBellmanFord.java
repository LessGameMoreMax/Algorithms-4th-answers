package myCharpter4_4;

import edu.princeton.cs.algs4.Stack;

public class EdgeWeightedCycleFinderBellmanFord {
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<MyDirectedEdge> cycle;
	private boolean[] onStack;
	
	public EdgeWeightedCycleFinderBellmanFord(MyEdgeWeightedDigraph G) {
		onStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		for(int v = 0;v<G.V();v++)
			if(!marked[v]) dfs(G,v);
	}
	
	private void dfs(MyEdgeWeightedDigraph G,int v) {
		onStack[v] = true;
		marked[v] = true;
		for(MyDirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(this.hasCycle()) return;
			else if(!marked[w]) 
			{ edgeTo[w] = v; dfs(G,w);}
			else if(onStack[w]) {
				cycle = new Stack<MyDirectedEdge>();
				int pre = v;
				cycle.push(G.edgeFinder(v, w));
				for(int x = edgeTo[v]; x != w ; x = edgeTo[x]) {
					cycle.push(G.edgeFinder(x, pre));
					pre = x;
				}
				cycle.push(G.edgeFinder(w, pre));
			}
		}
		onStack[v] = false;
	}
	
	public boolean hasCycle()
	{ return cycle!=null;}
	
	public Iterable<MyDirectedEdge> cycle()
	{ return cycle;}
}
