package myCharpter4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class GraphCopy {
	private GraphCopy copy;
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	public GraphCopy(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0;v<V;v++)
			adj[v] = new Bag<Integer>();
	}
	public GraphCopy(In in) {
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0;i<E;i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	public GraphCopy(GraphCopy g) {
		this(g.V);
		this.E = g.E;
		for(int v = 0;v<g.V;v++)
			for(int w : g.adj(v))
				addSingle(v,w);
		copy = g;
	}
	private void addSingle(int v,int w) {
		adj[v].add(w);
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
}
