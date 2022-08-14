package myCharpter4_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.SET;

public class GraphDelete {
	private final int V;
	private int E;
	private SET<Integer>[] adj;
	public GraphDelete(int V) {
		this.V = V;
		this.E = 0;
		adj = (SET<Integer>[]) new SET[V];
		for(int v = 0;v<V;v++)
			adj[v] = new SET<Integer>();
	}
	
	public int V() { return V;}
	public int E() { return E;}
	public void addEdge(int v,int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public Iterable<Integer> adj(int v)
	{ return adj[v];}
	public void delete(int v,int w) {
		adj[v].delete(w);
		adj[w].delete(v);
		E--;
	}

}
