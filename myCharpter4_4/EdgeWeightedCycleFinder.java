package myCharpter4_4;

import edu.princeton.cs.algs4.Stack;

public class EdgeWeightedCycleFinder {
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;
	private boolean[] onStack;
	
	public EdgeWeightedCycleFinder(MyEdgeWeightedDigraph G) {
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
				cycle = new Stack<Integer>();
				for(int x = v; x != w ; x = edgeTo[x])
					cycle.push(x);
				
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v] = false;
	}
	
	public boolean hasCycle()
	{ return cycle!=null;}
	
	public Iterable<Integer> cycle()
	{ return cycle;}
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(4);
		G.addByVertex(0, 1, 0.1);
		G.addByVertex(1, 2, 0.2);
		G.addByVertex(2, 3, 0.3);
		G.addByVertex(3, 1, 0.4);
		EdgeWeightedCycleFinder C = new EdgeWeightedCycleFinder(G);
		for(int i : C.cycle) System.out.print(i);
	}
}
