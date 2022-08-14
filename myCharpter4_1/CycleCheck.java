package myCharpter4_1;

import edu.princeton.cs.algs4.Graph;

public class CycleCheck {
	private boolean[] marked;
	private boolean hasCycle;
	public CycleCheck(Graph G) {
		marked = new boolean[G.V()];
		for(int s = 0;s<G.V();s++)
			if(!marked[s]) dfs(G,s,s);
	}
	
	private void dfs(Graph G,int v,int u) {
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G,w,v);
			else if(w!=u) hasCycle = true;
	}
	
	public boolean hasCycle()
	{ return hasCycle;}
	
	public static void main(String[] args) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
//		g.addEdge(3, 0);
		CycleCheck c = new CycleCheck(g);
		System.out.print(c.hasCycle);
	}
}
