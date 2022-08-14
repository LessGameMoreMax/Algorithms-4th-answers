package myCharpter4_1;

import edu.princeton.cs.algs4.Graph;

public class SearchNoEffectV {
	private boolean[] marked;
	private int delete;
	public SearchNoEffectV(Graph G) {
		marked = new boolean[G.V()];
		dfs(G,0);
	}
	
	private boolean dfs(Graph G,int v) {
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w]) 
				if(dfs(G,w)) { 
					delete = w; 
					return false;
				}else return false;
		return true;
	}
	
	public int deleteNumber()
	{ return delete;}
	
	public static void main(String[] args) {
		Graph g = new Graph(8);
		g.addEdge(3, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(0, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 4);
		SearchNoEffectV e = new SearchNoEffectV(g);
		System.out.println(e.delete);
	}
}
