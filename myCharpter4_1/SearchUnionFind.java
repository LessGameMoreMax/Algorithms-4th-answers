package myCharpter4_1;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.UF;

public class SearchUnionFind {
	int s;
	UF uf;
	int count;
	public SearchUnionFind(Graph G,int s) {
		uf = new UF(G.V());
		this.s = s;
		for(int v = 0;v<G.V();v++) {
			for(int w : G.adj(v)) 
				uf.union(w, v);
			if(uf.connected(s, v))
				count++;
		}
		count--;
	}
	
	public boolean marked(int v) {
		return uf.connected(v, s);
	}
	
	public int count()
	{ return count;}
	
	public static void main(String[] args) {
		Graph g = new Graph(13);
		g.addEdge(0, 5);
		g.addEdge(4, 3);
		g.addEdge(0, 1);
		g.addEdge(9, 12);
		g.addEdge(6, 4);
		g.addEdge(5, 4);
		g.addEdge(0, 2);
		g.addEdge(11, 12);
		g.addEdge(9, 10);
		g.addEdge(0, 6);
		g.addEdge(7, 8);
		g.addEdge(9, 11);
		g.addEdge(5, 3);
		SearchUnionFind s = new SearchUnionFind(g,9);
		System.out.print(s.count);
	}
}
